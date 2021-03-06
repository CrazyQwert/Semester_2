package vorfuehrAufgabe6;


// bla
public class BinaryNode extends ExpressionNode {

	ExpressionNode a;
	ExpressionNode b;
	char operator;

	public BinaryNode(ExpressionNode a, ExpressionNode b) {
		this.a = a;
		this.b = b;
		this.value = this.compute();
	}
	
	@Override
	public void print() {
		if (a instanceof SubNode || a instanceof AddNode) {
			System.out.print("( ");
			a.print();
			System.out.print(" )");
		} else {
			a.print();
		}
		System.out.print(" " + operator + " ");
		
		
		if (b instanceof SubNode || b instanceof AddNode) {
			System.out.print("( ");
			b.print();
			System.out.print(" )");
		} else {
			b.print();
		}
	}

	@Override
	public int compute() {
		return 0;
	}

}
