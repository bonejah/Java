package br.com.deitel.cap.six;

public class MethodOberLoadError {
	// declaracao do metodo square com argumento int
	public int square (int x) {
		return x * x;
	}
	
	// segunda declaracao do metodo square com argumento int resulta
	// emn erros de compilacao mesmo que os tipos de retornos sejam diferentes
	/*public double square (int y) {
		return y * y;
	}*/
}
