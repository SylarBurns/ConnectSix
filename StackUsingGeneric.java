
public class StackUsingGeneric <T extends Object>{
	//Initialization
	private int stackSize;
	private int top;
	private T[] stackArr;
	
	public StackUsingGeneric(int size) {
		this.stackSize = size;
		this.top = -1;
		this.stackArr = (T[]) new Object[stackSize];
	}
	
	//PUSH
	public void push(T element) {
		if(this.isStackFull()) {
			System.out.println("Stack is full");
			this.increaseCapacity();
		}
		this.stackArr[++top] = element;
	}
	public boolean isStackFull() {
		return (this.stackSize - 1 == top);
	}
	public void increaseCapacity() {
		T[] newArr = (T[]) new Object[stackSize * 2];
		for(int i = 0; i < stackSize; i++) {
			newArr[i] = stackArr[i];
		}
		this.stackArr = newArr;
		this.stackSize = this.stackSize * 2;
	}
	
	//POP
	
	public T pop(){
		if(this.isStackEmpty()) {
			System.out.println("Stack is empty");
		}
		return stackArr[top--];
	}
	public boolean isStackEmpty() {
		return (this.top == -1);
	}
	public T peek() {
		return this.stackArr[top];
	}
}
