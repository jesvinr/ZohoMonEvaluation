import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LargestPossibleStringLexi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> st = new ArrayList<>();
        int n= Integer.parseInt(sc.nextLine());
        for(int i=0;i<n;i++){
            st.add(sc.nextLine());
        }
        for (int i=0;i<st.size();i++){
            System.out.println(lexi(st.get(i)));
        }
    }

    static public String lexi(String s){
        // Collections.sort(al, Collections.reverseOrder());
        char[] c=s.toCharArray();
        Arrays.sort(c);
        StringBuilder k= new StringBuilder();
        for (int i=c.length-1;i>=0;i--){
            k.append(c[i]);
        }
        return k.toString();
    }
}
