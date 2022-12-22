package paint;

public class Rect extends Shape{

	private int x1, y1;
	private int x2, y2;
	private int x3, y3;
	private int x4, y4;

	@Override
	public void draw() {
		System.out.println("사각형을 그렸습니다.");
	}
}
