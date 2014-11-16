/**
 * @author Adam Lininger
 */

package code;

import java.awt.Color;

/**
 * Implements the Shell Sort algorithm. 
 */
public class ShellSort extends Sortable
{
	boolean sorting;

	int currentSpread;
	int offset;
	int i,j;

	/** 
	 * Create a ShellSort object.
	 */
	public ShellSort()
	{
		super("Shell Sort");
	}

	/** 
	 * Create a ShellSort object.
	 * @param size Number of elements to sort.
	 */
	public ShellSort(int size)
	{
		super("Shell Sort",size);
	}
	
	/**
	 * Reset the internal data.
	 */
	public void reset()
	{
		super.reset();
		sorting = true;
		currentSpread = 7;
		offset = 0;
		i = size;
		j = offset;
	}

	/**
	 * Take one step in ShellSort.
	 */
	public boolean sortStep()
	{
		if (currentSpread <= 0)
		{
			return false;
		}
		if (array[j] > array[j + currentSpread])
		{
			this.swap(j,j + currentSpread);
		}
		j += currentSpread;
		if (j >= i - currentSpread)
		{
			j = offset;
			i -= currentSpread;
		}
		if (i <= 0)
		{ //Sort the next offset
			offset++;
			j = offset;
			i = size;
		}
		if (offset == currentSpread)
		{ //Update current spread
			currentSpread -= 2;
			offset = 0;
		}
		return true;
	}

	/**
	 * Return the proper color for the item at a given index.
	 * @param index The entry to be colored.
	 */
	public Color getColor(int index)
	{
		if (index == i)
		{
			return Color.BLUE;
		} else if (index == j)
		{
			return Color.RED;
		} else {
			return Color.BLACK;
		}
	}

}
