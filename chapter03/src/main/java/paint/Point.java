package paint;

public class Point {
	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void show() {
		System.out.println("점(x=" + this.x + ", y=" + this.y + ")을 그렸습니다.");
	}

	public void show(boolean visible) {
		if (visible) {
			show(); // 코드 중복 방지
		} else {
			System.out.println("점(x=" + this.x + ", y=" + this.y + ")을 지웠습니다.");

		}
	}

}
