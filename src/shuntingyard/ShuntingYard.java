package shuntingyard;

import java.util.Stack;

public class ShuntingYard {
	static int precedence(char c) {
		switch (c) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		}
		return -1;
	}

	static String infixToPostFix(String expression) {

		String result = "";
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);

			// check if char is operator
			if (precedence(c) > 0) {
				while (stack.isEmpty() == false && precedence(stack.peek()) >= precedence(c)) {
					result += stack.pop();
				}
				stack.push(c);
			} else if (c == ')') {
				char x = stack.pop();
				while (x != '(') {
					result += x;
					x = stack.pop();
				}
			} else if (c == '(') {
				stack.push(c);
			} else {
				// character is neither operator nor (
				result += c;
			}
		}
		for (int i = 0; i <= stack.size(); i++) {
			result += stack.pop();
		}
		return result;
	}

	public int result(int n1, int n2, String op) {
		if (op.equals("+"))
			return n1 + n2;
		if (op.equals("-"))
			return n1 - n2;
		if (op.equals("*"))
			return n1 * n2;
		return n1 / n2;
	}

	public boolean operator(String op) {
		return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/");
	}

	public int evalRPN(String tokens) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < tokens.length(); i++) {
			if (operator(tokens.charAt(i))) {
				int n2 = stack.pop();
				int n1 = stack.pop();
				stack.push(result(n1, n2, tokens[i]));
			} else
				stack.push(Integer.parseInt(tokens[i]));
		}
		return stack.peek();
	}

	public static void main(String[] args) {
		String exp = "3+(2+1)*2^3^2-8/(5-1*2/2)";
		System.out.println("Infix Expression: " + exp);
		System.out.println("Postfix Expression: " + infixToPostFix(exp));
		System.out.println("postfix evaluation: " + evalRPN(exp));
	}
}
