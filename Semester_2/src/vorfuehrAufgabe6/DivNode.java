package vorfuehrAufgabe6;

public class DivNode extends BinaryNode {

	public DivNode(ExpressionNode a, ExpressionNode b) {
		super(a, b);
	}
	
	@Override
	public int compute() {
		this.value = this.a.getValue() / this.b.getValue();
		return value;
	}
	
	@Override
	public void print() {
		a.print();
		System.out.print(" / ");
		b.print();
	}

}
