package project1b.ver04;

public class AutoSaverT extends Thread{
	private AccountManager accountManager = null;
	
	public AutoSaverT() {
		
	}
	public AutoSaverT(AccountManager accountManager) {
		this.accountManager = accountManager;
	}

	@Override
	public void run() {
		while(true) {
			try {
				accountManager.txtSave();
				System.out.println("5초마다 자동저장중");
				Thread.sleep(5000);
			} catch(InterruptedException e) {
				System.out.println("자동저장 그만");
				break;
			}
		}
	}
}

