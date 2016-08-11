package structure;
import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author Problemin
 *
 * @param <Item>
 */
public class Bag<Item> implements Iterable<Item>{
	
	private Node<Item> first;
	private int size;
	
	public Bag(){
		this.first = null;
		this.size = 0;
	}
	
	private class Node<Item>{
		private Item item;
		private Node<Item> next;
	}
	
	public void add(Item item){
		Node<Item> oldfirst = this.first;
		this.first = new Node<Item>();
		this.first.item = item;
		this.first.next = oldfirst;
		size++;
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public int size(){
		return size;
		
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
