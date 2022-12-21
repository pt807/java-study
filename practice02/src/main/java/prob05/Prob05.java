package prob05;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Random random = new Random();
		while (true) {
			int correctNumber = random.nextInt(100) + 1;
			System.out.println("수를 결정하였습니다. 맞추어보세요");

			int count = 1, max = 99, min = 0;

			while (true) {
				System.out.println(min + "-" + max);
				System.out.print(count + ">>");
				int user = scanner.nextInt();

				if (user > correctNumber) {
					System.out.println("더 낮게");
					max = user;
				} else if (user < correctNumber) {
					System.out.println("더 높게");
					min = user;
				} else {
					System.out.println("맞았습니다.");
					break;
				}
				count++;
			}
			System.out.print("다시 하겠습니까(y/n)>>");
			String answer = scanner.next();
			if ("y".equals(answer) == false) {
				break;
			}
		}

		scanner.close();
	}

}