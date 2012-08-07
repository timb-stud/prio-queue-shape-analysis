package de.htw;
public class QueueElement {
	public QueueElement	next;
	public int data;
	public int priority;
	
	public QueueElement( int data, int priority ){
		this.data		= data;
		this.priority	= priority;
	}
	
	public QueueElement() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "{d: " + data + ", p: " + priority + "}";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof QueueElement){
			QueueElement element = (QueueElement)obj;
			return this.data == element.data && this.priority == element.priority;
		}
		return false;
	}
}
