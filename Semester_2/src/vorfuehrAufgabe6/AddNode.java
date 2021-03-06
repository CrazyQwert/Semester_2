package vorfuehrAufgabe6;

public class AddNode extends BinaryNode {

	public AddNode(ExpressionNode a, ExpressionNode b) {
		super(a, b);
		this.operator = '+';
	}
	
	@Override
	public int compute() {
		return this.a.getValue() + this.b.getValue();
	}
	
}
