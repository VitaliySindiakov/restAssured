package Polimorfizm;

public class OverLoadingClass {
    public String get(){
        return "Hello";
    }
    public String get(String string){
        return string;
    }
    public String get(int a){
        return "Number"+a;
    }
}
