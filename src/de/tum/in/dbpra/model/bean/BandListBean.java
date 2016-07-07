package de.tum.in.dbpra.model.bean;

import java.util.ArrayList;


public class BandListBean {

    private ArrayList<BandBean> list = new ArrayList<BandBean>();

    public void setChild(BandBean object) {
        list.add(object);
    }
    
    public BandBean getChild(int i) {
        return list.get(i);
    }
    
    public void setList(ArrayList<BandBean> list){
    	this.list=list;
    }

    public ArrayList<BandBean> getList() {
        return list;
    }
}