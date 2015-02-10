

public class TestClass {
	private String feed = null;
	private String ruleName = null;
	
	public static void main(String[] args) {
		System.out.println("This is the TestClass Main method");
		
		TestClass tc = new TestClass();
		tc.extract();
	}
	
	public TestClass(){
		initialize();
	}
	public void initialize(){
		String HALLO_WORLD_SOURCE = "public class Guitar"
				+ "{\n"
				+ "      int price;\n	"
				+ "		 public static String run() {\n"
				+ "        return \"run sucessfully...\";\n" + "    }\n" + "}";
		
		feed = HALLO_WORLD_SOURCE;
		ruleName = "clRuleHasClassName";	
	}
	
	public void extract(){
		
	}
	
	private static void cookFeed(){
		feedObj = new clFeed(classFeed);
		feedObj.cookFeed();
	}
}
