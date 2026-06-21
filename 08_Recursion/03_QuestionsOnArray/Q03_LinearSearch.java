import java.util.ArrayList;

public class Q03_LinearSearch {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 18, 19, 2};
        int target2 = 2;


        // ArrayList<Integer> ans = new ArrayList<>();
        // System.out.println(searchAllIndex(arr, target2, 0, ans));

        
        System.out.println(searchAllIndex2(arr, target2, 0));
    }

    // If we not create ArrayList outside of the function then how to do !?
    // BY returning the list with passing the list as argument 

    static ArrayList<Integer> searchAllIndex(int[] arr, int target, int index, ArrayList<Integer> list){
        if(index == arr.length){
            return list;
        }

        if((arr[index] == target)){
            list.add(index);
        }

        return searchAllIndex(arr, target, index+1, list);
    }

    // Now do it like this-->
    // Reurn the list without passing the argument

    static ArrayList<Integer> searchAllIndex2(int[] arr, int target, int index){
 
        ArrayList<Integer> list = new ArrayList<>();
        
        if(index == arr.length){
            return list;
        }

        // this will contain answer for that function call only
        if((arr[index] == target)){
            list.add(index);
        }

        ArrayList<Integer> ansFromBelowCalls = searchAllIndex2(arr, target, index+1);

        list.addAll(ansFromBelowCalls);
        
        return list;
    }

}
