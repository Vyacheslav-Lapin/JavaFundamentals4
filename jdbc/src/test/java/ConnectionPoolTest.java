import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ConnectionPoolTest {

    ConnectionPool connectionPool = new ConnectionPool("src/test/resources/sql/db.properties");

    @Test
    public void takeConnection() throws Exception {
        assertNotNull(connectionPool.get());
    }



}