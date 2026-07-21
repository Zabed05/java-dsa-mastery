public class HashDemo {
    public static void main(String[] args) {
        String name = "Zabed";

        int code = name.hashCode(); // its generate a haasCode of "Zabed"
        System.out.println(code);

        Integer a = 12345;
        int intCode = a.hashCode();
        // number's hascode = number itself (bcz every number is a unique number)
        System.out.println(intCode);

    }
}