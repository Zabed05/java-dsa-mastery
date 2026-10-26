public class Maze {
    public static void main(String[] args) {
        System.out.println(countPaths(3, 3));

        printPaths("", 3, 3);
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
}
