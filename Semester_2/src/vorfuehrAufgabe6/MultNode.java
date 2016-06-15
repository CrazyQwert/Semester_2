package vorfuehrAufgabe6;

public class MultNode extends BinaryNode {

	public MultNode(ExpressionNode a, ExpressionNode b) {
		super(a, b);
	}
	
	
	@Override
	public int compute() {
		this.value = this.a.getValue() * this.b.getValue();
		return value;
	}
	
	@Override
	public void print() {
		a.print();
		System.out.print(" * ");
		b.print();
	}

}
