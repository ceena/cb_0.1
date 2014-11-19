package rulePack;

public class clRuleSet1000 extends IFRuleSet {

	public clRuleSet1000() {
		super(2001, "Prelim Class Checks");
		//props 
		
		super.addRules(new clRuleHasClassName() , 1002, 1, 100);
		
		
		super.addRules(new clRuleHasMethod(), 1003, 1, 100);
	}
	
}
