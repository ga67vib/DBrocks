package de.tum.in.dbpra.model.bean;

import java.util.ArrayList;


public class PerformanceListBean {

    private ArrayList<PerformanceBean> list = new ArrayList<PerformanceBean>();

    public void setChild(PerformanceBean object) {
        list.add(object);
    }
    
    public PerformanceBean getChild(int i) {
        return list.get(i);
    }
    
    public void setList(ArrayList<PerformanceBean> list){
    	this.list=list;
    }

    public ArrayList<PerformanceBean> getList() {
        return list;
    }
}