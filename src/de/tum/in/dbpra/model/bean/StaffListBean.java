package de.tum.in.dbpra.model.bean;

import java.util.ArrayList;


public class StaffListBean {

    private ArrayList<StaffBean> list = new ArrayList<StaffBean>();

    public void setChild(StaffBean object, int i) {
        list.add(i, object);
    }
    
    public StaffBean getChild(int i) {
        return list.get(i);
    }
    
    public void setList(ArrayList<StaffBean> list){
    	this.list=list;
    }

    public ArrayList<StaffBean> getList() {
        return list;
    }
}