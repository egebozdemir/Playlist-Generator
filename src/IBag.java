
public interface IBag <T> {
	
	public boolean add(T itemT);
	public boolean remove(T itemT);
	public int getCurrrentSize();
	public boolean isEmpty();
	public boolean isFull();
	public boolean contains(T itemT);
}
