package xml.ws.client;

import com.epam.courses.jf.functions.VarFunction;

import javax.xml.ws.WebServiceFeature;

public interface HelloClient {
    static void main(String[] args) {
        VarFunction<WebServiceFeature, Hello> helloVarFunction = HelloService.get();
        Hello hello = helloVarFunction.apply();
        String text = hello.sayHello("Henry");
        System.out.println(text);
    }
}
