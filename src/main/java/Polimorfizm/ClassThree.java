package Polimorfizm;

public class ClassThree {
    public void userMet(ParrentCl parrentCl){
        System.out.println(parrentCl.getNuv());
    }

    public static void main(String[] args) {
        ClassThree classThree = new ClassThree();
        ParrentCl parrentCl = new TestMethod();
        classThree.userMet(parrentCl);
    }
}
