package rulePack;

import org.codehaus.commons.compiler.CompileException;
import org.codehaus.janino.ScriptEvaluator;

import controller.clFeed;
import controller.clResultObject;
import controller.clResultObjectSet;


public class clRuleHasClassName  extends IFRule {

	public clRuleHasClassName(){
		int id = 1001;
		String desc = "Checks if the class has a class name";
		
		this.setAttributes(id, desc);
	}
	@Override
	public clResultObjectSet checkRule(clRuleConditions excCond, clFeed feed)
	{
		clClassCondition excClsCond;
		ScriptEvaluator se = new ScriptEvaluator();
		clResultObjectSet resultSet = new clResultObjectSet();
		
		try {
			se.cook(feed.getValue());
		} catch (CompileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*Class<? extends ScriptEvaluator> clSe =  se.getClass();
		return null;*/
		
		/*Object ruleMap = (IFRule) ruleSetCond.getRuleMap("clRuleHasClassName");
		String clName = ruleMap.get("att_class_name");
		*/
		
		
		//Check the cooked feed against the conditions of the excerise
		excClsCond = (clClassCondition) excCond.getRuleMap("clRuleHasClassName");
		
		if (excClsCond == null){
			resultSet.addResultObject(new clResultObject(0, 0, "Rule Conditions Missing"));
		}
		String clName = excClsCond.getClassName();
		if(feed.isCooked){
			Class<?> cl = feed.getCompiledFeed().loadClass(clName);
			if(cl != null)
				resultSet.addResultObject(new clResultObject(0, 1, " Classname matched."));
			else
				resultSet.addResultObject( new clResultObject(0, 0, " Classname mismatch."));
		}else {		
		resultSet.addResultObject( new clResultObject(0, 0, " Feed not cooked in clRuleHasClassName."));
		}
		return resultSet;
	}
	
}
