/**
 * @author Adam Lininger
 */

package code;

import java.awt.Color;
import java.awt.Point;

/**
 * Implements the Heap Sort algorithm. 
 */
public class HeapSort extends Sortable
{
	/**
	 * Current size of the heap.
	 */
	int heapSize;
	
	/**
	 * Whether or not we are building the heap. Only true before the initial heap is complete.
	 */
	boolean buildingHeap;

	/**
	 * Whether or not we are currently sorting. Always true until sorting is finished.
	 */
	boolean sorting;

	/**
	 * Whether or not we are re-heapifying a portion of the heap.
	 */
	boolean heapifying;

	/**
	 * The next element to be re-heapified.
	 */
	int heapifyIndex;

	/**
	 * The current index when building the heap.
	 */
	int heapBuildIndex;

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
		buildingHeap = true;
		sorting = true;
		heapifying = false;
		heapifyIndex = size-1;
		heapBuildIndex = size-1;
	}

	/**
	 * Get the prefered position of this algorithm.
	 * Used to initially display all algorithms in a somewhat tiled position.
	 */
	public Point getPreferedPosition()
	{
		return new Point(0,0);
	}

	/**
	 * 
	 */
	public boolean sortStep()
	{
		if (heapifying)
		{
			int l = leftChild(heapifyIndex);
			int r = rightChild(heapifyIndex);
			int largest = heapifyIndex;
			if (l < heapSize && l > 0 && array[l] > array[heapifyIndex])
			{
				largest = l;
			}
			if (r < heapSize && r > 0 && array[r] > array[largest])
			{
				largest = r;
			}
			if (largest != heapifyIndex)
			{
				swap(largest,heapifyIndex);
				heapifyIndex = largest;
			} else {
				heapifying = false;
			}
			return true;
		} else if (buildingHeap)
		{
			heapifyIndex = heapBuildIndex-1;
			heapBuildIndex--;
			heapifying = true;
			if (heapifyIndex < 0)
			{
				heapifying = false;
				buildingHeap = false;
//				sorting = true;
				heapSize = size;
			}
			return true;
		} else if (sorting)
		{
			swap(0,heapSize-1);
			heapSize--;
//			sorting = false;
			heapifying = true;
			heapifyIndex = 0;
			if (heapSize <= 0)
			{
				running = false;
				return false;
			}
			return true;
		}
		return false;
	}

	/**
	 * Return the parent of the current object. Might be unused.
	 * @param x The index for which to return the parent.
	 */
//	int parent(int x)
//	{
//		return (x-1)/2;
//	}

	/**
	 * Returns the index of the left child of index x.
	 * @param x The index for which to return a child.
	 * @return The child of index x.
	 */
	int leftChild(int x)
	{
		return x*2 + 1;
	}

	/**
	 * Returns the index of the right child of index x.
	 * @param x The index for which to return a child.
	 * @return The child of index x.
	 */
	int rightChild(int x)
	{
		return x*2 + 2;
	}

	/**
	 * Return the proper color for the item at a given index.
	 * @param index The entry to be colored.
	 * @return The color of the element at index.
	 */
	public Color getColor(int index)
	{
		if (index >= heapSize)
		{
			return Color.GREEN;
		} else {
			return Color.BLACK;
		}
	}

}
