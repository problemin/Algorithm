package structure;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Problemin
 *
 * @param <Item>
 */
public class StackArray<Item> implements Iterable<Item>{
	
	private Item[] items;
	private int size;
	private int currentMax = 10;
	public void push(Item item){
		items[size] = item;
		size++;
		if(this.size()*3/4==currentMax){
			currentMax += currentMax;
			resize(currentMax);
		}
	}
	
	public Item pop(){
		if(isEmpty()) throw new NoSuchElementException("Stack size is 0");
		Item item = items[--size];
		items[size] = null;
		if(size==currentMax/4){
			currentMax = currentMax/2;
			resize(currentMax);
		}
		return item;
	}
	
	public int size(){
		return size;
	}
	
	public void resize(int max){
		Item[] temp = (Item[]) new Object[max];
		for(int i = 0; i < this.size ;i++){
			temp[i] = items[i];
		}
		items = temp;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public StackArray(){
		this.items = (Item[]) new Object[currentMax];
		this.size = 0;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<Item>{
		private int i = size;

		@Override
		public boolean hasNext() {
			return i > 0;
		}

		@Override
		public Item next() {
			return items[--i];
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
	}
	
}
