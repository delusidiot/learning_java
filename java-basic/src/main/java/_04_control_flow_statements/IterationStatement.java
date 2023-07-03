package _04_control_flow_statements;

public class IterationStatement {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++){
            System.out.println(" i: " + i);
        }
        int i = 0;
        while (i < 10){
            System.out.println(" i: " + i);
            i++;
        }
    }
}
