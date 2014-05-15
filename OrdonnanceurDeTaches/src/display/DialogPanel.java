/*
 * 
 */
package display;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import tasks.TaskList;
import tasks.TaskReport;

// TODO: Auto-generated Javadoc
/**
 * The Class DialogPanel.
 */
public class DialogPanel extends JPanel {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The content. */
	private JPanel content;
	
	/**
	 * Instantiates a new dialog panel.
	 */
	public DialogPanel(){
		this.content = new JPanel();
		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
	}

	/**
	 * Disp.
	 * 
	 * @param tasks
	 *            the tasks
	 * @return the j scroll pane
	 */
	public JScrollPane disp(TaskList tasks){
		for(TaskReport task : tasks.getTasks()){
			JPanel taskPanel = new JPanel();
			JPanel center = new JPanel();
			JPanel left = new JPanel();
			JPanel right = new JPanel();
			Color blueColor = new Color(0,162,226);
			Color greenColor = new Color(118,196,117);
			center.setBackground(blueColor);
			left.setBackground(greenColor);
			right.setBackground(greenColor);
			taskPanel.setLayout(new BorderLayout());
			JLabel label = new JLabel();
			label.setText(task.getLabel());
			center.add(label);
			taskPanel.add(center, BorderLayout.CENTER);
			taskPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			JLabel begTime = new JLabel();
			begTime.setText(Integer.toString(task.getBeginTime()));
			left.add(begTime);
			taskPanel.add(left, BorderLayout.WEST);
			JLabel endTime = new JLabel();
			endTime.setText(Integer.toString(task.getEndTime()));
			right.add(endTime);
			taskPanel.add(right, BorderLayout.EAST);
			this.content.add(taskPanel);
		}
		Color backColor = new Color(239, 245, 247);
		content.setBackground(backColor);
		JScrollPane scroll = new JScrollPane(content);
		return scroll;
	}

}
