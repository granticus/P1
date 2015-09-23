package com.cs3114.simulation.p1;

public class Heap {

	/** The Heap. An array that will store all the values. */
	private Reaction[] Heap;

	/** The size. */
	private int size;

	/** The Constant FRONT. */
	private static final int FRONT = 0;

	/**
	 * Instantiates a new heap.
	 *
	 * @param reactions
	 *            the reactions that will be sorts in the heap.
	 */
	public Heap(Reaction[] reactions) {
		this.size = reactions.length;
		Heap = reactions;
		minHeap();
	}

	/**
	 * Gets the reaction at a specific index. Should never be called.
	 *
	 * @param pos
	 *            the pos of the reaction.
	 * @return the reaction
	 */
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
		return (pos - 1) / 2;
	}

	/**
	 * Left child.
	 *
	 * @param pos
	 *            the pos pf the left child.
	 * @return the int position of the left child. No need for error checking
	 *         since if there is no left, the the index is a leaf, so this
	 *         should never be called.
	 */
	private int leftChild(int pos) {
		return (2 * pos) + 1;
	}

	/**
	 * Right child of the parent.
	 *
	 * @param pos
	 *            the pos of the parent
	 * @return the int returns the right child if exists. Otherwise return -1 if
	 *         there is no right child.
	 */
	private int rightChild(int pos) {
		// The position is out of bounds.
		if (pos >= (size - 1) / 2) {
			return -1;
		}
		return (2 * pos) + 2;
	}

	/**
	 * Checks if the position in the heap is leaf, it has no children.
	 *
	 * @param pos
	 *            the pos of the current index that is being checked.
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
	 *            the spos The Second position that will swap into the first
	 *            position.
	 */
	private void swap(int fpos, int spos) {
		Reaction tmp;
		tmp = Heap[fpos];
		Heap[fpos] = Heap[spos];
		Heap[spos] = tmp;
	}

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
			} else if (Heap[pos].compareTo(Heap[leftChild(pos)]) > 0
					|| Heap[pos].compareTo(Heap[rightChild(pos)]) > 0) {
				if (Heap[leftChild(pos)].compareTo(Heap[rightChild(pos)]) < 0) {
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
		Heap[size - 1] = element;
		int current = size - 1;

		while (Heap[current].compareTo(Heap[parent(current)]) < 0) {
			swap(current, parent(current));
			current = parent(current);
		}
	}

	/**
	 * Prints the Heap as the array.
	 */
	public String print() {
		String heap = "";

		for (int i = 0; i < Heap.length; i++) {
			heap += Heap[i].getCurrentTau() + " ";
		}
		return heap;
	}

	/**
	 * Minimize the heap to push the lowest one to the top. Starts at the parent
	 * of the last element.
	 */
	public void minHeap() {
		for (int pos = (size / 2) - 1; pos >= 0; pos--) {
			minHeapify(pos);
		}
	}

	/**
	 * Minimum element of the heap.
	 *
	 * @return the reaction
	 */
	public Reaction minElement() {
		return Heap[FRONT];
	}

	/**
	 * Removes the Reaction element at the top of the array, and sorts the heap
	 * tree again. Sets the last element to the first element.
	 *
	 * @return the Reaction that was removed, which was the minimum value of the
	 *         tree
	 */
	public Reaction remove() {
		Reaction popped = Heap[FRONT];
		Heap[FRONT] = Heap[size - 1];
		minHeapify(FRONT);
		return popped;
	}
}