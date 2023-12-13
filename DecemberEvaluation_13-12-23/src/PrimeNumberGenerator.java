import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeNumberGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrimeNumberGenerator primeNumberGenerator = new PrimeNumberGenerator();
        int n = Integer.parseInt(sc.nextLine());
        //int[] arr = new int[n];
        System.out.print(primeNumberGenerator.primes(n));
    }
    List<Integer> primes(int n){
        List<Integer> listArray = new ArrayList<>();
        for(int i=2;i<n;i++){
            int k=0;
            for(int j=2;j<i;j++){
                if(i%j==0){
                    k++;
                    break;
                }
            }
            if(k==0){
                listArray.add(i);
            }
        }
        return listArray;
    }
}
