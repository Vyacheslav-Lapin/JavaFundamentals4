package xml.ws.client;

import com.epam.courses.jf.functions.ExceptionalSupplier;
import lombok.SneakyThrows;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import java.net.URL;

@WebServiceClient(
        name = "HelloService",
        targetNamespace = "http://ws.xml/",
        wsdlLocation = "http://localhost:1212/hello?wsdl")
public class HelloService extends Service {

    private final static URL HELLOSERVICE_WSDL_LOCATION = ExceptionalSupplier
            .getOrThrowUnchecked(() -> new URL(
                    HelloService.class.getDeclaredAnnotation(WebServiceClient.class).wsdlLocation()
            ));

    private final static QName HELLOSERVICE_QNAME =
            new QName(
                    HelloService.class.getDeclaredAnnotation(WebServiceClient.class).targetNamespace(),
                    HelloService.class.getDeclaredAnnotation(WebServiceClient.class).name()
            );

    @SuppressWarnings("WeakerAccess")
    public HelloService() {
        super(HELLOSERVICE_WSDL_LOCATION, HELLOSERVICE_QNAME);
    }

    /**
     * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns Hello
     */
    @SuppressWarnings("WeakerAccess")
    @WebEndpoint(name = "HelloPort")
    @SneakyThrows
    public Hello getHelloPort(WebServiceFeature... features) {
        return getPort(new QName(
                        HelloService.class.getDeclaredAnnotation(WebServiceClient.class).targetNamespace(),
                        HelloService.class.getDeclaredMethod("getHelloPort", WebServiceFeature[].class)
                                .getDeclaredAnnotation(WebEndpoint.class).name()),
                Hello.class,
                features);
    }
}
