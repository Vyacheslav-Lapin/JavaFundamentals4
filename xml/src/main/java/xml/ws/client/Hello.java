
package xml.ws.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Action;

@WebService(name = "Hello", targetNamespace = "http://ws.xml/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface Hello {

    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://ws.xml/Hello/sayHelloRequest", output = "http://ws.xml/Hello/sayHelloResponse")
    String sayHello(@WebParam(name = "name", partName = "name") String name);
}
