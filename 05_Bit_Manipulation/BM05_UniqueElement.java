// Q: Given an array where every element appears twice except one element that appears only once. Find that element.

public class BM05_UniqueElement {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 1, 2, 1, 3, 6, 4};

        System.out.println("Unique element is: " + ans(arr));
    }

    static int ans(int[] arr){
        int unique = 0;
        for (int i : arr) {
            unique ^= i; // here we use XOR op. ( a^a = 0, a^0 = a )
        }
        return unique;
    }
}