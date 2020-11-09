package project1b.ver03;

import java.util.InputMismatchException;
import java.util.Scanner;


public class AccountManager implements MenuChoice {

	Scanner s = new Scanner(System.in);
	Account[] accountList = new Account[50];
	Account account = null;
	NormalAccount normalaccount = null;
	HighCreditAccount highcreditaccount = null;
	
	   String accountNum;
	   String name;
	   String grade;
	   int balance;
	   int choice;
	   int rate;
	   int customrate;
	   
	   public void showMenu() {
	      while(true) {
	    	  int count = 0;
	      Scanner s = new Scanner(System.in);
	      
	      System.out.println("----Menu----");
	      System.out.println("1.계좌개설");
	      System.out.println("2.입 금");
	      System.out.println("3.출 금");
	      System.out.println("4.계좌정보출력");
	      System.out.println("5.프로그램 종료");
	      try {
	    	 choice = s.nextInt();
	    	 System.out.println("선택:"+ choice);      
	             if(choice >5) {
	                MenuSelectException ex = new MenuSelectException();
	               throw ex;
	            }
	      switch(choice) {
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
	         count ++;
	         break;
	      }
	      if(count != 0) {
	    	  System.out.println("프로그램이 종료됩니다.");
	    	  break;
	      }
	      } catch (InputMismatchException e) {
	          System.out.println("숫자로만 입력해야 합니다.");
	       }
	         catch (MenuSelectException e) {
	            System.out.println("1~5사이의 정수만 입력하세요");
	         }
	      }
	   }
	   int i=0;
	   void makeAccount() {
	      
	         System.out.println("==계좌개설==");
	         System.out.println("1.보통계좌");
	         System.out.println("2.신용신뢰계좌");
	         choice = s.nextInt();
	         
	         if(choice == 1) {
		         System.out.println("계좌번호를 입력해 주세요.");
		         accountNum = s.next();
		         System.out.println("고객이름을 입력해 주세요");
		         name = s.next();
		         System.out.println("잔고를 입력해 주세요");
		         balance = s.nextInt();
		         System.out.println("기본이자%(정수형태로 입력):");
		         rate = s.nextInt();
		         System.out.println("계좌 개설 완료");
		         normalaccount = new NormalAccount(accountNum,name,balance,rate);
		         accountList[i] = normalaccount;
		         i++;
	         }
	         if(choice == 2) {
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
		         System.out.println("계좌 개설 완료");
		         highcreditaccount = new HighCreditAccount(accountNum,name,balance,rate,grade);
		         accountList[i] = highcreditaccount;
		         i++;
	         }
	   }
	   
	   void depositMoney() {
	      System.out.println("***입금***");
	      System.out.println("계좌번호와 입금할 금액을 입력하세요");
	      System.out.println("계좌번호:");
	      String iaccountNum = s.next();
	      try {
	      System.out.println("입금할 금액");
	      int iBalance = s.nextInt();
	      if(iBalance<0) {
	            throw new MenuSelectException("음수는 입금할수 없습니다.");
	         }
	         if(iBalance%500 != 0) {
	            throw new MenuSelectException("500원 단위만 입금가능");
	         }
	      System.out.println("입금이 완료되었습니다.");
	      

	      for(int i=0 ; i<accountList.length ; i++) {
	         if(iaccountNum.equals(accountList[i].getAccountNum())) {
	            balance =accountList[i].getBalance();
	            grade = accountList[i].getGrade();
	            rate = accountList[i].getRate();
	            if(grade != null) {
		        	 if(grade.equals("A")) {
		 	        	customrate = CustomSpecialRate.A; 
		 	         }
		 	         if(grade.equals("B")) {
		 	        	customrate = CustomSpecialRate.B;
		 	         }
		 	         if(grade.equals("C")) {
		 	        	 customrate = CustomSpecialRate.C;
		 	         }
		 	         
		 	        accountList[i].setBalance((int)(Math.floor((balance+(balance*((double)rate/100))
	        				+(balance*customrate*0.01)+iBalance))));
		 	         
		         }
		         else {
		        	accountList[i].setBalance((int)(Math.floor((balance+(balance*((double)rate/100))
		        				+iBalance))));
		         }
	         }
	         else {
	            
	         }
	         }
	      }
	      catch(NullPointerException e) {
	         
	      }
	      catch (MenuSelectException e) {
	           System.out.println(e.getMessage());
	        }
	         catch(InputMismatchException e) {
	            System.out.println("문자는 입력불가");
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
	      if(oBalance<0) {
	            throw new MenuSelectException("음수는 출금 할 수 없습니다.");
	         }
	      if(oBalance%1000 != 0) {
	            throw new MenuSelectException("1000원 단위만 입금가능");
	         }
	 
	      for(int i=0 ; i<accountList.length ; i++) {
	         if(iaccountNum.equals(accountList[i].getAccountNum())) {
	            int result =(accountList[i].getBalance());
	            
	      
	            if(result< oBalance) {
	            	System.out.println("잔고가 부족합니다. 금액 전체를 출력할까요?(YES or NO)");
	            	String output = s.next();
	            	if(output.equals("YES")) {
	            		System.out.println("금액 전체 출력");
	            		accountList[i].setBalance(0);
	            	}
	            	if(output.equals("No")) {
	            		
	            		System.out.println("출금 요청 취소");
	            		accountList[i].setBalance(result);
	            		break;
	            	}
	            }
	            else {
	            	accountList[i].setBalance(result-oBalance);
	            }
	         }
	         else {
	         }
	         }
	      System.out.println("출금이 완료되었습니다.");
	      }
	      catch(NullPointerException e) {
	         
	      }
	      catch (MenuSelectException e) {
	           System.out.println(e.getMessage());
	        }
	   }

	   void showAccInfo() { 
	      System.out.println("==계좌정보 출력==");
	      try {
	      for(int j=0; j<accountList.length;j++) {
	         accountNum = accountList[j].getAccountNum();
	         name = accountList[j].getName();
	         balance = accountList[j].getBalance();
	         rate = accountList[j].getRate();
	         grade = accountList[j].getGrade();
	       
	         System.out.println("계좌번호: "+accountNum);
	         System.out.println("이름 : "+name);
	         System.out.println("잔고:" + balance);
	         System.out.println("이율:"+ rate);
	         if(grade != null) {
	         System.out.println("등급:"+ grade);
	         }
	         System.out.println("======================");
	      }
	      }
	      catch(NullPointerException e) {
	         
	      }
}
}

