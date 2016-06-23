package de.tum.in.dbpra.model.bean;

import java.util.ArrayList;


public class InvoiceItemListBean {

    private ArrayList<InvoiceItemBean> list = new ArrayList<InvoiceItemBean>();

    public void setChild(InvoiceItemBean object, int i) {
        list.add(i, object);
    }
    
    public InvoiceItemBean getChild(int i) {
        return list.get(i);
    }
    
    public void setList(ArrayList<InvoiceItemBean> list){
    	this.list=list;
    }

    public ArrayList<InvoiceItemBean> getList() {
        return list;
    }
}