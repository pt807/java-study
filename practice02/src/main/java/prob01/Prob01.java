package prob01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };

		System.out.println("금액 : ");
		int mon = scanner.nextInt();
		int count = mon;

		if (mon >= 1) {
			MONEYS[0] = count / 50000;
			count %= 50000;

			MONEYS[1] = count / 10000;
			count %= 10000;

			MONEYS[2] = count / 5000;
			count %= 5000;

			MONEYS[3] = count / 1000;
			count %= 1000;

			MONEYS[4] = count / 500;
			count %= 500;

			MONEYS[5] = count / 100;
			count %= 100;

			MONEYS[6] = count / 50;
			count %= 50;

			MONEYS[7] = count / 10;
			count %= 10;

			MONEYS[8] = count / 5;
			count %= 5;

			MONEYS[9] = count / 1;
			count %= 1;
		}

		System.out.println("50000원" + MONEYS[0] + "개 " + "10000원" + MONEYS[1] + "개 " + "5000원" + MONEYS[2] + "개 "
				+ "1000원" + MONEYS[3] + "개 " + "500원" + MONEYS[4] + "개 " + "100원" + MONEYS[5] + "개 " + "50원" + MONEYS[6]
				+ "개 " + "10원" + MONEYS[7] + "개 " + "5원" + MONEYS[8] + "개 " + "1원" + MONEYS[9] + "개 ");

		scanner.close();
	}
}