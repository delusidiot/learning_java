package _02_variable;

public class ReferenceType {
    /*
    - Annotation
    - Array
    - Class
    - Enumeration
    - Interface
     */
    public static void main(String[] args) {
        int[] intArray = new int[5];
        String classType = "String class";
        Week week = Week.MON;
        Runnable runnable = new Thread();
    }
    public enum Week {
        MON,
        TUE,
        WED,
        THU,
        FRI,
        SAT,
        SUN;
    }
}
