package vorfuehrAufgabe6;

public class SubNode extends BinaryNode {

	public SubNode(ExpressionNode a, ExpressionNode b) {
		super(a, b);
		this.operator = '-';
	}
	
	@Override
	public int compute() {
		return this.a.getValue() - this.b.getValue();
	}
	
}
