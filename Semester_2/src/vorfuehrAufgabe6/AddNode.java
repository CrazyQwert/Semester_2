package vorfuehrAufgabe6;

public class AddNode extends BinaryNode {

	public AddNode(ExpressionNode a, ExpressionNode b) {
		super(a, b);
	}
	
	@Override
	public int compute() {
		this.value = this.a.getValue() + this.b.getValue();
		return value;
	}
	
	@Override
	public void print() {
		a.print();
		System.out.print(" + ");
		b.print();
	}

}
