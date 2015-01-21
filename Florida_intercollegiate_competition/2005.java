mport java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

// https://www.seminolestate.edu/computers/competition/samples/2005
public class Competition_2005 {

	public static void main(String[] args) {
		TimeSegment();
	}
	
	public static void Triangles() {
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> lines = new ArrayList<Integer> ();
		
		System.out.print("Enter three lines dividing by space: ");
		lines.add(input.nextInt());
		lines.add(input.nextInt());
		lines.add(input.nextInt());
		
		lines.sort(null);
		
		int a = lines.get(0);
		int b = lines.get(1);
		int c = lines.get(2);
		
		if (a + b >= c) {
			if (a == b && b == c) { // Equilateral triangle
				System.out.println("Equilateral triangle");
			} else if (a == b || b == c || a == c) { // Isosceles triangle
				System.out.println("Isosceles triangle");
			} else if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) { // Right triangle
				System.out.println("Right triangle");
			} else {
				System.out.println("Regular triangle");
			}
		} else {
			System.out.println("Not a triangle.");
		}
	}
	
	public static void Ciphers() {
		Scanner input = new Scanner(System.in);
		
		String keyword = "";
		ArrayList<String> alphabet = new ArrayList<String> (Arrays.asList(				
				"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
				"k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
				"u", "v", "w", "x", "y", "z"				
				));

		System.out.print("Enter message: ");
		String message = input.nextLine();
		String[] messageArray = message.split(" ");
		String[] message2Array = new String[messageArray.length];
		
		for (int i = 0; i < messageArray.length; i++) {
			if (messageArray[i].length() >= 5) {
				keyword = messageArray[i];
				break;
			}
		}
		
		int index = 0;
		int keywordLength = keyword.length();
		
		for (int i = 0; i < messageArray.length; i++) {
			int wordLength = messageArray[i].length();
			if (index + wordLength > keywordLength) {
				String word = keyword.substring(index);
				word += keyword.substring(0, index + wordLength - keywordLength);
				message2Array[i] = word;
				index = index + wordLength - keywordLength;
			} else {
				String word = keyword.substring(index, index + wordLength);
				message2Array[i] = word;
				index += wordLength;
			}
		}
		
		String encrypted = "";
		for (int i = 0; i < messageArray.length; i++) {
			for (int j = 0; j < messageArray[i].length(); j++) {
				String messageCharacter = messageArray[i].substring(j, j + 1);
				String message2Character = message2Array[i].substring(j, j + 1);
				
				int number = alphabet.indexOf(messageCharacter) + alphabet.indexOf(message2Character) + 1;
				encrypted += alphabet.get(number % 26);
 			}
		}
		
		System.out.println("keyword: " + keyword + "\nEncrypted: " + encrypted);
	}
	
	public static void DeleteDuplicate () {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter sets of integer: ");
		ArrayList<Integer> originalNumbers = new ArrayList<Integer> ();
		while(input.hasNext()) {
			int num = input.nextInt();
			if (num == -1) {
				break;
			}
			originalNumbers.add(num);
		}
		ArrayList<Integer> cleanNumbers = new ArrayList<Integer> ();
		ArrayList<Integer> duplicateDigit = new ArrayList<Integer> ();
		ArrayList<Integer> duplicateTime = new ArrayList<Integer> ();
		
		for (int i = 0; i < originalNumbers.size(); i++) {
			Integer num = originalNumbers.get(i);
			if (cleanNumbers.indexOf(num) == -1) {
				cleanNumbers.add(num);
			} else {
				if (duplicateDigit.indexOf(num) == -1) {
					duplicateDigit.add(num);
					duplicateTime.add(1);
				} else {
					int index = duplicateDigit.indexOf(num);
					int times = duplicateTime.get(index);
					times++;
					duplicateTime.set(index, times);
				}
			}
		}
		
		// Output original numbers
		for (int i = 0; i < originalNumbers.size(); i++) {
			System.out.print(originalNumbers.get(i) + " ");
		}
		System.out.println();
		
		// Output duplicates
		if (duplicateDigit.size() == 0) {
			System.out.println("No duplicate values");
		} else {
			for (int i = 0; i < duplicateDigit.size(); i++) {
				System.out.println("Value " + duplicateDigit.get(i) + ": " + duplicateTime.get(i)  + " copies are deleted.");
			}			
		}
		
		// Output clean numbers
		for (int i = 0; i < cleanNumbers.size(); i++) {
			System.out.print(cleanNumbers.get(i) + " ");
		}
	}
	
	public static void TimeSegment() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter four time segments digit: ");
		int d = input.nextInt();
		int h = input.nextInt();
		int m = input.nextInt();
		int s = input.nextInt();
		
		int day, hour, minute, second;
		second = s % 60;
		m += s / 60;
		minute = m % 60;
		h += m / 60;
		hour = h % 24;
		d += h / 24;
		day = d;
		
		if (day != 0) {
			System.out.print(day + " day(s), ");
		}
		if (hour != 0) {
			System.out.print(hour + " hour(s), ");
		}
		if (minute != 0) {
			System.out.print(minute + " minute(s), ");
		}
		if (second != 0) {
			System.out.print(second + " second(s), ");
		}
	}
}

