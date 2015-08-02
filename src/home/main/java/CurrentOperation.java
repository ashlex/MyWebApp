package home.main.java;

public class CurrentOperation {
	private final int a;
	private final int b;
	private final String operator;
	private final int position;

	private CurrentOperation(Builder builder){
		this.a=builder.a;
		this.b=builder.b;
		this.operator=builder.operator;
		this.position=builder.position;
	}

	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}

	public int getPosition(){
		return position;
	}

	public double execOperation(String operation) throws ArithmeticException{
		double response=0;
		if ("-".equals(operation)) {
			response = a - b;

		} else if ("+".equals(operator)) {
			response = a + b;

		} else if ("/".equals(operator)) {
			response = (double)a / (double)b;

		} else if ("*".equals(operator)) {
			response = a * b;

		} else {
			throw new ArithmeticException("Operator isn't set.");
		}
		return response;
	}

	public static class Builder{
		private int a=0;
		private int b=0;
		private String operator="";
		private final int position;

		public Builder(int position){
			this.position=position;
		}
		public Builder setA(int a){
			this.a=a;
			return this;
		}
		public Builder setB(int b){
			this.b=b;
			return this;
		}
		public CurrentOperation build(){
			return new CurrentOperation(this);
		}
	}
}
