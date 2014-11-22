package model;

import rulePack.clRuleConditions;

/************************************************************************
 * Mapping of the activities(a.k.a. exercise) to the rule set and the 
 * conditions are fetched from the serialized objects
 ***********************************************************************/

public class clExcRuleMap {
	clExcRuleMap instance = null;
			
	//TO-DO: Replace the hard coded rule set with reading the serialized objects
	public static String fetchRuleSetName(int excNo){
		
		String ruleSetName = null;
		switch(excNo){
		case 1000:
			 ruleSetName = "rulePack.clRuleSet1000";
			 break;
		case 2000:
			 ruleSetName = "rulePack.clRuleSet1000";
			 break;
		case 1001:
			 ruleSetName = "rulePack.clRuleSet1001";
			 break;
		case 1002:
			 ruleSetName = "rulePack.clRuleSet1002";
			 break;
		}
		
		return ruleSetName;
	}
	
	public static clRuleConditions fetchRuleSetConditions(int excNo){
		
		clRuleConditions ruleCondition = new clRuleConditions();
		
		switch(excNo)
		{
		
		case 1000:
			ruleCondition.addCondition("clRuleHasClassName", "att_class_name", "Guitar");
			ruleCondition.addCondition("clRuleHasMethod", "att_method_name","main");
			ruleCondition.addCondition("clRuleHasMethod", "att_method_ret_type","void");
			break;
		
		default:
			//Do nothing
			break;
		}
		return ruleCondition;
		
	}
}
