package prob5;

import java.util.Scanner;

public class Prob5 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("1 ~ 99까지 숫자를 입력: ");
		int num = sc.nextInt();
		int count = 0;

		if (num < 1 || num >= 100) {
			System.out.println("다시입력");
		} else {
			if (num % 10 == 3 || num % 10 == 6 || num % 10 == 9) {
				count++;
			}

			if (num / 10 == 3 || num / 10 == 6 || num / 10 == 9) {
				count++;
			}

			if (count > 1) {
				System.out.println("짝짝");
			} else {
				System.out.println("짝");
			}
		}

	}
}
