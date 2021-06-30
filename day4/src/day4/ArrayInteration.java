package day4;

public class ArrayInteration {
	public static void main(String[] args) {
		int[] nums= {99,44,66,33,22,77};
		
		int index = 0;
		while (index < nums.length) {
			System.out.println(nums[index]);
			index++;
		}
		
		System.out.println("For Loop:");
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		
		System.out.println("Enhanced For Loop:");
		for (int element : nums) {
			System.out.println(element);
		}
	}
}
