package day4;

public class BreakAndContinue {
	public static void main(String[] args) {
		int i=0;
		System.out.println("Break:");
		while (true) {
			System.out.println(i);
			i++;
			if (i==2){
				break;
			}
		}
		System.out.println("Continue:");
		for (char letter = 'A'; letter <= 'D'; letter++) {
			for (int num = 0; num < 4; num++) {
				if (num == 2)
					continue;
				System.out.println(letter + ":" + num);
			}
		}
		/*labels are arbitary monikers/names given to various
		 * control statements (loops) to provide a way to
		 * distinguish which structure we want a break or
		 * continue statement to apply to
		 * 
		 * label syntax:
		 * <label-name> : while ()...
		 */
		//System.out.println("Break [with labels]:");
		//alpha: for (char letter = 'A'; letter <= 'D'; letter++) 
		//	numeric: for (int num = 0)
	
	//}
		System.out.println("Continue with labels:");
		alpha: for (char letter = 'A'; letter <= 'D'; letter++) {
			numeric: for (int num = 0; num < 4; num++) {
				if (num == 2)
					continue alpha;
				System.out.println(letter + ":" + num);
			}
		}
	}
}
