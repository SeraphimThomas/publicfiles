package day4;

public class ArraySimulator {
	public static void main(String[] args) {
		/* Arrays are data structures fixed in size.
		 * Means array cannot be changed
		 * But elements in them can be changed
		 * the 'new' keyword is for any new object
		 */
		//declare size but not the values
		int[] nums_1 = new int[5];
		
		//declare the values (and the size)
		int[] nums_2 = new int[] {6,44,32,99,101};
		
		//Anonymous array assignment
		
		int[] nums_3 = {51,62,73,84,95};
		
		nums_3 = new int[] {1,2,3,4};
		// nums = new {5,6,7,8}; // error
		
		/* indexing allows you to locate
		 * elements within the array
		 */
		System.out.println(nums_3[0]);
		nums_3[0]= 15;
		System.out.println(nums_3[0]);
	}
}
