import java.util.ArrayList;

public class Q02_LinearSearch {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 18, 19, 2};
        int target = 18;
        System.out.println(target + " is present at index " + searchIndex(arr, target, 0));


        int target2 = 2;
        searchAllIndex(arr, target2, 0);
        System.out.println(target2 + " present at index " + list);
    
    }

    // Returning target element present or not
    static boolean search(int[] arr, int target, int index){
        if(index == arr.length){
            return false;
        }

        return (arr[index] == target) || (search(arr, target, index+1));
    }

    // Returning the index of target element
    static int searchIndex(int[] arr, int target, int index){
        if(index == arr.length){
            return -1;
        }

        if((arr[index] == target)){
            return index;
        }

        else{
            return searchIndex(arr, target, index+1);
        }
    }

    // Searching for indexes of target element (multiple occurrence)

    static ArrayList<Integer> list = new ArrayList<>(); // For storing index

    static void searchAllIndex(int[] arr, int target, int index){
        if(index == arr.length){
            return;
        }

        if((arr[index] == target)){
            list.add(index);
        }

        searchAllIndex(arr, target, index+1);
    }

    // Now if we not create ArrayList outside of the function then how to do !?
    // Check in next file --> [Q03_LinearSearch.java]
}