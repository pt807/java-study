package prob6;

public class RectTriangle extends Shape {

	private double width;
	private double heigth;

	public RectTriangle(double w, double h) {
		width = w;
		heigth = h;
	}

	@Override
	protected double getArea() {
		return (width * heigth) / 2;
	}

	@Override
	protected double getPerimeter() {
		return (width + heigth + Math.sqrt(width * width + heigth * heigth));
	}

}
