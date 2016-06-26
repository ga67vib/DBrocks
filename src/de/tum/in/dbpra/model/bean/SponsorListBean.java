package de.tum.in.dbpra.model.bean;

import java.util.ArrayList;


public class SponsorListBean {

    private ArrayList<SponsorBean> list = new ArrayList<SponsorBean>();

    public void setChild(SponsorBean object, int i) {
        list.add(i, object);
    }
    
    public SponsorBean getChild(int i) {
        return list.get(i);
    }
    
    public void setList(ArrayList<SponsorBean> list){
    	this.list=list;
    }

    public ArrayList<SponsorBean> getList() {
        return list;
    }
}