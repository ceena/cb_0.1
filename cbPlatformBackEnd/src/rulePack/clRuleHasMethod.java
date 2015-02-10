package rulePack;

import controller.clFeed;
import controller.clResultObject;
import controller.clResultObjectSet;

public class clRuleHasMethod  extends IFRule{
	
	public clRuleHasMethod(){
		int id = 1002;
		String desc = "Checks if the class has a main method";
		
		this.setAttributes(id, desc);
	}
	@Override
	public clResultObjectSet checkRule(clRuleConditions ruleSetCond, clFeed feed) {
		clResultObjectSet resultSet = new clResultObjectSet();
		resultSet.addResultObject(new clResultObject(0, 0, " implement clRuleHasMainMethod checkRule"));
		return resultSet;
	}

}
