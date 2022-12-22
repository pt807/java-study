package prob5;

//일반 예외로 선언할 경우 Exception을 상속받아 구현
public class MyStackException extends Exception {
	MyStackException(String mes) {
		super(mes);
	}
}
