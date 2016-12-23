package interfaces;

public interface MyInterface {

    static void main(String[] args) {
        System.out.println(get().mByte(58.9));
    }

    static MyInterface get() {
        return d -> new Double(d).intValue();
    }

    int m(double d);

    default byte mByte(double d) {
        int m = m(d);
        return (byte) (m < 128 && m > -129 ? m : 0);
    }
}
