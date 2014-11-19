package controller;

public class clFeeder {
	
	clFeed feed = new clFeed("");
	public static clFeeder instance = null;
	
	protected clFeeder() {
		
	}

	public static clFeeder getInstance(){
		if(instance == null){
			instance = new clFeeder();
		}
		return instance;
	}
	
	public void setFeed(clFeed feed){
		this.feed = feed;
	}
	
	public clFeed getFeed(){
		return feed;
	}
	
}
