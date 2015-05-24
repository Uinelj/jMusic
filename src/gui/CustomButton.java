package gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * customButton permet de créer un bouton personnalisé qui possède les icon de path s1 et s2
 * le premier icon détermine l'état passif du bouton et le second l'état actif (par exemple quand on survole de la souris
 * le bouton)
 * 
 * 
 * @author JOHAN
 *
 */
public class CustomButton extends JButton {

	private String s1;
	private String s2;

	/**
	 * @param s1 path du premier icon
	 * @param s2 path du second icon
	 */
	public CustomButton(String s1 , String s2){ //s1 cest limage de base et s2 limage quand on scroll dessus
		
		
		this.setOpaque(false);
		this.setContentAreaFilled(false); // pas le bouton degeu de base
		this.setBorderPainted(false); // bordures
		this.setFocusPainted(false); 
		this.setIcon(new ImageIcon(s1));
		this.setRolloverIcon(new ImageIcon(s2));
		this.setPressedIcon(new ImageIcon(s1));
		
		
	}
}
