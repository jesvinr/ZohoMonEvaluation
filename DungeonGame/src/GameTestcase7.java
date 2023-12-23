import java.util.*;

public class GameTestcase7 {
    public static void main(String[] args) {
        GameTestcase7 game = new GameTestcase7();
        Scanner sc = new Scanner(System.in);

        char[][] room = {
                {'0','0','0','0'},
                {'0','0','0','0'},
                {'0','0','0','0'},
                {'0','0','0','0'}
        };
        // adventurer location
        System.out.println("Enter adventurer location in dungeon...");
        int row=sc.nextInt(),col=sc.nextInt();
        sc.nextLine();

        // Monster Location
        System.out.println("Enter Monster location in dungeon...");
        int Mrow = sc.nextInt(),Mcol = sc.nextInt();
        sc.nextLine();

        // Gold location
        System.out.println("Enter Gold location in dungeon...");
        int Grow =sc.nextInt(),Gcol = sc.nextInt();
        sc.nextLine();

        // pits location
        List<List<Integer>> pits = new ArrayList<>();
        System.out.println("Enter number of pits..");
        int pNum = sc.nextInt();
        for(int i=0;i<pNum;i++){
            int prow = sc.nextInt();
            int pcol = sc.nextInt();
            pits.add(Arrays.asList(prow,pcol));
        }
        sc.nextLine();

        // trigger location
        int tRow = sc.nextInt(),tCol = sc.nextInt();
        sc.nextLine();


        game.givingInput(room,Grow,Gcol,pits,Mrow,Mcol,tRow,tCol);
        game.display(room);
        List<Integer> res = new ArrayList<>();

        // Checking monster can reach adventurer
        if(game.differenceBetweenMonsterAndAdventurer(row,col,Grow,Gcol,Mrow,Mcol,tRow,tCol))
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

        if(room[i][j]=='G' || room[i][j]=='T'){
            //display(room);
            res.add(step);
            return true;
        }
        if(isValidMove(room,i,j)) {
            room[i][j] = 'A';
            if (findStep(room, i -1, j, res, step + 1) || findStep(room, i+1, j, res, step + 1)
                    || findStep(room, i, j-1, res, step + 1) || findStep(room, i, j +1, res, step + 1)) {

            }

            if(findStep(room, i +1, j, res, step + 1) || findStep(room, i, j+1, res, step + 1)
                    || findStep(room, i-1, j-1, res, step + 1) || findStep(room, i, j+1, res, step + 1)){

            }
            if(findStep(room, i , j+1, res, step + 1) || findStep(room, i+1, j, res, step + 1)
                    || findStep(room, i-1, j-1, res, step + 1) || findStep(room, i, j-1, res, step + 1)){

            }
            if(findStep(room, i , j-1, res, step + 1) || findStep(room, i+1, j, res, step + 1)
                    || findStep(room, i-1, j-1, res, step + 1) || findStep(room, i, j+1, res, step + 1)){

            }
            step=0;
            room[i][j] = '0';
            return true;
        }
        return false;
    }

    boolean differenceBetweenMonsterAndAdventurer(int Arow,int Acol,int Mrow,int Mcol,int Grow,int Gcol,int Trow,int Tcol){
        // steps between gold and adevnturer
        int adGoPath = Math.abs(Arow-Grow)+Math.abs(Acol-Gcol);

        // steps between gold and monster
        int monGoPath = Math.abs(Mrow-Grow)+Math.abs(Mcol-Gcol);

        // steps between trigger and adventurer
        int ta = Math.abs(Arow-Trow)+Math.abs(Acol-Tcol);
        int tm = Math.abs(Mrow-Trow)+Math.abs(Mrow-Tcol);
        if(Math.abs(adGoPath-monGoPath)>0 || Math.abs(ta-tm)>0){
            return false;
        }
        return true;
    }

    private static boolean isValidMove(char[][] maze, int row, int col) {
        int numRows = maze.length;
        int numCols = maze[0].length;

        // Check if the move is within the bounds of the maze and is an open path
        return row >= 0 && row < numRows && col >= 0 && col < numCols && maze[row][col] == '0';
    }


    //
    void givingInput(char[][] room,int Grow,int Gcol,List<List<Integer>> pits,
                     int Mrow,int Mcol,int tRow,int tCol){
        int e=0;
        for(int i=0;i<room.length;i++){
            for(int j=0;j<room[0].length;j++){
                if(Grow==i && Gcol==j){
                    room[i][j] ='G';
                    continue;
                }
                if(Mrow==i && Mcol==j){
                    room[i][j]='M';
                    continue;
                }
                if(tRow==i && tCol==j){
                    room[i][j]='T';
                    continue;
                }
                if(e<pits.size() && i==pits.get(e).get(0) && j==pits.get(e).get(1)){
                    room[i][j] = 'P';
                    e++;
                }
            }
        }
    }

    void display(char[][] room){
        for(int i=0;i<room.length;i++){
            System.out.println(room[i]);
        }
        System.out.println();
    }
}
