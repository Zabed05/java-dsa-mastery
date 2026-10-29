public class MazeWithObstacles {
    public static void main(String[] args) {
        boolean[][] maze = {
            {true, true, true},
            {true, false, true},
            {true, true, true}
        };

        printPaths("", maze, 0, 0);
    }

    static void printPaths(String p, boolean[][] maze, int r, int c){
        int m = maze.length - 1;
        int n = maze[0].length - 1;

        if(r == m && c == n){
            System.out.println(p);
            return;
        }
        
        // for obstacles
        if(!maze[r][c]){ // means, when we get -> maze[r][c] == false, just return(stop the recurssion call)
            return;
        }


        if(r < m){
            printPaths(p + 'D', maze, r+1, c);
        }
        if(c < n){
            printPaths(p + 'R', maze, r, c+1);
        }
    }
}
