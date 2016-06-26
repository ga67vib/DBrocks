package de.tum.in.dbpra.model.bean;

import java.util.ArrayList;


public class TimetableListBean {

    private ArrayList<TimetableBean> list = new ArrayList<TimetableBean>();

    public void setChild(TimetableBean object, int i) {
        list.add(i, object);
    }
    
    public TimetableBean getChild(int i) {
        return list.get(i);
    }
    
    public void setList(ArrayList<TimetableBean> list){
    	this.list=list;
    }

    public ArrayList<TimetableBean> getList() {
        return list;
    }
}