package oo.heranca;

public class Jogador {

	public int x;
	public int y;
	public int vida = 100;
	
	Jogador (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean atacar(Jogador oponente) {
		
		int deltaX = Math.abs(x - oponente.x);
		int deltay = Math.abs(y - oponente.y);
		
		if (deltaX == 0 && deltay == 1) {
			oponente.vida -= 10;
			return true;
		} if (deltaX == 1 && deltay == 0) {
			oponente.vida -= 10;
			return true;
		} else {
			return false;
		}
	}

	boolean andar(Direcao direcao) {
		switch (direcao) {
		case NORTE:
			y--;
			break;
		case LESTE:
			x++;
			break;
		case SUL:
			y++;
			break;
		case OESTE:
			x--;
			break;

		}

		return true;
	}

	
}
