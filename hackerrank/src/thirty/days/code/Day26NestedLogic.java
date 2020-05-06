package thirty.days.code;

import java.util.Scanner;

public class Day26NestedLogic {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		BookReturnDate actualDate = new BookReturnDate(sc.nextInt(), sc.nextInt(), sc.nextInt());
		BookReturnDate expectedDate = new BookReturnDate(sc.nextInt(), sc.nextInt(), sc.nextInt());

		sc.close();

		int fine = 0;

		if (inputsValid(actualDate, expectedDate)) {
			
			if (expectedDate.year == actualDate.year) {
			
				if (expectedDate.month < actualDate.month) {
					
					fine = (actualDate.month - expectedDate.month) * 500;
					
				} else if (expectedDate.month == actualDate.month && (expectedDate.day < actualDate.day)) {
					
					fine = (actualDate.day - expectedDate.day) * 15;
					
				}

			} else if (expectedDate.year < actualDate.year) {
				fine = 10000;
			}
			
		}

		System.out.println(fine);
	}

	public static boolean inputsValid(BookReturnDate actualDate, BookReturnDate expectedDate) {

		if ((actualDate.day < 1 && actualDate.day > 31) || (expectedDate.day < 1 && expectedDate.day > 31)) {
			return false;
		} else if ((actualDate.month < 1 && actualDate.month > 12)
				|| (expectedDate.month < 1 && expectedDate.month > 12)) {
			return false;
		} else if ((actualDate.year < 1 && actualDate.year > 3000)
				|| (expectedDate.year < 1 && expectedDate.year > 3000)) {
			return false;
		}

		return true;
	}
}

class BookReturnDate {

	public int day;
	public int month;
	public int year;

	public BookReturnDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

}
