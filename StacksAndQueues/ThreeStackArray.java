package StacksAndQueues;


// Implement three stacks using a single array
// [0        299][300       599][600      899]

public class ThreeStackArray {
	int stackSize = 300;
	int[] buffer = new int[stackSize * 3];
	int[] stackPointer = {0, 0, 0};
	
	int pop(int stackNumber) {
		int index = stackNumber * stackSize + stackPointer[stackNumber];
		int data = buffer[index];
		if (index > (stackNumber * stackSize)) {
			// shift stack pointer to pop off
			stackPointer[stackNumber] = stackPointer[stackNumber] - 1;
		}
		return data;
	}
	
	void push(int stackNumber, int d) {
		int index = stackNumber * stackSize + stackPointer[stackNumber];
		if (index >= (stackNumber * stackSize) && index < (stackNumber + 1) * stackSize) {
			buffer[index] = d;
			stackPointer[stackNumber] = stackPointer[stackNumber] + 1;
		}
	}
}
