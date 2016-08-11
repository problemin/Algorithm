package structure;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Problemin
 *
 * @param <Item>
 */
public class Queue<Item> implements Iterable<Item> {
	
	private Node<Item> first;
	private int size;
	private Node<Item> last;
	
	public Queue(){
		this.first = null;
		this.last = null;
		this.size = 0;
	}
	
	public void enqueue(Item item){
		if(this.first==null){
			this.first = new Node<Item>();
			this.first.item = item;
			this.last = this.first;
			size++;
		}else{
			Node<Item> newNode = new Node<Item>();
			newNode.item = item;
			this.last.next = newNode;
			this.last = newNode;
			size++;
		}
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public int size(){
		return size;
	}
	
	public void dequeue(){
		Node x = this.first;
		this.first = this.first.next;
	}
	
	private class Node<Item>{
		private Item item;
		private Node<Item> next;
	}
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator<Item>(first);
	}
	
	public class ListIterator<Item> implements Iterator<Item>{
		
		private Node<Item> current;
		public ListIterator(Node<Item> first) {
            current = first;
        }
		@Override
		public boolean hasNext() {
			return this.current!=null;
		}
		@Override
		public Item next() {
			if(!hasNext()) throw new NoSuchElementException();
			Item temp = this.current.item;
			current = current.next;
			return temp;
		}
		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
}
