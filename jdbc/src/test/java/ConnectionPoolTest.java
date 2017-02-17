import cp.ConnectionPool;
import lombok.val;
import model.Gender;
import model.Person;
import org.junit.jupiter.api.Test;

import static com.epam.courses.jf.test.Tests.RESOURCES_FILE_PATH;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConnectionPoolTest {

    private ConnectionPool connectionPool = new ConnectionPool(RESOURCES_FILE_PATH + "sql");

    @Test
    void takeConnection() throws Exception {
        assertNotNull(connectionPool.get());
    }

    @Test
    void takePerson() throws Exception {
        try (val connection = connectionPool.get()) {
            val stmt = connection.createStatement();
            val rs = stmt.executeQuery(
                    "SELECT id, gender_code, full_name " +
                            "FROM Person");

            assertTrue(rs.next());

            Person person = Person.builder().id(rs.getLong("id"))
                    .gender(Gender.valueOf(rs.getString("gender_code")))
                    .fullName(rs.getString("full_name"))
                    .build();

            System.out.println(person);
        }
    }
}