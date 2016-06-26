package de.tum.in.dbpra.model.bean;

import java.util.ArrayList;


public class LocatedListBean {

    private ArrayList<LocatedBean> list = new ArrayList<LocatedBean>();

    public void setChild(LocatedBean object, int i) {
        list.add(i, object);
    }
    
    public LocatedBean getChild(int i) {
        return list.get(i);
    }
    
    public void setList(ArrayList<LocatedBean> list){
    	this.list=list;
    }

    public ArrayList<LocatedBean> getList() {
        return list;
    }
}