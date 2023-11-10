import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class mathExpression {
//    public static void main(String[] args) {
//        char[] ex = {'+','-','*','/','%'};
//        char[] ob = {'(','{','['};
//        char[] cb = {')','}','['};
//
//        ArrayList<Character> arr1 = new ArrayList<>();
//        ArrayList<Character> arr2 = new ArrayList<>();
//
//        Scanner sc = new Scanner(System.in);
//        String s=sc.nextLine();
//        int v=0;
//ol:     for(int i=0;i<s.length();i++){
//            //checking ob
//            for(int j=0;j<ob.length;j++){
//                if(s.charAt(i)==ob[j]){
//                    arr1.add(ob[j]);
//                    continue ol;
//                }
//            }
//
//            //checking cb
//            for(int j=0;j<cb.length;j++){
//                boolean b = s.charAt(i) == cb[j];
//                if(b && arr1.contains(ob[j])){
//                    arr1.remove(ob[j]);
//                    continue ol;
//                }
//                else if(b && arr1.get(arr1.size()-1)!=ob[j]){
//                    v=1;
//                    break ol;
//                }
//            }
//
//            // checking expression
//            if(Character.isLetter(s.charAt(i))){
//                if(i+1<s.length() && i-1>=0 && !Character.isLetter(s.charAt(i+1)) &&
//                    !Character.isLetter(i-1)){
//                    arr2.add(s.charAt(i));
//                }
//                else{
//                    if(i+1<s.length() && i-1>=0 && (Character.isLetter(i+1)
//                            || Character.isLetter(i+1))){
//                        v=1;
//                        break ol;
//                    }
//                }
//                if(i-2>=0 && Character.isLetter(i-2) && Character.isLetter(i)){
//                    arr2.remove(0);
//                    arr2.remove(0);
//                    arr2.remove(0);
//                }
//            }
//        }
//
//        if(arr1.isEmpty() && arr2.isEmpty() && v==0){
//            System.out.println("valid");
//        }
//        else{
//            System.out.println("Invalid");
//        }
//
//    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String input = sc.nextLine();
        boolean isValid = isValidExpression(input);

        if (isValid) {
            System.out.print("valid");
        }
        else
        {
            System.out.print("invalid");
        }
    }

        public static boolean isValidExpression(String exp) {
            Stack<Character> stack = new Stack<>();

            for (char ch : exp.toCharArray()) {
                if (ch == '(' || ch == '[' || ch == '{') {
                    stack.push(ch);
                } else if (ch == ')' || ch == ']' || ch == '}') {
                    if (stack.isEmpty() || !isAPair(stack.pop(), ch)) {
                        return false;
                    }
                }
            }

            // If the stack is empty, all parentheses are matched
            return stack.isEmpty();
        }

        private static boolean isAPair(char st, char fn) {
            return (st == '(' && fn == ')') ||
                    (st == '[' && fn == ']') ||
                    (st == '{' && fn == '}');
        }
}
