package xml.ws.client;

import com.epam.courses.jf.functions.ExceptionalBiFunction;
import com.epam.courses.jf.functions.ExceptionalFunction;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Optional;

@WebServiceClient(
        name = "HelloService",
        targetNamespace = "http://ws.xml/",
        wsdlLocation = "http://localhost:1212/hello?wsdl")
public class HelloService extends Service {

    private static final String WEB_SERVICE_NAME;
    private static final String TARGET_NAMESPACE;
    private static final URL WSDL_LOCATION;
    private static final QName PORT_NAME;

    static {
        WebServiceClient webServiceClient = HelloService.class.getDeclaredAnnotation(WebServiceClient.class);

        WEB_SERVICE_NAME = webServiceClient.name();
        TARGET_NAMESPACE = webServiceClient.targetNamespace();
        WSDL_LOCATION = ExceptionalFunction.getOrThrowUnchecked(URL::new, webServiceClient.wsdlLocation());

        Method getHelloPort = ExceptionalBiFunction.getOrThrowUnchecked(
                HelloService.class::getDeclaredMethod,
                "getHelloPort",
                WebServiceFeature[].class);
        PORT_NAME = new QName(TARGET_NAMESPACE, getHelloPort.getDeclaredAnnotation(WebEndpoint.class).name());
    }

    @SuppressWarnings("WeakerAccess")
    private HelloService() {
        super(WSDL_LOCATION, new QName(TARGET_NAMESPACE, WEB_SERVICE_NAME));
    }

    @SuppressWarnings("WeakerAccess")
    @WebEndpoint(name = "HelloPort")
    public Hello getHelloPort(WebServiceFeature... features) {
        return getPort(PORT_NAME, Hello.class, features);
    }

    private static volatile HelloService INSTANCE;

    private static HelloService getInstance() {
        return Optional.ofNullable(INSTANCE)
                .orElseGet(() -> {
                    synchronized (HelloService.class) {
                        return Optional.ofNullable(INSTANCE)
                                .orElse(INSTANCE = new HelloService());
                    }
                });
    }

    /**
     * @param webServiceFeatures A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy. Supported
     *                           features not in the <code>features</code> parameter will have their default values.
     */
    public static Hello get(WebServiceFeature... webServiceFeatures) {
        return getInstance().getHelloPort(webServiceFeatures);
    }
}
