package _04_control_flow_statements;

public class ConditionalStatement {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: [] [] []");
        } else if (args.length == 1) {
            System.out.println("Usage: [] [] []");
        } else {
            System.out.println("executed");
        }
    }
}
