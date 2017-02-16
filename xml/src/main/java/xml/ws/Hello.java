package xml.ws;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import static javax.jws.soap.SOAPBinding.Style.RPC;

@WebService
@SOAPBinding(style= RPC)
public class Hello implements xml.ws.client.Hello {
    public String sayHello(@WebParam(name = "name") String name) {
        return "Hello, " + name;
    }
}
