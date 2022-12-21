package chapter03;

import mypakage.Goods2;

public class DiscountGoods2 extends Goods2 {
	int i = 10;
	//System.out.println(10); 리터널
	//System.out.println(i);
	//System.out.println(2+8);
	
	private float discountrate = 0.5f;
	
	public float getDiscountPrice() {
		// protected는 자식에서 접근할 수 있다.
		return discountrate * price;
	}
}
