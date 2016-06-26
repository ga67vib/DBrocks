package de.tum.in.dbpra.model.bean;

import java.util.ArrayList;


public class StageListBean {

    private ArrayList<StageBean> list = new ArrayList<StageBean>();

    public void setChild(StageBean object, int i) {
        list.add(i, object);
    }
    
    public StageBean getChild(int i) {
        return list.get(i);
    }
    
    public void setList(ArrayList<StageBean> list){
    	this.list=list;
    }

    public ArrayList<StageBean> getList() {
        return list;
    }
}