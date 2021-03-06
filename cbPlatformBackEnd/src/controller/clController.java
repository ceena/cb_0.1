package controller;

import model.clModel;
import rulePack.clRuleConditions;

/************************************************************************
 * Main Controller Class - Singleton
 * TO-DO: Check the scenario in Multi-threaded environment
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
		
		clObjectValidator objValidator = new clObjectValidator();
		clResultObjectSet resultSet = null;
		
		//Get corresponding ruleSet from DB
		String ruleSetName = clModel.getInstance().fetchRuleSetName(excNo);
		
		clRuleConditions ruleSetCond = clModel.getInstance().fetchRuleSetConditions(excNo);
		
		resultSet = objValidator.evaluate(ruleSetName, ruleSetCond, feed);
		
		return resultSet;
	}

}
