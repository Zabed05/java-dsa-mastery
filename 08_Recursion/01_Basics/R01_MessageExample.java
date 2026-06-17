// Write a function that prints "Hello World" and from main() by one calling its should print 5 times

// we do it without Recursion

public class R01_MessageExample {
    public static void main(String[] args) {
        message();
    }

    static void message(){
        System.out.println("Hello World"); // Not print it multiple times in one function

        message1();
    }

    static void message1(){
        System.out.println("Hello World");

        message2();
    }

    static void message2(){
        System.out.println("Hello World");

        message3();
    }
    static void message3(){
        System.out.println("Hello World");

        message4();
    }
    static void message4(){
        System.out.println("Hello World");
    }
}

// Here, we doing repeation (repeation of same function body) same task, same body
// Instead of calling another function and avoid repeation there came Recursion concept
// see in next file -->