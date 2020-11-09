package project1b.ver04;

public class NormalAccount extends Account{


	NormalAccount(String accountNum, String name, int balance, int rate) {
		super(accountNum,name,balance,rate);
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
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	@Override
	public int getBalance() {
		// TODO Auto-generated method stub
		return super.getBalance();
	}


	@Override
	public int getRate() {
		// TODO Auto-generated method stub
		return super.getRate();
	}


	@Override
	public String getAccountNum() {
		// TODO Auto-generated method stub
		return super.getAccountNum();
	}

	
	
	
}
