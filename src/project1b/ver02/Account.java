package project1b.ver02;

public class Account{

	   private String accountNum;
	   private String name;
	   private int balance;
	   int rate;
	   String grade;
	   
	   public String getGrade() {
		   return grade;
	   }
	   public void setGrade(String grade) {
		   this.grade = grade;
	   }
	   public int getRate() {
		   return rate;
	   }
	   public void setRate(int rate) {
		   this.rate = rate;
		}
	   public String getAccountNum() {
	      return accountNum;
	   }
	   public void setAccountNum(String accountNum) {
	      this.accountNum = accountNum;
	   }
	   public String getName() {
	      return name;
	   }
	   public void setName(String name) {
	      this.name = name;
	   }
	   public int getBalance() {
	      return balance;
	   }
	   public void setBalance(int balance) {
	      this.balance = balance;
	   }
	   
}
