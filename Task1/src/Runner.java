import java.util.Scanner;

import by.training.task1.RPNUtills;

public class Runner {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String notation = RPNUtills.getRPN(input.nextLine());
		double answer = RPNUtills.calculateRPN(notation);
		System.out.println(answer);
	}

}