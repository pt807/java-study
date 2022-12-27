package prob01;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class GugudanApp {

	static int resultNumber = 0;

	public static void main(String[] args) {
		int l = randomize(1, 9);
		int r = randomize(1, 9);

		resultNumber = l * r;

		int[] answerNumbers = randomizeAnswers();
		int loc = randomize(0, 8);
		answerNumbers[loc] = resultNumber;

		System.out.println(l + " x " + r + " = ?");

		int length = answerNumbers.length;
		for (int i = 0; i < length; i++) {
			if (i % 3 == 0) {
				System.out.print("\n");
			} else {
				System.out.print("\t");
			}

			System.out.print(answerNumbers[i]);
		}

		System.out.print("\n\n");
		System.out.print("answer:");

		Scanner s = new Scanner(System.in);
		int answer = s.nextInt();
		s.close();

		System.out.println((answer == resultNumber) ? "정답" : "오답");
	}

	private static int randomize(int lNum, int rNum) {
		int random = (int) (Math.random() * rNum) + lNum;
		return random;
	}

	private static int[] randomizeAnswers() {
		/* 코드 작성(수정 가능) */
		final int COUNT_ANSWER_NUMBER = 9;
		int[] boardNumbers = new int[COUNT_ANSWER_NUMBER];
		int l, r, count = 0;
		Set<Gugudan> set = new HashSet<>();

		while (set.size() < COUNT_ANSWER_NUMBER) {
			l = randomize(1, 9);
			r = randomize(1, 9);
			set.add(new Gugudan(l, r));
		}

		// 반복자 생성
		Iterator<Gugudan> i = set.iterator();
		while (i.hasNext()) {
			Gugudan g = i.next(); // set에 저장된 다음 객체의 참조값 저장
			boardNumbers[count] = g.getlValue() * g.getrValue();
			count++;
		}

		return boardNumbers;
	}
}
