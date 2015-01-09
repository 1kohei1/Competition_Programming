import java.util.Scanner;

// https://www.seminolestate.edu/computers/competition/samples/2011
// 1:17:28
public class Competition_2011 {

	public static void main(String[] args) {
		arrayDiagonals();
	}
	
	public static void easter() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter year: ");
		int year = input.nextInt();
		int m = 0;
		int n = 0;
		int day = 0;
		String month = "";
		String dayS = "";
		
		if (1583 <= year && year <= 1699) {
			m = 22;
			n = 2;
		} else if (1700 <= year && year <= 1799) {
			m = 23;
			n = 3;
		} else if (1800 <= year && year <= 1899) {
			m = 23;
			n = 4;
		} else if (1900 <= year && year <= 2099) {
			m = 24;
			n = 5;
		} else if (2100 <= year && year <= 2199) {
			m = 24;
			n = 6;
		} else if (2200 <= year && year <= 2299) {
			m = 25;
			n = 0;
		}
		
		int a = year % 19;
		int b = year % 4;
		int c = year % 7;
		int d = (19 * a + m) % 30;
		int e = (2 * b + 4 * c + 6 * d + n) % 7;
		
		if (d + e < 10) {
			day = d + e + 22;
			month = "March";
		} else {
			day = d + e - 9;
			month = "April";
			if (day == 26) {
				day = 19;
			} else if (day == 25 && d == 28 && e == 6 && a > 10) {
				day = 18;
			}
		}
		
		switch (day % 10) {
		case 1:
			dayS = day + "st";
			break;
		case 2:
			dayS = day + "nd";
			break;
		case 3:
			dayS = day + "rd";
			break;
		default: 
			dayS = day + "th";
			break;
		}
		
		System.out.printf("In %d Easter is on %s %s", year, month, dayS);
	}
	
	public static void binaryAdd() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the binary number: ");
		String binaryS = input.nextLine();
		System.out.print("Enter the decimal number to add: ");
		int decimal = input.nextInt();
		int binaryI = 0;
		int powerOf2 = 0;
		
		while (binaryS.length() > 0) {
			if(binaryS.substring(binaryS.length() - 1).equals("1")) {
				binaryI += Math.pow(2, powerOf2);
			}
			powerOf2++;
			binaryS = binaryS.substring(0, binaryS.length() - 1);
		}
		
		int answer = binaryI + decimal;
		String answerS = "";
		powerOf2 = 16;
		int divider = (int) Math.pow(2, powerOf2);
		
		while (divider != 0) {
			answerS += String.valueOf(answer / divider);
			
			answer = answer % divider;
			divider /= 2;
		}
		answerS = answerS.substring(answerS.indexOf("1"));
		
		System.out.println("Binary sum is " + answerS);
	}
	
	public static void pythagorasRedux() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter maximum: ");
		int max = input.nextInt();
		
		int a = 2;
		System.out.println("  a   b   c");
		
		while (a <= max) {
			for (int i = a + 1; i < max; i++) {
				int sum = (int) Math.pow(a , 2);
				sum += (int) Math.pow(i, 2);
				if (sum > Math.pow(max, 2)) {
					break;
				}
				int c = (int) Math.sqrt(sum);
				if (c <= max && sum == (int) Math.pow(c, 2)) {
					System.out.printf("%3d %3d %3d\n", a, i, c);
				}
			}
			a++;
		}
	}
	
	public static void arrayDiagonals() {
		Scanner input = new Scanner(System.in);
		int[][] arrayFigure = {
				{22, 13, 2, 8, 30},
				{14, 21, 18, 25, 27},
				{7, 4, 10, 3, 15},
				{5, 17, 12, 11, 16},
				{23, 6, 1, 9, 24}
				};
		
		System.out.print("Enter Diagonal: ");
		int num = input.nextInt();
		int row = -1;
		int col = -1;
		int sum = 0;
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (arrayFigure[i][j] == num) {
					row = i;
					col = j;
				}
			}
			if (i == 4 && row == -1 && col == -1){
				System.out.println("That diagonal doesn’t exist.");
				return;
			}
		}
		
		// to top left
		int r = row;
		int c = col;
		while (r >= 0 && c >= 0) {
			sum += arrayFigure[r][c];
			r--;
			c--;
		}
		
		// to bottom right;
		r = row;
		c = col;
		while (r < 5 && c < 5) {
			sum += arrayFigure[r][c];
			r++;
			c++;
		}
		
		// to top right
		r = row;
		c = col;
		while (r >= 0 && c < 5) {
			sum += arrayFigure[r][c];
			r--;
			c++;
		}
		
		// to bottom left
		r = row;
		c = col;
		while (r < 5 && c >= 0) {
			sum += arrayFigure[r][c];
			r++;
			c--;
		}
		
		sum -= num * 3;
		System.out.println("The sum of the diagonals for " + num + " is " + sum);
	}
}
