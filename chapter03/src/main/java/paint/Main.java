package paint;

public class Main {

	public static void main(String[] args) {
		Point point = new Point(10, 20);
//		point.setX(10);
//		point.setY(10);
		point.show();

		drawpoint(point);

		point.show(false);
		// point.disapear();
	}

	public static void drawpoint(Point point) {
		point.show();
	}

}
