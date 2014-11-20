package rulePack;

import java.util.Hashtable;

import controller.clFeed;
import controller.clResultObject;

public class clRuleHasMethod extends IFRule{

	public clRuleHasMethod(){
		int id = 1002;
		String desc = "Checks if the class has a main method";
		
		this.setAttributes(id, desc);
	}
	@Override
	public clResultObject checkRule(Hashtable<String, String> ruleSetCond, clFeed feed) {
		// TODO Auto-generated method stub
		
		
		return new clResultObject(0, 0, " implement clRuleHasMainMethod checkRule");
	}

}