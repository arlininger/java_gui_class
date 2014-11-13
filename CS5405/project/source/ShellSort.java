/**
 * @author Adam Lininger
 */

package code;

import java.awt.Color;

public class ShellSort extends Sortable
{
	boolean sorting;

	int currentSpread;
	int offset;
	int i,j;

	public ShellSort()
	{
		super("Shell Sort");
	}

	public ShellSort(int size)
	{
		super("Shell Sort",size);
	}
	
	public void reset()
	{
		super.reset();
		sorting = true;
		currentSpread = 7;
		offset = 0;
		i = size;
		j = offset;
		System.out.println("Shell Reset");
	}

	public boolean sortStep()
	{
		if (currentSpread <= 0)
		{
			System.out.println("Complete");
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
			System.out.printf("Moving to offset %d\n",offset);
		}
		if (offset == currentSpread)
		{ //Update current spread
			currentSpread -= 2;
			offset = 0;
			System.out.printf("Moving to stepsize %d\n",currentSpread);
		}
		return true;
	}

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
