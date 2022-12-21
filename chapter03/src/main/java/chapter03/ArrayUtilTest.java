package chapter03;

import java.util.Arrays;

public class ArrayUtilTest {

	public static void main(String[] args) {

//		int[] a = { 10, 20, 30, 40 };
//		int[] b = new int[4];
//		b[0] = 10;
//		b[1] = 20;
//		b[2] = 30;
//		b[3] = 40;

		double[] d = ArrayUtil.intToDouble(new int[] { 10, 20, 30, 40 });
		System.out.println(Arrays.toString(d));

		int[] i1 = ArrayUtil.doubleToInt(new double[] { 10.0, 11.1, 22.2, 33.3 });
		System.out.println(Arrays.toString(i1));

		int[] i2 = ArrayUtil.concat(new int[] { 1, 2, 3 }, new int[] { 4, 5, 6 });
		System.out.println(Arrays.toString(i2));

	}
}
