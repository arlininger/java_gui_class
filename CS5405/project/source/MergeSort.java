/**
 * @author Adam Lininger
 */

package code;

import java.awt.Color;
import java.awt.Point;
import java.util.*;

/**
 * Implements the bottom-up Merge Sort algorithm. 
 */
public class MergeSort extends Sortable
{

	/**
	 * Holds the lowest element guaranteed to be sorted.
	 * All elements in the array less than or equal to
	 * sortedIndex are sorted amongst themselves.
	 */
	int sortedIndex = 0;

	/**
	 * Temporary array needed for merging.
	 */
	int tempArray[];

	/**
	 * Step size for bottom-up merge sort.
	 */
	int stepSize;

	/**
	 * Left index used during merging.
	 */
	int leftIndex;

	/**
	 * Right index used during merging.
	 */
	int rightIndex;

	/**
	 * Upper limit of left array when merging.
	 */
	int leftLimit;

	/**
	 * Upper limit of right array when merging.
	 */
	int rightLimit;

	/**
	 * Index in to temporary array during merging.
	 */
	int tempIndex;

	/** 
	 * Create a MergeSort object.
	 */
	public MergeSort()
	{
		super("Merge Sort");
	}

	/** 
	 * Create a MergeSort object.
	 * @param size Number of elements to sort.
	 */
	public MergeSort(int size)
	{
		super("Merge Sort",size);
	}
	
	/**
	 * Reset local parameters for MergeSort.
	 */
	public void reset()
	{
		super.reset();
		tempArray = new int[size];
		stepSize = 1;
		leftIndex = 0;
		rightIndex = stepSize;
		leftLimit = rightIndex-1;
		rightLimit = leftLimit + stepSize;
		tempIndex = 0;
	}
	/**
	 * Get the prefered position of this algorithm.
	 * Used to initially display all algorithms in a somewhat tiled position.
	 */
	public Point getPreferedPosition()
	{
		return new Point(250,200);
	}

	/**
	 * 
	 */
	public boolean sortStep()
	{
		if (leftIndex <= leftLimit && rightIndex <= rightLimit)
		{
			if (array[leftIndex] < array[rightIndex])
			{
				tempArray[tempIndex] = array[leftIndex];
				leftIndex++;
			} else {
				tempArray[tempIndex] = array[rightIndex];
				rightIndex++;
			}
			tempIndex++;
		} else if (leftIndex <= leftLimit)
		{
			tempArray[tempIndex] = array[leftIndex];
			leftIndex++;
			tempIndex++;
		} else if (rightIndex <= leftLimit)
		{
			tempArray[tempIndex] = array[rightIndex];
			rightIndex++;
			tempIndex++;
		} else { //this section merged
			if (leftIndex-stepSize <= 0)
			{ //If this is the farthest left, we are sorted all the way to the right.
				sortedIndex = rightLimit;
			}
			for (int i = 0; i < tempIndex; i++)
			{
				array[i+leftIndex-stepSize] = tempArray[i];
			}
			leftIndex = rightLimit + 1;
			rightIndex = leftIndex + stepSize;
			leftLimit = rightIndex - 1;
			rightLimit = leftLimit + stepSize;
			tempIndex = 0;
			if (leftLimit >= size)
			{ //Occurs when we are done sorting at this stepsize
				stepSize *= 2;
				leftIndex = 0;
				rightIndex = stepSize;
				leftLimit = rightIndex-1;
				rightLimit = leftLimit + stepSize;
			}
			if (rightLimit >= size)
			{ //Occurs when we are sorting to the end
				rightLimit = size-1;
			}
			if (stepSize >= size)
			{ //we're done sorting
				return false;
			}
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
		} else {
			return Color.BLACK;
		}
	}

}

class MergeSortStage
{
	public int lowerBound;
	public int upperBound;
	public boolean sorted;

	public MergeSortStage(int left, int right, boolean isSorted)
	{
		lowerBound = left;
		upperBound = right;
		sorted = isSorted;
	}
}

