package com.platygames.mydatasheet.entities;

/**
 * Created by Miki-Muntain on 13/04/2015.
 */
public class Item {
    private String item_id;
    private String module_id;
    private String item_type;
    private String item_label;
    private String item_content;

    public Item(){

    }

    public Item(String id, String m_id, String type, String label, String content){
        this.item_id=id;
        this.module_id=m_id;
        this.item_type=type;
        this.item_label=label;
        this.item_content=content;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getModule_id() {
        return module_id;
    }

    public void setModule_id(String module_id) {
        this.module_id = module_id;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public String getItem_label() {
        return item_label;
    }

    public void setItem_label(String item_label) {
        this.item_label = item_label;
    }

    public String getItem_content() {
        return item_content;
    }

    public void setItem_content(String item_content) {
        this.item_content = item_content;
    }
}
