package prob5;

public class MyStack {
	private String[] buffer;
	private int top;

	public MyStack(int i) {
		top = -1;
		buffer = new String[i];
	}

	public void push(String string) {
		if (top == buffer.length - 1) {
			String[] temp = new String[buffer.length + 3];
			for (int i = 0; i < buffer.length; i++) {
				temp[i] = buffer[i];
			}
			buffer = temp;
		}
		buffer[++top] = string;
	}

	public String pop() throws MyStackException {
		if (isEmpty()) {
			throw new MyStackException("stack is empty");
		}
		String p = buffer[top];
		buffer[top--] = null;
		return p;
	}

	public boolean isEmpty() {
		return top == -1;
	}
}