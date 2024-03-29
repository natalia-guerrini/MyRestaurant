/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.util.HashMap;

/**
 *
 * @author Natalia
 */
public class Supplier implements Entity{
    private final String TABLE_NAME = "supplier";
    private String name;
    private String site;
    
    public Supplier(String name, String site){
        this.name=name;
        this.site=site;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getSite(){
        return this.site;
    }

    @Override
    public String getTableName() {
        return this.TABLE_NAME;
    }

    @Override
    public HashMap<String, Object> map() {
        HashMap<String, Object> res = new HashMap<String, Object>();
        res.put("name", this.name);
        res.put("site", this.site);
        return res;
    }
    
}
