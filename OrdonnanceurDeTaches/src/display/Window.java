/*
 * 
 */
package display;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class Window.
 */
public class Window extends JFrame{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The cl. */
	CardLayout cl = new CardLayout();
	
	/** The content. */
	JPanel content = new JPanel();
	//Liste des noms de nos conteneurs pour la pile de cartes
	/** The list content. */
	String[] listContent = {"Accueil", "Mode Normal", "Mode interactif"};
	
	/** The indice. */
	int indice = 0;

	/**
	 * Instantiates a new window.
	 */
	public Window(){
		this.setTitle("Ordonnanceur de Taches");
		this.setSize(640, 480);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		JPanel accueil = new HomePanel(new ImageIcon("tn.png").getImage());	
		JPanel normal = new NormalPanel();		
		JPanel interactif = new InterPanel();
		JPanel buttonPane = new JPanel();
		JButton buttonAcc = new JButton("Acceuil");

		buttonAcc.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){
				cl.show(content, listContent[0]);
			}
		});

		JButton buttonNorm = new JButton("Mode Normal");

		buttonNorm.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){				
				cl.show(content, listContent[1]);
			}
		});
		JButton buttonInter = new JButton("Mode Interactif");
		buttonInter.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){				
				cl.show(content, listContent[2]);
			}
		});

		buttonPane.add(buttonAcc);
		buttonPane.add(buttonNorm);
		buttonPane.add(buttonInter);
		//On definit le layout
		content.setLayout(cl);
		//On ajoute les cartes a la pile avec un nom pour les retrouver
		content.add(accueil, listContent[0]);
		content.add(normal, listContent[1]);
		content.add(interactif, listContent[2]);

		this.getContentPane().add(buttonPane, BorderLayout.NORTH);
		this.getContentPane().add(content, BorderLayout.CENTER);
		this.setVisible(true);
	}	
}