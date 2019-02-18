package Polimorfizm;

public class MainTestClass {

    public static void main(String[] args) {
        OverLoadingClass overLoadingClass = new OverLoadingClass();
        System.out.println(overLoadingClass.get());
        System.out.println( overLoadingClass.get("Some text"));
        System.out.println(overLoadingClass.get(5));
       }
}
