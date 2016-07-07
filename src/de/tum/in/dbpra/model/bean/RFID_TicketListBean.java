package de.tum.in.dbpra.model.bean;

import java.util.ArrayList;


public class RFID_TicketListBean {

    private ArrayList<RFID_TicketBean> list = new ArrayList<RFID_TicketBean>();

    public void setChild(RFID_TicketBean object) {
        list.add(object);
    }
    
    public RFID_TicketBean getChild(int i) {
        return list.get(i);
    }
    
    public void setList(ArrayList<RFID_TicketBean> list){
    	this.list=list;
    }

    public ArrayList<RFID_TicketBean> getList() {
        return list;
    }
}