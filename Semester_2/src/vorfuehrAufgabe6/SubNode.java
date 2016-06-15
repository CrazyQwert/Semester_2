package vorfuehrAufgabe6;

public class SubNode extends BinaryNode {

	public SubNode(ExpressionNode a, ExpressionNode b) {
		super(a, b);
	}
	
	@Override
	public int compute() {
		this.value = this.a.getValue() - this.b.getValue();
		return value;
	}
	
	@Override
	public void print() {
		a.print();
		System.out.print(" - ");
		b.print();
	}

}
