package _03_operators;

public class InstanceOf {
    public static void main(String args[]) {

        String name = "James";

        // following will return true since name is type of String
        boolean result = name instanceof String;
        System.out.println( result );
    }
}
