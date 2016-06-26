package de.tum.in.dbpra.model.bean;

import java.util.ArrayList;


public class AssignedToListBean {

    private ArrayList<AssignedToBean> list = new ArrayList<AssignedToBean>();

    public void setChild(AssignedToBean object, int i) {
        list.add(i, object);
    }
    
    public AssignedToBean getChild(int i) {
        return list.get(i);
    }
    
    public void setList(ArrayList<AssignedToBean> list){
    	this.list=list;
    }

    public ArrayList<AssignedToBean> getList() {
        return list;
    }
}