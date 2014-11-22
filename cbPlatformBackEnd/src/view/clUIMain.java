package view;

import controller.clController;
import controller.clFeed;
import controller.clFeeder;
import controller.clResultObjectSet;

public class clUIMain {

	static clController controller = null;
	static clFeed feedFromUI = null;
	static int excNo = 0;
	
	public static void main(String[] args) {
		
		initialize();
//		clFeed feed =clFeeder.getInstance().getFeed();

		if(clFeeder.getInstance().getFeed().getValue() != feedFromUI.getValue()){
			clFeeder.getInstance().getFeed().setValue(feedFromUI.getValue());
			clResultObjectSet evaluationResult = controller.evaluateFeed(excNo, feedFromUI);
			evaluationResult.displayResultObjects();
		}
		
	}

	
	public static void initialize() {
//		String str = new String( 
//					"public class HelloWorld{"
//				  + "public static void main(String[] args){"
//				  + "System.out.println(\"Hello World!\")"
//				  + "}}" );
		
		String HALLO_WORLD_SOURCE = "public class Guitar"
				+ "{\n"
				+ "      int price; public static String run() {\n"
				+ "        return \"run sucessfully...\";\n" + "    }\n" + "}";
		
		
		controller = clController.getInstance();
		feedFromUI = new clFeed(HALLO_WORLD_SOURCE);
		excNo = 1000;
		//new line - testing git
	}
}
