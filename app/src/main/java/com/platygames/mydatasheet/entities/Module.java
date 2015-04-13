package com.platygames.mydatasheet.entities;

import java.util.List;
import java.util.ArrayList;
/**
 * Created by Miki-Muntain on 13/04/2015.
 */
public class Module {
    private String module_id;
    private String sheet_id;
    private String module_name;
    private String module_desc;
    private List<Item> module_items;

    public Module(){
        this.module_items=new ArrayList<Item>();
    }

    public Module(String m_id, String s_id, String name, String desc){
        this.module_id=m_id;
        this.sheet_id=s_id;
        this.module_name=name;
        this.module_desc=desc;
        this.module_items=new ArrayList<Item>();
    }

    public Module(String m_id, String s_id, String name, String desc, List<Item> items){
        this.module_id=m_id;
        this.sheet_id=s_id;
        this.module_name=name;
        this.module_desc=desc;
        this.module_items=items;
    }

    public String getModule_id() {
        return module_id;
    }

    public void setModule_id(String module_id) {
        this.module_id = module_id;
    }

    public String getSheet_id() {
        return sheet_id;
    }

    public void setSheet_id(String sheet_id) {
        this.sheet_id = sheet_id;
    }

    public String getModule_name() {
        return module_name;
    }

    public void setModule_name(String module_name) {
        this.module_name = module_name;
    }

    public String getModule_desc() {
        return module_desc;
    }

    public void setModule_desc(String module_desc) {
        this.module_desc = module_desc;
    }

    public List<Item> getModule_items() {
        return module_items;
    }

    public void setModule_items(List<Item> module_items) {
        this.module_items = module_items;
    }

    public void addModule_items(Item item){
        this.module_items.add(item);
    }
}
