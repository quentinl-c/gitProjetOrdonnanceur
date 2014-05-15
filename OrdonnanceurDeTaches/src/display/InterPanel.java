/*
 * 
 */
package display;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import tasks.TaskList;
import tasks.interMode;

// TODO: Auto-generated Javadoc
/**
 * The Class InterPanel.
 */
public class InterPanel extends JPanel {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The mode. */
	private interMode mode;
	
	/** The policy. */
	private String[] policy = {"Veuillez choisir la politique de tri", "FIFO", "SJF", "PR" ,"RR","PFIFO", "SRT"}; 
	
	/** The tab. */
	private String[] tab={"Veuillez choisir le mode d'execution","Execution iterative","Execution preemptive"};
	
	/** The directory. */
	private JFileChooser directory;
	
	/** The title. */
	private JLabel title;
	
	/** The label ref. */
	private JLabel labelRef;
	
	/** The recep time ref. */
	private JLabel recepTimeRef;
	
	/** The duration ref. */
	private JLabel durationRef;
	
	/** The pr ref. */
	private JLabel prRef;
	
	/** The q. */
	private JLabel q;
	
	/** The console. */
	private JLabel console;
	
	/** The p name. */
	private JLabel pName;
	
	/** The exec. */
	private JButton exec;
	
	/** The export. */
	private JButton export;
	
	/** The reset. */
	private JButton reset;
	
	/** The form. */
	private JPanel form;
	
	/** The center. */
	private JPanel center;
	
	/** The result. */
	private JPanel result;
	
	/** The scop. */
	private JPanel scop;
	
	/** The east. */
	private JPanel east;
	
	/** The form2. */
	private JPanel form2;
	
	/** The combo. */
	private JComboBox<String> combo;
	
	/** The combo1. */
	private JComboBox<String> combo1;
	
	/** The label. */
	private JTextField label;
	
	/** The recep time. */
	private JTextField recepTime;
	
	/** The duration. */
	private JTextField duration;
	
	/** The quantum. */
	private JTextField quantum;
	
	/** The pr. */
	private JTextField pr;
	
	/** The proj name. */
	private JTextField projName;
	
	/**
	 * Instantiates a new inter panel.
	 */
	public InterPanel(){
		this.mode = new interMode();
		this.directory = new JFileChooser();
		this.directory.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		this.labelRef = new JLabel("Label :");
		this.recepTimeRef = new JLabel("Reception : ");
		this.durationRef = new JLabel("duree :");
		this.prRef = new JLabel("pr : ");
		this.q = new JLabel("q : ");
		this.title = new JLabel("Mode interactif");
		this.console = new JLabel("Ceci est la console");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		this.exec = new JButton("ajouter et executer");
		this.pName = new JLabel("Nom du projet : ");
		exec.addActionListener(new ExecButtonListener());
		this.export = new JButton("exporter au format jSon");
		this.export.addActionListener(new ExportButtonListener());
		this.reset = new JButton("reset");
		this.reset.addActionListener(new RefreshButtonListener());
		this.label = new JTextField("blabla");
		this.label.setPreferredSize(new Dimension(50, 20));
		this.recepTime = new JTextField("0");
		this.duration = new JTextField("10");
		this.quantum = new JTextField();
		this.pr = new JTextField("1");
		this.projName = new JTextField("MonProjet");
		this.projName.setPreferredSize(new Dimension(400, 20));
		this.combo = new JComboBox<>(policy);
		this.combo1 = new JComboBox<>(tab);
		this.east = new JPanel();
		this.east.setLayout(new GridLayout(3,1));
		this.form2 = new JPanel();
		this.form2.setLayout(new BoxLayout(this.form2, BoxLayout.LINE_AXIS));
		this.form2.add(pName);
		this.form2.add(projName);
		this.result = new JPanel();
		this.result.setBackground(Color.white);
		this.result.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.result.setPreferredSize(new Dimension(20, 250));
		this.result.setAutoscrolls(true);
		this.scop = new JPanel();
		this.scop.setBackground(Color.white);
		this.scop.setBorder(BorderFactory.createLineBorder(Color.black));
		this.scop.setPreferredSize(new Dimension(20, 250));
		this.scop.add(console);
		this.setLayout(new BorderLayout());
		this.add(this.title, BorderLayout.NORTH);
		this.center = new JPanel();
		this.form = new JPanel();
		this.form.setLayout(new BoxLayout(this.form, BoxLayout.LINE_AXIS ));
		this.form.add(labelRef);
		this.form.add(label);
		this.form.add(recepTimeRef);
		this.form.add(recepTime);
		this.form.add(durationRef);
		this.form.add(duration);
		this.form.add(prRef);
		this.form.add(pr);
		this.form.add(q);
		this.form.add(quantum);
		this.center.setLayout(new BoxLayout(this.center, BoxLayout.PAGE_AXIS));
		this.center.add(combo);
		this.center.add(combo1);
		this.center.add(form);
		this.center.add(form2);
		this.center.add(result);
		this.center.add(scop);
		this.add(this.center, BorderLayout.CENTER);
		this.east.add(exec);
		this.east.add(export);
		this.east.add(reset);
		this.add(this.east, BorderLayout.EAST);

	}

	/**
	 * The listener interface for receiving execButton events. The class that is
	 * interested in processing a execButton event implements this interface,
	 * and the object created with that class is registered with a component
	 * using the component's <code>addExecButtonListener<code> method. When
	 * the execButton event occurs, that object's appropriate
	 * method is invoked.
	 * 
	 * @see ExecButtonEvent
	 */
	class ExecButtonListener implements ActionListener{

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			result.removeAll();
			DialogPanel dialogPane = new DialogPanel();
			String labelTask = label.getText();
			String repTimeTask = recepTime.getText();
			String durationTask = duration.getText();
			String prTask = pr.getText();
			String qTask =q.getText();
			TaskList tasks = mode.run(labelTask, repTimeTask, durationTask, prTask, qTask);
			JScrollPane scroll = dialogPane.disp(tasks);
			scroll.setPreferredSize(result.getSize());
			Color backColor = new Color(239, 245, 247);
			result.setBackground(backColor);
			result.add(scroll);
			result.validate();

		}

	}
	
	/**
	 * The listener interface for receiving exportButton events. The class that
	 * is interested in processing a exportButton event implements this
	 * interface, and the object created with that class is registered with a
	 * component using the component's
	 * <code>addExportButtonListener<code> method. When
	 * the exportButton event occurs, that object's appropriate
	 * method is invoked.
	 * 
	 * @see ExportButtonEvent
	 */
	class ExportButtonListener implements ActionListener{

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			int retour=directory.showOpenDialog(InterPanel.this);
			if(retour==JFileChooser.APPROVE_OPTION){
				String dirName= directory.getSelectedFile().getPath();
				System.out.println(dirName);
				String projectName = projName.getText();
				try {
					mode.JsonExport(dirName, projectName);

				} catch (IOException e1) {

					e1.printStackTrace();
				}

			}

		}
	}
	
	/**
	 * The listener interface for receiving refreshButton events. The class that
	 * is interested in processing a refreshButton event implements this
	 * interface, and the object created with that class is registered with a
	 * component using the component's
	 * <code>addRefreshButtonListener<code> method. When
	 * the refreshButton event occurs, that object's appropriate
	 * method is invoked.
	 * 
	 * @see RefreshButtonEvent
	 */
	class RefreshButtonListener implements ActionListener{

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			mode.refresh();
		}

	}



}
