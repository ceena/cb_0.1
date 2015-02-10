package rulePack;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import controller.clFeed;
import controller.clResultObjectSet;

/************************************************************************
 * Interface for Rule Set (To combine multiple rules into a set)
 * Methods:			- Add Rules in a sorted order (TreeMap)
 * 					- Execute Rules in a pre-defined sequence 
 * 					  and return a result Object (Logger)
 ***********************************************************************/
public abstract class IFRuleSet {
	int ID 		   = 0;
	String desc    = null;

	HashMap<?, ?> ruleCheckValues;	
	Hashtable<?, ?> attrTab;
	
//	ArrayList<clRuleAtt> alRules = new ArrayList<clRuleAtt>();
	Map<Integer, clRuleAtt> alRules = new HashMap<Integer, clRuleAtt>();
	
	public IFRuleSet(int id, String desc){
		this.ID = id;
		this.desc = desc;
	}
	
	public void  addRules(IFRule clRule, int sucR, int mandtR, int scoreR){
		clRuleAtt ruleAtt = new clRuleAtt(clRule, sucR, mandtR, scoreR);
//		alRules.add(ruleAtt); 20150102
		alRules.put(sucR, ruleAtt);
	}
	
	public clResultObjectSet evaluate(clRuleConditions excCondition, clFeed feed){
		
		Map<Integer, clRuleAtt> alRulesSorted = new TreeMap<Integer, clRuleAtt>(alRules);
		clResultObjectSet resultSet = new clResultObjectSet();
//		Iterator<clRuleAtt> iterator = alRules.iterator(); 20150102
		Iterator<Entry<Integer, clRuleAtt>> iterator = alRulesSorted.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry<Integer, clRuleAtt> mapEntry = (Map.Entry<Integer, clRuleAtt>) iterator.next();
			clResultObjectSet result = mapEntry.getValue().getClRule().checkRule(excCondition, feed);
			resultSet.addResultObject(result);
		}
	
		return resultSet;
	}
}
