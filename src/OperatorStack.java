public class OperatorStack<T> implements StackInterface<T> {
	
	// create operator stack using StackInterface
	private T[] operatorStack;
	private int topIndex;
	private static final int DEFAULT_CAPACITY = 10;
	private static final int MAX_CAPACITY = 100;
	
	public OperatorStack() {
		this(DEFAULT_CAPACITY);
	}
	
	public OperatorStack(int initialCapacity) {
		T[] tempStack = (T[]) new Object[initialCapacity];
		operatorStack = tempStack;
		topIndex = -1;
	}
	
	public void push(T newEntry) {
		operatorStack[topIndex + 1] = newEntry;
		topIndex++;
	}
	
	public T pop() {
		if (!isEmpty()) {
			return operatorStack[topIndex--];
		} else {
			return null;
		}
	}
	
	public T peek() {
		if (!isEmpty()) {
			return operatorStack[topIndex];
		}
		return null;
	}
	
	public boolean isEmpty() {
		return topIndex == -1;
	}
	
	// used to check the operator stack as it adds operators
    public void printStack() {
        System.out.print("Operator Stack: ");
        for (int i = 0; i <= topIndex; i++) {
            System.out.print(operatorStack[i] + " ");
        }
    }
}
       