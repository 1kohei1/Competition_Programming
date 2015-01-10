import java.util.Scanner;
import java.util.ArrayList;

// https://www.seminolestate.edu/computers/competition/samples/2012
// 1:40:24
public class Competition_2012 {

	public static void main(String[] args) {
		foreignLanguage();
	}
	
	public static void checkDigit() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the UPC code minus the check digit: ");
		String num = input.nextLine();
		int[] numArray = new int[11];
		
		for (int i = 0; i < num.length(); i++) {
			numArray[i] = new Integer(num.substring(i, i + 1));
		}
		int oddSum = 0;
		int evenSum = 0;
		int total = 0;
		int checkDigit = 0;
		
		for (int i = 0; i < num.length(); i++) {
			if (i % 2 == 0) {
				oddSum += numArray[i]; 
			} else {
				evenSum += numArray[i];
			}
		}
		total = oddSum * 3;
		total += evenSum;
		checkDigit = total % 10;
		
		if (checkDigit != 0) {
			checkDigit = 10 - checkDigit;
		}
		
		System.out.println("Check digit for " + num + " is " + checkDigit);
	}
	
	public static void numberSequence() {
		Scanner input = new Scanner(System.in);
		
		int[] numbers = new int[10];
		int maxIndex = 0;
		System.out.println("Enter up to 10 numbers.");
		for (int i = 0; i < 10; i++) {
			System.out.print("Number " + ((int) i + 1) + ": ");
			int num = input.nextInt();
			if (num == 99999) {
				maxIndex = i;
				break;
			} else {
				numbers[i] = num;
			}
		}
		if (maxIndex < 3) {
			System.out.println("You need to put more than 2 numbers in the list.");
			return;
		}
		System.out.print("Enter N for the Nth term: ");
		int n = input.nextInt();
		
		boolean isArithmetic = true;
		boolean isGeometric = true;
		// Check arithmetic
		for (int i = 0; i < maxIndex - 2; i++) {
			int answer1 = numbers[i] - numbers[i + 1];
			int answer2 = numbers[i + 1] - numbers[i + 2];
			if (answer1 != answer2) {
				isArithmetic = false;
			}
		}
		
		// Check geometric
		for (int i = 0; i < maxIndex - 2; i++) {
			int answer1 = numbers[i] / numbers[i + 1];
			int answer2 = numbers[i + 1] / numbers[i + 2];
			if (answer1 != answer2) {
				isGeometric = false;
			}
		}
		
		if (isArithmetic) {
			System.out.println("The list is an arithmetic sequence.");
			int answer = numbers[0] + (numbers[1] - numbers[0]) * (n - 1);
			System.out.println("The value of term " + n + " is: " + answer);
		} else if (isGeometric) {
			System.out.println("The list is a geometric sequence.");
			int answer = numbers[0] * ((int) Math.pow(numbers[1] / numbers[0], (n - 1)));
			System.out.println("The value of term " + n + " is: " + answer);
		} else {
			System.out.println("The list is not a sequence.");
		}
	}
	
	public static void DiminishingArea () {
		Scanner input = new Scanner(System.in);
		
		int[] point1 = new int[2];
		int[] point2 = new int[2];
		int[] point3 = new int[2];
		
		System.out.print("Enter x1: ");
		point1[0] = input.nextInt();
		System.out.print("Enter y1: ");
		point1[1] = input.nextInt();
		
		System.out.print("Enter x2: ");
		point2[0] = input.nextInt();
		System.out.print("Enter y2: ");
		point2[1] = input.nextInt();

		System.out.print("Enter x3: ");
		point3[0] = input.nextInt();
		System.out.print("Enter y3: ");
		point3[1] = input.nextInt();
		
		System.out.print("Enter how many nested triangles do you want: ");
		int n = input.nextInt();
		
		double length1, length2, length3;
		ArrayList<Double> length = new ArrayList<Double> ();
		length1 = Math.sqrt(Math.pow(point1[0] - point2[0], 2) + Math.pow(point1[1] - point2[1], 2));
		length2 = Math.sqrt(Math.pow(point1[0] - point3[0], 2) + Math.pow(point1[1] - point3[1], 2));
		length3 = Math.sqrt(Math.pow(point2[0] - point3[0], 2) + Math.pow(point2[1] - point3[1], 2));
		length.add(length1);
		length.add(length2);
		length.add(length3);
		length.sort(null);
		
		double originalArea = length.get(0) * length.get(1) / 2;
		double diminishedArea = originalArea / Math.pow(4, n);
		
		System.out.println("The areofnested triangle " + n + " is " + diminishedArea);
	}
	
	public static void foreignLanguage() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the phrase to translate: ");
		String s = input.nextLine();
		s = s.substring(0, s.length() - 5);
		String[] words = s.split(" ");
		String[] translated = new String[words.length];
		
		for (int i = 0; i < words.length; i++) {
			boolean isUppercase = false;
			boolean ispunctuated = false;
			
			char c = words[i].charAt(0);
			int cNum = (int) c;
			if (65 <= cNum && cNum <= 90) {
				isUppercase = true;
	 		}			
			char lastC = words[i].charAt(words[i].length() - 1);
			if (lastC == '.' || lastC == ',' || lastC == '!' || lastC == '?') {
				ispunctuated = true;
				words[i] = words[i].substring(0, words[i].length() - 1);
			}
			words[i] = words[i].toLowerCase();
			String word = "";
			
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
				c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
				word = words[i] + "way";
			} else {
				int firstVowelIndex = -1;
				for (int j = 0; j < words[i].length(); j++) {
					c = words[i].charAt(j);
					if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
						firstVowelIndex = j;
						break;
					}
				}
				if (firstVowelIndex == -1) {
					if (words[i].indexOf("y") != -1) {
						firstVowelIndex = words[i].indexOf("y"); 
					}
				}
				if (words[i].charAt(firstVowelIndex) == 'u' && words[i].charAt(firstVowelIndex - 1) == 'q')  {
					firstVowelIndex++;
				}
				word = words[i].substring(firstVowelIndex) + words[i].substring(0, firstVowelIndex) + "ay";
			}
			if (isUppercase) {
				word = word.substring(0, 1).toUpperCase() + word.substring(1);
			}
			if (ispunctuated) {
				word += lastC;
			}
			translated[i] = word;
		}
		
		for (int i = 0; i < translated.length; i++) {
			System.out.print(translated[i] + " ");
		}
	}
}
