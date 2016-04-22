package vorfuehrAufgabe3;

public class OneLine {
	
	private OneLine next = null;
	private String content;
	
	//constructor(s)
	OneLine(String line) {
		this.content = line;
	}
	
	//setter and getter methods
	public OneLine getNext() {
		return this.next;
	}
	
	public void setNext(OneLine oneline) {
		this.next = oneline;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	

}
