package project1b.ver04;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import project1b.ver04.MenuSelectException;
import project1b.game3by3.*;

public class AccountManager implements MenuChoice, CustomSpecialRate {

	Scanner s = new Scanner(System.in);
	Account account = null;
	NormalAccount normalaccount = null;
	HighCreditAccount highcreditaccount = null;

	AutoSaverT dt = null;
	HashSet<Account> set = new HashSet<Account>();
	String accountNum;
	String name;
	String grade;
	int balance;
	int choice;
	int rate;
	int customrate;

	public void showMenu() {
		while (true) {
			int count = 0;
			Scanner s = new Scanner(System.in);

			System.out.println("----Menu----");
			System.out.println("1.계좌개설");
			System.out.println("2.입 금");
			System.out.println("3.출 금");
			System.out.println("4.계좌정보출력");
			System.out.println("5.자동저장");
			System.out.println("6.3by3game");
			System.out.println("7.종료");

			try {
				choice = s.nextInt();

				System.out.println("선택:" + choice);
				if (choice > 7) {
					MenuSelectException ex = new MenuSelectException("1~6사이의 정수만 입력하세요");
					throw ex;
				}
			}
			catch (InputMismatchException e) {
			System.out.println("숫자로만 입력해야 합니다.");
		} catch (MenuSelectException e) {
			System.out.println(e.getMessage());
		}
				
				switch (choice) {
				case MenuChoice.MAKE:
					makeAccount();
					break;
				case MenuChoice.DEPOSIT:
					depositMoney();
					break;
				case MenuChoice.WITHDRAW:
					withdrawMoney();
					break;
				case MenuChoice.INQUIRE:
					showAccInfo();
					break;
				case MenuChoice.SAVE:
					autoSave();
					break;
				case MenuChoice.GAME:
					Game3by3 game = new Game3by3();
					game.game();
					break;
				case MenuChoice.EXIT:
					save();
					count++;
					break;
				}
				if (count != 0) {
					System.out.println("프로그램이 종료됩니다.");
					break;
				}
			
		}
	}



	void makeAccount() {

		System.out.println("==계좌개설==");
		System.out.println("1.보통계좌");
		System.out.println("2.신용신뢰계좌");
		int cho = s.nextInt();

		if (cho == 1) {

			try {
				System.out.println("계좌번호를 입력해 주세요.");
				accountNum = s.next();
				System.out.println("고객이름을 입력해 주세요");
				name = s.next();
				System.out.println("잔고를 입력해 주세요");
				balance = s.nextInt();
				System.out.println("기본이자%(정수형태로 입력):");
				rate = s.nextInt();

				normalaccount = new NormalAccount(accountNum, name, balance, rate);
				boolean result = set.add(normalaccount);

				if (result == false) {
					System.out.println("중복저장되었습니다. 덮어쓸까요?(y or n)");
					String c = s.next();
					if (c.equals("y")) {
						set.remove(normalaccount);
						set.remove(highcreditaccount);
						set.add(normalaccount);
						System.out.println("덮어쓰기 했습니다.");
					} else if (c.equals("n")) {
						System.out.println("기존 정보 유지");
					}
				} else {
					System.out.println("계좌 개설 완료");
				}
				
			} catch (NullPointerException e) {

			}
		}
		if (cho == 2) {
			System.out.println("계좌번호를 입력해 주세요.");
			accountNum = s.next();
			System.out.println("고객이름을 입력해 주세요");
			name = s.next();
			System.out.println("잔고를 입력해 주세요");
			balance = s.nextInt();
			System.out.println("기본이자%(정수형태로 입력):");
			rate = s.nextInt();
			System.out.println("신용등급(A,B,C):");
			grade = s.next();

			highcreditaccount = new HighCreditAccount(accountNum, name, balance, rate, grade);
			boolean result = set.add(highcreditaccount);

			if (result == false) {
				System.out.println("중복저장되었습니다. 덮어쓸까요?(y or n)");
				String c = s.next();
				if (c.equals("y")) {
					set.remove(highcreditaccount);
					set.remove(normalaccount);
					set.add(highcreditaccount);
					System.out.println("덮어쓰기 했습니다.");
				} else if (c.equals("n")) {
					System.out.println("기존 정보 유지");
				}
			} else {
				System.out.println("계좌 개설 완료");
			}
			
		}
	}

