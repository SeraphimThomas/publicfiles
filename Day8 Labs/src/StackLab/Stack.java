package StackLab;

import java.util.Arrays;

public class Stack {
	private int lastItem = 0;
	private int[] items = new int[0];
	
	//add items to stack
	//add item to stack, update lastItem to on being pushed
	public void push(int newItem) {
		int index = items.length; //get current length to store
		System.out.println("Array length is: " + index);
	
		items = new int[items.length + 1]; //increase array by 1 to add new items
		System.out.println("Items after extending by 1: " + Arrays.toString(items));
		
		items[index]=newItem; //store value in index
		System.out.println("Items after storing new val: " + Arrays.toString(items));
		
		lastItem=newItem; //update lastItem
		System.out.println("The last items is: " + lastItem);
	}
	
	//remove items from stack
	public int pop() {
		int tempItem = lastItem; //store the last item to variable
		
		//copy new array, but remove last item
		int[] newArray = new int[items.length-1];
		
		for(int i=0; i<newArray.length; i++) {
			newArray[i]=items[i];
		}
		items=newArray; //update the items array with new one
		
		//return 'popped'
		return tempItem;
	}
	
	//view last item
	public int peek() {
		return 0;
	}
}
