package de.tum.in.dbpra.model.bean;

import java.util.ArrayList;


public class ProductListBean {

    private ArrayList<ProductBean> list = new ArrayList<ProductBean>();

    public void setChild(ProductBean object, int i) {
        list.add(i, object);
    }
    
    public ProductBean getChild(int i) {
        return list.get(i);
    }
    
    public void setList(ArrayList<ProductBean> list){
    	this.list=list;
    }

    public ArrayList<ProductBean> getList() {
        return list;
    }
}