	void depositMoney() {
	
				System.out.println("***입금***");
				System.out.println("계좌번호와 입금할 금액을 입력하세요");

				System.out.println("계좌번호:");
				String iaccountNum = s.next();
				System.out.println("입금할 금액");
				try {
				int iBalance = s.nextInt();

				if (iBalance < 0) {
					throw new MenuSelectException("음수는 입금할수 없습니다.");
				}

				if (iBalance % 500 != 0) {
					throw new MenuSelectException("500원 단위만 입금가능");
				}
				System.out.println("입금이 완료되었습니다.");

				Iterator<Account> itr = set.iterator();
				while (itr.hasNext()) {
					Account account = itr.next();
					if (iaccountNum.equals(account.accountNum)) {

						if (grade != null) {
							account.balance = (int) (Math.floor((balance + (balance * ((double) rate / 100))
									+ (balance * customrate * 0.01) + iBalance)));
							
						} else {
							account.balance = (int) (Math.floor((balance + 
									(balance * ((double) rate / 100)) + iBalance)));
							
						}
					}
				}
			}  catch (InputMismatchException e) {
				System.out.println("숫자로만 입력하세요.");
				
			}
				catch (MenuSelectException e) {
				
				System.out.println(e.getMessage());
				
			}
		
	}

	void withdrawMoney() {

		System.out.println("***출금***");
		System.out.println("계좌번호와 출금할 금액을 입력하세요.");
		System.out.println("계좌번호:");
		String iaccountNum = s.next();

		System.out.println("출금할 금액");

		try {
			int oBalance = s.nextInt();

			if (oBalance < 0) {
				throw new MenuSelectException("음수는 출금 할 수 없습니다.");
			}
			if (oBalance % 1000 != 0) {
				throw new MenuSelectException("1000원 단위만 출금가능");
			}

			Iterator<Account> itr = set.iterator();
			while (itr.hasNext()) {
				Account account = itr.next();
				if (iaccountNum.equals(account.accountNum)) {
					int result = account.balance - oBalance;

					if (account.balance < oBalance) {
						System.out.println("잔고가 부족합니다. 금액 전체를 출력할까요?(YES or NO)");
						String output = s.next();
						if (output.equals("YES")) {
							System.out.println("금액 전체 출력");
							account.setBalance(0);
						}
						if (output.equals("No")) {

							System.out.println("출금 요청 취소");
							account.setBalance(account.balance);
							break;
						}
					} else {
						account.setBalance(result);
					}
				}

				else {
				}
			}

			System.out.println("출금이 완료되었습니다.");
		}

		catch (NullPointerException e) {

		} catch (MenuSelectException e) {
			System.out.println(e.getMessage());
		}
	}

	void showAccInfo() {
		System.out.println("==계좌정보 출력==");
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/project1b/ver04/AccountInfo.obj"));
			HashSet<Account> arr = (HashSet<Account>) in.readObject();
			System.out.println(arr.toString());
			in.close();
		} catch (Exception e) {
		}
		try {
			for (Account arr : set) {
				System.out.println(arr.toString());
				System.out.println("=============");
			}
		} catch (NullPointerException e) {

		}
	}

	void save() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("src/project1b/ver04/AccountInfo.obj"));
			out.writeObject(set);

			out.close();
		} catch (Exception e) {
			System.out.println("친구정보 파일저장시 예외발생");
			e.printStackTrace();
		}
	}

	void autoSave() {

		System.out.println("1.자동저장 on");
		System.out.println("2.자동저장 off");
		int a = s.nextInt();
		if (a == 1) {
			if (dt == null) {
				dt = new AutoSaverT(this);
				dt.setDaemon(true);
				dt.start();
			} else {
				System.out.println("이미 자동저장이 실행중입니다.");
			}
		} else if (a == 2) {
			dt.interrupt();
			dt = null;
		}
	}

	public void txtSave() {
		try {
			PrintWriter out = new PrintWriter(new FileWriter("src/project1b/ver04/AutoSaveAccount.txt"));
			Iterator<Account> itr = set.iterator();
			while (itr.hasNext()) {
				Account account = itr.next();
				out.println(account.toString());
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}