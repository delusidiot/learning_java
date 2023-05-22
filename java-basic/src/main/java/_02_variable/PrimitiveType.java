package _02_variable;

public class PrimitiveType {
    public static void main(String[] args) {
        byte byteType = 0;
        short shortType = 0;
        int intType = 0;
        long longType = 0L;
        float floatType = 0.0f;
        double doubleType = 0.0;
        char charType = '0';
        boolean boolType = false;

        floatError();
    }

    public static void floatError() {
        float flt = 2147483648.0f;
        System.out.println("flt : " + flt);
        System.out.println("flt - 20 : " + (flt - 20));
        System.out.println("flt - 64 : " + (flt - 64));
    }
}
