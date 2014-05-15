package tasks;

import java.util.Comparator;


// TODO: Auto-generated Javadoc
/**
 * The Class SimpleTaskProcessor.
 * 
 * @author quentinlaporte-chabasse
 */
public class SimpleTaskProcessor extends TaskProcessor
{
	
	/** The to process. */
	private BinarySearchTree<Task> toProcess;
	
	/**
	 * Instantiates a new simple task processor.
	 * 
	 * @param comparator
	 *            the comparator
	 */
	public SimpleTaskProcessor(Comparator<Task> comparator)
	{
		toProcess = new BinarySearchTree<Task>(comparator);
	}

	/* (non-Javadoc)
	 * @see tasks.TaskProcessor#addTask(tasks.Task)
	 */
	@Override
	public void addTask(Task task)
	{
		toProcess.add(task);
	}
	
	/* (non-Javadoc)
	 * @see tasks.TaskProcessor#getNextToProcess(int)
	 */
	@Override
	//Renvoie la tache suivante a traiter et la supprime de toProcess
	public TaskReport getNextToProcess(int time)
	{
		if(toProcess.isEmpty())
			return null;
		TaskReport report = new TaskReport(time, toProcess.takeFirst());
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
