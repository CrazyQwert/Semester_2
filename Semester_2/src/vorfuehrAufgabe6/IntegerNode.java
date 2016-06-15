package vorfuehrAufgabe6;

public class IntegerNode extends ExpressionNode {

	
	public IntegerNode(int value) {
		this.value = value;
	}

	@Override
	public int compute() {
		return this.value;
	}

	@Override
	public void print() {
		System.out.print(value);
	}
	

}
