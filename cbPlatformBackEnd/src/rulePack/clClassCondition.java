package rulePack;


public class clClassCondition extends clConditions{

	public clClassCondition(String objID) {
		super(objID);
		// TODO Auto-generated constructor stub
	}
	private String className; //Indicator to check if 
	private boolean checkConstructor;
	
	
	public boolean isCheckConstructor() {
		return checkConstructor;
	}
	public void setCheckConstructor(boolean checkConstructor) {
		this.checkConstructor = checkConstructor;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	/*public clClassCondition(){
		
	}*/
	
	
	
}
