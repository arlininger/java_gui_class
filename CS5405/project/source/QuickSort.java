/**
 * @author Adam Lininger
 */

package code;

import java.awt.Color;
import java.util.*;

/**
 * Implements the Quick Sort algorithm. 
 */
public class QuickSort extends Sortable
{
	boolean sorting;
	int pivot;
	int pivotValue;
	int left;
	int right;
	int i;
	int storeIndex;
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
	}

	/**
	 * Take one step in QuickSort.
	 */
	public boolean sortStep()
	{
		if (st.empty() && sorting == false)
		{
//			for(int i = 0; i < size; i++)
//			{
//			}
//			while (true) ;
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
			if (storeIndex == array[storeIndex])
			{
				if (storeIndex+1 <= right) 
				{
					st.push(new QuickSortStage(storeIndex+1,right));
				}
				if (storeIndex-1 >= left) 
				{
					st.push(new QuickSortStage(left,storeIndex-1));
				}
			} else {
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
		return Color.BLACK;
	}

	/**
	 * Helper function to select a pivot point within the given range.
	 * @param left Lower inclusive bound.
	 * @param right Upper inclusive bound.
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
