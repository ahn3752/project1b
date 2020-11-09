package project1b.ver02;

import java.util.Scanner;


public class AccountManager implements MenuChoice {

	Scanner s = new Scanner(System.in);
	Account[] accountList = new Account[50];
	Account account = null;
	NormalAccount normalAccount = null;
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
	      choice = s.nextInt();
	      System.out.println("선택:"+ choice);
	      
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
	      }
	   }
	   int i=0;
	   void makeAccount() {
	      account = new Account();
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
		         normalAccount = new NormalAccount(accountNum,name,balance,rate);
		         account.setAccountNum(accountNum);
		         account.setName(name);
		         account.setBalance(balance);
		         account.setRate(rate);
		         accountList[i] = account;
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
		         account = new HighCreditAccount(accountNum,name,balance,rate,grade);
		         account.setAccountNum(accountNum);
		         account.setName(name);
		         account.setBalance(balance);
		         account.setRate(rate);
		         account.setGrade(grade);
		         accountList[i] = account;
		         i++;
	         }
	   }
	   void depositMoney() {
	      System.out.println("***입금***");
	      System.out.println("계좌번호와 입금할 금액을 입력하세요");
	      System.out.println("계좌번호:");
	      String iaccountNum = s.next();
	      System.out.println("입금할 금액");
	      int iBalance = s.nextInt();
	      System.out.println("입금이 완료되었습니다.");
	      
	      try {
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
	        				+(balance*(double)customrate/100)+iBalance))));
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
	   }
	   
	   void withdrawMoney() {
	      System.out.println("***출금***");
	      System.out.println("계좌번호와 출금할 금액을 입력하세요.");
	      System.out.println("계좌번호:");
	      String iaccountNum = s.next();
	      System.out.println("출금할 금액");
	      int iBalance = s.nextInt();
	      System.out.println("출금이 완료되었습니다.");
	      
	      try {
	      for(int i=0 ; i<accountList.length ; i++) {
	         if(iaccountNum.equals(accountList[i].getAccountNum())) {
	            int result =(accountList[i].getBalance());
	            accountList[i].setBalance(result-iBalance);
	         }
	         else {
	         }
	         }
	      }
	      catch(NullPointerException e) {
	         
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

