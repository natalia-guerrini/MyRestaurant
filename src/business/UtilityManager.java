package business;

import java.sql.SQLException;
import java.util.ArrayList;
import model.dao.UtilityTable;
import model.entity.Utility;

import java.util.HashMap;

public class UtilityManager {

    private UtilityTable utilityTable;

    public UtilityManager(){
        this.utilityTable = new UtilityTable();
    }

    public boolean save(HashMap<String, Object> data){
        Utility utility = this.utilityTable.constructEntityFromMap(data);
        return this.utilityTable.save(utility);
    }
    
    public ArrayList getAll(){
        ArrayList<Utility> utilities = this.utilityTable.getAll();
        ArrayList<HashMap<String,Object>> res  = new ArrayList<HashMap<String,Object>>();
        for(Utility utility : utilities){
            res.add(utility.map());
        }
        return res;
    }
     public ArrayList getAllbyPage(int page, HashMap<String, String> filters, String utilityType) throws SQLException{
        ArrayList<Utility> utilities = this.utilityTable.getPageWithStatus(page, filters, utilityType);
        return this.parseRes(utilities);
    }
     
     private ArrayList parseRes(ArrayList<Utility> list){
        ArrayList<HashMap<String,Object>> res  = new ArrayList<HashMap<String,Object>>();
        for(Utility utility : list){
            res.add(utility.map());
        }
        return res;
    }
    
     public int getTotalUtilities(){
        return utilityTable.getTotal();
    }
     
    public void setOrdersPageLength(int l){
        this.utilityTable.setPageLength(l);
    }
     
      public void setUtilitiesPageLength(int l){
        this.utilityTable.setPageLength(l);
    }
     
      public boolean updateUtility(HashMap<String, Object> utilityInfo ){
        Utility utility = this.utilityTable.constructEntityFromMap(utilityInfo);
        return this.utilityTable.update(utility);
    }
    
    public ArrayList getFrom(Object searchParam, String paramName ){
        ArrayList<Utility> utilities = this.utilityTable.getFrom(searchParam, paramName);
        ArrayList<HashMap<String,Object>> res  = new ArrayList<HashMap<String,Object>>();
        for(Utility utility : utilities){
            res.add(utility.map());
        }
        return res;
    }
}
