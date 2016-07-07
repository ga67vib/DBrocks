package de.tum.in.dbpra.model.bean;

import java.util.ArrayList;


public class NoteListBean {

    private ArrayList<NoteBean> list = new ArrayList<NoteBean>();

    public void setChild(NoteBean object) {
        list.add(object);
    }
    
    public NoteBean getChild(int i) {
        return list.get(i);
    }
    
    public void setList(ArrayList<NoteBean> list){
    	this.list=list;
    }

    public ArrayList<NoteBean> getList() {
        return list;
    }
}