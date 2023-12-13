import java.util.*;

/*
[["5","3",".",".","7",".",".",".","."],
["6",".",".","1","9","5",".",".","."],
[".","9","8",".",".",".",".","6","."],
["8",".",".",".","6",".",".",".","3"],
["4",".",".","8",".","3",".",".","1"],
["7",".",".",".","2",".",".",".","6"],
[".","6",".",".",".",".","2","8","."],
[".",".",".","4","1","9",".",".","5"],
[".",".",".",".","8",".",".","7","9"]]
 */
/*
{
        {5,3,0,0,7,0,0,0,0},
        {6,0,0,1,9,5,0,0,0},
        {0,9,8,0,0,0,0,6,0},
        {8,0,0,0,6,0,0,0,3},
        {4,0,0,8,0,3,0,0,1},
        {7,0,0,0,2,0,0,0,6},
        {0,6,0,0,0,0,2,8,0},
        {0,0,0,4,1,9,0,0,5},
        {0,0,0,0,8,0,0,7,9}
        };

 */
public class SudokuSolver {
    public static void main(String[] args) {
        SudokuSolver sudokuSolver = new SudokuSolver();
        //Scanner sc = new Scanner(System.in);
        int[][] sudokuBoard ={
                {1,0,6,0,7,8,0,3,0},
                {0,5,7,3,4,9,0,6,2},
                {2,9,3,6,0,5,0,0,7},
                {0,0,0,8,0,1,6,0,4},
                {4,6,1,0,0,0,2,8,9},
                {5,8,0,0,6,4,3,0,0},
                {7,3,4,1,9,6,5,0,8},
                {6,1,8,7,0,2,4,9,3},
                {0,0,0,0,8,0,0,1,0}
        };
        sudokuSolver.validateSudoku(sudokuBoard);
        sudokuSolver.display(sudokuBoard);


    }
    void display(int[][] sudokuBoard){
        for (int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(sudokuBoard[i][j]+" ");
            }
            System.out.println();
        }
    }

    void validateSudoku(int[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!=0){
                    continue;
                }
                int iMat=0;
                int jMat=0;
                iMat= i/3;
                jMat = j/3;
                List<Integer> elementInRow = new ArrayList<>();
                List<Integer> elementsInCol = new ArrayList<>();
                List<Integer> elementIn3x3 = new ArrayList<>();

                // Result
                Set<Integer> res = new TreeSet<>();

                // for row and col
                for(int elementsInRows =0;elementsInRows<9;elementsInRows++){
                    if(board[i][elementsInRows]!=0){
                        elementInRow.add(board[i][elementsInRows]);
                    }
                }

                for(int elementsInColumns=0;elementsInColumns<9;elementsInColumns++){
                    if(board[elementsInColumns][j]!=0){
                        elementsInCol.add(board[elementsInColumns][j]);
                    }
                }
                //System.out.println(elementInRow);
                //System.out.println(elementsInCol);
                for(int temp1 =iMat*3; temp1< (iMat+1)*3; temp1++){
                    for(int temp2 =jMat*3; temp2<(jMat+1)*3; temp2++){
                        if(board[temp1][temp2]!=0) {
                            elementIn3x3.add(board[temp1][temp2]);
                        }
                    }
                }
                //System.out.println(elementIn3x3);

                res.addAll(elementInRow);
                res.addAll(elementsInCol);
                res.addAll(elementIn3x3);
                //System.out.println(res);
                int r2 = 0;
                for(int r=1;r<=9;r++){
                    if(!res.contains(r)){
                        r2 = r;
                    }
                }
                if(r2!=0){
                    board[i][j] = r2;
                }
                //System.out.println();
            }
        }
    }
}
