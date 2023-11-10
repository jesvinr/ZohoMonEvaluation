import java.util.Arrays;
import java.util.Scanner;

public class stringZigZagPattern {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s=scan.nextLine();
        int n= Integer.parseInt(scan.nextLine());
        String res[] = new String[n];
        Arrays.fill(res,"");
        int alphabets = 0;
        for(int w=0;alphabets<s.length();w++){
            for(int i =0;i<n;i++){
                if(alphabets<s.length()){
                    res[i]+=s.charAt(alphabets++);
                }
                else{
                    res[i]+=" ";
                }
                if(i==0 || i==n-1){
                    for(int j=0;j<n-1;j++){
                        res[i]+=" ";
                    }
                }
            }

            for(int i=n-1;i>0;i--){
                for(int j=1;j<n-1;j++){
                    if(i+j==n-1 && alphabets<s.length()){
                        res[i]+=s.charAt(alphabets++);
                    }else{
                        res[i]+=" ";
                    }
                }
            }
        }
        for (String i:res){
            System.out.println(i);
        }
    }
}
