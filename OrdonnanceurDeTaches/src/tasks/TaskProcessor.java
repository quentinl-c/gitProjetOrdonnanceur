/*
 * 
 */
package tasks;


// TODO: Auto-generated Javadoc
/**
 * The Class TaskProcessor.
 */
public abstract class TaskProcessor
{
	
	/**
	 * Adds the task.
	 * 
	 * @param task
	 *            the task
	 */
	public abstract void addTask(Task task);
	
	/**
	 * Gets the next to process.
	 * 
	 * @param time
	 *            the time
	 * @return the next to process
	 */
	public abstract TaskReport getNextToProcess(int time);

	/**
	 * Checks if is empty.
	 * 
	 * @return true, if is empty
	 */
	public abstract boolean isEmpty();

	/**
	 * Checks for to pause for.
	 * 
	 * @param toProcess
	 *            the to process
	 * @return true, if successful
	 */
	public abstract boolean hasToPauseFor(Task toProcess);

	/**
	 * Pause task.
	 * 
	 * @param delay
	 *            the delay
	 */
	public abstract void pauseTask(int delay);
}
