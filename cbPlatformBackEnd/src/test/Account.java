package test;

import java.util.ArrayList;
import java.util.Iterator;

public class Account
{
	 public static int MAXLIMIT_AMT = 100000;
      double balance;
      ArrayList<Transaction> history = new ArrayList<Transaction>();
      
      public Account(int initialBalance) {
		balance = initialBalance;
	}
      
      public  boolean withdraw(int amount){ 
    	  if(amount <= 0){
    		  return false;
    	  }
    	  if(balance >= amount){
    		 history.add(new Transaction(TransactionType.WITHDRAW, amount, true));
    		 balance =  balance - amount;
    		 return true;
    	  }
    	  else {
    		  history.add(new Transaction(TransactionType.WITHDRAW, amount, false));
    		  return false;
    	  }
    		  
      }
      
      public  boolean deposit(int amount){   
    	  if(amount <= 0){
    		  return false;
    	  }
    	  if( (balance + amount) <= MAXLIMIT_AMT){
    		  history.add(new Transaction(TransactionType.DEPOSIT, amount, true));
    		 balance =  balance + amount;
    		 return true;
    	  }
    	  else {
    		  history.add(new Transaction(TransactionType.DEPOSIT, amount, false));
    		  return false;
    	  }
      }
	 
      public String  miniStmt(){
    	  String stmt = "";
    	  for (Transaction tr : history) {
			stmt += tr.toString();
		}
    	  return stmt;
      }
      

}