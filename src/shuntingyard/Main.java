package shuntingyard;

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Shunting Yard Algorithm Test\n");
		ShuntingYard sy = new ShuntingYard();
		
		System.out.println("Enter infix expression");
		String infix = scan.next();
		
		String postfix = sy.infixToPostfix(infix);
		
		System.out.println("\nPostfix expression : " + postfix);
		
		System.out.println("\nCalculate postfix evaluation :" + sy.postfixToEvaluation(postfix));
		
		System.out.println(sy.postfixToEvaluation("321+232^^*+8512*2/-/-"));
		

	}

}
