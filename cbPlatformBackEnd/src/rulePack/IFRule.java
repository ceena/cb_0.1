package rulePack;

import controller.clFeed;
import controller.clResultObjectSet;

public abstract class IFRule {
	int ID      = 0;
	String desc = null;
	
//	HashMap<?, ?> ruleCheckValues;	
//	Hashtable<?, ?> attrTab;
	public void setAttributes(int id, String desc){
		this.ID = id;
		this.desc = desc;
	}
	public abstract clResultObjectSet checkRule(clRuleConditions ruleSetCond, clFeed feed);
}
