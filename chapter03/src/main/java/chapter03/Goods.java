package chapter03;

public class Goods {

	public static int countOfGoods = 0;

	private String name;
	private int price;
	private int countStock;
	private int countSold;

	public Goods() {
		// 같은 클래스에서는 클래스이름 생략 가능
		Goods.countOfGoods = Goods.countOfGoods + 1;
	}

	//생성자 오버로딩
	public Goods(String name, int price, int countStock, int countSold) {
		this.name = name;
		this.price = price;
		this.countStock = countStock;
		this.countSold = countSold;
		
		Goods.countOfGoods = Goods.countOfGoods + 1;
	}

	public int calDiscountPrice(float discountRate) {
		float f = 3; // 암시적 케스팅

		return (int) (price * discountRate);
	}

	public void printInfo() {
		System.out.println(name + ":" + price + ":" + countStock + ":" + countSold);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if (price < 0) { // 정보보호
			price = 0;
		}
		this.price = price;
	}

	public int getCountStock() {
		return countStock;
	}

	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}

	public int getCountSold() {
		return countSold;
	}

	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}

}
