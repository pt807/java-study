package chapter03;

import java.util.Iterator;

public class ArrayUtil {

	public static double[] intToDouble(int[] is) {
		double[] result = new double[is.length];

		for (int i = 0; i < is.length; i++) {
			result[i] = is[i];
		}
		return result;
	}

	public static int[] doubleToInt(double[] is) {
		int[] result = new int[is.length];

		for (int i = 0; i < is.length; i++) {
			result[i] = (int) is[i];
		}
		return result;
	}

	public static int[] concat(int[] is, int[] is2) {
		int len = is.length + is2.length;
		int[] result = new int[len];
		
		System.arraycopy(is, 0, result, 0, is.length);
		System.arraycopy(is2, 0, result, is.length, is2.length);
		return result;
	}

}
