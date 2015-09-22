package com.cs3114.simulation.p1;

public class Heap {

	/** The Heap. An array that will store all the values. */
	private Reaction[] Heap;

	/** The size. */
	private int size;

	/** The maxsize. 
	private int maxsize;*/

	/** The Constant FRONT. */
	private static final int FRONT =0;

	/**
	 * Instantiates a new heap.
	 *
	 * @param maxsize
	 *            the maxsize
	 */
	public Heap(Reaction[] reactions) { //int maxsize) {
		
		this.size = reactions.length;
		/*Heap = new Reaction[size + 1];
		Heap[0] = new NullReaction();
		for (int i = 0; i < reactions.length; i++) {
			Heap[i+1] = reactions[i]; 
		}*/
		Heap = reactions;
	}

	public Reaction getReaction(int pos) {
		return Heap[pos];
	}
	
	/**
	 * The index of the Parent.
	 *
	 * @param pos
	 *            the pos that is currently the child
	 * @return the int the index of the parent
	 */
	private int parent(int pos) {
		return (pos-1) / 2;
	}

	/**
	 * Left child.
	 *
	 * @param pos
	 *            the pos
	 * @return the int
	 */
	private int leftChild(int pos) {
		return (2 * pos) + 1;
	}

	/**
	 * Right child of the parent.
	 *
	 * @param pos
	 *            the pos
	 * @return the int
	 */
	private int rightChild(int pos) {
		// The position is out of bounds.
		if (pos >= (size-1)/2) {
			return -1; 
		}
		return (2 * pos) + 2;
	}

	/**
	 * Checks if the position in the heap is leaf, it has no children.
	 *
	 * @param pos
	 *            the pos
	 * @return true, if is leaf
	 */
	private boolean isLeaf(int pos) {
		if (pos >= (size / 2) && pos <= size) {
			return true;
		}
		return false;
	}

	/**
	 * Swap the position of the 2 taken elements in the array.
	 *
	 * @param fpos
	 *            the fpos First Position that will be swapped.
	 * @param spos
	 *            the spos The Second position that will swap into the first position.
	 */
	private void swap(int fpos, int spos) {
		Reaction tmp;
		tmp = Heap[fpos];
		Heap[fpos] = Heap[spos];
		Heap[spos] = tmp;
	}
	/*
	 
	public int compareTo(Reaction other) {
		if(currentTau > other.getCurrentTau()){
			return 1;
		}else if(currentTau > other.getCurrentTau()){
			return -1;
		}else{
			return 0;
		}
	}
	
	 */

	/**
	 * Takes the parent index, and first makes sure the element is not a leaf,
	 * then makes sure the children of the index are bigger than the parent.
	 * Also, calls itself recursively to sort the whole tree.
	 *
	 * @param pos
	 *            the pos of the parent node.
	 */
	private void minHeapify(int pos) {
		if (!isLeaf(pos)) {
			if (rightChild(pos) == -1) {
				if (Heap[pos].compareTo(Heap[leftChild(pos)]) > 0) {
					swap(pos, leftChild(pos));
				}
			}
			else if (Heap[pos].compareTo(Heap[leftChild(pos)]) > 0
					|| Heap[pos].compareTo(Heap[rightChild(pos)]) > 0)
			{
				if (Heap[leftChild(pos)].compareTo(Heap[rightChild(pos)]) < 0)
				{
					swap(pos, leftChild(pos));
					minHeapify(leftChild(pos));
				} else {
					swap(pos, rightChild(pos));
					minHeapify(rightChild(pos));
				}
			}
		}
	}

	/**
	 * Inserts and elements into a valid position inside the heap.
	 *
	 * @param element
	 *            the element that will be inserted inside the heap.
	 */
	public void insert(Reaction element) {
		Heap[++size] = element;
		int current = size;

		while (Heap[current].compareTo(Heap[parent(current)]) < 0)
		// Heap[current] < Heap[parent(current)])
		{
			swap(current, parent(current));
			current = parent(current);
		}
	}

	/**
	 * Prints the Heap.
	 */
	public String print() {
		String heap = "";
		/*
		 * for (int i = 1; i <= size / 2; i++ ) { heap = " PARENT : " + Heap[i]
		 * + " LEFT CHILD : " + Heap[2*i] + " RIGHT CHILD :" + Heap[2 * i + 1] +
		 * "\n"; }
		 */

		for (int i = 0; i < Heap.length; i++) {
			heap += Heap[i] + " ";
		}
		return heap;
	}

	/**
	 * Minimize the heap to push the lowest one to the top. Starts at the parent of the last element.
	 */
	public void minHeap() {
		for (int pos = (size / 2) - 1; pos >= 0; pos--) {
			minHeapify(pos);
		}
	}

	/**
	 * Removes the Reaction element at the top of the array, and sorts the heap
	 * tree again. Sets the last element to the first element.
	 *
	 * @return the Reaction that was removed, which was the minimum value of the tree
	 */
	public Reaction remove() {
		Reaction popped = Heap[FRONT];
		Heap[FRONT] = Heap[size--];
		minHeapify(FRONT);
		return popped;
	}
}