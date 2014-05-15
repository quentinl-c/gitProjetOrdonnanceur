/*
 * 
 */
package tasks;

import java.util.Comparator;

// TODO: Auto-generated Javadoc
/**
 * The Class PreemptiveTaskProcessor.
 */
public class PreemptiveTaskProcessor extends TaskProcessor {

	/** The waiting list. */
	private BinarySearchTree<Task> waitingList;
	
	/** The in execution. */
	private Task inExecution;
	
	/** The comparator. */
	private Comparator<Task> comparator;

	/**
	 * Instantiates a new preemptive task processor.
	 * 
	 * @param comparator
	 *            the comparator
	 */
	public PreemptiveTaskProcessor(Comparator<Task> comparator) {
		this.waitingList = new BinarySearchTree<Task>(comparator);
		this.inExecution = null;
		this.comparator = comparator;
	}

	/* (non-Javadoc)
	 * @see tasks.TaskProcessor#addTask(tasks.Task)
	 */
	@Override
	public void addTask(Task task) {
		this.waitingList.add(task);
	}

	/* (non-Javadoc)
	 * @see tasks.TaskProcessor#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return waitingList.isEmpty();
	}

	/* (non-Javadoc)
	 * @see tasks.TaskProcessor#getNextToProcess(int)
	 */
	@Override
	public TaskReport getNextToProcess(int time) {
		TaskReport report = null;
		if (!waitingList.isEmpty())
			inExecution = waitingList.takeFirst();
		else
			inExecution = null;
		if (inExecution != null)
			report = new TaskReport(time, inExecution);
		return report;
	}

	/* (non-Javadoc)
	 * @see tasks.TaskProcessor#hasToPauseFor(tasks.Task)
	 */
	@Override
	public boolean hasToPauseFor(Task toProcess) {
		if (inExecution == null)
			return false;
		return comparator.compare(toProcess, inExecution) > 0;
	}

	/* (non-Javadoc)
	 * @see tasks.TaskProcessor#pauseTask(int)
	 */
	@Override
	public void pauseTask(int delay) {
		inExecution.reduceDuration(delay);
		waitingList.add(inExecution);
		inExecution = waitingList.getFirst();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return inExecution + "\n" + waitingList;
	}

}
