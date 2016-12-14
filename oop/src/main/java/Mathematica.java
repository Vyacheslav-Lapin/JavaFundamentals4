public class Mathematica {

    public Mathematica(Num obj) {
        System.out.println(1);
    }
    public Mathematica(Int obj) {
        System.out.println(2);
    }
    public Mathematica(Num obj1, Int obj2) {
        System.out.println(3);
    }
    public Mathematica(Int obj1, Int obj2) {
        System.out.println(4);
    }

    public static void main(String[] args){
        Num o1 = new Num();
        Int o2 = new Int();
        LongInt o3 = new LongInt();
        Num o4 = new Int();

        Mathematica m1 = new Mathematica(o1); // 1
        Mathematica m2 = new Mathematica(o2); // 2
        Mathematica m3 = new Mathematica(o3); // 2
        Mathematica m4 = new Mathematica(o4); // 1 ? 2 ?
        Mathematica m5 = new Mathematica(o1, o2); // 3
        Mathematica m6 = new Mathematica(o3, o2); // 4
//        Mathematica m7 = new Mathematica(o1, o4);//error
//        Mathematica m8 = new Mathematica(o3, o4);//error
    }
}

class Num{}
class Int extends Num{}
class LongInt extends Int{}
