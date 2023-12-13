import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PascalTriangle pascalTriangle = new PascalTriangle();
        int n= Integer.parseInt(sc.nextLine());
        List<List<Integer>> result= pascalTriangle.solution(n);
        for(List<Integer> print: result){
            System.out.println(Arrays.toString(print.toArray()));
        }
    }

    List<List<Integer>> solution(int n){
        List<List<Integer>> result = new ArrayList<>();
        int startCount = 1;
        for(int i=0;i<n;i++){
            List<Integer> tempResult = new ArrayList<>();
            if(i==0){
                tempResult.add(startCount);
                result.add(tempResult);
                continue;
            }
            for(int j=0;j<result.get(i-1).size()+1;j++){
                if(j==0 || j==result.get(i-1).size()){
                    tempResult.add(result.get(i-1).get(0));
                }
                else{
                    tempResult.add(result.get(i-1).get(j)+result.get(i-1).get(j-1));
                }
            }
            System.out.println(tempResult);
            result.add(tempResult);
        }
        return result;
    }
}
