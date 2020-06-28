package shuntingyard;

public class Main {

	public static void main(String[] args) {
		 String exp = "a+b*(c^d-e)^(f+g*h)-i"; 
	        System.out.println(infixToPostfix(exp));

	}

}
