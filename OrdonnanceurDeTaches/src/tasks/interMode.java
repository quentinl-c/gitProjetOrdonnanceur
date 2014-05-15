/*
 * 
 */
package tasks;

import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import tasks.comparators.FIFOComparator;
import tasks.comparators.PRComparator;
import tasks.comparators.SJFComparator;

// TODO: Auto-generated Javadoc
/**
 * The Class interMode.
 */
public class interMode {
	
	/** The id. */
	private int id;
	
	/** The tasks. */
	private BinarySearchTree<Task> tasks;
	
	/** The reports. */
	private TaskList reports;
	
	/** The policy. */
	private String policy;
	
	/** The exec mode. */
	private String execMode;

	/**
	 * Instantiates a new inter mode.
	 */
	public interMode(){
		this.id=0;
		this.tasks = new BinarySearchTree<>(new FIFOComparator());
		this.reports = new TaskList();
		this.policy = new String();
		this.policy = "FIFO";//politique par defaut
		this.execMode = new String();
	}
	
	/**
	 * Sets the policy.
	 * 
	 * @param s
	 *            the new policy
	 */
	public void setPolicy(String s){
		this.policy = s;
	}
	
	/**
	 * Sets the exec mode.
	 * 
	 * @param s
	 *            the new exec mode
	 */
	public void setExecMode(String s){
		this.execMode = s;
	}
	
	/**
	 * Run.
	 * 
	 * @param label
	 *            the label
	 * @param recepTime
	 *            the recep time
	 * @param duration
	 *            the duration
	 * @param pr
	 *            the pr
	 * @param q
	 *            the q
	 * @return the task list
	 */
	public TaskList run(String label, String recepTime, String duration, String pr, String q){
		this.id++;
		int taskRecepTime = Integer.parseInt(recepTime);
		int taskDuration = Integer.parseInt(duration);
		int taskPr = Integer.parseInt(pr);
		Task task = new Task(this.id, label, taskRecepTime, taskDuration, taskPr);
		tasks.add(task);
		BinarySearchTree<Task> tasksTemp = tasks.clone();
		ProcessList taskToDo = new ProcessList();
		taskToDo.setTasks(tasksTemp);
		if(execMode == "Execution preemptive"){
			PreemptiveTaskProcessor preemptiveProcess=null;
			switch (policy){
			case "PFIFO":
				preemptiveProcess = new PreemptiveTaskProcessor(new PRComparator());
				break;
			case "SRT":
				preemptiveProcess = new PreemptiveTaskProcessor(new SJFComparator());
				break;
			default :
				preemptiveProcess = new PreemptiveTaskProcessor(new PRComparator());
				break;
			}
			this.reports = taskToDo.process(preemptiveProcess);
		}else{
			TaskProcessor processor = null;
			switch (policy){
			case "FIFO":
				processor = new SimpleTaskProcessor(new FIFOComparator());
				break;
			case "SJF":
				processor = new SimpleTaskProcessor(new SJFComparator());
				break;
			case "PR":
				processor = new SimpleTaskProcessor(new PRComparator());
				break;
			case "RR":
				int quantum = Integer.parseInt(q);
				processor = new RRTaskProcessor(quantum);
			default :
				processor = new SimpleTaskProcessor(new FIFOComparator());
				break;
			}
			this.reports = taskToDo.process(processor); 
		}
		return reports;
	}
	
	/**
	 * Refresh.
	 */
	public void refresh(){
		this.id=0;
		this.tasks = new BinarySearchTree<>(new FIFOComparator());
	}
	
	/**
	 * Json export.
	 * 
	 * @param directory
	 *            the directory
	 * @param title
	 *            the title
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void JsonExport(String directory, String title) throws IOException{
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(reports);
		FileWriter writer = new FileWriter(title+".json");
		writer.write(json);
		writer.close();
		
		
	}
	

}
