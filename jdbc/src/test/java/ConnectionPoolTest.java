import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ConnectionPoolTest {

    ConnectionPool connectionPool = new ConnectionPool("src/main/resources/db.properties");

    @Test
    public void takeConnection() throws Exception {
        assertNotNull(connectionPool.get());
    }

}