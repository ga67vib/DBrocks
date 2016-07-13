package de.tum.in.dbpra.model.bean;

import java.util.ArrayList;
import java.util.HashSet;


public class PerformanceListBean {

    private ArrayList<PerformanceBean> list = new ArrayList<PerformanceBean>();

    public void setChild(PerformanceBean object) {
        list.add(object);
    }
    
    public PerformanceBean getChild(int i) {
        return list.get(i);
    }
    
    public void setList(ArrayList<PerformanceBean> list){
    	this.list=list;
    }

    public ArrayList<PerformanceBean> getList() {
        return list;
    }
    
    /**
     * Removes those PerformanceBeans from the set which are in the otherSet.
     * (Used in the TimetableServlet)
     */
    public void removePerformancesFromOtherSet(PerformanceListBean otherSet){
    	//get all performanceIDs in the otherSet
    	HashSet<Integer> otherIDs = new HashSet<Integer>();
    	for (int i=0; i<otherSet.getList().size(); i++){
    		otherIDs.add(otherSet.getChild(i).getPerformanceID());
    	}
    	for (int i=list.size(); i>=0; i--){
    		if(otherIDs.contains(list.get(i).getPerformanceID())){
    			list.remove(i);    		
    		}
    	}
    }
}