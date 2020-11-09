package project1b.game3by3;

import java.util.Arrays;
import java.util.Scanner;

public class Game3by3 {

	Scanner sc = new Scanner(System.in);

	String[][] arr = { { "1", "2", "3" }, { "4", "5", "6" }, { "7", "8", "X" } };
	String[][] ar = { { "1", "2", "3" }, { "4", "5", "6" }, { "7", "8", "X" } };
	int count = 100;
	int out = 0;
	String temp;
	String button;
	String w, a, s, d;

	public void print() {
		System.out.println("=====");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("=====");

	}

	public void game() {

		print();
		while (true) {
		for (int i = 0; i < count; i++) {
			int x1 = (int) (Math.random() * arr.length);
			int y1 = (int) (Math.random() * arr.length); 
			int x2 = (int) (Math.random() * arr.length);
			int y2 = (int) (Math.random() * arr.length);

			temp = arr[x1][y1];
			arr[x1][y1] = arr[x2][y2];
			arr[x2][y2] = temp;
		}
		print();

		while(true) {
			System.out.println("방향키를 입력하세요.(w,a,s,d)");

				String control = sc.next();
				if (control.equals("s")) {
					for (int i = 0; i < arr.length; i++) {
						for (int j = 0; j < arr[i].length; j++) {
							if (arr[i][j] == "X") {
								if (i == 0) {
									System.out.println("이동불가");
								} else {
									temp = arr[i][j];
									arr[i][j] = arr[i - 1][j];
									arr[i - 1][j] = temp;
									break;

								}
							}
						}
					}
				}
				if (control.equals("d")) {
					for (int i = 0; i < arr.length; i++) {
						for (int j = 0; j < arr[i].length; j++) {
							if (arr[i][j] == "X") {
								if (j == 0) {
									System.out.println("이동불가");
								} else {
									temp = arr[i][j];
									arr[i][j] = arr[i][j - 1];
									arr[i][j - 1] = temp;
									break;

								}
							}
						}
					}
				}
				
				if (control.equals("w")) {
					for (int j = 0; j < arr.length; j++) {
						for (int i = 0; i < arr[j].length; i++) {
							if (i + 1 <= arr.length) {
								if (arr[i][j] == "X") {
									if (i == 2) {
										System.out.println("이동불가");
									} else {
										temp = arr[i][j];
										arr[i][j] = arr[i + 1][j];
										arr[i + 1][j] = temp;
										System.out.println(arr[i][j]);
										break;
		
									}
								}
							}
						}
					}
				}
						
				if (control.equals("a")) {
					for (int i = 0; i < arr.length; i++) {
						for (int j = 0; j < arr[i].length; j++) {
							if (j + 1 <= arr.length) {
								if (arr[i][j] == "X") {
									if (j == 2) {
										System.out.println("이동불가");
									} else {
										temp = arr[i][j];
										arr[i][j] = arr[i][j + 1];
										arr[i][j + 1] = temp;
										break;

									}
								}
							}
						}
					}
				}
			

			print();
			
			if (Arrays.deepEquals(arr, ar) == true) {
				System.out.println("=====게임 clear=====");
				System.out.println("재시작 하시겠습니까?");
				button = sc.next();

				if (button.equals("y")) {
					System.out.println("재시작합니다");
					break;
				} else {
					System.out.println("종료합니다.");
					out++;
					break;
				}
			}
		}
		if(out != 0) {
			break;
		}
		}
	}

	public static void main(String[] args) {
		Game3by3 game = new Game3by3();
		game.game();
	}
}
