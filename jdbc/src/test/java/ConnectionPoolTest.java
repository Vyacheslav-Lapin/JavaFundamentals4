import cp.ConnectionPool;
import lombok.val;
import model.Gender;
import model.Person;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ConnectionPoolTest {

    ConnectionPool connectionPool = new ConnectionPool("src/test/resources/sql");

    @Test
    public void takeConnection() throws Exception {
        assertNotNull(connectionPool.get());
    }

    @Test
    public void takePerson() throws Exception {
        try (val connection = connectionPool.get()) {
            val stmt = connection.createStatement();
            val rs = stmt.executeQuery(
                    "SELECT id, gender_code, full_name" +
                     " FROM Person");

            assertTrue(rs.next());

            Person person = Person.builder().id(rs.getLong("id"))
                    .gender(Gender.valueOf(rs.getString("gender_code")))
                    .fullName(rs.getString("full_name"))
                    .build();

            System.out.println(person);
        }
    }



}