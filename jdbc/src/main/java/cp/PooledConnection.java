package cp;

import lombok.SneakyThrows;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

public interface PooledConnection extends Connection {

    Connection getRealConnection();

    @SneakyThrows
    static PooledConnection from(Connection c, Consumer<Connection> callback) {
        c.setAutoCommit(true);

        return new PooledConnection() {
            @Override
            public Connection getRealConnection() {
                return c;
            }

            @Override
            public void close() throws SQLException {
                if (getRealConnection().isClosed()) {
                    throw new SQLException("Attempting to close closed getRealConnection().");
                }
                if (getRealConnection().isReadOnly()) {
                    getRealConnection().setReadOnly(false);
                }

                callback.accept(this);
                // throw new SQLException("Error allocating connection in the pool.");

            }
        };
    }

    default void reallyClose() throws SQLException {
        getRealConnection().close();
    }

    @Override
    default boolean isClosed() throws SQLException {
        return getRealConnection().isClosed();
    }

    @Override
    default DatabaseMetaData getMetaData() throws SQLException {
        return getRealConnection().getMetaData();
    }

    @Override
    default void setReadOnly(boolean readOnly) throws SQLException {
        getRealConnection().setReadOnly(readOnly);
    }

    @Override
    default boolean isReadOnly() throws SQLException {
        return getRealConnection().isReadOnly();
    }

    @Override
    default void setCatalog(String catalog) throws SQLException {
        getRealConnection().setCatalog(catalog);
    }

    @Override
    default String getCatalog() throws SQLException {
        return getRealConnection().getCatalog();
    }

    @Override
    default void setTransactionIsolation(int level) throws SQLException {
        getRealConnection().setTransactionIsolation(level);
    }

    @Override
    default int getTransactionIsolation() throws SQLException {
        return getRealConnection().getTransactionIsolation();
    }

    @Override
    default SQLWarning getWarnings() throws SQLException {
        return getRealConnection().getWarnings();
    }

    @Override
    default void clearWarnings() throws SQLException {
        getRealConnection().clearWarnings();
    }

    @Override
    default Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
        return getRealConnection().createStatement(resultSetType, resultSetConcurrency);
    }

    @Override
    default PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return getRealConnection().prepareStatement(sql, resultSetType, resultSetConcurrency);
    }

    @Override
    default CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return getRealConnection().prepareCall(sql, resultSetType, resultSetConcurrency);
    }

    @Override
    default Map<String, Class<?>> getTypeMap() throws SQLException {
        return getRealConnection().getTypeMap();
    }

    @Override
    default void setTypeMap(Map<String, Class<?>> map) throws SQLException {
        getRealConnection().setTypeMap(map);
    }

    @Override
    default void setHoldability(int holdability) throws SQLException {
        getRealConnection().setHoldability(holdability);
    }

    @Override
    default int getHoldability() throws SQLException {
        return getRealConnection().getHoldability();
    }

    @Override
    default Savepoint setSavepoint() throws SQLException {
        return getRealConnection().setSavepoint();
    }

    @Override
    default Savepoint setSavepoint(String name) throws SQLException {
        return getRealConnection().setSavepoint(name);
    }

    @Override
    default void rollback(Savepoint savepoint) throws SQLException {
        getRealConnection().rollback(savepoint);
    }

    @Override
    default void releaseSavepoint(Savepoint savepoint) throws SQLException {
        getRealConnection().releaseSavepoint(savepoint);
    }

    @Override
    default Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return getRealConnection().createStatement(resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    @Override
    default PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return getRealConnection().prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    @Override
    default CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return getRealConnection().prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    @Override
    default PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
        return getRealConnection().prepareStatement(sql, autoGeneratedKeys);
    }

    @Override
    default PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
        return getRealConnection().prepareStatement(sql, columnIndexes);
    }

    @Override
    default PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
        return getRealConnection().prepareStatement(sql, columnNames);
    }

    @Override
    default Clob createClob() throws SQLException {
        return getRealConnection().createClob();
    }

    @Override
    default Blob createBlob() throws SQLException {
        return getRealConnection().createBlob();
    }

    @Override
    default NClob createNClob() throws SQLException {
        return getRealConnection().createNClob();
    }

    @Override
    default SQLXML createSQLXML() throws SQLException {
        return getRealConnection().createSQLXML();
    }

    @Override
    default boolean isValid(int timeout) throws SQLException {
        return getRealConnection().isValid(timeout);
    }

    @Override
    default void setClientInfo(String name, String value) throws SQLClientInfoException {
        getRealConnection().setClientInfo(name, value);
    }

    @Override
    default void setClientInfo(Properties properties) throws SQLClientInfoException {
        getRealConnection().setClientInfo(properties);
    }

    @Override
    default String getClientInfo(String name) throws SQLException {
        return getRealConnection().getClientInfo(name);
    }

    @Override
    default Properties getClientInfo() throws SQLException {
        return getRealConnection().getClientInfo();
    }

    @Override
    default Array createArrayOf(String typeName, Object[] elements) throws SQLException {
        return getRealConnection().createArrayOf(typeName, elements);
    }

    @Override
    default Struct createStruct(String typeName, Object[] attributes) throws SQLException {
        return getRealConnection().createStruct(typeName, attributes);
    }

    @Override
    default void setSchema(String schema) throws SQLException {
        getRealConnection().setSchema(schema);
    }

    @Override
    default String getSchema() throws SQLException {
        return getRealConnection().getSchema();
    }

    @Override
    default void abort(Executor executor) throws SQLException {
        getRealConnection().abort(executor);
    }

    @Override
    default void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
        getRealConnection().setNetworkTimeout(executor, milliseconds);
    }

    @Override
    default int getNetworkTimeout() throws SQLException {
        return getRealConnection().getNetworkTimeout();
    }

    @Override
    default <T> T unwrap(Class<T> iface) throws SQLException {
        return getRealConnection().unwrap(iface);
    }

    @Override
    default boolean isWrapperFor(Class<?> iface) throws SQLException {
        return getRealConnection().isWrapperFor(iface);
    }

    @Override
    default Statement createStatement() throws SQLException {
        return getRealConnection().createStatement();
    }

    @Override
    default PreparedStatement prepareStatement(String sql) throws SQLException {
        return getRealConnection().prepareStatement(sql);
    }

    @Override
    default CallableStatement prepareCall(String sql) throws SQLException {
        return getRealConnection().prepareCall(sql);
    }

    @Override
    default String nativeSQL(String sql) throws SQLException {
        return getRealConnection().nativeSQL(sql);
    }

    @Override
    default void setAutoCommit(boolean autoCommit) throws SQLException {
        getRealConnection().setAutoCommit(autoCommit);
    }

    @Override
    default boolean getAutoCommit() throws SQLException {
        return getRealConnection().getAutoCommit();
    }

    @Override
    default void commit() throws SQLException {
        getRealConnection().commit();
    }

    @Override
    default void rollback() throws SQLException {
        getRealConnection().rollback();
    }
}
