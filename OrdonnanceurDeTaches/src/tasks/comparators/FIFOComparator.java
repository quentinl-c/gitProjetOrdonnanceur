/*
 * 
 */
package tasks.comparators;

import java.util.Comparator;

import tasks.Task;

// TODO: Auto-generated Javadoc
/**
 * The Class FIFOComparator.
 */
public class FIFOComparator implements Comparator<Task>
{
	
	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Task o1, Task o2)
	{
		if(o1.getReceiptTime() == o2.getReceiptTime())
			return o1.getId()-o2.getId();
		return o2.getReceiptTime()-o1.getReceiptTime();
	}
}
