import java.util.Arrays;
import java.util.Scanner;

public class A01_1DArray {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();

        int[] arr = new int[n];
        
        System.out.println("Enter elements:");
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        // Display
        System.out.println("Output:");
        // for(int a: arr){  //using for each
        //     System.out.println(a);
        // }

        System.out.println(Arrays.toString(arr)); //using toSting() method
        

        System.out.println("---Another Program---");
        //Arrays of Object
        String[] str = new String[4];
        System.out.println("Enter String input:");
        for(int i = 0; i < str.length; i ++){
            str[i] = sc.next();
        }

        System.out.println(Arrays.toString(str));

        sc.close();
    }
}