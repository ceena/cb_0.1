package rulePack;

import java.io.Serializable;
import java.util.Hashtable;

/************************************************************************
 * Hashtable in this class holds the conditions. Rules can use these
 * conditions to check the feeder
 * Include serialVersionUID if the structure of the serialized object is 
 * changed in future
 ***********************************************************************/

public class clRuleConditions implements Serializable {
		Hashtable<String, clConditions> ruleCondTable;	
		
	public clRuleConditions(){
		ruleCondTable = new Hashtable<String, clConditions>();
	}
	
	public void addCondition(String ruleName, clConditions ruleConds){
			
			//Requires sequence number(?)
			ruleCondTable.put(ruleName,  ruleConds);
	}
	
	public clConditions getRuleMap(String ruleName){
		return ruleCondTable.get(ruleName);
	}
	
}
