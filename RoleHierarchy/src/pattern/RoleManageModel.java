package pattern;

import java.util.*;

public class RoleManageModel {
    static RoleManageModel model;

    Map<String, String> reportMap = new LinkedHashMap<>();  // position  and reporting to
    Map<String, List<String>> positions = new HashMap<>();  // position and username
    Map<String, Integer> positionPowerMap = new HashMap<>();  // power of each position
    Map<String, Set<String>> reportees = new LinkedHashMap<>();
    List<String> positionList = new ArrayList<>();
    RoleManageModel(){
        // Empty constructor
    }

    public static RoleManageModel getInstance(){
        if(model == null){
            model = new RoleManageModel();
        }
        return model;
    }

    // displaying for question 2

    public Map<String,String> getReportMap(){
        return reportMap;
    }
}
