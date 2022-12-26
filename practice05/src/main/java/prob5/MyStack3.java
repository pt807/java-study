package prob5;

public class MyStack3<T> {
	private T[] buffer;
	private int top;

	@SuppressWarnings("unchecked")
	public MyStack3(int i) {
		top = -1;
		buffer = (T[]) new Object[i];
	}

	public void push(T t) {
		if (top == buffer.length - 1) {
			@SuppressWarnings("unchecked")
			T[] temp = (T[]) new Object[buffer.length + 3];
			for (int i = 0; i < buffer.length; i++) {
				temp[i] = buffer[i];
			}
			buffer = temp;
		}
		buffer[++top] = t;
	}

	public T pop() throws MyStackException {
		if (isEmpty()) {
			throw new MyStackException("stack is empty");
		}
		T p = buffer[top];
		buffer[top--] = null;
		return p;
	}

	public boolean isEmpty() {
		return top == -1;
	}
}