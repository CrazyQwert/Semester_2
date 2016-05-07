package vorfuehrAufgabe3_videoHelp;

public class ListOfLines {
	
	private OneLine head;
	private OneLine curr;
	private OneLine tail;
	
	//getter and setter
	
	public OneLine getHead() {
		return this.head;
	}
	
	public OneLine getCurr() {
		return this.curr;
	}
	
	public void setCurr(OneLine curr) {
		this.curr = curr;
	}
	
	public OneLine getTail() {
		return this.tail;
	}
	
	//methods
	
	public void append(String content) {
		OneLine line = new OneLine(content);
		if (head == null) {
			head = line;
			tail = line;
		}
		tail.setNext(line);
		tail = line;
	}
	
	public boolean empty() {
		if (head == null) {
			return true;
		} else {
			return false;
		}
	}

}
