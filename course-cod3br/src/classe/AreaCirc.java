package classe;

public class AreaCirc {
	
	double raio;
	static final double PI = 3.14;
	
	public AreaCirc(double raio) {
	
		this.raio = raio;
	}
	
	public double area() {
		return AreaCirc.PI * Math.pow(this.raio, 2);
	}
	
}
