package de.tum.in.dbpra.model.bean;

import java.util.ArrayList;


public class ShiftListBean {

    private ArrayList<ShiftBean> list = new ArrayList<ShiftBean>();

    public void setChild(ShiftBean object) {
        list.add(object);
    }
    
    public ShiftBean getChild(int i) {
        return list.get(i);
    }
    
    public void setList(ArrayList<ShiftBean> list){
    	this.list=list;
    }

    public ArrayList<ShiftBean> getList() {
        return list;
    }
}