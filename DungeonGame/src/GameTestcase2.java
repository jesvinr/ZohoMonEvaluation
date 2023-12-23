import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class GameTestcase2 {
    public static void main(String[] args) {
        GameTestcase2 game = new GameTestcase2();
        char[][] room = {
                {'0','0','0','G'},
                {'0','0','0','0'},
                {'0','0','T','0'},
                {'0','0','0','0'}
        };
        // adventurer location
        int row=2,col=0;

        // Monster Location
        int Mrow = 2,Mcol =0;

        // Gold location
        int Grow =0,Gcol = 3;
        List<Integer> res = new ArrayList<>();

        // Checking monster can reach adventurer
        if(game.differenceBetweenMonsterAndAdventurer(row,col,Mrow,Mcol,Grow,Gcol))
        {
            System.out.println("No possible solution");
            System.out.println("Monster will catch you and kill you!!!");
            System.exit(0);
        }
        game.findStep(room,row,col,res,0);
        Set<Integer> resultSet = new TreeSet<>(res);

        int minStep = 0;
        for(Integer temp:resultSet){
            minStep = temp;
            break;
        }
        System.out.println(minStep);
    }


    // finding steps using recursion
    boolean findStep(char[][] room, int i, int j, List<Integer> res,int step){
        if(i<0 || j<0 || i>=room.length || j>=room[0].length){
            return false;
        }

        if(room[i][j]=='G'){
            res.add(step);
            return true;
        }
        if(isValidMove(room,i,j)) {
            if(room[i][j]=='T'){
                System.out.println("Trigger reached! Teleported to gold");
                res.add(step);
                return true;
            }
            room[i][j] = 'A';
            if (findStep(room, i -1, j, res, step + 1) || findStep(room, i+1, j, res, step + 1)
                    || findStep(room, i, j-1, res, step + 1) || findStep(room, i, j +1, res, step + 1)) {

            }
            if(findStep(room, i +1, j, res, step + 1) || findStep(room, i, j+1, res, step + 1)
                    || findStep(room, i-1, j-1, res, step + 1) || findStep(room, i, j+1, res, step + 1)){

            }

            room[i][j] = '0';
            return true;
        }
        return false;
    }

    boolean differenceBetweenMonsterAndAdventurer(int Arow,int Acol,int Mrow,int Mcol,int Grow,int Gcol){
        // steps between gold and adevnturer
        int adGoPath = Math.abs(Arow-Grow)+Math.abs(Acol-Gcol);

        // steps between gold and monster
        int monGoPath = Math.abs(Mrow-Grow)+Math.abs(Mcol-Gcol);
        if(adGoPath-monGoPath>0){
            return false;
        }
        return true;
    }

    private static boolean isValidMove(char[][] maze, int row, int col) {
        int numRows = maze.length;
        int numCols = maze[0].length;

        // Check if the move is within the bounds of the maze and is an open path
        return row >= 0 && row < numRows && col >= 0 && col < numCols && (maze[row][col] == '0' || maze[row][col]=='T');
    }
}
