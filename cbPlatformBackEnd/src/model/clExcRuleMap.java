package model;

import rulePack.clClassCondition;
import rulePack.clRuleConditions;

/************************************************************************
 * Mapping of the activities(a.k.a. exercise) to the rule set and the 
 * conditions are fetched from the serialized objects
 * TO-DO: 1. Serialization
 * 		  2. Raise exception  if the conditions is NULL
 ***********************************************************************/

public class clExcRuleMap {
	clExcRuleMap instance = null;
			
	//TO-DO: Replace the hard coded rule set with a logic to read the serialized objects
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
			 ruleSetName = "rulePack.clRuleSet1000";
			 break;
		case 1002:
			 ruleSetName = "rulePack.clRuleSet1002";
			 break;
		}
		
		return ruleSetName;
	}
	
	public static clRuleConditions fetchRuleSetConditions(int excNo){
		//This part of the code to be replaced with reading DB for serialized object
		//Hard-coded for NOW
		
		clRuleConditions ruleCondition = new clRuleConditions();
		
		switch(excNo)
		{
		
		case 1000:
//			ruleCondition.addCondition("clRuleHasClassName", "att_class_name", "Guitar");
//			ruleCondition.addCondition("clRuleHasMethod", "att_method_name","main");
//			ruleCondition.addCondition("clRuleHasMethod", "att_method_ret_type","void");
//			ruleCondition.addCondition(instance);
			
			clClassCondition clsCond = new clClassCondition("clRuleHasClassName");
			clsCond.setClassName("Guitar");
			clsCond.setCheckConstructor(true);
			ruleCondition.addCondition("clRuleHasClassName", clsCond);
			
			
			break;
		
		case 1001:
			String path =  "D:\\Users\\srinivaa\\Documents\\GitHub\\cb_0.1\\cbPlatformBackEnd\\war\\WEB-INF\\classes\\model\\1001.cbp";
			clObjSerializer objSerializer = new clObjSerializer();
			try {
				ruleCondition = (clRuleConditions) objSerializer.readFromFile(path);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		default:
			//Do nothing
			break;
		}
		return ruleCondition;
		
	}
}
