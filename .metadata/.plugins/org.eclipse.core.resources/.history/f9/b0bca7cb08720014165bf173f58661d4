package controller;

import java.util.ArrayList;
import java.util.Hashtable;

import rulePack.IFRule;
import rulePack.IFRuleSet;

public abstract class IFObjectValidator {

	ArrayList<IFRule> al = new ArrayList<IFRule>();

	public abstract void loader();

	public clResultObjectSet evaluate(String ruleSetName, Hashtable<String,String> ruleSetCond, clFeed feed) {

		IFRuleSet ruleSet = loadRuleSet(ruleSetName);

		clResultObjectSet resultSet = ruleSet.evaluate(ruleSetCond, feed);
		
		return resultSet;
	}

	private IFRuleSet loadRuleSet(String ruleSetName) {
		IFRuleSet ruleSet = null;
		Class<?> cls = null;
		
		try {
			cls = Class.forName(ruleSetName);
		
			try {
				ruleSet = (IFRuleSet) cls.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return ruleSet;
	}

}
