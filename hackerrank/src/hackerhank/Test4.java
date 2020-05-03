package hackerhank;

import java.util.ArrayList;
import java.util.List;

public class Test4 implements Pancake {

	public static void main(String[] args) {
		List<String> array = new ArrayList<String>();
		array.add("3");
		array.add("7");
		array.add("5");
		
		List<String> y = new Test4().doStuff(array);
		y.add("1");
		System.out.println(array);
		
		StringBuffer sBuffer = new StringBuffer();
		StringBuilder sBuilder = new StringBuilder();
	}

	public List<String> doStuff(List<String> s) {
		s.add("9");
		return s;
	}
}

interface Pancake {
	List<String> doStuff(List<String> s);
}