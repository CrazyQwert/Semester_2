package vorfuehrAufgabe6;

public class BinaryNode extends ExpressionNode {

	ExpressionNode a;
	ExpressionNode b;

	public BinaryNode(ExpressionNode a, ExpressionNode b) {
		this.a = a;
		this.b = b;
		this.compute();
	}
	
	@Override
	public void print() {
		// TODO Auto-generated method stub
	}

	@Override
	public int compute() {
		return 0;
	}

}
