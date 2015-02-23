package test;

public class Transaction {
	TransactionType trnsType;
	int amount;
	boolean success = false;
	
	public Transaction(TransactionType trnsType, int amount, boolean success) {
		this.trnsType = trnsType;
		this.amount = amount;
		this.success = success;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Transction: " + trnsType + " , Amount:"+amount+ " - Status: "+success+"\n";
	}
}
