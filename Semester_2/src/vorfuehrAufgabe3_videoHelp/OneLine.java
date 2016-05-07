package vorfuehrAufgabe3_videoHelp;

public class OneLine {
	
	private String content;
	private OneLine next;
	
	//constructor(s)
	
	public OneLine(String content) {
		this.content = content;
	}
	
	//getter and setter
	
	public String getContent() {
		return this.content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public OneLine getNext() {
		return this.next;
	}
	
	public void setNext(OneLine next) {
		this.next = next;
	}

}
