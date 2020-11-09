package project1b.ver03;

public class Account{

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
