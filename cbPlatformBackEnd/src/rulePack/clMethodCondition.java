package rulePack;

import java.util.ArrayList;

public class clMethodCondition extends clConditions{

	private String methodName;
	private String returnType;
	private ArrayList<String> parametersType;
	
	public clMethodCondition(String objType) {
		super(objType);
		parametersType = new ArrayList<String>();
	}


	public String getMethodName() {
		return methodName;
	}


	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}


	public String getReturnType() {
		return returnType;
	}


	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}


	public ArrayList<String> getParametersType() {
		return parametersType;
	}


	public void addParametersType(String parametersType) {
		this.parametersType.add(parametersType);
	}

}
