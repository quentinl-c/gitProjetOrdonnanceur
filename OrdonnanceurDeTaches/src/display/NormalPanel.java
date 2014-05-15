/*
 * 
 */
package display;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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

import display.DialogPanel;
import tasks.ModeNormal;
import tasks.TaskList;

// TODO: Auto-generated Javadoc
/**
 * The Class NormalPanel.
 */
public class NormalPanel extends JPanel {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The title. */
	private JLabel title;
	
	/** The console. */
	private JLabel console;
	
	/** The result. */
	private JPanel result;
	
	/** The center. */
	private JPanel center;
	
	/** The east. */
	private JPanel east;
	
	/** The south. */
	private JPanel south;
	
	/** The scop. */
	private JPanel scop;
	
	/** The form. */
	private JPanel form;
	
	/** The proj name. */
	private JTextField projName;
	
	/** The proj name ref. */
	private JLabel projNameRef;
	
	/** The directory. */
	private JFileChooser directory;
	
	/** The exec button. */
	private JButton execButton;
	
	/** The select button. */
	private JButton selectButton;
	
	/** The export button. */
	private JButton exportButton;
	
	/** The combo. */
	private JComboBox<String> combo;
	
	/** The tab. */
	private String[] tab={"Veuillez choisir le mode d'execution","Execution iterative","Execution preemptive"};
	
	/** The exec mode. */
	private String execMode;
	
	/** The dir name. */
	private String dirName;
	
	/**
	 * Instantiates a new normal panel.
	 */
	public NormalPanel(){
		this.title = new JLabel("Mode normal: A partir d'un fichier");
		this.center = new JPanel();
		this.result = new JPanel();
		this.directory = new JFileChooser();
		this.execButton = new JButton("Executer");
		this.exportButton = new JButton("Exporter en JSon");
		this.selectButton = new JButton("Selectionner un fichier");
		this.east = new JPanel();
		this.south = new JPanel();
		this.scop = new JPanel();
		this.form = new JPanel();
		this.projName = new JTextField("MonProjet");
		this.projNameRef = new JLabel("Nom du projet : ");
		this.combo = new JComboBox<>(tab);
		this.form.setLayout(new BoxLayout(this.form, BoxLayout.LINE_AXIS));
		this.form.add(projNameRef);
		this.form.add(projName);
		scop.setBorder(BorderFactory.createLineBorder(Color.black));
		result.setBorder(BorderFactory.createLineBorder(Color.black));
		this.selectButton.addActionListener(new SelectButtonListener());
		this.execButton.addActionListener(new ExecButtonListener());
		this.exportButton.addActionListener(new ExportButtonListener());
		this.execMode = new String();
		this.console = new JLabel();
		this.dirName = new String();
		this.dirName = null;
		result.setLayout(new BoxLayout(result, BoxLayout.LINE_AXIS));
		result.setBackground(Color.white);
		this.console.setText("Veuillez selectionnes un fichier");
		scop.setBackground(Color.white);
		this.setLayout(new BorderLayout());
		this.add(this.title, BorderLayout.NORTH);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		this.center.setLayout(new GridLayout(4,1));
		this.combo.addItemListener(new ItemState());
		combo.addActionListener(new ItemAction());
		scop.setAutoscrolls(true);
		this.center.add(combo);
		this.center.add(form);
		this.center.add(result);
		this.scop.add(console);
		this.center.add(scop);
		this.add(center, BorderLayout.CENTER);
		this.east.setLayout(new GridLayout(3,1));
		this.east.add(selectButton);
		this.east.add(execButton);
		this.east.add(exportButton);
		this.add(east, BorderLayout.EAST);
		this.add(south, BorderLayout.SOUTH);

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
			ModeNormal mode = new ModeNormal();
			TaskList tasks = new TaskList();
			try {
				tasks = mode.run(dirName,execMode);
				
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			JScrollPane scroll = dialogPane.disp(tasks);
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
			ModeNormal exp = new ModeNormal();
			String projTitle = projName.getText();
			try {
				exp.JsonExport(dirName, execMode, projTitle);
		
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			
		}
		
	}
	
	/**
	 * The Class ItemState.
	 */
	class ItemState implements ItemListener{
		
		/* (non-Javadoc)
		 * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
		 */
		@Override
		public void itemStateChanged(ItemEvent e){

		}
	}
	
	/**
	 * The Class ItemAction.
	 */
	class ItemAction implements ActionListener{
		
		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			execMode=(String)combo.getSelectedItem();
		}               
	}
	
	/**
	 * The listener interface for receiving selectButton events. The class that
	 * is interested in processing a selectButton event implements this
	 * interface, and the object created with that class is registered with a
	 * component using the component's
	 * <code>addSelectButtonListener<code> method. When
	 * the selectButton event occurs, that object's appropriate
	 * method is invoked.
	 * 
	 * @see SelectButtonEvent
	 */
	class SelectButtonListener implements ActionListener{

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			int retour=directory.showOpenDialog(NormalPanel.this);
		    if(retour==JFileChooser.APPROVE_OPTION){
		       dirName= directory.getSelectedFile().getPath();
		       console.setText("vous avez selectionne: "+dirName);
		    }
		   
		}

	}

}
