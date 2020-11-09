package project1b.ver04;

public class HighCreditAccount extends Account{

	public HighCreditAccount(String accountNum, String name, int balance, int rate, String grade) {
			super(accountNum,name,balance,rate,grade);
		}

	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	 

	@Override
	public String getAccountNum() {
		// TODO Auto-generated method stub
		return super.getAccountNum();
	}

	@Override
	public String getName() {
		return super.getName();
	}

	@Override
	public int getBalance() {
		// TODO Auto-generated method stub
		return super.getBalance();
	}



	@Override
	public String getGrade() {
		// TODO Auto-generated method stub
		return super.getGrade();
	}



	@Override
	public int getRate() {
		// TODO Auto-generated method stub
		return super.getRate();
	}
	
	 
	 
}
