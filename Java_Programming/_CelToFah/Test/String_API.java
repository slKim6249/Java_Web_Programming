package Test;

public class String_API {

	public static void main(String[] args) {
		
		String Message = "http://www.google.com";

		if( Message.startsWith("http") && Message.endsWith(".com")
				&& Message.contains("google") ) {
		   System.out.println("Welcome To Google!");
		}

		
	}

}
