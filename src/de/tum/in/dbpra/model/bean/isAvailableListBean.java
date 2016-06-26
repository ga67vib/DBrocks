package de.tum.in.dbpra.model.bean;

import java.util.ArrayList;


public class isAvailableListBean {

    private ArrayList<IsAvailableBean> list = new ArrayList<IsAvailableBean>();

    public void setChild(IsAvailableBean object, int i) {
        list.add(i, object);
    }
    
    public IsAvailableBean getChild(int i) {
        return list.get(i);
    }
    
    public void setList(ArrayList<IsAvailableBean> list){
    	this.list=list;
    }

    public ArrayList<IsAvailableBean> getList() {
        return list;
    }
}