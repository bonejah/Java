package generics;

public class Caixa<T> {

	private T object;

	public void guardar(T object) {
		this.object = object;
	}

	public T abrir() {
		return object;
	}

}
