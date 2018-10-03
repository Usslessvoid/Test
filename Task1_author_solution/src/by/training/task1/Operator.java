package by.training.task1;

public enum Operator {
	MUL('*') {
		@Override
		public double solve(double a, double b) {
			return a*b;
		}
	},
	DIV('/') {
		@Override
		public double solve(double a, double b) {
			return a/b;
		}
	},
	ADD('+') {
		@Override
		public double solve(double a, double b) {
			// TODO Auto-generated method stub
			return a+b;
		}
	},
	SUB('-') {
		@Override
		public double solve(double a, double b) {
			// TODO Auto-generated method stub
			return a-b;
		}
	};
	final char symbol;
	Operator(char c) {
		symbol = c;
	}
	public char getSymbol() {
		return this.symbol;
	}
	public abstract double solve(double a, double b);
}
