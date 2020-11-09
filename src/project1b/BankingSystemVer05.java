package project1b;

import java.sql.SQLException;
import java.util.Scanner;

import project1b.ver05.Account;
import project1b.ver05.MenuChoice;
import project1b.ver05.IConnectImpl;

public class BankingSystemVer05 extends IConnectImpl {
	static Scanner s = new Scanner(System.in);
	static Account[] accountList = new Account[50];
	static Account account = null;

	String accountNum;
	String name;
	int balance;

	public BankingSystemVer05() {
		super(ORACLE_DRIVER, "kosmo", "1234");
	}

	public static void showMenu() {
		while (true) {
			int count = 0;
			Scanner s = new Scanner(System.in);

			System.out.println("----Menu----");
			System.out.println("1.계좌개설");
			System.out.println("2.입 금");
			System.out.println("3.출 금");
			System.out.println("4.계좌정보출력");
			System.out.println("5.프로그램 종료");
			int choice = s.nextInt();
			System.out.println("선택:" + choice);

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
			case MenuChoice.EXIT:
				System.out.println("프로그램 종료");
				count++;
				break;
			}
			if (count != 0) {
				System.out.println("프로그램이 종료됩니다.");
				break;
			}
		}
	}

	static void makeAccount() {

		try {
			String query = "INSERT INTO banking_tb VALUES (?, ?, ?)";
			psmt = con.prepareStatement(query);

			account = new Account();
			System.out.println("==계좌개설==");
			System.out.println("계좌번호를 입력해 주세요.");
			String accountNum = s.next();
			System.out.println("고객이름을 입력해 주세요");
			String name = s.next();
			System.out.println("잔고를 입력해 주세요");
			int balance = s.nextInt();
			System.out.println("계좌 개설 완료");

			psmt.setString(1, accountNum);
			psmt.setString(2, name);
			psmt.setInt(3, balance);

			int affected = psmt.executeUpdate();
			System.out.println(affected + "행이 입력되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void depositMoney() {

		String sql = "UPDATE banking_tb SET balance = balance + ? WHERE accountNum = ?";
		try {
			psmt = con.prepareStatement(sql);

			System.out.println("***입금***");
			System.out.println("계좌번호와 입금할 금액을 입력하세요");
			System.out.println("계좌번호:");
			String iaccountNum = s.next();
			System.out.println("입금할 금액");
			int ibalance = s.nextInt();

			psmt.setString(2, iaccountNum);
			psmt.setInt(1, ibalance);

			int affected = psmt.executeUpdate();
			System.out.println(affected + "행이 업데이트 되었습니다.");

		} catch (NullPointerException e) {

		} catch (SQLException e) {
		}
	}

	static void withdrawMoney() {

		String sql = "UPDATE banking_tb SET balance = balance - ? WHERE accountNum = ?";
		try {
			psmt = con.prepareStatement(sql);

			System.out.println("***출금***");
			System.out.println("계좌번호와 출금할 금액을 입력하세요.");
			System.out.println("계좌번호:");
			String iaccountNum = s.next();
			System.out.println("출금할 금액");
			int ibalance = s.nextInt();

			psmt.setString(2, iaccountNum);
			psmt.setInt(1, ibalance);

			int affected = psmt.executeUpdate();
			System.out.println(affected + "행이 업데이트 되었습니다.");

		} catch (NullPointerException e) {

		} catch (SQLException e) {
		}
	}

	static void showAccInfo() {
		System.out.println("==계좌정보 출력==");
		try {
			String sql = "SELECT * FROM banking_tb";

			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				System.out.println("계좌번호 :" + rs.getString(1));
				System.out.println("이름 :" + rs.getString(2));
				System.out.println("잔액 :"+ rs.getString(3));
				System.out.println("=======================");
			}

			int affected = stmt.executeUpdate(sql);
			System.out.println(affected + "행이 입력되었습니다.");
			
		} catch (NullPointerException e) {

		} catch (SQLException e) {
			System.out.println("쿼리실행시 문제 발생");
			e.printStackTrace();
		}
	}
	
//	static void delete() {
//		try {
//			stmt = con.createStatement();
//			String query = "DELETE FROM banking_tb";
//			int affected = stmt.executeUpdate(query);
//
//			System.out.println(affected +"행이 삭제됨");
//		}
//		catch(SQLException e) {
//			System.out.println("쿼리실행 오류");
//			e.printStackTrace();
//		}
//	}

	public static void main(String[] args) {
		new BankingSystemVer05().showMenu();
	}
}
