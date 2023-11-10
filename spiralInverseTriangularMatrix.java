import java.util.Scanner;

public class spiralInverseTriangularMatrix {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n =sc.nextInt();
        int[][] arr = new int[n][n];
        int k=1;  //count
        int a=0,c=n-1;
        int b=0,d=n-1;
        int ld= (int) Math.pow(n,2);
        for(int i=n-1;i>0;i--){
            ld = ld -i;
        }
        while(k<=ld){
            for(int i=a;i<=c;i++){
                arr[i][b]=k;
                k++;
            }
            b++;c--;
            for(int i=c;i>=a;i--){
                arr[i][d]=k;
                k++;
            }
            d--;
            for(int i=d;i>=b;i--){
                arr[a][i]=k;
                k++;
            }
            a++;c--;
        }

        for(int i=0;i<n;i++){
            for(int sp=0;sp<i;sp++){
                System.out.print("  ");
            }

            for(int j=0;j<n;j++){
                if(arr[i][j]==0)
                    continue;
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

}
