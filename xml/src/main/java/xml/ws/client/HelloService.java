package xml.ws.client;

import com.epam.courses.jf.functions.ExceptionalBiFunction;
import com.epam.courses.jf.functions.ExceptionalFunction;
import com.epam.courses.jf.functions.VarFunction;

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

    private static final String WEB_SERVICE_NAME;
    private static final String TARGET_NAMESPACE;
    private static final String WSDL_LOCATION;

    static {
        WebServiceClient webServiceClient = HelloService.class.getDeclaredAnnotation(WebServiceClient.class);
        WEB_SERVICE_NAME = webServiceClient.name();
        TARGET_NAMESPACE = webServiceClient.targetNamespace();
        WSDL_LOCATION = webServiceClient.wsdlLocation();
    }

    private static final String HELLO_PORT = ExceptionalBiFunction.getOrThrowUnchecked(
            HelloService.class::getDeclaredMethod,
            "getHelloPort",
            WebServiceFeature[].class
    ).getDeclaredAnnotation(WebEndpoint.class).name();

    private final static URL HELLOSERVICE_WSDL_LOCATION =
            ExceptionalFunction.getOrThrowUnchecked(URL::new, WSDL_LOCATION);

    private final static QName HELLOSERVICE_QNAME = new QName(TARGET_NAMESPACE, WEB_SERVICE_NAME);

    @SuppressWarnings("WeakerAccess")
    private HelloService() {
        super(HELLOSERVICE_WSDL_LOCATION, HELLOSERVICE_QNAME);
    }

    /**
     * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns Hello
     */
    @SuppressWarnings("WeakerAccess")
    @WebEndpoint(name = "HelloPort")
    public Hello getHelloPort(WebServiceFeature... features) {
        return getPort(new QName(TARGET_NAMESPACE, HELLO_PORT), Hello.class, features);
    }

    private static volatile HelloService INSTANCE;

    public static HelloService getInstance() {
        HelloService instance = INSTANCE;
        if (instance == null)
            synchronized (HelloService.class) {
                instance = INSTANCE;
                if (instance == null)
                    INSTANCE = instance = new HelloService();
            }
        return instance;
    }

    public static VarFunction<WebServiceFeature, Hello> get() {
        return getInstance()::getHelloPort;
    }
}
