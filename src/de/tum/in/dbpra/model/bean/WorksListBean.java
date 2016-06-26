package de.tum.in.dbpra.model.bean;

import java.util.ArrayList;


public class WorksListBean {

    private ArrayList<WorksBean> list = new ArrayList<WorksBean>();

    public void setChild(WorksBean object, int i) {
        list.add(i, object);
    }
    
    public WorksBean getChild(int i) {
        return list.get(i);
    }
    
    public void setList(ArrayList<WorksBean> list){
    	this.list=list;
    }

    public ArrayList<WorksBean> getList() {
        return list;
    }
}