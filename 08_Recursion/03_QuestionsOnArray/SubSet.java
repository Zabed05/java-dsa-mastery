import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        List<List<Integer>> ans = subSetDuplicate(arr);

        for (List<Integer> list : ans) {
            System.out.println(list);
        }

    }

    public static List<List<Integer>> subSet(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();
        
        outer.add(new ArrayList<Integer>());
        for (int num : arr) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i)); // create a copy of ith list
                internal.add(num);
                outer.add(internal);
            }
        }
        return outer;
    }

    // For duplicate elements
    public static List<List<Integer>> subSetDuplicate(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<Integer>());
        int start = 0;
        int end = 0;

        for (int i = 0; i < arr.length; i++) {
            start = 0;
            // if current and previous element is same, start = end+1
            if (i > 0 && arr[i] == arr[i-1]) { // for checking from 2nd indeces (i > 0) 
                start = end+1;
            }
            end = outer.size()-1; // now this is the end index

            int n = outer.size();
            for (int j = start; j < n; j++) {
                List<Integer> internal = new ArrayList<>(outer.get(j)); // create a copy of ith list
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
    }
}
