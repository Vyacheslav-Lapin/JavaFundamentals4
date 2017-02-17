package xml.ws.client;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.ws.Endpoint;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class HelloServiceTest {

    private static final String URL = "http://localhost:1212/hello";
    private Endpoint endpoint;

    @BeforeEach
    void setUp() throws Exception {
//        System.out.printf("Service started @ %s?wsdl", URL);
        endpoint = Endpoint.publish(URL, new xml.ws.Hello());
    }

    @Test
    void get() throws Exception {
        assertThat(HelloService.get().sayHello("Henry"), is("Hello, Henry"));
    }

    @AfterEach
    void tearDown() throws Exception {
        endpoint.stop();
    }
}