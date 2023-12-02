import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Questions4 {
    /*
    Given a string composed of lowercase English letters, find the lexiographically smallest
    string that can be formed by removing some character(possibly no character) from
    the string.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        StringBuffer s1 = new StringBuffer(str1);

        int c=0;
        for(int i=0;i<str2.length();i++){
            for(int j=0;j<s1.length();j++){
                if(str2.charAt(i)==s1.charAt(j)){
                    s1.replace(j,j+1,"");
                    c++;
                    break;
                }
            }
        }
        if(c==str2.length())
            System.out.println("True");
        else
            System.out.println("False");
    }
}
