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
		if (pos >= currentSize/2) return -1;
		return 2*pos + 1;
	}
	
	public int rightChild (int pos){
		if (pos >= (currentSize-1)/2) return -1;
		return 2*pos + 2;
	}
	
	public int parent (int pos){
		if (pos <= 0) return -1;
		return (pos - 1)/2;
	}
	
	private void swap(int fpos, int spos){
		int tmp;
		tmp = heapArray[fpos];
		heapArray[fpos] = heapArray[spos];
		heapArray[spos] = tmp;
	}
	
	public void insert (int key){
		if(currentSize >= maxSize){
			System.out.println("Heap full");
			return;
		}
		int curr = currentSize++;
		heapArray[curr] = key;
		
		while((curr != 0) && (heapArray[curr] < heapArray[parent(curr)])){
			swap(curr, parent(curr));
			curr = parent(curr);
		}
	}
	
	public void buildHeap() {
		for (int i = n/2-1; i >= 0; i--) {
			siftDown();
		}
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
