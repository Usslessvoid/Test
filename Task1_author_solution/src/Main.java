import java.util.Scanner;

import by.training.task1.Operator;

public class Main {
	static final String NUMBERS = "1234567890.";
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter expression:");
		double answer = calculate(scanner.nextLine());
		System.out.println(answer);
		scanner.close();
	}
	public static double calculate(String str) {
		int start = 0;
		int end = 0;
		boolean gap;
		StringBuilder builder = new StringBuilder(str);
		for(Operator action: Operator.values()) {
			gap = true;
			for(int position = 0; position<builder.length();position++) {
				char current = builder.charAt(position);
				if(isDigit(current)) {            //detect begin of number before
					if(gap) {
						gap=false;
						start = position;
					}
				}else {
					gap = true;
					if(current == action.getSymbol()) {   //find operator
						double firstOperand;
						double secondOperand;
						boolean begin = false;
						for(int tmp = position+1; tmp<builder.length();tmp++) { //detect end of number
							if(isDigit(builder.charAt(tmp))) {
								begin = true;
								end = tmp;
							}else if(begin) {
								break;
							}	
						}
						firstOperand = doubleFromString(builder.substring(start, position));
						secondOperand = doubleFromString(builder.substring(position+1, end+1));
						builder.replace(start, end+1, String.valueOf(action.solve(firstOperand, secondOperand)));
						start = 0;
						gap = false;

					}
				}
			}
		}
		return doubleFromString(builder.toString());
	}
	public static double doubleFromString(String builder) {
		double result = 0;
		try {
			result = Double.parseDouble(builder);
		}catch (NumberFormatException e) {
			System.err.println("Wrong expression format!");
			e.printStackTrace();
		}
		return result;
	}
	public static boolean isDigit(char c) {
		return NUMBERS.contains(String.valueOf(c));
	}


}
