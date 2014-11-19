package controller;

import java.util.ArrayList;

public class clResultObjectSet {
	private ArrayList<clResultObject> al = new ArrayList<clResultObject>();
	
	public void addResultObject(clResultObject obj){
		al.add(obj);
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
