package prob1;

import java.util.Scanner;

public class Prob1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = 0;

		System.out.println("수를 입력하시오 : ");
		num = scanner.nextInt();

		if (num % 3 == 0) {
			System.out.println("3의 배수입니다.");
		}
		scanner.close();
	}
}
