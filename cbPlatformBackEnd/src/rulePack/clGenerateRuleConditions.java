package rulePack;

public class clGenerateRuleConditions {
	
	static String classFeed;
	static String ruleName;
	
	public static void main(String[] args) {
		initialize();
		
		extractConditions(ruleName, classFeed);
	}
	
	static void extractConditions(String ruleName, String feed){
		
		switch( ruleName){
			case "clRuleHasClassName":
				//
				break;
			
		}
	}
	
	public static void initialize(){
	String HALLO_WORLD_SOURCE = "public class Guitar"
			+ "{\n"
			+ "      int price; public static String run() {\n"
			+ "        return \"run sucessfully...\";\n" + "    }\n" + "}";
	
	
	classFeed = HALLO_WORLD_SOURCE;
	ruleName = "clRuleHasClassName";		
	}
}
