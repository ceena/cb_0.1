package rulePack;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Method;
import java.util.Arrays;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;

import controller.clFeed;

public class clGenerateRuleConditions {
	
	private static String classFeed;
	private static String ruleName;
	private static clFeed feedObj = null;
//	static String[] preSelConds;
	
	
	public static void main(String[] args) {
		clGenerateRuleConditions ruleCond = new clGenerateRuleConditions("clRuleHasClassName");
		
//		feedObj = new clFeed(classFeed);
//		ruleCond.extractConditions(ruleName, feedObj);
		if (feedObj.isCooked() == true){
			ruleCond.extractConditions(ruleName, feedObj);
		}
	}
	
	public clGenerateRuleConditions(String cond){
		initialize(cond);
		
		//cook the feed: 
		//			  1. Capture syntax errors (?)
		//			  2. Cook for rules extractions
		try {
			cookFeed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void extractConditions(String ruleName, clFeed feed){
		
		switch( ruleName){
			case "clRuleHasClassName":
				String clName = feedObj.getClass().getName();
				System.out.println(clName);
				break;
			
			case "clRuleHasMethodName":
				//cater scenario of multiple methods
				Class cls = feedObj.getClass();
				java.lang.reflect.Method[] mtds = cls.getMethods();
				
				
			
		}
		return;
	}
	
	private static void initialize(String preSelCond){
		String HALLO_WORLD_SOURCE = 
				  "package generated;"
				+ "public class Guitar"
				+ "{\n"
				+ "      int price;\n	"
				+ "		 public static String run() {\n"
				+ "        return \"run sucessfully...\";\n" + "    }\n" + "}";
		
		classFeed = HALLO_WORLD_SOURCE;
		ruleName = preSelCond;		
	/*	preSelCond = new String[20];
		preSelCond[0] = "clRuleHasClassName";
		preSelCond[1] = "clRuleHasMethodName";*/
	}
	
	private static void cookFeed() throws Exception{
//		feedObj = new clFeed(classFeed);
//		feedObj.cookFeed();
		
		File sourceFile = new File("Feed.java");
		FileWriter writer = new FileWriter(sourceFile);
		writer.write(classFeed);
		writer.close();
		
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
		fileManager.setLocation(StandardLocation.CLASS_OUTPUT, Arrays.asList(new File("generated/")));
		 // Compile the file
	      boolean success = compiler.getTask(null, fileManager, null, null, null,
	          fileManager.getJavaFileObjectsFromFiles(Arrays.asList(sourceFile))).call();
	      fileManager.close();
	      
	      
	      Class params[] = {};
	      Object paramsObj[] = {};
	      try {
		      Class thisClass = Class.forName("Feed");
		      Object iClass = thisClass.newInstance();
		      Method thisMethod = thisClass.getDeclaredMethod("run", params);
		      thisMethod.invoke(iClass, paramsObj);
	      } catch (Exception e) {
	      	e.printStackTrace();
	      }
	      
	}
}
