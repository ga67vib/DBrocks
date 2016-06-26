package de.tum.in.dbpra.model.bean;

import java.util.ArrayList;


public class AreaListBean {

    private ArrayList<AreaBean> list = new ArrayList<AreaBean>();

    public void setChild(AreaBean object, int i) {
        list.add(i, object);
    }
    
    public AreaBean getChild(int i) {
        return list.get(i);
    }
    
    public void setList(ArrayList<AreaBean> list){
    	this.list=list;
    }

    public ArrayList<AreaBean> getList() {
        return list;
    }
}