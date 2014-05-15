/*
 * 
 */
package tasks;

import java.util.LinkedList;

// TODO: Auto-generated Javadoc
/**
 * The Class RRTaskProcessor.
 */
public class RRTaskProcessor extends TaskProcessor
{
	
	/** The to process. */
	private LinkedList<Task> toProcess;
	
	/** The quantum. */
	private int quantum;
	
	/**
	 * Instantiates a new RR task processor.
	 * 
	 * @param quantum
	 *            the quantum
	 */
	public RRTaskProcessor(int quantum)
	{
		toProcess = new LinkedList<Task>();
		this.quantum = quantum;
	}
	
	/* (non-Javadoc)
	 * @see tasks.TaskProcessor#addTask(tasks.Task)
	 */
	@Override
	public void addTask(Task task)
	{
		toProcess.addLast(task);
	}
	
	//Renvoie la tache suivante a traiter et la supprime de toProcess
	/* (non-Javadoc)
	 * @see tasks.TaskProcessor#getNextToProcess(int)
	 */
	@Override
	public TaskReport getNextToProcess(int time)
	{
		if(toProcess.isEmpty())
			return null;
		Task task = toProcess.getFirst();
		toProcess.removeFirst();
		TaskReport report = new TaskReport(time, task);
		if(report.getDuration() > quantum)
		{
			report.setDuration(quantum);
			task.reduceDuration(quantum);
			toProcess.addLast(task);
		}
		return report;
	}

	/* (non-Javadoc)
	 * @see tasks.TaskProcessor#isEmpty()
	 */
	@Override
	public boolean isEmpty()
	{
		return toProcess.isEmpty();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return toProcess.toString();
	}

	/* (non-Javadoc)
	 * @see tasks.TaskProcessor#hasToPauseFor(tasks.Task)
	 */
	@Override
	public boolean hasToPauseFor(Task toProcess)
	{
		return false;
	}

	/* (non-Javadoc)
	 * @see tasks.TaskProcessor#pauseTask(int)
	 */
	@Override
	public void pauseTask(int delay)
	{
		
	}
}
