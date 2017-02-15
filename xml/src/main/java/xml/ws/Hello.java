package xml.ws;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

import static javax.jws.soap.SOAPBinding.Style.RPC;

@WebService
@SOAPBinding(style= RPC)
public class Hello {
    public String sayHello(@WebParam(name = "name") String name) {
        return "Hello, " + name;
    }

    private static final String url = "http://localhost:1212/hello";
    public static void main(String[] args) {
        System.out.printf("Service started @ %s?wsdl", url);
        Endpoint.publish(url, new Hello());
    }
}
