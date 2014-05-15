/*
 * 
 */
package tasks;



import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import tasks.comparators.*;

// TODO: Auto-generated Javadoc
/**
 * The Class ModeNormal.
 */
public class ModeNormal {
	
	/** The result. */
	String result ;
	
	/** The reports. */
	TaskList reports;
	
	/**
	 * Instantiates a new mode normal.
	 */
	public ModeNormal(){
		result = new String();
	}
	
	/**
	 * Run.
	 * 
	 * @param str
	 *            the str
	 * @param execMod
	 *            the exec mod
	 * @return the task list
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public TaskList run(String str, String execMod) throws IOException{
		this.result = new String();
			ProcessList taskToDo = new ProcessList();
			taskToDo.load(str);
			String policy = sortPolicy(str);
			int q=0;
			String s = policy.substring(0, 2);
			if(s.equals("RR")){
				q=Integer.parseInt(policy.substring(policy.length()-1,policy.length()));
				policy="RR";
			}
			if(execMod=="Execution iterative"){
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
					processor = new RRTaskProcessor(q);
				default :
					processor = new SimpleTaskProcessor(new FIFOComparator());
					break;
				}
				this.reports = taskToDo.process(processor);
		
			}
		

		
	
			return reports;
		
	}
	
	/**
	 * Sort policy.
	 * 
	 * @param directory
	 *            the directory
	 * @return the string
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@SuppressWarnings("finally")
	public static String sortPolicy(String directory) throws IOException{
		String result=null;
		InputStream ips=new FileInputStream(directory);
		InputStreamReader ipsr=new InputStreamReader(ips);
		BufferedReader br=new BufferedReader(ipsr);
		try{
			int count =0;
			String line;
			while((line=br.readLine())!=null && count<3){
				count++;
				if(count==2){
					 result = line;
				}

			}
		}finally{
			br.close();
			return result;
		}


	}
	
	/**
	 * Json export.
	 * 
	 * @param directory
	 *            the directory
	 * @param execMod
	 *            the exec mod
	 * @param title
	 *            the title
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void JsonExport(String directory, String execMod, String title) throws IOException{
		this.run(directory, execMod);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(reports);
		FileWriter writer = new FileWriter(title+".json");
		writer.write(json);
		writer.close();
		
	}
	
}