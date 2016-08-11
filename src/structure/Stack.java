package structure;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Problemin
 *
 * @param <Item>
 */
public class Stack<Item> implements Iterable<Item> {
	
	private Node<Item> first;
	private int size;
	
	public void push(Item item){
		if(isEmpty()){
			this.first = new Node<Item>();
			this.first.item = item;
			size++;
		}else{
			Node<Item> newNode = new Node<Item>();
			newNode.item = item;
			newNode.next = first;
			this.first = newNode;
			size++;
		}
	}
	
	public Item pop(){
		if(isEmpty()){
			throw new NoSuchElementException("Size is 0");
		}else{
			Item item = this.first.item;
			this.first = this.first.next;
			return item;
		}
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public Stack(){
		this.first = null;
		this.size = 0;
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
		public ListIterator(Node<Item> last) {
            current = last;
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
