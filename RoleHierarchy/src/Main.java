import javax.swing.text.html.parser.Entity;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Main main = new Main();

        // storage
        int positionPower = 10;
        Map<String, String> reportMap = new LinkedHashMap<>();  // position  and reporting to
        Map<String, List<String>> positions = new HashMap<>();  // position and username
        Map<String, Integer> positionPowerMap = new HashMap<>();  // power of each position
        Map<String,Set<String>> reportees = new LinkedHashMap<>();
        List<String> positionList = new ArrayList<>();


        // Question 1
        System.out.println("Enter root role name: ");
        String root = sc.nextLine();
        reportMap.put(root, null);
        positionList.add(root);
        positions.put(root,new ArrayList<>());
        main.addPosition(positions,root);
        while (true) {
            int choice;
            System.out.println("Operations: \n   1. Add sub role.\n" +
                    "   2. Display roles\n   3. Delete role\n   4. Add user\n"+
                    "   5. Display users\n   6. Display user and sub user\n"+
                    "   7. Delete user\n   8. Number of users from top\n"+
                    "   9. Height of role Hierarchy\n   10. Common boss of users\n");
            try {
                System.out.println("Operation to be performed: ");
                choice = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                break;
            }
            switch (choice) {
                // Question 2
                case 1: {
                    System.out.println("Enter sub role name: ");
                    String subRole = sc.nextLine();
                    System.out.println("Enter reporting to role name: ");
                    String reportingOfficer = sc.nextLine();
                    reportMap.put(subRole,reportingOfficer);
                    positionList.add(subRole);
                    positions.put(subRole,new ArrayList<>());
                    main.addPosition(positions,subRole);
                    break;
                }
                // Question 3
                case 2: {
                    for(Map.Entry<String, String> temp: reportMap.entrySet()){
                        System.out.print(temp.getKey()+" -> ");
                    }
                    break;
                }
                // Question 4
                case 3: {
                    System.out.println("Enter the role to be deleted: ");
                    String deleteRole = sc.nextLine();
                    System.out.println("Enter the role to be transformed: ");
                    String transformedRole = sc.nextLine();
                    reportMap.remove(deleteRole);
                    positions.remove(deleteRole);
                    for(Map.Entry<String,String> temp: reportMap.entrySet()){
                        String s = temp.getKey();
                        String sV = temp.getValue();
                        if(sV!=null && sV.equals(deleteRole))
                            reportMap.put(s,transformedRole);
                    }
                    break;
                }
                // Question 5
                case 4:{
                    System.out.println("Enter User Name: ");
                    String userName = sc.nextLine();
                    System.out.println("Enter role: ");
                    String role = sc.nextLine();
                    main.addUserNames(positions,userName,role);
                    break;
                }
                case 5:{
                    main.display(positions);
                    break;
                }
                case 6: {
                    int posLen = positionList.size();
                    Set<String> set = new HashSet<>();

                    for(int i=posLen-1;i>=0;i--){
                        //System.out.print(positionList.get(i)+" -> ");
                        int c=0;
                        for(Map.Entry<String,String> temp: reportMap.entrySet()){
                            String s1 = positionList.get(i);
                            if(temp.getValue() != null && s1.equals(temp.getValue())) {
                                //System.out.print(temp.getKey() + " ");
                                set.add(temp.getKey());
                                c++;
                            }
                        }
                        if(c==0){
                            reportees.put(positionList.get(i),null);
                            continue;
                        }
                        Set<String> tempset = new HashSet<>();
                        tempset.addAll(set);
                        reportees.put(positionList.get(i), new HashSet<>(tempset));
                        System.out.println();
                    }
                    System.out.println();
                    // main.display(reportees);
                    for(Map.Entry<String,Set<String>> temp: reportees.entrySet()){
                        if(temp.getValue()==null){
                            System.out.println(temp.getKey()+" ->");
                            continue;
                        }
                        List<String> l = new ArrayList<>(temp.getValue());
                        for(String tempset: temp.getValue()){
                            l.add(tempset);
                        }
                        System.out.println(temp.getKey()+" ->"+temp.getValue());
                    }
                    break;
                }
                case 7: {
                    System.out.println("Enter username to be deleted: ");
                    String userName = sc.nextLine();
                    main.deleteUserName(positions,userName);
                    main.display(positions);
                    break;
                }
                case 9:{

                }
                case 10:{
                    System.out.println("The most common boss is :"+positionList.get(0));
                }
                default: {
                    System.out.println("Please enter valid input...");
                }
            }
        }
    }

    void addPosition(Map<String,List<String>> positions,String posName){
        positions.put(posName,new ArrayList<>());
    }

    void addUserNames(Map<String,List<String>> positions, String userName,String role){
        List<String> l = new ArrayList<>(positions.get(role));
//        if(l==null){
//            return;
//        }
        l.add(userName);
        positions.put(role,l);
    }

    void deleteUserName(Map<String, List<String>> positions, String userName){
        for(Map.Entry<String,List<String>> temp:positions.entrySet()){
            for(int i=0;i<temp.getValue().size();i++){
                String tempUser = temp.getValue().get(i);
                List<String> tempList = temp.getValue();
                if(tempUser!=null && tempUser.equals(userName)){
                    tempList.remove(userName);
                    positions.put(temp.getKey(),tempList);
                    return;
                }
            }
        }
    }

    void display(Map<String,List<String>> positions){
        for(Map.Entry<String,List<String>> temp: positions.entrySet()){
            String s=temp.getKey();
            System.out.print(temp.getKey()+" -> ");
            if(temp.getValue()==null){
                continue;
            }
            System.out.println(temp.getValue());
//            for(int i=0;i<temp.getValue().size();i++){
//                System.out.print(temp.getValue().get(i));
//            }
            System.out.println();

        }
    }
}