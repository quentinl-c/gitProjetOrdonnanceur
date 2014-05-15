/*
 * 
 */
package display;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

// TODO: Auto-generated Javadoc
/**
 * The Class HomePanel.
 */
public class HomePanel extends JPanel {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The title. */
	JLabel title;
	
	/** The img. */
	Image img;
	
	/**
	 * Instantiates a new home panel.
	 * 
	 * @param img
	 *            the img
	 */
	public HomePanel(Image img){
		this.img=img;

		JLabel mainContent = new JLabel("Ce projet a ete developpe dans le cadre du module de SD");
		JLabel authors = new JLabel("Projet developpe par: REVEL Julien LAPORTE-CHABASSE Quentin");
		this.setLayout(new BorderLayout());
		this.add(mainContent, BorderLayout.CENTER);
		mainContent.setHorizontalAlignment(SwingConstants.CENTER);
		authors.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(authors, BorderLayout.SOUTH);
	
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics g){

	      g.drawImage(img, this.getWidth()-300, this.getHeight()-150, this);
            
	  }         
}
