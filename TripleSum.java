
import java.util.Scanner;
import java.util.Vector;
import java.util.Arrays;
import java.io.File;

//Do not change the name of the TripleSum class
public class TripleSum{
	/* TripleSum225()
		The input array A will contain non-negative integers. The function
		will search the array A for a triple of elements which sum to 225.
		If such a triple is found, return true. Otherwise, return false.
		The function may modify the array A.
		
		The TripleSum225() method code was written by Dahv Reinhart - V00735279
		Date of submission: 1/24/2016
	*/
	public static boolean TripleSum225(int[] A){
		
		int n = A.length;
		
		if (n < 3) {
			return false; //if less that 3 elements total, then auto-return false
		}
		
		int[] subArr = new int[226]; //new array with defined, constant size
		
		for (int i = 0; i < subArr.length; i++) {
			subArr[i] = -1; //intially fill with erroneous values to differentiate
		}			//which spots have actual values in them and which are unused
		
		for (int i = 0; i < n; i++) {
			if (A[i] < 226) {
				subArr[A[i]] = A[i]; //go through the large array, copying values < 226
			}			     //as we go into the constant time array
		}
		
		for (int i = 0; i < 226; i++) { //all action from here onwards performed on constant time array
			
			if (subArr[i] == -1) { //if subArr[i] == -1 then that spot corresponds to a value 
				continue;      //which was not contained in the large, original array and is
			}			//thus not to be used.
			
			for (int j = i + 1; j < 226; j++) {
				
				if (subArr[j] == -1) {
					continue;
				}
				
				for (int k = j + 1; k < 226; k++) {
					
					if (subArr[k] == -1) {
						continue;
					}
					
					if (subArr[i] + subArr[j] + subArr[k] == 225){ //iterative check for the summation
						return true; //if found return true!
					}
					
				}
			}
		}
		
		return false; //at this point, every possibility for summation in subArr has been checked.
				//Thus, return false.
	}

	/* main()
	   Contains code to test the TripleSum225 function.
	*/
	public static void main(String[] args){
		Scanner s;
		if (args.length > 0){
			try{
				s = new Scanner(new File(args[0]));
			} catch(java.io.FileNotFoundException e){
				System.out.printf("Unable to open %s\n",args[0]);
				return;
			}
			System.out.printf("Reading input values from %s.\n",args[0]);
		}else{
			s = new Scanner(System.in);
			System.out.printf("Enter a list of non-negative integers. Enter a negative value to end the list.\n");
		}
		Vector<Integer> inputVector = new Vector<Integer>();
		
		int v;
		while(s.hasNextInt() && (v = s.nextInt()) >= 0)
			inputVector.add(v);
		
		int[] array = new int[inputVector.size()];
		
		for (int i = 0; i < array.length; i++)
			array[i] = inputVector.get(i);

		System.out.printf("Read %d values.\n",array.length);
		
		
		long startTime = System.currentTimeMillis();
		
		boolean tripleExists = TripleSum225(array);
		
		long endTime = System.currentTimeMillis();
		
		double totalTimeSeconds = (endTime-startTime)/1000.0;
		
		System.out.printf("Array %s a triple of values which sum to 225.\n",tripleExists? "contains":"does not contain");
		System.out.printf("Total Time (seconds): %.4f\n",totalTimeSeconds);
	}
}
