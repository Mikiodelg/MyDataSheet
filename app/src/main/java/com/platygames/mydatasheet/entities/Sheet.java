package com.platygames.mydatasheet.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Miki-Muntain on 13/04/2015.
 */

public class Sheet {

    private String sheet_id;
    private String sheet_name;
    private String sheet_desc;
    private List<Module> sheet_modules;

    public Sheet(){
        this.sheet_modules=new ArrayList<Module>();
    }

    public Sheet(String id, String name, String desc){
        this.sheet_id=id;
        this.sheet_name=name;
        this.sheet_desc=desc;
        this.sheet_modules=new ArrayList<Module>();
    }

    public Sheet(String id, String name, String desc, List<Module> modules){
        this.sheet_id=id;
        this.sheet_name=name;
        this.sheet_desc=desc;
        this.sheet_modules=modules;
    }

    public String getSheet_id() {
        return sheet_id;
    }

    public void setSheet_id(String sheet_id) {
        this.sheet_id = sheet_id;
    }

    public String getSheet_name() {
        return sheet_name;
    }

    public void setSheet_name(String sheet_name) {
        this.sheet_name = sheet_name;
    }

    public String getSheet_desc() {
        return sheet_desc;
    }

    public void setSheet_desc(String sheet_desc) {
        this.sheet_desc = sheet_desc;
    }

    public List<Module> getSheet_modules() {
        return sheet_modules;
    }

    public void setSheet_modules(List<Module> sheet_modules) {
        this.sheet_modules = sheet_modules;
    }

    public void addSheet_modules(Module mod){
        this.sheet_modules.add(mod);
    }
}
