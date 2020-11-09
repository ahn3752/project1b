package project1b.ver04;

import java.io.Serializable;
import java.util.Objects;

public abstract class Account implements Serializable{

	   String accountNum;
	   String name;
	   int balance;
	   int rate;
	   String grade;
	   
	   public Account(String accountNum, String name, int balance, int rate) {
		   	this.accountNum = accountNum;
			this.name = name;
			this.balance = balance;
			this.rate = rate;
		}
	   
	   public Account(String accountNum, String name, int balance, int rate, String grade) {
			this.accountNum = accountNum;
			this.name = name;
			this.balance = balance;
			this.rate = rate;
			this.grade = grade;
		}
	   
	   @Override
	public String toString() {
		   if(grade == null) {
			   return
					   "계좌번호 :"+accountNum+
						"\n이름 :"+name+
						"\n잔액 :"+balance+
						"\n이율 :"+rate;
		   }	
		return  "\n"+
				"계좌번호 :"+accountNum+
				"\n이름 :"+name+
				"\n잔액 :"+balance+
				"\n이율 :"+rate+
				"\n등급:"+grade;
				
	}

	@Override
	public boolean equals(Object obj) {
		Account account = (Account)obj;
		if(this.accountNum.equals(account.accountNum)) {
			return true; 
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		
		return Objects.hash(accountNum);
	}

	public void setBalance(int balance) {
		   this.balance = balance;
	   }

	   public String getGrade() {
		   return grade;
	   }
	   
	   public int getRate() {
		   return rate;
	   }
	 
	   public String getAccountNum() {
	      return accountNum;
	   }
	  
	   public String getName() {
	      return name;
	   }
	   
	   public int getBalance() {
	      return balance;
	   }
	  

	   
}
