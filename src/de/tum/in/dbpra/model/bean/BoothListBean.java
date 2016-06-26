package de.tum.in.dbpra.model.bean;

import java.util.ArrayList;


public class BoothListBean {

    private ArrayList<BoothBean> list = new ArrayList<BoothBean>();

    public void setChild(BoothBean object, int i) {
        list.add(i, object);
    }
    
    public BoothBean getChild(int i) {
        return list.get(i);
    }
    
    public void setList(ArrayList<BoothBean> list){
    	this.list=list;
    }

    public ArrayList<BoothBean> getList() {
        return list;
    }
}