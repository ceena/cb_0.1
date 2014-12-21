package rulePack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;

import controller.clFeed;
import controller.clResultObject;
import controller.clResultObjectSet;

public abstract class IFRuleSet {
	int ID 		   = 0;
	String desc    = null;

	HashMap<?, ?> ruleCheckValues;	
	Hashtable<?, ?> attrTab;
	
	ArrayList<clRuleAtt> alRules = new ArrayList<clRuleAtt>();
	
	public IFRuleSet(int id, String desc){
		this.ID = id;
		this.desc = desc;
	}
	
	public void  addRules(IFRule clRule, int sucR, int mandtR, int scoreR){
		clRuleAtt ruleAtt = new clRuleAtt(clRule, sucR, mandtR, scoreR);
		alRules.add(ruleAtt);
	}
	
	public clResultObjectSet evaluate(clRuleConditions excCondition, clFeed feed){
		
		clResultObjectSet resultSet = new clResultObjectSet();
		Iterator<clRuleAtt> iterator = alRules.iterator();
		while(iterator.hasNext()){
			
			clResultObject result = iterator.next().getClRule().checkRule(excCondition, feed);
			resultSet.addResultObject(result);
		}
	
		return resultSet;
	}
}
