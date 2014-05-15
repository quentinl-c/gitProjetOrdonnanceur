/*
 * 
 */
package tasks;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class TaskList.
 */
public class TaskList
{
	
	/** The tasks. */
	ArrayList<TaskReport> tasks = new ArrayList<TaskReport>();
	
	/**
	 * Adds the task.
	 * 
	 * @param task
	 *            the task
	 */
	public void addTask(TaskReport task)
	{
		if(task == null)
			return;
		if(tasks.size() > 0)
		{
			if(tasks.get(tasks.size()-1).getEndTime() < task.getBeginTime())
				tasks.add(new TaskReport(0, "idle", tasks.get(tasks.size()-1).getEndTime(), task.getBeginTime()));
			if(tasks.get(tasks.size()-1).getId() == task.getId())
			{
				tasks.get(tasks.size()-1).addDuration(task.getDuration());
				return;
			}
		}
		tasks.add(task);
	}

	/**
	 * Gets the task count.
	 * 
	 * @return the task count
	 */
	public int getTaskCount()
	{
		return tasks.size();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		String result = "";
		for(TaskReport task : tasks)
		{
			result += task + "\n";
		}
		return result;
	}
	
	/**
	 * Gets the.
	 * 
	 * @param i
	 *            the i
	 * @return the task report
	 */
	public TaskReport get(int i)
	{
		return tasks.get(i);
	}

	/**
	 * Gets the tasks.
	 * 
	 * @return the tasks
	 */
	public ArrayList<TaskReport> getTasks() {
		return tasks;
	}
	
}
