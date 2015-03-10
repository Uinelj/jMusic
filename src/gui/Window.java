package gui;

import java.awt.Color;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import gui.PlayMusic;

public class Window extends JFrame{
		
		private JButton playPause = new JButton("Play");
		
		private JLabel noteLabel = new JLabel("Choisissez la note fondamentale de votre morceau");
		private JLabel modeLabel = new JLabel("CHoisissez le mode de votre morceau");
	
		private JPanel[][] container = new JPanel[1][15];
		private GridLayout grid = new GridLayout();
		private JComboBox<String> note = new JComboBox<String>();
		private JComboBox<String> mode = new JComboBox<String>();
		
		private int options[] = {60, 1};
	
		public Window(){
			
			/* création basique de la fenetre */
			this.setSize(600,480);
			this.setTitle("Jmusic");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLocation(15,45); 
			/*								  */
		
			//notre grille de surface est en 1 sur 10
		
				grid.setColumns(1);
				grid.setRows(15); 
			
				this.setLayout(grid);
				
			//les options des JComboBox
				
				String[] optionsNote = {"Do", "Re", "Mi", "Fa", "Sol", "La", "Si"};
				note = new JComboBox<String>(optionsNote);
				
				String[] optionsMode = {"do (lydien)", "ré (phrygien)", "mi (dorien)", "fa (hypolydien)",
										"sol (hypophrygien)", "la (hypodorien)", "si (mixolydien)",
										"pentatonique majeur (jazzy)", "pentatonique mineur (bluezy)", 
										"gamme blues", "gamme mineure mélodique ascendante", "gamme mineure harmonique"};
				mode = new JComboBox<String>(optionsMode);
			//remplissage de la grille avec des JPanel (rangés dans un tableau de JPanel à deux dimensions).
				
				for(int j = 0; j < 15; j ++){ // ligne
					for(int i = 0; i <1; i ++) {   //colone
						container[i][j] = new JPanel();
						this.getContentPane().add(container[i][j]);
						container[i][j].setBackground(Color.LIGHT_GRAY); //zones vides ou fond de base
					}
				}
			
			//// placement des divers widgets (bouttons, champx de texte, labels ... ) ////
				//// ajoutés de haut en bas et de gauche à droite ////
			
			container[0][0].add(noteLabel);
			container[0][0].add(note);
			container[0][1].add(modeLabel);
			container[0][1].add(mode);
			container[0][2].add(playPause);
				
			// Ajout des Listeners //
			
			note.addActionListener(new ItemAction());
			mode.addActionListener(new ItemAction());
			playPause.addActionListener(new PlayPauseListener());
			
				
				this.setVisible(true);
		}
		
		// CLASSES DE LECTURE ET ACTIONS //
		
		class ItemAction implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				
				switch(note.getSelectedItem().toString()){ //swith sur note
				
				case "Do":
					options[0] = 60;
					System.out.println(options[0]);
					break;
					
				case "Re":
					options[0] = 62;
					System.out.println(options[0]);
					break;
				
				case "Mi":
					options[0] = 64;
					System.out.println(options[0]);
					break;
						
				case "Fa":
					options[0] = 65;
					System.out.println(options[0]);
					break;
				
				case "Sol":
					options[0] = 67;
					System.out.println(options[0]);
					break;
				
				case "La":
					options[0] = 69;
					System.out.println(options[0]);
					break;
				
				case "Si":
					options[0] = 71;
					System.out.println(options[0]);
					break;
				}
				
				switch(mode.getSelectedItem().toString()){
					
				case "do (lydien)":
					options[1] = 1;
					break;
				case "ré (phrygien)":
					options[1] = 2;
					break;
				case "mi (dorien)":
					options[1] = 3;
					break;
				case "fa (hypolydien)":
					options[1] = 4;
					break;
				case "sol (hypophrygien)":
					options[1] = 5;
					break;
				case "la (hypodorien)":
					options[1] = 6;
					break;
				case "si (mixolydien)":
					options[1] = 7;
					break;
				case "pentatonique majeur (jazzy)":
					options[1] = 8;
					break;
				case "pentatonique mineur (bluezy)":
					options[1] = 9;
					break;
				case "gamme blues":
					options[1] = 10;
					break;
				case "gamme mineure mélodique ascendante":
					options[1] = 11;
					break;
				case "gamme mineure harmonique":
					options[1] = 12;
					break;
				}
			}
		}
		
		
		class PlayPauseListener implements ActionListener {
			public void actionPerformed(ActionEvent arg0){
				//TODO ici il faut démarer le lecteur de musique et dans la fonction d'initialisation, utiliser options[0] pour définir la note de départ et options[1] pour définir le mode
				PlayMusic playMusic = new PlayMusic(options);
			}
		}
			
}

