package br.com.deitel.cap.eight;

public class PackageDataTest {
	public static void main(String[] args) {
		PackageData packageData = new PackageData();
		System.out.printf("After instantiation:\n%s\n", packageData);
		
		packageData.number = 77;
		packageData.string = "GoodBye";
		
		System.out.printf("\nAfter changing values:\n%s\n", packageData);
	}
}

class PackageData {
	int number;
	String string;
	
	public PackageData(){
		number = 0;
		string = "Hello";
	}
	
	@Override
	public String toString() {
		return String.format("number: %d, string: %s", number, string);
	}
	
}
