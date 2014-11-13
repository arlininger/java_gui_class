/**
 * @author Adam Lininger
 */

package code;

import java.awt.Color;

public class BubbleSort extends Sortable
{
	int i;
	int j;

	public BubbleSort()
	{
		super("Bubble Sort");
	}

	public BubbleSort(int size)
	{
		super("Bubble Sort",size);
	}
	
	public void reset()
	{
		super.reset();
		System.out.println("Bubble Reset");
		i = size;
		j = 0;
	}

	public boolean sortStep()
	{
		if (i == 0)
		{
			System.out.println("Complete");
			return false;
		}
		if (array[j] > array[j+1])
		{
			this.swap(j,j+1);
			//array[j] ^= array[j+1];
			//array[j+1] ^= array[j];
			//array[j] ^= array[j+1];
		}
		j++;
		if (j >= i-1)
		{
			j = 0;
			i--;
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
