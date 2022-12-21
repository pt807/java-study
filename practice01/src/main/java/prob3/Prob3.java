package prob3;

import java.util.Scanner;

public class Prob3 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int num = 0;
		int even = 0;
		int odd = 0;

		System.out.println("숫자를 입력하세요: ");
		num = scanner.nextInt();

		if (num % 2 == 0) {
			for (int i = 2; i <= num; i++) {
				if (i % 2 == 0) {
					even += i;
				}
			}
			System.out.println("결과 값 :" + even);
		} else {
			for (int i = 1; i <= num; i++) {
				if (i % 2 == 1) {
					odd += i;
				}
			}
			System.out.println("결과 값 :" + odd);
		}

		scanner.close();
	}
}
