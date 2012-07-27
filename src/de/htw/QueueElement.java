package de.htw;
public class QueueElement {
	QueueElement	next;
	int				data;
	int				priority;
	
	public QueueElement( int data, int priority ){
		this.data		= data;
		this.priority	= priority;
	}
}
