package annotations;

@MyAnno(params = "456")
public class AnnoDemo {

    public static void main(String[] args) {
        System.out.println(AnnoDemo.class.getAnnotation(MyAnno.class).params()[0]); // "456"
    }
}
