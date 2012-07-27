package de.htw;

public interface IPriorityQueue {

	/**
	 * Liefert den mit hoechster Prioritaet gespeicherten Wert zurueck, 
	 * ohne ihn aus der Queue zu entfernen.
	 *
	 * Ist die Queue leer, liefert die Methode den Wert 0 zurueck.
	 *
	 * Eigenschaften, die eine Analyse zeigen sollte:
	 * Wenn this.head == null, dann wird 0 zurück geliefert.
	 * Wenn this.head != null, wird ein Wert zurückgeliefert, der gleich
	 * dem Wert ist, der im Listenelement mit der höchsten Priorität
	 * gespeichert ist.
	 * Wenn this.head auf eine gültige PriorityQueue-Struktur oder NULL verweist,
	 * können bei Methodenabarbeitung keine Nullzeigerdereferenzierungen
	 * auftreten.
	 */
	public abstract int peek();

	/**
	 * Liefert den mit hoechster Prioritaet gespeicherten Wert zurueck 
	 * und entfernt ihn aus der Queue.
	 *
	 *
	 * Ist die Queue leer, liefert die Methode den Wert 0 zurueck.	
	 *
	 * Eigenschaften, die eine Analyse zeigen sollte:
	 * Wenn this.head == null, dann wird 0 zurück geliefert.
	 * Wenn this.head != null, wird ein Wert zurückgeliefert, der gleich
	 * dem Wert ist, der im Listenelement mit der höchsten Priorität
	 * gespeichert ist. Dieses Listenelement wurde zusätzlich aus der
	 * Queue entfernt.
	 * Wenn this.head auf eine gültige PriorityQueue-Struktur oder NULL verweist,
	 * können bei Methodenabarbeitung keine Nullzeigerdereferenzierungen
	 * auftreten.	 
	 */
	public abstract int dequeue();

	/**
	 * Fuegt einen Wert (> 0) mit vorgegebener Prioritaet in die Queue ein,
	 * sofern dieser Wert nicht bereits enthalten ist.
	 * Ist der Wert bereits enthalten, wird seine Prioritaet neugesetzt.
	 *
	 * Die Funktion liefert true zurueck, wenn ein neuer
	 * Wert tatsaechlich eingefuegt wurde, sonst false.
	 *
	 * Eigenschaften, die eine Analyse zeigen sollte:
	 * Wenn die Queue bereits ein Element enthält, das den Wert data
	 * speichert, ist dessen Priorität nach Methodenabarbeitung gleich
	 * priority.
	 * Enthält die Queue bisher kein Element, das data speichert,
	 * wird ein QueueElement mit diesem Wert und einer Priorität gleich
	 * priority erzeugt und in die Liste eingefügt.
	 * Der Rückgabewert gibt stets korrekt an, welcher der beiden Fälle
	 * eingetreten war.
	 * Wenn this.head auf eine gültige PriorityQueue-Struktur oder NULL verweist,
	 * können bei Methodenabarbeitung keine Nullzeigerdereferenzierungen
	 * auftreten.
	 */
	public abstract boolean enqueue(int data, int priority);

	/**
	 * Liefert true zurueck, falls die Queue leer ist, d.h. keine
	 * Elemente enthaelt; sonst false.
	 *
	 * Eigenschaften, die eine Analyse zeigen sollte:
	 * Wenn this.head == null wird true zurückgeliefert.
	 * Wenn this.head != null wird false zurückgeliefert.
	 */
	public abstract boolean isEmpty();

}