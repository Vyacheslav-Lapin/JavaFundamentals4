package xml.ws.client;

public interface HelloClient {
    static void main(String[] args) {
        HelloService service = new HelloService();
        Hello hello = service.getHelloPort();
        String text = hello.sayHello("Henry");
        System.out.println(text);
    }
}
