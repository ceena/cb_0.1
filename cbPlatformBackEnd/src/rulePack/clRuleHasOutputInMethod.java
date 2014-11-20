package rulePack;

import java.util.Hashtable;

import controller.clFeed;
import controller.clResultObject;

public class clRuleHasOutputInMethod extends IFRule {

	public clRuleHasOutputInMethod (){
		int id = 1003;
		String desc = "Checks if there is an output statement in a method";
		
		this.setAttributes(id, desc);
	}
	
	@Override
	public clResultObject checkRule(Hashtable<String, String> ruleSetCond, clFeed feed) {
		// TODO Auto-generated method stub
		return null;
	}

}