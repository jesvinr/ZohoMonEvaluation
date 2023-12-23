import java.util.*;

public class GameTestcase1 {
    public static void main(String[] args) {
        GameTestcase1 game = new GameTestcase1();
        char[][] room = {
                {'0','0','0','G'},
                {'0','0','0','0'},
                {'0','0','0','0'},
                {'0','0','0','0'}
        };
        // adventurer location
        int row=3,col=0;
        List<Integer> res = new ArrayList<>();
        game.findStep(room,row,col,0,3,res,1);
        Set<Integer> resultSet = new TreeSet<>(res);
        int minStep = 0;
        for(Integer temp:resultSet){
            minStep = temp;
            break;
        }
        System.out.println(minStep);
    }


    // finding steps using recursion
    boolean findStep(char[][] room, int i, int j, int gi, int gj, List<Integer> res,int step){
        if(i<0 || j<0 || i>=room.length || j>=room[0].length){
            return false;
        }

        if(room[i][j]=='G'){
            res.add(step);
            return true;
        }
        if(isValidMove(room,i,j)) {
            room[i][j] = 'A';
            if (findStep(room, i -1, j, gi, gj, res, step + 1) || findStep(room, i+1, j, gi, gj, res, step + 1)
                    || findStep(room, i, j-1, gi, gj, res, step + 1) || findStep(room, i, j +1, gi, gj, res, step + 1)) {

            }
            if(findStep(room, i +1, j, gi, gj, res, step + 1) || findStep(room, i, j+1, gi, gj, res, step + 1)
                    || findStep(room, i-1, j-1, gi, gj, res, step + 1) || findStep(room, i, j+1, gi, gj, res, step + 1)){

            }

            room[i][j] = '0';
            return true;
        }
        return false;
    }

    private static boolean isValidMove(char[][] maze, int row, int col) {
        int numRows = maze.length;
        int numCols = maze[0].length;

        // Check if the move is within the bounds of the maze and is an open path
        return row >= 0 && row < numRows && col >= 0 && col < numCols && maze[row][col] == '0';
    }
}
