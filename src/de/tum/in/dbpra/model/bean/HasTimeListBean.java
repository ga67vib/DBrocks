package de.tum.in.dbpra.model.bean;

import java.util.ArrayList;


public class HasTimeListBean {

    private ArrayList<HasTimeBean> list = new ArrayList<HasTimeBean>();

    public void setChild(HasTimeBean object, int i) {
        list.add(i, object);
    }
    
    public HasTimeBean getChild(int i) {
        return list.get(i);
    }
    
    public void setList(ArrayList<HasTimeBean> list){
    	this.list=list;
    }

    public ArrayList<HasTimeBean> getList() {
        return list;
    }
}