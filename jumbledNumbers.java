import java.util.Scanner;

public class jumbledNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s= sc.nextLine();
        boolean check = true;
        for(int i=0;i<s.length()-1;i++){
            if(Math.abs(s.charAt(i)-s.charAt(i+1))>=2){
                System.out.println(s+" is not a jumbled number");
                check = false;
                break;
            }
        }
        if(check){
            System.out.println(s+" is a jumbled number");
        }

    }
}
