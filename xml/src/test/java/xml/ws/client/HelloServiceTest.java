package xml.ws.client;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.xml.ws.Endpoint;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HelloServiceTest {

    private static final String URL = "http://localhost:1212/hello";

    private Thread thread;

    @Before
    public void setUp() throws Exception {
        System.out.printf("Service started @ %s?wsdl", URL);
        thread = new Thread(() -> Endpoint.publish(URL, new xml.ws.Hello()));
        thread.start();
        Thread.sleep(1_500);
    }

    @Test
    public void get() throws Exception {
        assertThat(HelloService.get().sayHello("Henry"), is("Hello, Henry"));
    }

    @After
    public void tearDown() throws Exception {
        thread.interrupt();
    }
}