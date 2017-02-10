package xml.ws;

import javax.xml.ws.Endpoint;

public class ServiceStarter {
    public static void main(String[] args) {
        String url = "http://localhost:1212/hello";
        System.out.printf("Service started @ %s?wsdl", url);
        Endpoint.publish(url, new Hello());
    }
}
