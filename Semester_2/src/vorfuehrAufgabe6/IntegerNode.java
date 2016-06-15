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
		if (value > 0) {
			System.out.print(value);
		} else {
			System.out.print("(" + value + ")");
		}
	}
	

}
