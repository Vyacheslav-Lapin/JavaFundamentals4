public class VarArgs {

    public static int getArgCount(Integer... args) {
        if (args.length == 0) {
            System.out.print("No arg");
        }
        for (int i : args) {
            System.out.print("arg:" + i + "  ");
        }
        return args.length;
    }

    public static void getArgCount(Integer[]... args) {
        if (args.length == 0) {
            System.out.print("No arg2");
        }
        for (Integer[] mas : args) {
            for (int x : mas) {
                System.out.print("arg2:" + x + "  ");
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println("N=" + getArgCount(7, 71, 555));
//        Integer[] i = { 1, 2, 3, 4, 5, 6, 7 };
//        System.out.println("N=" + getArgCount(i));
//        getArgCount(i, i);
//        getArgCount(); //error

        Integer[] i = { 1, 2, 3, 4, 5 };
        printArgCount(7, "No", true, null); // "Object args: 4"
        printArgCount(i, i, i); // "Integer[] args: 3"
        printArgCount(i, 4, 71); // "Object args: 3"
        printArgCount(i); // будет вызван метод 1 // "Object args: 5"
        printArgCount(new int[]{5, 7}); //неопределенность, 1 или 3!
    }

    public static void printArgCount(Object... args) { // 1
        System.out.println("Object args: " + args.length);
    }

    public static void printArgCount(Integer[]... args) { // 2
        System.out.println("Integer[] args: " + args.length);
    }

    public static void printArgCount(int... args) { // 3
        System.out.print("int args: " + +args.length);
    }


}
