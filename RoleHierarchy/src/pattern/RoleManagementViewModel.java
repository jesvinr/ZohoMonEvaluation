package pattern;

import java.util.*;

public class RoleManagementViewModel {
    RoleManageModel model = new RoleManageModel();

    void addPosition(Map<String,List<String>> positions,String posName){
        model.positions.put(posName,new ArrayList<>());
    }


    void display(){
        for(Map.Entry<String,List<String>> temp: model.positions.entrySet()){
            String s=temp.getKey();
            System.out.print(temp.getKey()+" -> ");
            if(temp.getValue()==null){
                System.out.println();
                continue;
            }
            System.out.println(temp.getValue());
//            for(int i=0;i<temp.getValue().size();i++){
//                System.out.print(temp.getValue().get(i));
//            }
            System.out.println();

        }
    }

    void deleteUserName(String userName){
        for(Map.Entry<String,List<String>> temp: model.positions.entrySet()){
            for(int i=0;i<temp.getValue().size();i++){
                String tempUser = temp.getValue().get(i);
                List<String> tempList = temp.getValue();
                if(tempUser!=null && tempUser.equals(userName)){
                    tempList.remove(userName);
                    model.positions.put(temp.getKey(),tempList);
                    return;
                }
            }
        }
    }

    void addUserNames(String userName,String role){
        Map<String,List<String>> temp=model.positions;
        List<String> l = new ArrayList<>(temp.get(role));
//        if(l==null){
//            return;
//        }
        l.add(userName);
        temp.put(role,l);
    }

    void addRoles(String role, String reportingOfficer){
        if(reportingOfficer == null){
            model.reportMap.put(role,null);
        }
        else
            model.reportMap.put(role,reportingOfficer);
        model.positionList.add(role);
        model.positions.put(role,new ArrayList<>());
        addPosition(model.positions,role);
    }

    void displayRoles()
    {
        for(Map.Entry<String, String> temp: model.reportMap.entrySet()){
            System.out.print(temp.getKey()+" -> ");
        }
    }

    void deleteRoles(String deleteRole, String transformedRole){
        model.reportMap.remove(deleteRole);
        model.positions.remove(deleteRole);
        for(Map.Entry<String,String> temp: model.reportMap.entrySet()){
            String s = temp.getKey();
            String sV = temp.getValue();
            if(sV!=null && sV.equals(deleteRole))
                model.reportMap.put(s,transformedRole);
        }
    }

    void displayUserAndSubUsers(){
        int posLen = model.positionList.size();
        Set<String> set = new HashSet<>();

        for(int i=posLen-1;i>=0;i--){
            //System.out.print(model.positionList.get(i)+" -> ");
            int c=0;
            for(Map.Entry<String,String> temp: model.reportMap.entrySet()){
                String s1 = model.positionList.get(i);
                if(temp.getValue() != null && s1.equals(temp.getValue())) {
                    //System.out.print(temp.getKey() + " ");
                    set.add(temp.getKey());
                    c++;
                }
            }
            if(c==0){
                model.reportees.put(model.positionList.get(i),null);
                continue;
            }
            Set<String> tempset = new HashSet<>();
            tempset.addAll(set);
            model.reportees.put(model.positionList.get(i), new HashSet<>(tempset));
            System.out.println();
        }
        System.out.println();
        for(Map.Entry<String,Set<String>> temp: model.reportees.entrySet()){
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
    }
}
