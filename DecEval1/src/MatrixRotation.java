import java.util.Scanner;
/*
1 2 3
4 5 6
7 8 9
 */
public class MatrixRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num= Integer.parseInt(sc.nextLine());
        int[][] mat = new int[num][num];
        int element =1;

        // Inputting matrix
        for(int i=0;i<num;i++){
            for(int j=0;j<num;j++){
                mat[i][j] = element;
                element++;
            }
        }
        //print(mat,num);
            for (int i = 0; i <num; i++) {
                for (int j = i; j < num; ++j) {
                    int temp = mat[i][j];
                    mat[i][j] = mat[j][i];
                    mat[j][i] = temp;
                }
            }
        //print(mat,num);
        for(int i=0;i<num;i++){
            for(int j=0;j<num/2;j++){
                int temp = mat[i][num-j-1];
                mat[i][num-j-1] = mat[i][j];
                mat[i][j] = temp;
            }
        }
        print(mat,num);


        // Printing

    }
    static void print(int[][] mat,int num){
        for(int i=0;i<num;i++){
            for(int j=0;j<num;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}
