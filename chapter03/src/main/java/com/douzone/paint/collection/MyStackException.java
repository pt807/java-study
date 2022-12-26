package com.douzone.paint.collection;

//일반 예외로 선언할 경우 Exception을 상속받아 구현
public class MyStackException extends Exception {

	// 예외 발생 원인(예외 메시지)을 전달하기 위해 String 타입의 매개변수를 갖는 생성자
	MyStackException(String mes) {
		super(mes); // RuntimeException 클래스의 생성자를 호출
	}
}
