package br.com.deitel.cap.eightheen;

public class TowersOfHanoi {
	public static void solveTowers(int disks, int sourcePeg, int destinationPeg, int tempPeg) {
		if (disks == 1) {
			System.out.printf("\n%d --> %d", sourcePeg, destinationPeg);
			return;
		}

		solveTowers(disks - 1, sourcePeg, tempPeg, destinationPeg);

		System.out.printf("\n%d --> %d", sourcePeg, destinationPeg);

		solveTowers(disks - 1, tempPeg, destinationPeg, sourcePeg);
	}
	
	public static void main(String[] args) {
		int startPeg = 1; // valor 1 utilizado para indicar startPeg na saida
		int endPeg = 3; // valor 3 utilizado para indicar endPeg na saida 
		int tempPeg = 2; // valor 2 utilizado para indicar tempPeg na saida
		int totalDisks = 3; // numero de discos
		
		TowersOfHanoi.solveTowers(totalDisks, startPeg, endPeg, tempPeg);
	}
}
