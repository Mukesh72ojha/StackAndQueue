import java.util.Stack;

public class Practice {
    public static void main(String[] args){
        Person p1 = new Person();
        p1.age = 23;
        p1.name = "A";


        Person p2 = new Person();
        p2.age = 34;
        p2.name = "B";

        p1.saysHi();
        p2.saysHi();
        System.out.println();
        Swap(p1,p2);
        System.out.println();
        p1.saysHi();
        p2.saysHi();
        System.out.println();
        Swap1(p1,p2);
        p1.saysHi();
        p2.saysHi();

    }
    public static void Swap(Person p1, Person p2){
        Person temp = p1;
        p1 = p2;
        p2 = temp;
    }
    public static void Swap1(Person psn1, Person psn2){
        psn1 = new Person();
        int age = psn1.age;
        psn1.age = psn2.age;
        psn2.age = age;

        psn2 = new Person();

        String str = psn1.name;
        psn1.name = psn2.name;
        psn2.name = str;
    }
    public static class Person{
        int age;
        String name;

        void saysHi(){
            System.out.println(name + " [" + age + "] " + "Say hii");
        }
    }
}
