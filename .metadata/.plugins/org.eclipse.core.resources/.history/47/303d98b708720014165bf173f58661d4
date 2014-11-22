package model;

import java.util.Hashtable;

public class clModel {

public static clModel instance = null;
	
	protected clModel() {
		
	}

	public static clModel getInstance(){
		if(instance == null){
			instance = new clModel();
		}
		return instance;
	}
	
	public String fetchRuleSetName(int excNo){
		
		return clExcRuleMap.fetchRuleSetName(excNo);
	}
	
	public Hashtable<String, String>fetchRuleSetConditions(int excNo){
		
		return clExcRuleMap.fetchRuleSetConditions(excNo);
	}
}
