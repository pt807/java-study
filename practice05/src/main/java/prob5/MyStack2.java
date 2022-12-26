package prob5;

public class MyStack2 {
	private Object[] buffer;
	private int top;

	public MyStack2(int i) {
		top = -1;
		buffer = new Object[i];
	}

	public void push(Object string) {
		if (top == buffer.length - 1) {
			Object[] temp = new Object[buffer.length + 3];
			for (int i = 0; i < buffer.length; i++) {
				temp[i] = buffer[i];
			}
			buffer = temp;
		}
		buffer[++top] = string;
	}

	public Object pop() throws MyStackException {
		if (isEmpty()) {
			throw new MyStackException("stack is empty");
		}
		Object p = buffer[top];
		buffer[top--] = null;
		return p;
	}

	public boolean isEmpty() {
		return top == -1;
	}
}