import java.util.ArrayList;

public class Maze {
    public static void main(String[] args) {
        System.out.println(countPaths(3, 3));

        printPaths("", 3, 3);

        System.out.println(printPathsReturn("", 3, 3));

        System.out.println(printPathsDiagonal("", 3, 3));
    }

    // Counting Paths
    static int countPaths(int r, int c){
        if(r == 1 || c == 1){
            return 1;
        }

        int left = countPaths(r-1, c);
        int right = countPaths(r, c-1);

        return  left + right;
    }

    // Printing Paths
    static void printPaths(String p, int r, int c){
        if(r == 1 && c == 1){
            System.out.println(p);
            return;
        }

        if(r > 1){
            printPaths(p + 'D', r-1, c);
        }
        if(c > 1){
            printPaths(p + 'R', r, c-1);
        }
    }

    // Return in ArrayList
    static ArrayList<String> printPathsReturn(String p, int r, int c){
        if(r == 1 && c == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();

        if(r > 1){
            list.addAll(printPathsReturn(p + 'D', r-1, c));
        }
        if(c > 1){
            list.addAll(printPathsReturn(p + 'R', r, c-1));
        }

        return list;
    }


    // Now add Diagonal also....
    static ArrayList<String> printPathsDiagonal(String p, int r, int c){
        if(r == 1 && c == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();
        // for vartical
        if(r > 1){
            list.addAll(printPathsDiagonal(p + 'V', r-1, c));
        }
        // for diagonal
        if(r > 1 && c > 1){
            list.addAll(printPathsDiagonal(p + 'D', r-1, c-1));
        }
        // for Horizontal
        if(c > 1){
            list.addAll(printPathsDiagonal(p + 'H', r, c-1));
        }

        return list;
    }
}
