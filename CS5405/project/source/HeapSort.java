/**
 * @author Adam Lininger
 */

package code;

import java.awt.Color;

/**
 * Implements the Heap Sort algorithm. 
 */
public class HeapSort extends Sortable
{
	int heapSize;

	/**
	 * Create a HeapSort object. 
	 */
	public HeapSort()
	{
		super("Heap Sort");
	}

	/**
	 * Create a HeapSort object. 
	 * @param size The number of elements in the array to be sorted.
	 */
	public HeapSort(int size)
	{
		super("Heap Sort",size);
	}
	
	/**
	 * Reset the object.
	 */
	public void reset()
	{
		super.reset();
		heapSize = size;

	}

	/**
	 * Re-insert the item at index start. Presumes the trees below start are
	 * already properly in a max-heap.
	 */
	void maxHeapify(int start)
	{
		int l = leftChild(start);
		int r = rightChild(start);
		int largest = start;
		if (l < heapSize && l > 0 && array[l] > array[start])
		{
			largest = l;
		}
		if (r < heapSize && r > 0 && array[r] > array[largest])
		{
			largest = r;
		}
		if (largest != start)
		{
			swap(largest,start);
			repaint();
			sleep();
			maxHeapify(largest);
		}
	}

	/**
	 * Turns the entire array in to a heap.
	 */
	void buildMaxHeap()
	{
		for (int i = size-1; i >= 0; i--)
		{
			maxHeapify(i);
		}
	}

	/**
	 * Sorts the elements using the MaxHeap algorithm. This does include delays to allow
	 * for proper visualization.
	 */
	void sort()
	{
		buildMaxHeap();
		for (int i = size-1; i >= 0; i--)
		{
			swap(0,i);
			repaint();
			sleep();
			heapSize--;
			maxHeapify(0);
		}
	}

	/**
	 * The main loop in the thread. This overrides the normal main loop for most Sortable objects.
	 */
	public void run()
	{
		while (true)
		{
			if (running)
			{
				sort();
				running = false;
			}
			repaint();
			sleep();
		}
	}

	/**
	 * Unused.
	 */
	public boolean sortStep()
	{
		return true;
	}

	/**
	 * Return the parent of the current object. Might be unused.
	 */
	int parent(int x)
	{
		return (x-1)/2;
	}

	/**
	 * Returns the index of the left child of index x.
	 */
	int leftChild(int x)
	{
		return x*2 + 1;
	}

	/**
	 * Returns the index of the right child of index x.
	 */
	int rightChild(int x)
	{
		return x*2 + 2;
	}

	/**
	 * Return the proper color for the item at a given index.
	 * @param index The entry to be colored.
	 */
	public Color getColor(int index)
	{
			return Color.BLACK;
	}

}
