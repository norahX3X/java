
/**
 * Write a description of Node here.
 * 
 * @author (your name) 
 * @version (a version number or a date)*/
class Node<T> {
	public T data;
	public Node<T> next;
	
	public Node (T val) {
		data = val;
		next = null;
	}
}

