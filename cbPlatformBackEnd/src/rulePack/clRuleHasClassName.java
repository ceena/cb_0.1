package rulePack;

import java.util.Hashtable;

import controller.clFeed;
import controller.clResultObject;

public class clRuleHasClassName extends IFRule {

	public clRuleHasClassName(){
		int id = 1001;
		String desc = "Checks if the class has a class name";
		
		this.setAttributes(id, desc);
	}
	@Override
	public clResultObject checkRule(Hashtable<String, String> ruleSetCond, clFeed feed)
	{
/*		ScriptEvaluator se = new ScriptEvaluator();

		try {
			se.cook(feed.getValue());
		} catch (CompileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Class<? extends ScriptEvaluator> clSe =  se.getClass();
		return null;*/
		
		String clName = ruleSetCond.get("clRuleHasClassName");
		if(feed.isCooked){
			Class<?> cl = feed.getCompiledFeed().loadClass(clName);
			if(cl != null)
				return new clResultObject(0, 1, " Classname matched.");
			else
				return new clResultObject(0, 0, " Classname mismatch.");
		}else		
			return new clResultObject(0, 0, " Feed not cooked at clRuleHasClassName.");
	}
	
}