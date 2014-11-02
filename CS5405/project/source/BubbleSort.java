/**
 * @author Adam Lininger
 */

package code;

public class BubbleSort extends Sortable
{
	int i;
	int j;
	public void reset()
	{
		super.reset();
		System.out.println("Bubble Reset");
		i = 0;
		j = 0;
	}

	public boolean sort_step()
	{
		if (i == size)
		{
			System.out.println("Complete");
			return false;
		}
		if (array[j] > array[j+1])
		{
			//swap(array[i],array[i+1]);
			array[j] ^= array[j+1];
			array[j+1] ^= array[j];
			array[j] ^= array[j+1];
		}
		j++;
		if (j == size-1)
		{
			j = 0;
			i++;
		}
		return true;
	}

}
