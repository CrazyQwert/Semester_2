package vorfuehrAufgabe6;

public class DivNode extends BinaryNode {

	public DivNode(ExpressionNode a, ExpressionNode b) {
		super(a, b);
		this.operator = '/';
	}
	
	@Override
	public int compute() {
		return this.a.getValue() / this.b.getValue();
	}
	
}
