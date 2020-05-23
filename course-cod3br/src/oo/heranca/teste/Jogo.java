package oo.heranca.teste;

import oo.heranca.Heroi;
import oo.heranca.Monstro;

public class Jogo {

	public static void main(String[] args) {
		Heroi heroi = new Heroi(10, 10);
		heroi.x = 10;
		heroi.y = 10;
		
		Monstro monstro = new Monstro();
		monstro.x = 10;
		monstro.y = 11;
		
//		jogador2.andar(Direcao.NORTE);
//		jogador2.andar(Direcao.LESTE);
//		jogador2.andar(Direcao.NORTE);
//		jogador2.andar(Direcao.LESTE);
		
//		System.out.println(jogador2.x);
//		System.out.println(jogador2.y);
		
		System.out.println(heroi.vida);
		System.out.println(monstro.vida);
		
		heroi.atacar(monstro);
		monstro.atacar(heroi);
		
		System.out.println("Heroi tem: " +  heroi.vida  + " de vida.");
		System.out.println("Monstro tem: " +  monstro.vida  + " de vida.");
	}
}
