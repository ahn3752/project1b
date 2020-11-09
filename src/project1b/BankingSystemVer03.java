package project1b;

import project1b.ver03.AccountManager;
import project1b.ver03.MenuSelectException;


public class BankingSystemVer03  {

	public static void main(String[] args) throws MenuSelectException{
		
		AccountManager accountmanager = new AccountManager();
		
		accountmanager.showMenu();

	}

}
