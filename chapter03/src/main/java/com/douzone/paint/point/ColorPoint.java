package com.douzone.paint.point;

public class ColorPoint extends Point {

//  부모의 기본 생성자가 없어서 에러
//  기본생성자 생성 또는 생성자에 맞춰서 작성	
//	public ColorPoint() {
//		super();
//	}

	private String color;

	public ColorPoint(int x, int y, String color) {
		super(x,y);
//		setX(x);
//		setY(y);
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void show() {
		System.out.println(
				"점(x=" + getX() + 
				", y=" + getY() +
				"color=" + color + ")을 그렸습니다.");

	}

}
