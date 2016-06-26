package de.tum.in.dbpra.model.bean;

import java.util.ArrayList;


public class ConcertAreaListBean {

    private ArrayList<ConcertAreaBean> list = new ArrayList<ConcertAreaBean>();

    public void setChild(ConcertAreaBean object, int i) {
        list.add(i, object);
    }
    
    public ConcertAreaBean getChild(int i) {
        return list.get(i);
    }
    
    public void setList(ArrayList<ConcertAreaBean> list){
    	this.list=list;
    }

    public ArrayList<ConcertAreaBean> getList() {
        return list;
    }
}