import java.util.Scanner;

public class Question2 {
    /*
    Transpose a given matrix
     */
    public static void main(String[] args) {
        Question2 q2 = new Question2();
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        q2.transposeMatrix(num);
    }

    void transposeMatrix(int n){
        int[][] arr = new int[n][n];
        int arrCount = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=arrCount++;
            }
        }

        // Debugging
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        // printing
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
