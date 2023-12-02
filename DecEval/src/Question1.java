import java.util.ArrayList;
import java.util.Scanner;
/*
input: -2 1 -3 4 -1 2 1 -5 4
 */
public class Question1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] gnArr = new int[n];
        for(int i=0;i<n;i++){
            gnArr[i] = sc.nextInt();
        }
        int  sum = Integer.MIN_VALUE;
        int start = 0, end=0;
        for(int i=0;i<n;i++){
            int tempSum =0;
            for(int j=i;j<n;j++){
                 tempSum = tempSum + gnArr[j];
                if(tempSum>=sum){
                    sum = tempSum;
                    start = i;
                    end =j;
                }
            }

        }
        //System.out.println(sum+" "+ start+ " "+ end);
        for(int i=start;i<=end;i++){
            System.out.print(gnArr[i]+ " ");
        }

    }
}
