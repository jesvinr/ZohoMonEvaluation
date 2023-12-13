import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        WordFrequencyCounter wordFrequencyCounter = new WordFrequencyCounter();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        wordFrequencyCounter.countWord(str);
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

        // eliminating duplicate element to check with original list
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
