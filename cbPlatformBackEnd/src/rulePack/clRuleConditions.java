package rulePack;

import java.util.HashMap;
import java.util.Hashtable;

/************************************************************************
 * Hashtable in this class holds the conditions. Rules can use these
 * conditions to check the feeder
 ***********************************************************************/

public class clRuleConditions {
		Hashtable<String, HashMap<String, String>> ruleCondTable;
	
	
	public clRuleConditions(){
		ruleCondTable = new Hashtable<String, HashMap<String, String>>();
	}
	
	public void addCondition(String ruleName, String attribute, String value){
		HashMap<String, String> ruleAtt = new HashMap<String, String>();
		
		ruleAtt = ruleCondTable.get(ruleName);
		ruleAtt.put(attribute, value);
	}
	
	public HashMap<String, String> getRuleMap(String ruleName){
		return ruleCondTable.get(ruleName);
	}
}
