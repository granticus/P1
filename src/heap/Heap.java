package heap;

public class Heap {
	private int[] heapArray;
	private int currentSize;
	private int maxSize;
	
	public Heap (int max){
		maxSize = max;
		currentSize = 0;
		heapArray = new int[maxSize];
	}
	
	public int heapSize() { return currentSize; }
	
	public boolean isLeaf (int pos){
		return (pos >= currentSize/2) && (pos < currentSize); 
	}
	
	public int leftChild (int pos){
		return 0;
	}
	
	public int rightChild (int pos){
		return 0;
	}
	
	public int parent (int pos){
		return 0;
	}
	
	public void insert (int key){
		
	}
	
	public void buildHeap() {
		
	}
	
	public void siftDown() {
		
	}
	
	public int removeMin() {
		return 0;
	}
	
	public int remove(int pos){
		return 0;
	}
}
