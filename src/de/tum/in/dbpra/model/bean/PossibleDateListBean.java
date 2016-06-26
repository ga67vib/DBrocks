package de.tum.in.dbpra.model.bean;

import java.util.ArrayList;


public class PossibleDateListBean {

    private ArrayList<PossibleDateBean> list = new ArrayList<PossibleDateBean>();

    public void setChild(PossibleDateBean object, int i) {
        list.add(i, object);
    }
    
    public PossibleDateBean getChild(int i) {
        return list.get(i);
    }
    
    public void setList(ArrayList<PossibleDateBean> list){
    	this.list=list;
    }

    public ArrayList<PossibleDateBean> getList() {
        return list;
    }
}