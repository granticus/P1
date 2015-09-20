
package heap;

/**
 * The Class Heap that will store the minimum value at the top and every child will be a larger value than the parent
 */
public class Heap
{
    
    /** The Heap. An array that will store all the values. */
    private int[] Heap;
    
    /** The size. */
    private int size;
    
    /** The maxsize. */
    private int maxsize;
 
    /** The Constant FRONT. */
    private static final int FRONT = 1;
 
    /**
     * Instantiates a new heap.
     *
     * @param maxsize the maxsize
     */
    public Heap(int maxsize)
    {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MIN_VALUE;
    }
 
    /**
     * The index of the Parent.
     *
     * @param pos the pos that is currently the child
     * @return the int the index of the parent
     */
    private int parent(int pos)
    {
        return pos / 2;
    }
 
    /**
     * Left child.
     *
     * @param pos the pos
     * @return the int
     */
    private int leftChild(int pos)
    {
        return (2 * pos);
    }
 
    /**
     * Right child.
     *
     * @param pos the pos
     * @return the int
     */
    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }
 
    /**
     * Checks if is leaf.
     *
     * @param pos the pos
     * @return true, if is leaf
     */
    private boolean isLeaf(int pos)
    {
        if (pos >=  (size / 2)  &&  pos <= size)
        { 
            return true;
        }
        return false;
    }
 
    /**
     * Swap.
     *
     * @param fpos the fpos
     * @param spos the spos
     */
    private void swap(int fpos, int spos)
    {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }
 
    /**
     * Min heapify.
     *
     * @param pos the pos
     */
    private void minHeapify(int pos)
    {
        if (!isLeaf(pos))
        { 
            if ( Heap[pos] > Heap[leftChild(pos)]  || Heap[pos] > Heap[rightChild(pos)])
            {
                if (Heap[leftChild(pos)] < Heap[rightChild(pos)])
                {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }else
                {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }
 
    /**
     * Inserts and elements into a valid position inside the heap.
     *
     * @param element the element that will be inserted inside the heap.
     */
    public void insert(int element)
    {
        Heap[++size] = element;
        int current = size;
 
        while (Heap[current] < Heap[parent(current)])
        {
            swap(current,parent(current));
            current = parent(current);
        }	
    }
 
    /**
     * Prints the Heap.
     */
    public String print()
    {
        String heap = "";
    	/*for (int i = 1; i <= size / 2; i++ )
        {
            heap = " PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2*i] 
                + " RIGHT CHILD :" + Heap[2 * i  + 1] + "\n";
        }*/
        
        
    	return heap;
    }
 
    /**
     * Min heap.
     */
    public void minHeap()
    {
        for (int pos = (size / 2); pos >= 1 ; pos--)
        {
            minHeapify(pos);
        }
    }
 
    /**
     * Removes the.
     *
     * @return the int
     */
    public int remove()
    {
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--]; 
        minHeapify(FRONT);
        return popped;
    }
}