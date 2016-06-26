package de.tum.in.dbpra.model.bean;

import java.util.ArrayList;


public class PossibleLocationListBean {

    private ArrayList<PossibleLocationBean> list = new ArrayList<PossibleLocationBean>();

    public void setChild(PossibleLocationBean object, int i) {
        list.add(i, object);
    }
    
    public PossibleLocationBean getChild(int i) {
        return list.get(i);
    }
    
    public void setList(ArrayList<PossibleLocationBean> list){
    	this.list=list;
    }

    public ArrayList<PossibleLocationBean> getList() {
        return list;
    }
}