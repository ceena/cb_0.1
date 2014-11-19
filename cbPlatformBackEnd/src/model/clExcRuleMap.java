package model;

import java.util.HashMap;
import java.util.Hashtable;

public class clExcRuleMap {
	clExcRuleMap instance = null;
			
	//This can be replaced with a select on DB
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
	
	public static Hashtable<String, String> fetchRuleSetConditions(int excNo){
		
		Hashtable<String,String> hash = new Hashtable<String, String>();  
		switch(excNo)
		{
		
		case 1000:
			hash.put("clRuleHasClassName", "Guitar");
			hash.put("clRuleHasMainMethod", "main");
			break;
		
		default:
			//Do nothing
			break;
		}
		return hash;
		
	}
}
