
package Basic_Concepts;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter expression (e.g., 10+5-2):");
		String expression = sc.next();
		
		//The regex splits the string but keeps the operators in the array
		String[] splitArray = expression.split("(?<=[-+*/])|(?=[-+*/])");
		ArrayList<String> token = new ArrayList<>(Arrays.asList(splitArray));
		
		System.out.println("Your query tokens: "+token);
		
		//start with the first number
		int result = Integer.parseInt(token.get(0));
		
		//Loop through the list, jumping by 2 (to hit every operator)
		//we start at index 1 (the first operator)
		for(int i=1; i<token.size(); i+=2) {
			String op = token.get(i);
			int nextNum = Integer.parseInt(token.get(i+1));
			
			System.out.println("Now doing : "+op+" "+nextNum);
			
			if(op.equals("+")) {
				result += nextNum;
			}
			else if(op.equals("-")) {
				result -= nextNum;
			}
			else if(op.equals("*")) {
				result *= nextNum;
			}
			else if(op.equals("/")) {
				if(nextNum != 0) {
					result /= nextNum;
				}
				else {
					System.out.println("Error: Division by zero");
				}
			}
		}
		
		System.out.println("Final Result: "+result);
		sc.close();
	}

}

//1+2-3*4/5
