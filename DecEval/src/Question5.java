import java.util.Scanner;


/*
Input:
n:       5
String:  welcometozohoschoolforgraudatestudies
tartget: hoo
 */
public class Question5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int col = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();

        String target = sc.nextLine();

        int targetIndS = 0,targetIndE =0;
        //searching
        for(int i=0;i<str.length();i++){
            if(str.contains(target)){
                targetIndS = str.indexOf(target);
                targetIndE = targetIndS+target.length()-1;
                break;
            }
        }
        if(targetIndS ==0 && targetIndE==0){
            System.out.println("Not found");
        }
        System.out.println("Starting range: <"+targetIndS/col+", "+targetIndS%col+">");
        System.out.println("Ending range: <"+targetIndE/col+", "+targetIndE%col+">");

    }
}
