package rulePack;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import model.clObjSerializer;

import org.codehaus.commons.compiler.CompileException;
import org.codehaus.janino.SimpleCompiler;
/**************************************************************************/
/* This class extracts conditions from the source code (Exercise solution 
 * for selected rules.
 * 		1.  Cook the feed from UI
 * 		2.  Based on the selected rules, get extract conditions from the 
 * 			instance
 * 		3.  Return the extracted conditions to serialization
 * 		4.  Currently supports programs with single class. Should be enhanced
 * 			to support multiple classes/external references (inheritance, 
 * 			interface, etc.)
 * 							                                              */
/**************************************************************************/
public class clGenerateRuleConditionsReBuilt {
	
	private Class<?> classObj; 
	private static String classFeed;
	private static ArrayList<String> ruleName;
	private static boolean cookFeedFlg = true;
	private static clRuleConditions extConditions;
	static clGenerateRuleConditionsReBuilt ruleCond;
	public static void main(String[] args) {
		ruleName = new ArrayList<String>();
		ruleName.add("clRuleHasClassName");
		ruleName.add("clRuleHasMethodName");
		
		 /*Replace ruleName with args[]. Args[] will be input from UI with list of condition names
		 for which conditions should be extracted
		 * args[0] = execerise number
		 * args[1] = rule name 1
		 * args[2] = rule name 2
		 */
		ruleCond = new clGenerateRuleConditionsReBuilt(ruleName);
		
//		feedObj = new clFeed(classFeed);
//		ruleCond.extractConditions(ruleName, feedObj);
		if (cookFeedFlg == true){
			for(int i = 0; i < ruleName.size(); i++){
				ruleCond.extractConditions(ruleName.get(i));//, feedObj);
			}
		}
		
		//Serialize extracted conditions
		serialize();
	}
	
	private static void serialize() {
		String path =  "D:\\Users\\srinivaa\\Documents\\GitHub\\cb_0.1\\cbPlatformBackEnd\\war\\WEB-INF\\classes\\model\\1001.cbp"; 
		//TODO: replace with args[0] contents
		
		try {
			clObjSerializer serializer = new clObjSerializer();
			serializer.writeToFile(path, ruleCond.extConditions);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public clGenerateRuleConditionsReBuilt(ArrayList<String> cond){
		initialize();
		extConditions = new clRuleConditions();
		//cook the feed: 
		//			  1. Capture syntax errors (?)
		//			  2. Cook for rules extractions
		try {
			classObj = cookFeed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			cookFeedFlg = false;
			e.printStackTrace();
		}
	}
	
	public void extractConditions(String ruleName/*, clFeed feed*/){
		
//		clConditions condition; 
		
		
		
		switch( ruleName){
			case "clRuleHasClassName":
				clClassCondition conditionC = new clClassCondition(ruleName);
//				String clName = feedObj.getClass().getName();
				String clName = classObj.getSimpleName();
				conditionC.setClassName(clName);
				extConditions.addCondition(ruleName, conditionC);
//				System.out.println(clName);
				break;
			
			case "clRuleHasMethodName":
				clMethodCondition conditionM;
				
				java.lang.reflect.Method[] methods = classObj.getDeclaredMethods();
				for(int i = 0; i < methods.length; i++){
					conditionM = new clMethodCondition(ruleName);
					String methodName = methods[i].getName();
					conditionM.setMethodName(methodName);
					conditionM.setReturnType(methods[i].getReturnType().getSimpleName());
					Class<?> paramTypes[] = methods[i].getParameterTypes();
					for(int j = 0; j < paramTypes.length; j++)
					{
						conditionM.addParametersType(paramTypes[j].getSimpleName());						
					}
					extConditions.addCondition(ruleName, conditionM);
					conditionM = null;
				}
		}
		return;
	}
	
	private static void initialize(){
		String HALLO_WORLD_SOURCE = 
				  "package generated;"
				+ "public class Guitar"
				+ "{\n"
				+ "      static int price;\n	"
				+ "		 private static int run2(int A, String B) {\n"
//				+ "        return \"run successfully...\";\n" + "    "
				+ "        return price;"
						+ "}\n" 
				+ "}";
		
		classFeed = HALLO_WORLD_SOURCE;
//		ruleName = preSelCond;		
	/*	preSelCond = new String[20];
		preSelCond[0] = "clRuleHasClassName";
		preSelCond[1] = "clRuleHasMethodName";*/
	}
	
	private static Class<?> cookFeed() throws Exception{
		SimpleCompiler compiler = new SimpleCompiler();
		Class<?> cl = null;
		try {
			compiler.cook(new StringReader(classFeed));			
		} catch (CompileException | IOException e) {
			cookFeedFlg = false;
			e.printStackTrace();
		} 
		
		compiler.cook(new StringReader(classFeed));
		
		try {
			 ClassLoader classLoader = compiler.getClassLoader();
			 String clName = "generated."+"Guitar";
			 cl = classLoader.loadClass(clName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cl;
	}
}
