package rulePack;

import java.util.Hashtable;

import controller.clFeed;
import controller.clResultObject;

public abstract class IFRule {
	int ID      = 0;
	String desc = null;
	
//	HashMap<?, ?> ruleCheckValues;	
//	Hashtable<?, ?> attrTab;
	public void setAttributes(int id, String desc){
		this.ID = id;
		this.desc = desc;
	}
	public abstract clResultObject checkRule(Hashtable<String, String> ruleSetCond, clFeed feed);
}
