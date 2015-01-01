import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

// https://www.seminolestate.edu/computers/competition/samples/2006
// 1 hr, 10 min, 24 sec.
public class Competition_2006 {

	public static void main(String[] args) {
		romanNumerals();
	}

	public static void BinaryOperator() {
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> first = new ArrayList<Integer> ();
		ArrayList<Integer> second = new ArrayList<Integer> ();
		
		System.out.print("Enter integer: ");
		while(true) {
			int a = input.nextInt();
			if (a == -1) {
				break;
			} else {
				first.add(a);
			}
		}
		
		System.out.print("Enter integer: ");
		while(true) {
			int a = input.nextInt();
			if (a == -1) {
				break;
			} else {
				second.add(a);
			}
		}
		
		first.sort(null);
		second.sort(null);
		
		int shorterLength = first.size() > second.size() ? second.size() : first.size();
		
		ArrayList<Integer> aANDb = new ArrayList<Integer>();
		ArrayList<Integer> aORb = new ArrayList<Integer>();
		ArrayList<Integer> aXORb = new ArrayList<Integer>();
		ArrayList<Integer> aNORb = new ArrayList<Integer>();
		
		// AND
		for(int i = 0; i < first.size(); i++) {
			if (second.indexOf(first.get(i)) != -1) {
				aANDb.add(first.get(i));
			}
		}
		
		// OR
		for (int i = 0; i < first.size(); i++) {
			aORb.add(first.get(i));
		}
		for (int i = 0; i < second.size(); i++) {
			if (aORb.indexOf(second.get(i)) == -1) {
				aORb.add(second.get(i));
			}
		}
		aORb.sort(null);
		
		// XOR
		for (int i = 0; i < aORb.size(); i++) {
			if (aANDb.indexOf(aORb.get(i)) == -1) {
				aXORb.add(aORb.get(i));
			}
		}
		
		// NOR
		for (int i = 0; i < 10; i++) {
			if (aORb.indexOf(i) == -1) {
				aNORb.add(i);
			}
		}
		
		System.out.print("A AND B: ");
		for (int i = 0; i < aANDb.size(); i++) {
			System.out.print(aANDb.get(i) + " ");
		}
		System.out.print("\nA OR  B: ");
		for (int i = 0; i < aORb.size(); i++) {
			System.out.print(aORb.get(i) + " ");
		}
		System.out.print("\nA XOR B: ");
		for (int i = 0; i < aXORb.size(); i++) {
			System.out.print(aXORb.get(i) + " ");
		}
		System.out.print("\nA NOR B: ");
		for (int i = 0; i < aNORb.size(); i++) {
			System.out.print(aNORb.get(i) + " ");
		}
	}
	
	public static void wordRectangle() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a word: ");
		String word = input.nextLine();
		char[] wordArray = word.toCharArray();
		int wordLength = word.length();
		
		System.out.println(word);
		for (int i = 1; i < wordArray.length - 1; i++) {
			System.out.print(wordArray[i]);
			for (int j = 0; j < wordLength - 2; j++) {
				System.out.print(" ");
			}
			System.out.print(wordArray[wordLength - 1 - i]);
			System.out.println();
		}
		for (int i = wordLength - 1; i >= 0; i--) {
			System.out.print(wordArray[i]);
		}
	}
	
	public static void amazingNumbers() {
		int[] numbers1 = new int[10];
		int[] numbers2 = new int[10];
		int count = 0;
		int digit = 27398;
		
		while (count < 10) {
			int number = digit * 365;
			if (number / 10000 == number % 10000) {
				numbers1[count] = digit;
				numbers2[count] = number;
				count++;
			}
			if (number >= 100000000) {
				break;
			}
			digit++;				
		}
		
		System.out.println("Number |  Number * 365");
		for (int i = 0; i < numbers1.length; i++) {
			System.out.println(numbers1[i] + "  |  " + numbers2[i]);
		}
	}
	
	public static void romanNumerals() {
		Scanner input = new Scanner(System.in);
		
		ArrayList<Integer> divider = new ArrayList<> (Arrays.asList(1000, 500, 100, 50, 10, 5, 1));
		ArrayList<String> letter = new ArrayList<> (Arrays.asList("M", "D", "C", "L", "X", "V", "I"));
		
		while (true) {
			System.out.print("Enter an integer: ");
			int number = input.nextInt();
			if (number == 0) {
				break;
			}
			
			if (number / 1000 > 0) {
				for (int i = 0; i < number / 1000; i++)  {
					System.out.print("M");
				}
				number = number % 1000;				
			}
			if (number / 100 > 0) {
				int product = number / 100;
				if (product == 9) {
					System.out.print("CM");
				} else if (product == 4) {
					System.out.print("CD");
				} else {
					if (product >= 5) {
						System.out.print("D");
						product -= 5;
					}
					for (int i = 0; i < product; i++) {
						System.out.print("C");
					}
				}
				number = number % 100;				
			}
			if (number / 10 > 0) {
				int product = number / 10;
				if (product == 9) {
					System.out.print("XC");
				} else if (product == 4) {
					System.out.print("XL");
				} else {
					if (product >= 5) {
						System.out.print("L");
						product -= 5;
					}
					for (int i = 0; i < product; i++) {
						System.out.print("X");
					}
				}
				number = number % 10;				
			}
			if (number / 1 > 0) {
				int product = number / 1;
				if (product == 9) {
					System.out.print("IX");
				} else if (product == 4) {
					System.out.print("IV");
				} else {
					if (product >= 5) {
						System.out.print("V");
						product -= 5;
					}
					for (int i = 0; i < product; i++) {
						System.out.print("I");
					}
				}
			}
			System.out.println();
		}
		
	}
}

