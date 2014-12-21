package model;

import rulePack.clRuleConditions;


/************************************************************************
 * Main Model Class - Singleton
 * TO-DO: Check the scenario in multi-threaded environment
 ***********************************************************************/

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
	
	public clRuleConditions fetchRuleSetConditions(int excNo){
		
		return clExcRuleMap.fetchRuleSetConditions(excNo);
	}
}
