import java.util.*;

public class Question3 {

    public static void main(String[] args) {
        Question3 q3 = new Question3();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        q3.countWord(str);
    }
    void countWord(String str){
        StringBuilder str2 = new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==',' || str.charAt(i)=='.' || str.charAt(i)=='\''){
                continue;
            }
            str2.append(str.charAt(i));
        }
        String[] arrayStr = str2.toString().toLowerCase().split(" ");
        // System.out.println(Arrays.toString(arrayStr));

        // eliminating duplicate element
        List<String> strList = Arrays.asList(arrayStr);
        Set<String> strSet = new LinkedHashSet<>(strList);

        // finding count
        for(String i:strSet){
            int count = 0;
            for(int j=0;j<arrayStr.length;j++){
                if(i.equals(arrayStr[j])){
                    count++;
                }
            }
            System.out.print(i+" ->"+count);
            System.out.print(", ");
        }

    }
}
