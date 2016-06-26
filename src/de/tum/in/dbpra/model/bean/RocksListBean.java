package de.tum.in.dbpra.model.bean;

import java.util.ArrayList;


public class RocksListBean {

    private ArrayList<RocksBean> list = new ArrayList<RocksBean>();

    public void setChild(RocksBean object, int i) {
        list.add(i, object);
    }
    
    public RocksBean getChild(int i) {
        return list.get(i);
    }
    
    public void setList(ArrayList<RocksBean> list){
    	this.list=list;
    }

    public ArrayList<RocksBean> getList() {
        return list;
    }
}