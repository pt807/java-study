package prob01;

public class Printer {

//	public void println(int i) {
//		System.out.println(i);
//	}
//
//	public void println(boolean b) {
//		System.out.println(b);
//
//	}
//
//	public void println(double d) {
//		System.out.println(d);
//
//	}
//
//	public void println(String s) {
//		System.out.println(s);
//
//	}

	// ex) extends number 제한가능
	public <T> void println(T t) {
		System.out.println(t);
	}

	// 가변 파라미터
	public int sum(Integer... nums) {
		int s = 0;
		for (Integer n : nums) {
			s += n;
		}
		return s;
	}

	@SuppressWarnings("unchecked")
	public <T> void println(T... ts) {
		for (T t : ts)
			System.out.println(t);
	}
}
