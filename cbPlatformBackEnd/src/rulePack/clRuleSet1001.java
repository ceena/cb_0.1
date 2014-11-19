package rulePack;

public class clRuleSet1001 extends IFRuleSet {

	public clRuleSet1001() {
		super(2001, "Prelim Class Checks");
		super.addRules(new clRuleHasClassName(), 1002, 1, 100);
		super.addRules(new clRuleHasMethod() , 1003, 1, 100);
		super.addRules(new clRuleHasOutputInMethod(), 0, 0, 100);
	}
	
}
