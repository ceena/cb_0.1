package controller;

public class clFeed {
	String feed = null;
	public boolean isCooked = false;
	clCodeCompiler compiledFeed;
	
	public clFeed(String str){
		feed = new String(str);
		this.cookFeed();
	}
	
	public String getValue(){
		return feed;
	}
	
	public void setValue(String value){
		feed = value;
	}
	
	
	
	public void cookFeed(){
		if(!isCooked){
			compiledFeed = new clCodeCompiler();
			compiledFeed.compile(feed);
			isCooked = true;
		}else
			System.out.println("Feed is already cooked:"+this.getValue());
	}

	/**
	 * @return the isCooked
	 */
	public boolean isCooked() {
		return isCooked;
	}

	/**
	 * @param isCooked the isCooked to set
	 */
	public void setCooked(boolean isCooked) {
		this.isCooked = isCooked;
	}

	/**
	 * @return the compiledFeed
	 */
	public clCodeCompiler getCompiledFeed() {
		return compiledFeed;
	}

	/**
	 * @param compiledFeed the compiledFeed to set
	 */
	public void setCompiledFeed(clCodeCompiler compiledFeed) {
		this.compiledFeed = compiledFeed;
	}


}
