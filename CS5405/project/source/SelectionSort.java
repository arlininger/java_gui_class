/**
 * @author Adam Lininger
 */

package code;

import java.awt.Color;
import java.awt.Point;

/**
 * Implements the Selection Sort algorithm. 
 */
public class SelectionSort extends Sortable
{
	/**
	 * Holds the offset of the element currently being sorted.
	 */
	int current;
	int currentMinimum;
	int selector;
	/**
	 * Holds whether there is an element currently being sorted.
	 */
	boolean working;

	/** 
	 * Create a SelectionSort object.
	 */
	public SelectionSort()
	{
		super("SelectionSort");
	}

	/** 
	 * Create a SelectionSort object.
	 * @param size Number of elements to sort.
	 */
	public SelectionSort(int size)
	{
		super("SelectionSort",size);
	}
	
	/**
	 * Reset the internal data.
	 */
	public void reset()
	{
		super.reset();
		current = 0;
		currentMinimum = 0;
		selector = 0;
	}

	/**
	 * Get the prefered position of this algorithm.
	 * Used to initially display all algorithms in a somewhat tiled position.
	 */
	public Point getPreferedPosition()
	{
		return new Point(500,0);
	}

	/**
	 * Take one step in SelectionSort.
	 */
	public boolean sortStep()
	{
		selector++;
		if (current == size)
		{
			return false;
		}
		if (selector == size)
		{ //swap the elements
			//array[current] ^= array[currentMinimum];
			//array[currentMinimum] ^= array[current];
			//array[current] ^= array[currentMinimum];
			swap(current,currentMinimum);
			current++;
			currentMinimum = current;
			selector = current;
		} else if (array[currentMinimum] > array[selector])
		{
			currentMinimum = selector;
		}
		return true;
	}

	/**
	 * Return the proper color for the item at a given index.
	 * @param index The entry to be colored.
	 */
	public Color getColor(int index)
	{
		if (index < current)
		{
			return Color.GREEN;
		} else if (index == current)
		{
			return Color.BLUE;
		} else if (index == currentMinimum)
		{
			return Color.YELLOW;
		} else if (index == selector)
		{
			return Color.RED;
		} else {
			return Color.BLACK;
		}
	}

}
