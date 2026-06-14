import java.util.Arrays;

public class S03_StringMethods {
    public static void main(String[] args) {
        String name = "Zabed Aktar Khan";

        System.out.println(Arrays.toString(name.toCharArray())); // convert every character to array

        System.out.println(name.toLowerCase());

        System.out.println(name.toUpperCase());

        System.out.println(name.charAt(0));

        System.out.println("   Zabed  ".strip()); // removed white spaces

        System.out.println(Arrays.toString(name.split(" ")));
    }
}
