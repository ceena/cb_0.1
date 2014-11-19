package rulePack;


public class clRuleAtt {
	private IFRule clRule;
	private int sucR;
	private int mandtR;
	private int scoreR;
	
	public clRuleAtt(IFRule clRule, int sucR, int mandtR, int scoreR){
		this.setClRule(clRule);
		this.setSucR(sucR);
		this.setMandtR(mandtR);
		this.setScoreR(scoreR);
	}

	public int getSucR() {
		return sucR;
	}

	public void setSucR(int sucR) {
		this.sucR = sucR;
	}

	public int getMandtR() {
		return mandtR;
	}

	public void setMandtR(int mandtR) {
		this.mandtR = mandtR;
	}

	public IFRule getClRule() {
		return clRule;
	}

	public void setClRule(IFRule clRule) {
		this.clRule = clRule;
	}

	public int getScoreR() {
		return scoreR;
	}

	public void setScoreR(int scoreR) {
		this.scoreR = scoreR;
	}
}
