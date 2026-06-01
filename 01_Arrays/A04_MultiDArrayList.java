import java.util.ArrayList;
import java.util.Scanner;

public class A04_MultiDArrayList {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter no of Row:");
        int row = sc.nextInt();

        System.out.println("Enter no of Column:");
        int col = sc.nextInt();

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        // initialization
        for(int i = 0; i < row; i++){
            list.add(new ArrayList<>());
        }
 
        //add elements
        System.out.println("---Add Elements---");
        for(int i = 0; i < row; i++){
            System.out.println("input for colum no " + (i+1) );
            for(int j = 0; j < col; j++){
                list.get(i).add(sc.nextInt());
            }
        }

        //Dsiplay
        System.out.println("Output:");
        System.out.println(list);

        sc.close();
    }
}
