package gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CustomButton extends JButton {

	private String s1;
	private String s2;

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
