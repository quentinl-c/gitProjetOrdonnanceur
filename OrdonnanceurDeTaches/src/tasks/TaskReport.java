/*
 * 
 */
package tasks;

// TODO: Auto-generated Javadoc
/**
 * The Class TaskReport.
 */
public class TaskReport {
	
	/** The id. */
	private int id;
	
	/** The label. */
	private String label;
	
	/** The begin time. */
	private int beginTime;
	
	/** The end time. */
	private int endTime;


	/**
	 * Instantiates a new task report.
	 * 
	 * @param time
	 *            the time
	 * @param toProcess
	 *            the to process
	 */
	public TaskReport(int time, Task toProcess)
	{
		this.beginTime=time;
		this.label=toProcess.getLabel();
		this.id=toProcess.getId();
		this.endTime= (toProcess.getDuration())+time;
	}
	
	/**
	 * Instantiates a new task report.
	 * 
	 * @param time
	 *            the time
	 * @param execTime
	 *            the exec time
	 * @param toProcess
	 *            the to process
	 */
	public TaskReport(int time, int execTime, Task toProcess)
	{
		this.beginTime=time-execTime;
		this.label=toProcess.getLabel();
		this.id=toProcess.getId();
		this.endTime=time;
	}
	
	/**
	 * Instantiates a new task report.
	 * 
	 * @param id
	 *            the id
	 * @param label
	 *            the label
	 * @param beginTime
	 *            the begin time
	 * @param endTime
	 *            the end time
	 */
	public TaskReport(int id, String label, int beginTime, int endTime)
	{
		this.id = id;
		this.label = label;
		this.beginTime = beginTime;
		this.endTime = endTime;
	}
	
	/**
	 * Gets the end time.
	 * 
	 * @return the end time
	 */
	public int getEndTime() 
	{
		return endTime;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		String resultat = this.id+" "+this.label+" "+this.beginTime+" -> "+this.endTime;
		return resultat;
	}
	
	/**
	 * Gets the duration.
	 * 
	 * @return the duration
	 */
	public int getDuration()
	{
		return endTime-beginTime;
	}
	
	/**
	 * Sets the duration.
	 * 
	 * @param duration
	 *            the new duration
	 */
	public void setDuration(int duration)
	{
		endTime = beginTime+duration;
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
	 * Adds the duration.
	 * 
	 * @param duration
	 *            the duration
	 */
	public void addDuration(int duration)
	{
		this.endTime += duration;
	}
	
	/**
	 * Gets the begin time.
	 * 
	 * @return the begin time
	 */
	public int getBeginTime()
	{
		return beginTime;
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
}
