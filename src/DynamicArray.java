import java.util.Arrays;

public class DynamicArray<T> {
									// Our own Dynamic array implementation. It has basic
	private T[] array;				// array functionalities.
	private int sizeOfArray;
	private int count;
	
	@SuppressWarnings("unchecked")
	public DynamicArray() {
		
		array = (T[]) new Object[2];
		count = 0;
		sizeOfArray = 2;
		
	}
	
	public void addItem (T item) {
		
		if (count == sizeOfArray) {
			ensureCapacity(2);
		}
		
		array[count] = item;
		count++;
		
	}
	public void addItem (int index, T item) {
			
		if (count == sizeOfArray) {
			ensureCapacity(2);
		}
		
		for (int i = count - 1; i >= index; i--) {
			array[i+1] = array[i];
		}
		
		array[index] = item;
		count++;
	}
	
	public T getItem(int index) {
		
		return array[index];
	}
	
	public int getIndex(T itemT) {
		int index = -1;
		
		for (int i = 0; i < this.count; i++) {
			if (array[i].equals(itemT)) {
				index = i;
			}
		}
		
		return index;
	}
	public void removeItemByName(T itemT) {
		int index;
		index = this.getIndex(itemT);
		this.removeItem(index);
		
	}
	
	public void removeItem(int index){
        if(index>=this.count || index<0){
        	System.out.println("No element at this index");
       	}
        else{
        	
        	for(int i=index;i<count-1;i++){
	            array[i] = array[i+1];
	        }
            array[count-1]=null;
            count = count - 1;
	    }
        trimToSize();
	}
	
	public int getSize() {
		return this.count;
	}
	
	public int getCapacity() {
		return this.sizeOfArray;
	}
	
	@SuppressWarnings("unchecked")
	private void ensureCapacity(int minCapacity) {
		
		T[] temp = null;
		temp = (T[]) new Object[sizeOfArray*minCapacity];
		for (int i = 0; i < this.count; i++) {
			
			temp[i] = array[i];
			
		}
		array = temp;
		sizeOfArray = sizeOfArray*minCapacity;
	}
	@SuppressWarnings("unchecked")
	private void trimToSize(){
       
        T[] temp = (T[]) new Object[count];
        for (int i=0; i < this.count; i++){
            temp[i] = array[i];
        }
        array = temp;
        sizeOfArray = this.count;
	}

	@Override
	public String toString() {
		return "DynamicArray [array=" + Arrays.toString(array) + ", sizeOfArray=" + sizeOfArray + ", currentNumberOfItems=" + count
				+ "]";
	}
	
	
}
