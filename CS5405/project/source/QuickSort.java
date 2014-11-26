/**
 * @author Adam Lininger
 */

package code;

import java.awt.Color;
import java.awt.Point;
import java.util.*;

/**
 * Implements the Quick Sort algorithm. 
 */
public class QuickSort extends Sortable
{
	/**
	 * Holds the lowest element guaranteed to be sorted.
	 * All elements in the array less than or equal to
	 * sortedIndex are sorted amongst themselves.
	 */
	int sortedIndex = 0;

	/**
	 * Flag for when we are sorting. Only false when we need to split a sub-array.
	 */
	boolean sorting;

	/**
	 * Current pivot index.
	 */
	int pivot;

	/**
	 * Current pivot value.
	 */
	int pivotValue;

	/**
	 * Index in the left array. Current upper edge of the left side.
	 */
	int left;

	/**
	 * Index in the right array. Current upper edge of the right side.
	 */
	int right;

	/**
	 * Current index being sorted.
	 */
	int i;

	/**
	 * Next location to be stored.
	 */
	int storeIndex;

	/**
	 * Stack of sub-arrays that still need to be sorted.
	 */
	Stack<QuickSortStage> st;

	/** 
	 * Create a QuickSort object.
	 */
	public QuickSort()
	{
		super("Quick Sort");
	}

	/** 
	 * Create a QuickSort object.
	 * @param size Number of elements to sort.
	 */
	public QuickSort(int size)
	{
		super("Quick Sort",size);
	}
	
	/**
	 * Reset the internal data.
	 */
	public void reset()
	{
		super.reset();
		st = new Stack<QuickSortStage>();
		st.push(new QuickSortStage(0,size-1));
		sorting = false;
		pivot = -1;
		pivotValue = -1;
		left = 0;
		right = size-1;
		i = 0;
		storeIndex = 0;
		sortedIndex = 0;
	}

	/**
	 * Get the prefered position of this algorithm.
	 * Used to initially display all algorithms in a somewhat tiled position.
	 */
	public Point getPreferedPosition()
	{
		return new Point(0,200);
	}

	/**
	 * Take one step in QuickSort.
	 */
	public boolean sortStep()
	{
		if (st.empty() && sorting == false)
		{ //Quicksort doesn't lend itself to identifying the last round as sorted.
		  //Identify that the entire array is sorted at this point.
			sortedIndex = size;
			return false;
		}
		if (!sorting)
		{
			QuickSortStage temp = st.pop();
			left = temp.lowerBound;
			right = temp.upperBound;
			pivot = choosePivot(left, right);
			pivotValue = array[pivot];
			sorting = true;
			i = left;
			swap(pivot,right);
			storeIndex = left;
			sortedIndex = left-1;
		} else if (i < right)
		{
			if (array[i] < pivotValue)
			{
				swap(i,storeIndex);
				storeIndex++;
			}
			i++;
		} else { //array split in half now, shift pivot back to location
			swap(storeIndex,right);
			if (storeIndex+1 <= right) 
			{
				st.push(new QuickSortStage(storeIndex+1,right));
			}
			if (storeIndex-1 >= left) 
			{
				st.push(new QuickSortStage(left,storeIndex-1));
			}
			sorting = false;
		}
		return true;
	}

	/**
	 * Return the proper color for the item at a given index.
	 * @param index The entry to be colored.
	 */
	public Color getColor(int index)
	{
		if (index <= sortedIndex)
		{
			return Color.GREEN;
		} else if (index == pivot) {
			return Color.BLUE;
		} else {
			return Color.BLACK;
		}
	}

	/**
	 * Helper function to select a pivot point within the given range.
	 * @param left Lower inclusive bound.
	 * @param right Upper inclusive bound.
	 * @return The index of the pivot point to use.
	 */
	private int choosePivot(int left, int right)
	{
		return right;
	}

}

class QuickSortStage
{
	public int lowerBound;
	public int upperBound;

	public QuickSortStage(int left, int right)
	{
		lowerBound = left;
		upperBound = right;
	}
}
