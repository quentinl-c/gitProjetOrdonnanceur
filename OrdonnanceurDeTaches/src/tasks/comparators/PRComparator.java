/*
 * 
 */
package tasks.comparators;

import java.util.Comparator;

import tasks.Task;

// TODO: Auto-generated Javadoc
/**
 * The Class PRComparator.
 */
public class PRComparator implements Comparator<Task>
{

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Task o1, Task o2)
	{
		if(o1.getPriority() == o2.getPriority())
			return o1.getId()-o2.getId();
		return o1.getPriority()-o2.getPriority();
	}

}
