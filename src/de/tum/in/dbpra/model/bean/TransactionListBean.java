package de.tum.in.dbpra.model.bean;

import java.util.ArrayList;


public class TransactionListBean {

    private ArrayList<TransactionBean> list = new ArrayList<TransactionBean>();

    public void setChild(TransactionBean object) {
        list.add(object);
    }
    
    public TransactionBean getChild(int i) {
        return list.get(i);
    }
    
    public void setList(ArrayList<TransactionBean> list){
    	this.list=list;
    }

    public ArrayList<TransactionBean> getList() {
        return list;
    }
}