package de.htw;
public class QueueElement {
	QueueElement	next;
	int				data;
	int				priority;
	
	public QueueElement( int data, int priority ){
		this.data		= data;
		this.priority	= priority;
	}
	
	@Override
	public String toString() {
		return "{d: " + data + ", p: " + priority + "}";
	}
}
