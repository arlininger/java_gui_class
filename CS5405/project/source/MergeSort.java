/**
 * @author Adam Lininger
 */

package code;

import java.awt.Color;
import java.awt.Point;

/**
 * Implements the Merge Sort algorithm. 
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
	
	public void reset()
	{
		super.reset();
		sortedIndex = 0;
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
	 * Unused. This function exists only to satisfy the requirements to extend Sortable.
	 * Since MergeSort re-implements run(), this is not needed. 
	 */
	public boolean sortStep()
	{
		return true;
	}

	/**
	 * The main function for MergeSort. This function will recursively sort the array between elements
	 * lower and upper.
	 * @param lower The lower bound (inclusive) of the range to sort.
	 * @param upper The upper bound (inclusive) of the range to sort.
	 */
	private void sort(int lower, int upper)
	{
		if (upper - lower >= 1)
		{
			int midpoint = lower + (upper - lower) / 2; //Goes in the "left" half
			sort(lower, midpoint);
			sort(midpoint + 1, upper);
			merge(lower, midpoint, upper);
			if (lower == 0)
			{ //sortedIndex indicates the top of the currently sorted array.
			  //This is only true if we merged from zero to the current upper.
				sortedIndex = upper;
			}
			repaint();
			sleep();
		}
	}

	/**
	 * Merge function for merge Sort. Since MergeSort does not use the normal
	 * run() method of Sortable, this function must call sleep() and repaint()
	 * after every element is merged.
	 */
	private void merge(int lower, int midpoint, int upper)
	{
		int newArray[] = new int[upper-lower+1];
		int leftIndex = lower;
		int rightIndex = midpoint + 1;
		int nextSpot = 0;
		while (leftIndex <= midpoint && rightIndex <= upper)
		{
			if (array[leftIndex] < array[rightIndex])
			{
				newArray[nextSpot] = array[leftIndex];
				leftIndex++;
			} else {
				newArray[nextSpot] = array[rightIndex];
				rightIndex++;
			}
			nextSpot++;
			repaint();
			sleep();
		}
		while (leftIndex <= midpoint)
		{
			newArray[nextSpot] = array[leftIndex];
			nextSpot++;
			leftIndex++;
			repaint();
			sleep();
		}
		while (rightIndex <= upper)
		{
			newArray[nextSpot] = array[rightIndex];
			nextSpot++;
			rightIndex++;
			repaint();
			sleep();
		}
		for (int i = lower; i <= upper; i++)
		{
			array[i] = newArray[i-lower];
			repaint();
			sleep();
		}
	}

	/**
	 * Main thread loop for MergeSort. This overloads the run function in
	 * Sortable. 
	 */
	public void run()
	{
		while (true)
		{
			if (running)
			{
				sort(0,size-1);
				running = false;
			}
			sleep();
		}
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

