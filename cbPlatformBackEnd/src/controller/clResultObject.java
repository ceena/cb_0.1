package controller;

public class clResultObject {
	private int resultScore 	= 0;
	private int sucessFlag    	= 0; //0 = false; 1 = true
	private String resultLog	= null;
	
	public clResultObject( int score, int flg, String log){
		resultScore = score;
		sucessFlag    = flg;
		resultLog   = log;
	}
	
	public int getScore(){
		return resultScore;
	}
	
	public int getFlg(){
		return sucessFlag;
	}
	
	public String getLog(){
		return resultLog;
	}
	
	public void displayResult(){
			System.out.println("score:"+this.resultScore+", flg:"+this.sucessFlag+", log:"+this.resultLog);		
	}
	
}
