package project1b;

import java.util.Iterator;

import project1b.ver04.Account;
import project1b.ver04.AccountManager;
import project1b.ver04.MenuSelectException;


public class BankingSystemVer04  {

	public static void main(String[] args) throws MenuSelectException{
		
		AccountManager accountmanager = new AccountManager();
		
		accountmanager.showMenu();

	}

}
