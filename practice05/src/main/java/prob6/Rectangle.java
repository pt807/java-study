package prob6;

public class Rectangle extends Shape implements Resizable {

	private double width;
	private double heigth;

	public Rectangle(double w, double h) {
		width = w;
		heigth = h;
	}

	@Override
	protected double getArea() {
		return width * heigth;
	}

	@Override
	protected double getPerimeter() {
		return (width + heigth) * 2;
	}

	@Override
	public void resize(double s) {
		width *= s;
		heigth *= s;
	}

}
