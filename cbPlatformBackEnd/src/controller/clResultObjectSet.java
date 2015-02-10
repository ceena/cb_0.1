package controller;

import java.util.ArrayList;

public class clResultObjectSet {
	private ArrayList<clResultObject> al = new ArrayList<clResultObject>();
	
	public void addResultObject(clResultObject obj){
		al.add(obj);
	}
	public void addResultObject(clResultObjectSet obj){
		int objIndx = obj.getResultObjSize();
		for(int i = 0; i < objIndx; i++){
			al.add(obj.getResultOjbect(i));
		}
	}
	
	public clResultObject getResultOjbect(int index){
		
		return al.get(index);
	}
	
	public Integer getResultObjSize(){
		return al.size();
	}
	
	public ArrayList<clResultObject> getResultObjectSet(){
		return al;
	}
	
	public void displayResultObjects(){
		for (clResultObject clResultObject : al) {
			clResultObject.displayResult();
		}
	}
}
