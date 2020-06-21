package practice.java;

public class _53_JavaSinglePattern {

	public static void main(String[] args) {
		Singleton singleInstance = Singleton.getSingleInstance();
		singleInstance.str = "hello SIngleton";
	}
	
}

class Singleton{
    
    public String str;
    
    private Singleton() {
    	
    }
        
    static Singleton getSingleInstance() {
    	return new Singleton();
    }
}