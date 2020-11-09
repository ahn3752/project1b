package project1b;

import java.util.Scanner;

import project1b.ver01.Account;
import project1b.ver01.MenuChoice;


public class BankingSystemVer01 implements MenuChoice  {
   static Scanner s = new Scanner(System.in);
   static Account[] accountList = new Account[50];
   static Account account = null;
   
   String accountNum;
   String name;
   int balance;
   
   public static void showMenu() {
      while(true) {
    	  int count = 0;
      Scanner s = new Scanner(System.in);
      
      System.out.println("----Menu----");
      System.out.println("1.계좌개설");
      System.out.println("2.입 금");
      System.out.println("3.출 금");
      System.out.println("4.계좌정보출력");
      System.out.println("5.프로그램 종료");
      int choice = s.nextInt();
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
   static int i=0;
   static void makeAccount() {
      account = new Account();
         System.out.println("==계좌개설==");
         System.out.println("계좌번호를 입력해 주세요.");
         String accountNum = s.next();
         System.out.println("고객이름을 입력해 주세요");
         String name = s.next();
         System.out.println("잔고를 입력해 주세요");
         int balance = s.nextInt();
         System.out.println("계좌 개설 완료");
         account.setAccountNum(accountNum);
         account.setName(name);
         account.setBalance(balance);
         accountList[i] = account;
         i++;
   }
   static void depositMoney() {
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
        	 System.out.println(i);
            int result =(accountList[i].getBalance());
            accountList[i].setBalance(result+iBalance);
         }
         else {
            
         }
         }
      }
      catch(NullPointerException e) {
         
      }
   }
   
   static void withdrawMoney() {
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

   static void showAccInfo() {
      System.out.println("==계좌정보 출력==");
      try {
      for(int j=0; j<accountList.length;j++) {
         String accountNum = accountList[j].getAccountNum();
         String name = accountList[j].getName();
         int balance = accountList[j].getBalance();
         System.out.println(j+"계좌번호: "+accountNum);
         System.out.println(j+"이름 : "+name);
         System.out.println(j+"잔고 :"+balance);
         System.out.println("======================");
      }
      }
      catch(NullPointerException e) {
         
      }
      
   } 
   
   public static void main(String[] args) {
      showMenu();
   }
}