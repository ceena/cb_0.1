package controller;

import model.clModel;
import rulePack.clRuleConditions;

/************************************************************************
 * Main Controller Class - Singleton
 * TO-DO: Check the scenario in multi-threaded environment
 ***********************************************************************/

public final class clController {
	
public static clController instance = null;
	
	protected clController() {
		
	}

	public static clController getInstance(){
		if(instance == null){
			instance = new clController();
		}
		return instance;
	}

	public clResultObjectSet evaluateFeed(int excNo, clFeed feed) {
		
		clObjectValidator codeValidator = new clObjectValidator();
		clResultObjectSet resultObjectSet = null;
		
		//Get corresponding ruleSet from DB
		String ruleSetName = clModel.getInstance().fetchRuleSetName(excNo);
		
		clRuleConditions ruleSetCond = clModel.getInstance().fetchRuleSetConditions(excNo);
		
		
		resultObjectSet = codeValidator.evaluate(ruleSetName, ruleSetCond, feed);
		
		
//		resultObject = 
		return resultObjectSet;
		
		
	}

}
