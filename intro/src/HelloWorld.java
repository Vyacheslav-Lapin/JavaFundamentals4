public class HelloWorld {
    static public void main(String... arguments) {

        int i=3;
//        i = -i++ + i++ + -i;
//        System.out.println(i);

        int i2;
        int i3;
        int i4;
        int i5;

        System.out.println("-i++ = " + (i2 = -i++)); // -3
        System.out.println("i = " + i); // 4

        System.out.println("i++ = " + (i3 = i++)); // 4
        System.out.println("i = " + i); // 5

        System.out.println("-i = " + (i4 = -i)); // -5
        System.out.println("i = " + i); // 5

        System.out.println("i2 + i3 = " + (i5 = i2 + i3)); // 1
        System.out.println("i = " + i); // 5

        System.out.println("i5 + i4 = " + (i5 + i4)); // -4
        System.out.println("i = " + i); // 5
    }
}
