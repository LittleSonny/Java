package abstract1.data.type;

import java.util.EmptyStackException;

public class StackByArray<E> {
	E[] data;
	int size;

	public StackByArray() {
		this(16);
	}

	public StackByArray(int size) {
		this.size = 0;
		data = getArray(size);
	}

	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	public E peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}

		return data[size - 1];
	}

	public E pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}

		return data[size--];
	}

	public void push(E item) {
		if (isFull()) {
			data = getArray(2 * data.length);
		}

		data[size - 1] = item;
		size++;
	}

	public int search(Object o) {
		if (!isEmpty()) {
			for (int i = 0; i < data.length; i++) {
				if (data[i].equals(o))
					return i;
			}
		}
		return -1;
	}

	// private
	private boolean isFull() {
		if (size == data.length) {
			return true;
		}
		return false;
	}

	private E[] getArray(int size) {
		return (E[]) new Object[size];
	}
}
