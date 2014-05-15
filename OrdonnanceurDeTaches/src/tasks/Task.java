/*
 * 
 */
package tasks;

// TODO: Auto-generated Javadoc
/**
 * The Class Task.
 */
public class Task
{
	
	/** The receipt time. */
	private int id, duration, priority, receiptTime;
	
	/** The label. */
	String label;
	
	/**
	 * Instantiates a new task.
	 * 
	 * @param id
	 *            the id
	 * @param label
	 *            the label
	 * @param receiptTime
	 *            the receipt time
	 * @param duration
	 *            the duration
	 * @param priority
	 *            the priority
	 */
	public Task(int id, String label, int receiptTime, int duration, int priority)
	{
		this.id = id;
		this.label = label;
		this.duration = duration;
		this.priority = priority;
		this.receiptTime = receiptTime;
	}
	
	/**
	 * Gets the label.
	 * 
	 * @return the label
	 */
	public String getLabel()
	{
		return label;
	}
	
	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}
	
	/**
	 * Gets the duration.
	 * 
	 * @return the duration
	 */
	public int getDuration()
	{
		return duration;
	}
	
	/**
	 * Reduce duration.
	 * 
	 * @param duration
	 *            the duration
	 */
	public void reduceDuration(int duration)
	{
		this.duration -= duration;
	}
	
	/**
	 * Gets the priority.
	 * 
	 * @return the priority
	 */
	public int getPriority()
	{
		return priority;
	}
	
	/**
	 * Gets the receipt time.
	 * 
	 * @return the receipt time
	 */
	public int getReceiptTime()
	{
		return receiptTime;
	}
	
	/**
	 * Sets the duration.
	 * 
	 * @param duration
	 *            the new duration
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return id + " : " + label + "(duration :" + duration + ", receiptTime : " + receiptTime + ", priority : " + priority + ")";
	}
}
