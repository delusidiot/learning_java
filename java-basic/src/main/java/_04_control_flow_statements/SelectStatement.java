package _04_control_flow_statements;

import java.util.Scanner;

public class SelectStatement {
    public static void main(String[] args) {
        int x = new Scanner(System.in).nextInt();
        switch (x){
            case 1:
                System.out.println("1");
                break;
            case 2: case 3:
                System.out.println("2 or 3");
                break;
            default:
                System.out.println("other");
        }
    }
}
