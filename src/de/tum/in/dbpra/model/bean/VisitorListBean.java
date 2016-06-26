package de.tum.in.dbpra.model.bean;

import java.util.ArrayList;


public class VisitorListBean {

    private ArrayList<VisitorBean> list = new ArrayList<VisitorBean>();

    public void setChild(VisitorBean object, int i) {
        list.add(i, object);
    }
    
    public VisitorBean getChild(int i) {
        return list.get(i);
    }
    
    public void setList(ArrayList<VisitorBean> list){
    	this.list=list;
    }

    public ArrayList<VisitorBean> getList() {
        return list;
    }
}