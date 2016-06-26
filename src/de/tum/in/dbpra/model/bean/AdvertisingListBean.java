package de.tum.in.dbpra.model.bean;

import java.util.ArrayList;


public class AdvertisingListBean {

    private ArrayList<AdvertisingBean> list = new ArrayList<AdvertisingBean>();

    public void setChild(AdvertisingBean object, int i) {
        list.add(i, object);
    }
    
    public AdvertisingBean getChild(int i) {
        return list.get(i);
    }
    
    public void setList(ArrayList<AdvertisingBean> list){
    	this.list=list;
    }

    public ArrayList<AdvertisingBean> getList() {
        return list;
    }
}