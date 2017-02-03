package cp;

import lombok.SneakyThrows;
import lombok.val;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ConnectionPool implements Supplier<Connection>, AutoCloseable {
    private BlockingQueue<Connection> connectionQueue;

    private static final String DB_DRIVER = "driver";
    private static final String DB_URL = "url";
    private static final String DB_POLL_SIZE = "poolSize";
    private static final String DB_PROPERTIES_FILE_NAME = "db.properties";

    @SneakyThrows
    public ConnectionPool(String resourcesDbProperties) {

        Properties properties = getProperties(
                resourcesDbProperties + "/" + DB_PROPERTIES_FILE_NAME);
        String url = (String) properties.remove(DB_URL);
        int poolSize = Integer.parseInt((String) properties.remove(DB_POLL_SIZE));
        initDriverClass(properties);

        connectionQueue = new ArrayBlockingQueue<>(poolSize);

        try {
            for (int i = 0; i < poolSize; i++) {
                assert properties.size() == 2;
                val connection = DriverManager.getConnection(url, properties);
                connectionQueue.add(PooledConnection.from(connection, connectionQueue::add));
            }
        } catch (SQLException e) {
            throw new ConnectionPoolException("SQLException in cp.ConnectionPool", e);
        }

        for (int i = 1; new File(resourcesDbProperties + "/" + i + ".sql").exists(); i++) {
            String collect = Files.readAllLines(Paths.get(resourcesDbProperties + "/" + i + ".sql")).stream()
                    .collect(Collectors.joining());
            try (val conn = get();
                 val stmt = conn.createStatement()) {
                stmt.executeUpdate(collect);
            }
        }
    }

    private void initDriverClass(Properties properties) throws ConnectionPoolException {
        try {
            Class.forName((String) properties.remove(DB_DRIVER));
        } catch (ClassNotFoundException e) {
            throw new ConnectionPoolException("Can't find database driver class", e);
        }
    }

    private static Properties getProperties(String resourcesDbProperties) throws IOException {
        val properties = new Properties();
        try (val fileInputStream = new FileInputStream(resourcesDbProperties)) {
            properties.load(fileInputStream);
        }
        return properties;
    }

    @Override
    public void close() {
        try {
            Connection connection;
            while ((connection = connectionQueue.poll()) != null) {
                if (!connection.getAutoCommit()) {
                    connection.commit();
                }
                ((PooledConnection) connection).reallyClose();
            }
        } catch (SQLException e) {
            // logger.log(Level.ERROR, "Error closing the connection.", e);
        }
    }

    @Override
    public Connection get() {
        try {
            return connectionQueue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException("Error connecting to the data source.", e);
        }
    }
}
