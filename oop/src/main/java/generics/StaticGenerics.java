package generics;

public class StaticGenerics {

    public static void main(String[] args) {
        System.out.println(StaticGenerics.<String>method("123"));
    }

    public static <Type> Type method(Type obj) {
        System.out.println("<Type> void method(Type obj)");
        return obj;
    }

    public static void method(Number obj) {
        System.out.println("void method(Number obj)");
    }

    public static void method(Integer obj) {
        System.out.println("void method(Integer obj)");
    }

//    public static void method(String obj) {
//        System.out.println("void method(String obj)");
//    }

}
