import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

// https://www.seminolestate.edu/computers/competition/samples/2013
public class Competition_2013 {

	public static void main(String[] args) {
		matchingSpecialCharacters2();
	}
	
	public static void MatchingSpecialCharacters() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter characters: ");
		String s = input.next();
		
		ArrayList<String> chars = new ArrayList<String> (Arrays.asList("(", ")", "{", "}", "[", "]"));
		ArrayList<String> sList = new ArrayList<String> (Arrays.asList(s.split("")));
		
		boolean didMatch = true;
		
		while (sList.size() > 0) {
			int index = chars.indexOf(sList.get(0));
			if (index != -1) {
				int matchingIndex = (index % 2 == 0) ? index + 1 : index - 1;
				for (int i = 0; i < sList.size(); i++) {
					if (chars.get(matchingIndex).equals(sList.get(i))) {
						sList.remove(i);
						break;
					}
					if (i == sList.size() - 1) {
						didMatch = false;
					}
				}
			} else {
				didMatch = false;
				break;
			}
			sList.remove(0);
		}
		
		if (didMatch) {
			System.out.println("All special characters have a match.");
		} else {
			System.out.println("There are missing special characters.");
		}	
	}
	
	public static void matchingSpecialCharacters2() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter characters: ");
		String userString = input.nextLine();
		String cleanString = "";
		
		// Delete any other characters
		for (int i = 0; i < userString.length(); i++) {
			String oneLetter = userString.substring(i, i + 1);
			
			if (oneLetter.equals("(") || 
				oneLetter.equals(")") || 
				oneLetter.equals("{") || 
				oneLetter.equals("}") || 
				oneLetter.equals("[") || 
				oneLetter.equals("]")) 
			{
				cleanString += oneLetter;
			}
		}
		
		// Check if there are matching special characters
		boolean didMatch = true;
		while(cleanString.length() > 0) {
			String oneLetter = cleanString.substring(0, 1);
			String matchingLetter = "";
			
			switch(oneLetter) {
			case "(":
				matchingLetter = ")";
				break;
			case ")":
				matchingLetter = "(";
				break;
			case "{":
				matchingLetter = "}";
				break;
			case "}":
				matchingLetter = "{";
				break;
			case "[":
				matchingLetter = "]";
				break;
			case "]":
				matchingLetter = "[";
				break;
			}
			
			String leftString = cleanString.substring(1);
			if (leftString.contains(matchingLetter)) {
				// there is a matching character
				// Delete matched character
				int matchedIndex = cleanString.indexOf(matchingLetter);
				leftString = leftString.substring(0, matchedIndex - 1) + leftString.substring(matchedIndex);
			} else {
				// there is missing character
				didMatch = false;
			}
			cleanString = leftString;
		}
		
		if (didMatch) {
			System.out.println("All special characters have a match.");
		} else {
			System.out.println("Not all special characters have a match.");
		}
	}
	
	public static void MovingAverages() {
		Scanner input = new Scanner(System.in);
		System.out.print("Numbers in Series: ");
		String userInput = input.nextLine();
		
		String[] numberString = userInput.split(" ");
		float[] numbers = new float[numberString.length];
		for (int i = 0; i < numberString.length; i++) {
			numbers[i] = Float.parseFloat(numberString[i]);
		}
		
		System.out.print("Enter size of subset: ");
		int subset = input.nextInt();
		
		for (int i = 0; i <= numbers.length - subset; i++) {
			float sum = 0;
			for (int j = 0; j < subset; j++) {
				sum += numbers[i + j];
			}
			System.out.printf("%.2f ", sum / subset);
		}
	}

	public static void MealDeal() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the number of travelers: ");
		int numTraveler = input.nextInt();
		
		System.out.print("Enter the daily meal costs: ");
		float[] costs = new float[numTraveler];
		float sum = 0;
		for (int i = 0; i < numTraveler; i++) {
			float cost = input.nextFloat();
			costs[i] = cost;
			sum += cost;
		}
		
		float average = sum / numTraveler;
		float output = 0;
		
		for (int i = 0; i < numTraveler; i++) {
			output += (average > costs[i]) ? average - costs[i] : 0;
		}
		System.out.printf("%.2f", output);
	}
	
	public static void Palindrome() {
		Scanner input = new Scanner(System.in);
		
		long lower, upper;
		System.out.print("Lower bound: ");
		lower = input.nextInt();
		System.out.print("Upper bound: ");
		upper = input.nextInt();
		
		int count = 0;
		for (long i = lower; i <= upper; i++) {
			String num = String.valueOf(i);
			int numLength = num.length();
			
			boolean isPalindromic = false;
			if (i < 10) {
				isPalindromic = true;
			}
			
			for (int j = 0; j < numLength / 2; j++) {
				if (num.substring(j, j + 1).equals(num.substring(numLength - j - 1, numLength - j))) {
					if (j == numLength / 2 - 1) {
						isPalindromic = true;
					}
				} else {
					break;
				}
			}
			if (isPalindromic) {
				count++;
			}
		}
		System.out.println("The number of palindromes is " + count);
	}
	
	public static void StackingBlocks() {
		Scanner input = new Scanner(System.in);
		System.out.print("Number of Blocks: ");
		int numBlocks = input.nextInt();
		int usedBlocks = 0, numRow = 0, leftBlocks = 0;;
		
		for (int i = 1; i <= numBlocks; i++) {
			usedBlocks += i;
			if (usedBlocks > numBlocks) {
				usedBlocks -= i;
				leftBlocks = numBlocks - usedBlocks;
				break;
			}
			numRow++;
		}
		System.out.println(numRow + " level(s) with " + leftBlocks + " block(s) leftover");
	}
	
	public static void GatherPoints() {
		Scanner input = new Scanner(System.in);
		int row, col;
		System.out.print("How many rows? ");
		row = input.nextInt();
		System.out.print("How many columns? ");
		col = input.nextInt();
		
		int[][] array = new int[row][col];
		for (int i = 0; i < row; i++) {
			System.out.print("Enter the number in " + i + "th row(dividing each number by the space): ");
			for (int j = 0; j < col; j++) {
				int num = input.nextInt();
				array[i][j] = num;
			}
		}
		
		int posRow = 0, posCol = 0;
		int points = array[posRow][posCol];
		boolean isRightExist, isBottomExist;
		isRightExist = (posCol + 1 == col) ? false : true;
		isBottomExist = (posRow + 1 == row) ? false : true;
		
		while(isRightExist || isBottomExist) {			
			if (isRightExist && isBottomExist) {
				// if right is bigger than bottom
				if (array[posRow][posCol + 1] > array[posRow + 1][posCol]) {
					posCol++;
				} else {
					posRow++;
				}
			} else if (isRightExist) {
				posCol++;
			} else if (isBottomExist) {
				posRow++;
			}
			points += array[posRow][posCol];
			
			isRightExist = (posCol + 1 == col) ? false : true;
			isBottomExist = (posRow + 1 == row) ? false : true;
		}
		System.out.println("You get " + points + " points");
	}
	
	public static void SnailInTheWall() {
		Scanner input = new Scanner(System.in);
		int day, up, down, wallHeight, fatigueRate;
		day = 0;
		
		System.out.print("Enter wall height, climbing distance, sliding distance, and fatigue factor dividing by space: ");
		wallHeight = input.nextInt();
		up = input.nextInt();
		down = input.nextInt();
		fatigueRate = input.nextInt();
		double position = 0;
		double distanceLost = ((double) up * fatigueRate / 100);
		
		while (position < wallHeight && position >= 0) {
			day++;
			position += up - distanceLost * (day - 1);
			
			if (position > wallHeight) {
				break;
			}
			position -= down;
		}
		if (position > wallHeight) {
			System.out.println("Success on day " + day);
		} else {
			System.out.println("Failure on day " + day);
		}
	}
}
