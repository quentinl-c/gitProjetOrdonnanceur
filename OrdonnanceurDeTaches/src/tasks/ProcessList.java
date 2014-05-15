/*
 * 
 */
package tasks;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import tasks.comparators.FIFOComparator;
// TODO: Auto-generated Javadoc
/*
 * Cette classe permet de charger une liste de tache a partir d'un fichier (methode:load)
 * Elle permet egalement de gerer les donnees triees
 */
/**
 * The Class ProcessList.
 */
public class ProcessList
{
	
	/** The tasks. */
	BinarySearchTree<Task> tasks;
	
	/**
	 * Instantiates a new process list.
	 */
	public ProcessList(){
		this.tasks = new BinarySearchTree<Task>(new FIFOComparator());
	}

	/**
	 * Load.
	 * 
	 * @param path
	 *            the path
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void load(String path) throws IOException
	{
		InputStream ips=new FileInputStream(path);
		InputStreamReader ipsr=new InputStreamReader(ips);
		BufferedReader br=new BufferedReader(ipsr);
		try{
			int count =0;
			String line;
			String elemt[]= new String[5];
			while((line=br.readLine())!=null){
				count++;
				if(count>4){
					StringTokenizer st = new StringTokenizer(line);
					int column =0;
					while(column<=4 && st.hasMoreTokens()){
						elemt[column]=st.nextToken();
						column++;
					}
					column=0;
					int id=Integer.parseInt(elemt[0]);
					String label = elemt[1];
					int reception = Integer.parseInt(elemt[2]);
					int duration = Integer.parseInt(elemt[3]);
					String p = elemt[4].replace('-','0');
					int priority = Integer.parseInt(p);
					Task task = new Task(id, label, reception , duration, priority);
					tasks.add(task);
				}
			}

		}finally{
			br.close();
		}
	}
	
	/**
	 * Sets the tasks.
	 * 
	 * @param tasks
	 *            the new tasks
	 */
	public void setTasks(BinarySearchTree<Task> tasks) {
		this.tasks = tasks;
	}

	/**
	 * Process.
	 * 
	 * @param processor
	 *            the processor
	 * @return the task list
	 */
	public TaskList process(TaskProcessor processor)
	{
		TaskList reports = new TaskList();
		int time = 0;
		while(!tasks.isEmpty() || !processor.isEmpty())
		{
			//ajout des nouvelles taches
			Task toProcess = tasks.takeFirst();
			while(toProcess != null && toProcess.getReceiptTime() <= time)
			{
				processor.addTask(toProcess);
				toProcess = tasks.takeFirst();
			}
			//on recupere la prochaine tache et executer
			TaskReport nextToProcess = processor.getNextToProcess(time);
			//si il y a encore des taches programmees
			if(toProcess != null && nextToProcess != null
					//prochaine tache a arriver => on regarde si elle arrive avant la fin de la tache en cours
					&& toProcess.getReceiptTime() < nextToProcess.getEndTime()
					&& processor.hasToPauseFor(toProcess))
			{
						//si la tache est plus prioritaire et qu'on est dans un systame praemptif, on met en pause la tache actuelle
						processor.pauseTask(toProcess.getReceiptTime()-time);
						//on reduit la duree de la tache
						nextToProcess.setDuration(toProcess.getReceiptTime()-time);
						//et on ajoute la tache plus prioritaire
						processor.addTask(toProcess);
						time = toProcess.getReceiptTime();
						reports.addTask(nextToProcess);
			}
			else
			{
				if(toProcess != null && toProcess.getReceiptTime() > time)
					tasks.add(toProcess);
				
				reports.addTask(nextToProcess);
				
				if(nextToProcess!=null)
				{
					time = nextToProcess.getEndTime();
				}
				else if(!tasks.isEmpty())
				{
					time = tasks.getFirst().getReceiptTime();
				}
			}
		}
		return reports;
	}
}


