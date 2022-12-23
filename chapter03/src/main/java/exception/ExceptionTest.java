package exception;

public class ExceptionTest {

	public static void main(String[] args) {

		int a = 10;
		int b = 10 - a;

		System.out.println("some code 1...");
		try {
			System.out.println("some code 2... file open");
			System.out.println("some code 3...");

			int res = (1 + 2 + 3) / b;

			System.out.println("some code 4...");
			System.out.println("some code 5...");

		} catch (ArithmeticException ex) {
			/* 예외 처리 */
			// 1. 로깅
			System.out.println("error: " + ex);
			// 2. 사과
			System.out.println("sorry...");
			// 3. 정상종료
			// System.exit(0);
			return;
		} finally {
			System.out.println("자원 정리 예: file close...");
		}

		System.out.println("some code 6...");
		System.out.println("some code 7...");

	}

}
