package by.training.task1;

import java.util.Stack;

public class RPNUtills {
	static final String DIGITS = "1234567890.";
	public static String getRPN(String expression) {
		StringBuilder result = new StringBuilder();
		Stack<Character> operators = new Stack<>();
		char[] sourse = expression.toCharArray();
		for(int position = 0;position<sourse.length;position++) {
			if(isDigit(sourse[position])) {
				while(position<sourse.length&&isDigit(sourse[position])) {
					result.append(sourse[position]);
					position++;
				}
				result.append(" ");
				position--;
			}
			if(getPriority(sourse[position])>0) {
				if((!operators.empty())&&getPriority(sourse[position])<=getPriority(operators.peek())) {
					result.append(operators.pop());
					result.append(" ");
				}
				operators.push(sourse[position]);
			}
		}
		while(!operators.empty()) {
			result.append(operators.pop());
			result.append(" ");
		}
		return result.toString();
	}
	public static double calculateRPN(String expression) {
		double answer = 0;
		Stack<Double> nums = new Stack<>();
		char[] source = expression.toCharArray();
		for(int position = 0;position<source.length;position++) {
			if(isDigit(source[position])) {
				StringBuilder builder = new StringBuilder();
				do {
					builder.append(source[position]);
					position++;
				}while(position<source.length&&isDigit(source[position]));
				nums.push(Double.parseDouble(builder.toString()));
			}
			if(getPriority(source[position])>0) {
				double secondOperand = nums.pop();
				double firstOperand = nums.pop();
				switch (source[position]) {
				case '+':
					answer = firstOperand + secondOperand;
					break;
				case '-':
					answer = firstOperand - secondOperand;
					break;
				case '*':
					answer = firstOperand * secondOperand;
					break;
				case '/':
					try {
						answer = firstOperand / secondOperand;
					}catch (Exception e) {
						System.err.println("Divided by zero! Result replaced with 0.");
						answer = 0;
					}
					break;
				}
				nums.push(answer);
			}
		}
		return nums.pop();
	}
	private static boolean isDigit(char c) {
		return DIGITS.contains(String.valueOf(c));
	}
	private static int getPriority(char c) {
		switch (c) {
		case '+':
			return 1;
		case '-':
			return 1;
		case '*':
			return 2;
		case '/':
			return 2;
		default:
			return -1;
		}
	}
}
