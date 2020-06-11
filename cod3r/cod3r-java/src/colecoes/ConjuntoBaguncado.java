package colecoes;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoBaguncado {
	
	/**
	 * Set
	 * - Não ordenado (por padrão, mas pode ser)
	 * - Não indexado
	 * - Não aceita repetição
	 * - Pode ser heterogeneo (tipos diferentes)
	 * - Pode ser homogeneo (mesmo tipo)
	 * Ex: HashSet
	 * 
	 */
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		HashSet conjunto = new HashSet();
		conjunto.add(1.2);
		conjunto.add(true);
		conjunto.add("Teste");
		conjunto.add(1);
		conjunto.add('x');
		
		System.out.println(conjunto);

		System.out.println(conjunto.size());
		conjunto.add("teste");
		System.out.println(conjunto.size());
		conjunto.add("Teste");
		System.out.println(conjunto.size());
		
		System.out.println(conjunto.remove("teste"));
		System.out.println(conjunto.size());
		System.out.println(conjunto.contains("teste"));
		System.out.println(conjunto.contains('x'));
		
		Set nums = new HashSet();
		nums.add(1);
		nums.add(2);
		nums.add(3);
		System.out.println(nums);
		System.out.println(conjunto);
		
		conjunto.retainAll(nums);
		System.out.println(conjunto);
		
		conjunto.addAll(nums);
		System.out.println(conjunto);
		
		conjunto.clear();
		System.out.println(conjunto);
	}

}
