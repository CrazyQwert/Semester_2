package vorfuehrAufgabe3;

public class ListOfLines {
	
	private OneLine head = null;	//first item of list.
	private OneLine tail = null;	//last item of list. Acts as break condition
	private OneLine curr = null;	//current line
	
	//getter and setter
	public OneLine getHead() {
		return this.head;
	}
	
	public OneLine getTail() {
		return this.tail;
	}
	
	public OneLine getCurrent() {
		return this.curr;
	}
	
	//methods
	public void append(String line) {
		OneLine oneLine = new OneLine(line);
		OneLine current;
		if (this.head == null) {
			this.head = oneLine;
		} else {
			current = this.head;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(oneLine);
		}
		this.tail = oneLine;
	}
	
	public boolean empty() {
		if (this.head != null) {
			return false;
		} else {
			return true;
		}
	}
	
	public OneLine getNext() {
		if (this.curr == null) {
			this.curr = this.head;
		} else if (this.curr.getNext() != null) {
			this.curr = this.curr.getNext();
		} else {
			this.curr = this.head;
		}
		
		return this.curr;
	}
	
}
