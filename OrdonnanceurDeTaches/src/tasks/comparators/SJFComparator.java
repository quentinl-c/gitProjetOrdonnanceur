/*
 * 
 */
package tasks.comparators;

import java.util.Comparator;
import tasks.Task;

// TODO: Auto-generated Javadoc
/**
 * The Class SJFComparator.
 */
public class SJFComparator implements Comparator<Task> {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Task o1, Task o2) {
		return o2.getDuration()-o1.getDuration();
	}
	

}
