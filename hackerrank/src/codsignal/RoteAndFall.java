package codsignal;

/**
 *
 * brunolima on Feb 10, 2021
 * 
 * You are given a matrix of characters representing a big box. Each cell of the
 * matrix contains one of three characters:
 * 
 * '.', which means that the cell is empty; '*', which means that the cell
 * contains an obstacle; '#', which means that the cell contains a small box.
 * You decide to rotate the big box clockwise to see how the small boxes will
 * fall under the gravity. After rotating, each small box falls down until it
 * lands on an obstacle, another small box, or the bottom of the big box.
 * 
 * Given box, a matrix representation of the big box, your task is to return the
 * state of the box after rotating it clockwise.
 * 
 * Example
 * 
 * For box = [['#', '#', '.', '.', '.', '.', '.'], ['#', '#', '#', '.', '.',
 * '.', '.'], ['#', '#', '#', '.', '.', '#', '.']] the output should be
 * 
 * rotateAndFall(box) = [['.', '.', '.'], ['.', '.', '.'], ['.', '.', '.'],
 * ['#', '.', '.'], ['#', '#', '.'], ['#', '#', '#'], ['#', '#', '#']] example1
 * 
 * For box = [['#', '#', '.', '.', '.', '#', '.'], ['#', '#', '#', '.', '.',
 * '*', '.'], ['#', '#', '#', '*', '.', '#', '.']] the output should be
 * 
 * rotateAndFall(box) = [['#', '.', '.'], ['#', '.', '.'], ['#', '#', '.'],
 * ['*', '#', '.'], ['.', '#', '#'], ['.', '*', '#'], ['#', '.', '#']] example2
 * 
 * Input/Output
 * 
 * [execution time limit] 3 seconds (java)
 * 
 * [input] array.array.char box
 * 
 * A matrix representing a big box. The matrix consists of characters '.', '*',
 * and '#'. It is guaranteed that initially the small boxes are stable and won't
 * fall, i.e. there isn't a small box with an empty cell under it.
 * 
 * Guaranteed constraints: 3 ≤ box.length ≤ 100, 3 ≤ box[i].length ≤ 100.
 * 
 * [output] array.array.char
 * 
 * Return the state of the big box after rotating it as described above.
 * 
 */

public class RoteAndFall {

	public static void main(String[] args) {
		
	
	}

	public char[][] rotateAndFall(char[][] box) {

		return null;
	}

}
