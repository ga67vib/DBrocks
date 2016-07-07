package de.tum.in.dbpra.model.bean;

import java.util.ArrayList;


public class PersonListBean {

    private ArrayList<PersonBean> list = new ArrayList<PersonBean>();

    public void setChild(PersonBean object) {
        list.add(object);
    }
    
    public PersonBean getChild(int i) {
        return list.get(i);
    }
    
    public void setList(ArrayList<PersonBean> list){
    	this.list=list;
    }

    public ArrayList<PersonBean> getList() {
        return list;
    }
}