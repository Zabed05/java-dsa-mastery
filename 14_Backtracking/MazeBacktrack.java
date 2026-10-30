import java.util.Arrays;

public class MazeBacktrack {
    public static void main(String[] args) {
        
        boolean[][] maze = {
            {true, true, true},
            {true, true, true},
            {true, true, true}
        };

        allPaths("", maze, 0, 0);


        int[][] path = new int[maze.length][maze[0].length];

        allPathsPrint("", maze, 0, 0, path, 1);
    }

    static void allPaths(String p, boolean[][] maze, int r, int c){
        int m = maze.length - 1;
        int n = maze[0].length - 1;

        if(r == m && c == n){
            System.out.println(p);
            return;
        }

        if(!maze[r][c]){
            return;
        }

        // Now I am considering this block is in my path
        maze[r][c] = false;

        if(r < m){
            allPaths(p + 'D', maze, r+1, c);
        }
        if(c < n){
            allPaths(p + 'R', maze, r, c+1);
        }

        if(r > 0){
            allPaths(p + 'U', maze, r-1, c);
        }

        if(c > 0){
            allPaths(p + 'L', maze, r, c-1);
        }

        // this line is where the function will be over
        // so before the function gets removed, also remove the changes that were made by that function
        maze[r][c] = true;

    }

    // Print matrix and Paths
    static void allPathsPrint(String p, boolean[][] maze, int r, int c, int[][] path, int step){
        int m = maze.length - 1;
        int n = maze[0].length - 1;

        if(r == m && c == n){
            System.out.println(p);
            path[r][c] = step;
            for(int[] arr: path){
                System.out.println(Arrays.toString(arr));
            }
            return;
        }

        if(!maze[r][c]){
            return;
        }

        // Now I am considering this block is in my path
        maze[r][c] = false;
        path[r][c] = step;

        if(r < m){
            allPathsPrint(p + 'D', maze, r+1, c, path, step+1);
        }
        if(c < n){
            allPathsPrint(p + 'R', maze, r, c+1, path, step+1);
        }

        if(r > 0){
            allPathsPrint(p + 'U', maze, r-1, c, path, step+1);
        }

        if(c > 0){
            allPathsPrint(p + 'L', maze, r, c-1, path, step+1);
        }

        // this line is where the function will be over
        // so before the function gets removed, also remove the changes that were made by that function
        maze[r][c] = true;
        path[r][c] = 0; // When we go back, erasing the path (set as 0)

    }
}