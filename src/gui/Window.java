package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Window extends JFrame{
		
		private JButton playPause =new JButton(new ImageIcon("images\\playpauseicon.jpg"));
		private JLabel playPauseLabel = new JLabel("Play/Pause"); //TODO quand l'utilisateur cliquera sur play le label deviendra PAUSE et inversement
		
		//CASUAL OPTIONS
		private JLabel optionsCasual  = new JLabel("CASUAL OPTIONS");
		private JLabel feelingLabel  = new JLabel("Feeling___________");
		private JLabel modeCasuLabel  = new JLabel("Mode (simple)_____");
		private JLabel scaleCasuLabel  = new JLabel("scale (simple) ____");
		private JLabel specialLabel  = new JLabel("Special___________");
		
		
		private JComboBox<String> feeling = new JComboBox<String>();
		
		private JComboBox<String> special = new JComboBox<String>();
		
		private JComboBox<String> modeCasu = new JComboBox<String>();
		
		private JComboBox<String> scaleCasu = new JComboBox<String>();
		
		//CASUAL OPTIONS
		
		//ADVENCED OPTIONS
		private JLabel optionsPro  = new JLabel("ADVENCED OPTIONS");
		private JLabel noteLabel = new JLabel("Fondamental note  __");
		private JLabel modeLabel = new JLabel("Mode & Scale_______");
		private JLabel genreLabel = new JLabel("Gender ____________");
		private JLabel chordsLabel = new JLabel("Left hand (chords)___");
		private JLabel melodyLabel = new JLabel("Right hand (melody) _");
		
		private JComboBox<String> note = new JComboBox<String>();
		
		private JComboBox<String> mode = new JComboBox<String>();
		
		private JComboBox<String> genre = new JComboBox<String>();
		
		private JComboBox<String> chords = new JComboBox<String>();
		
		private JComboBox<String> melody = new JComboBox<String>();
		
		//ADVENCED OPTIONS
		
		//GENERAL OPTIONS
		
		private JLabel optionsGeneral  = new JLabel("GENERAL OPTIONS");
		private JLabel timeUnitLabel = new JLabel("Time Unit ______");
		private JLabel melodyLengthLabel = new JLabel("Melody Length _");
		private JLabel tempoLabel = new JLabel("Tempo _____");

		
		private JFormattedTextField tempo = new JFormattedTextField(NumberFormat.getIntegerInstance());
		
		private JComboBox<String> timeUnit = new JComboBox<String>();
		
		private JComboBox<String> melodyLength = new JComboBox<String>();
		
		//GENERAL OPTIONS
		
		//INSTRUMENTS OPTIONS
		
		private JLabel optionsInstruments  = new JLabel("INSTRUMENTS");
		private JLabel labelespace  = new JLabel(".        .");
		private JLabel labelLeft  = new JLabel("LEFT HAND                           ");
		private JLabel labelRight  = new JLabel("RIGHT HAND");
		
		private JComboBox<String> rightHandCategory = new JComboBox<String>();
		private JComboBox<String> rightHand = new JComboBox<String>();
		
		private JComboBox<String> leftHandCategory = new JComboBox<String>();
		private JComboBox<String> leftHand = new JComboBox<String>();
		
		String[] optionsCategory = {"Piano", "Chromatic Percussion", "Organ",
				"Guitar", "Bass", "Strings", "Ensemble", "Brass", "Reed", "Pipe", 
				"Synth Lead", "Synth Pad", "Synth Effects"};
		
		String[] optionsPiano = {"Acoustic Grand Piano", "Bright Acoustic Piano", "Electric Grand Piano",
				"Harpsichord", "Clavinet"};
		
		String[] optionsChromaticPercussion = {"Vibraphone________", "Xylophone", "Tubular Bells"};
		
		String[] optionsOrgan = {"Percussive Organ___", "Rock Organ", "Church Organ",
				"Reed Organ", "Accordion", "Harmonica"};
		
		String[] optionsGuitar = {"Acoustic Guitar___", "Electric Guitar (jazz)", "Electric Guitar (clean)",
				"Electric Guitar (muted)", "Distortion Guitar", "Guitar Harmonics"};
		
		String[] optionsBass = {"Acoustic Bass____", "Electric Bass", "Slap Bass 1",
				"Slap Bass 2", "Synth Bass"};
		
		String[] optionsString = {"Violin_______", "Viola", "Cello",
				"Contrabass", "Tremolo", "Orchestral Harp"};
		
		String[] optionsEnsemble = {"String Ensemble____", "Synth Strings", "Choir Aahs",
				"Voice Oohs", "Orchestra Hit"};
		
		String[] optionsBrass = {"Trumpet________", "Trombone", "Tuba",
				"Muted Trumpet", "French Horn", "Brass Section"};
		
		String[] optionsReed = {"Soprano Sax_____", "Alto Sax", "Tenor Sax",
				"Baritone Sax", "Clarinet"};
		
		String[] optionsPipe = {"Piccolo_______", "Flute", "Recorder",
				"Pan Flute", "Ocarina"};
		
		String[] optionsSynthLead = {"Lead 1 (square)___", "Lead 2 (sawtooth)", "Lead 3 (calliope)",
				"Lead 6 (voice)"};
		
		String[] optionsSynthPad = {"Pad 1 (new age)___", "Pad 2 (warm)", "Pad 3 (polysynth)",
				"Pad 4 (choir)", "Pad 5 (bowed)", "Pad 6 (metallic)"};
		
		String[] optionsSynthEffects = {"FX 1 (rain)_____", "FX 2 (soundtrack)", "FX 3 (crystal)",
				"FX 4 (atmosphere)", "FX 5 (brightness)", "FX 6 (goblins)"};
		
		//INSTRUMENTS OPTIONS

		
		
		//Gridlayout principak
		private JPanel[][] container = new JPanel[4][30];
		private GridLayout grid = new GridLayout(4,30,0,0);
		
		
		private int optionsAll[] = {60, 1,1,1,1,1,1,1,50,1,1,1};
		
		private BufferedImage background;		
	
		public Window(){
			
			JFrame B = new JFrame("Background");
			
			try {
				background = ImageIO.read(new File("images\\background.jpg"));
				// Set your Image Here.
				B.setContentPane(new JLabel(new ImageIcon(background)));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			// création basique de la fenetre //
			B.setSize(background.getWidth(),background.getHeight());
			B.setTitle("Jmusic");
			B.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			B.setLocation(60,10);
			B.setResizable(false);
			B.pack();
			B.setVisible(true);
			
			
			
			// création de la barre supérieure
			
			
			  JMenuBar menubar = new JMenuBar();
		      
		      
		        JMenu file = new JMenu("File");
		        JMenu save = new JMenu("Save");
		        save.setToolTipText("save last music or current one");
		        save.addActionListener(new ActionListener() {
		            
		            public void actionPerformed(ActionEvent event) {
		                
		            }
		        });
		        JMenu load = new JMenu("Load");
		        load.setToolTipText("import a previous music");
		        load.addActionListener(new ActionListener() {
		            
		            public void actionPerformed(ActionEvent event) {
		              
		            }
		        });
		        JMenu help = new JMenu("Help");
		        help.setToolTipText("get some help about options");
		        help.addActionListener(new ActionListener() {
		            
		            public void actionPerformed(ActionEvent event) {
		                
		            }
		        });

		        JMenuItem eMenuItem = new JMenuItem("Exit");
		        eMenuItem.setToolTipText("Exit application");
		        eMenuItem.addActionListener(new ActionListener() {
		            
		            public void actionPerformed(ActionEvent event) {
		                System.exit(0);
		            }
		        });

		        file.add(eMenuItem);
		        
		        menubar.add(file);
		        menubar.add(save);
		        menubar.add(load);
		        menubar.add(help);



		        setJMenuBar(menubar);
		        
			//création barre supérieure
		
			//notre grille de surface est en 1 sur 10
		
			grid.setColumns(4);
			grid.setRows(30); 
		
			B.setLayout(grid);


				
			//les options des JComboBox
				
				//CASUAL OPTIONS

				String[] optionsFeeling = {"Sad _______________", "Happy", "Nervous",
						"Calm", "Quiet", "Furious", "Nostalgic", "Dancing", "Sleepy"};
				feeling = new JComboBox<String>(optionsFeeling);
				
				String[] optionsModeCasu = {"Major______________", "Minor"};
				modeCasu = new JComboBox<String>(optionsModeCasu);
				
				String[] optionsScaleCasu = {"European ___________", "Persian", "Asian","African","Celtic"};
				scaleCasu = new JComboBox<String>(optionsScaleCasu);
				
				String[] optionsSpecial = {"Random____________", "Epic", "Akward"};
				special = new JComboBox<String>(optionsSpecial);
				
				
				//CASUAL OPTIONS

				
				
				//ADVENCED OPTIONS
				
				String[] optionsNote = {"Do________________", "Re", "Mi",
										"Fa", "Sol", "La", "Si"};
				note = new JComboBox<String>(optionsNote);
				
				String[] optionsMode = {"Do (lydien)__________", "Re (phrygien)", "Mi (dorien)", "Fa (hypolydien)",
										"Sol (hypophrygien)", "La (hypodorien)", "Si (mixolydien)",
										"Pentat. major (jazzy)", "Pentat. minor (bluezy)", 
										"G. blues", "G. minor mld. asc.", "G. minor hamq."};
				mode = new JComboBox<String>(optionsMode);
				
				String[] optionsGenre = {"Jazz ______________", "Twelve bar blues", "Salsa",
										"Bossa", "Classic", "Blues", "RagTimeGender", "Variety"};
				genre = new JComboBox<String>(optionsGenre);
				
				String[] optionsChords = {"Chord of 5th ________", "Chord of 7th", "Chord of 9th",
										"Quinte diminuée", "7th diminuated", "9th diminuated", "RagTime", "Walk bass"};
				chords = new JComboBox<String>(optionsChords);
				
				String[] optionsMelody = {"Fast_______________", "Moderate", "Slow",
										"Wide note panel", "Tight note panel", "Basic %", "Evolutive %"};
				melody = new JComboBox<String>(optionsMelody);
				
				//ADVENCED OPTIONS
				
				//GENERAL OPTIONS
				
				String[] optionsTimeUnit = {"Noire ______________", "Blanche", "Croche",
											"Double croche", "Triple croche", "Ronde"};
				timeUnit = new JComboBox<String>(optionsTimeUnit);
				
				String[] optionsMelodyLength = {"50 ________________", "100", "150",
												"200", "300", "500", "1000","infinite"};
				melodyLength = new JComboBox<String>(optionsMelodyLength);
				
				
				//GENERAL OPTIONS
				
				//INSTRUMENTS OPTIONS
				
				
				rightHandCategory = new JComboBox<String>(optionsCategory);
				
				rightHand = new JComboBox<String>(optionsPiano);

				leftHandCategory = new JComboBox<String>(optionsCategory);

				leftHand = new JComboBox<String>(optionsPiano);
				
				tempo.setPreferredSize(new Dimension(135,30));

				
				
				//INSTRUMENTS OPTIONS

				
				
			//remplissage de la grille  avec des JPanel (rangés dans un tableau de JPanel à deux dimensions). GridLayout PRINCIPAL
				
				for(int j = 0; j < 30; j ++){ // ligne
					for(int i = 0; i <4; i ++) {   //colone
						container[i][j] = new JPanel();
						B.getContentPane().add(container[i][j]);
						container[i][j].setBackground(Color.WHITE); //zones vides ou fond de base
						container[i][j].setOpaque(false);
						
					}
				}
				
				
			
			//// placement des divers widgets (bouttons, champx de texte, labels ... ) ////
				//// ajoutés de haut en bas et de gauche à droite ////
				
				
				// POLICES ET FORMES D'ECRITURE
				
				Font policeTitre = new Font("Arial", Font.BOLD, 19);
				Font policeTexte1 = new Font("Arial",Font.BOLD, 13);
				
				//casual options
				feelingLabel.setFont(policeTexte1);
				feelingLabel.setOpaque(false);
				feelingLabel.setForeground (new Color(255,255,255,255));
				modeCasuLabel.setFont(policeTexte1);
				modeCasuLabel.setForeground (new Color(255,255,255,255));
				scaleCasuLabel.setFont(policeTexte1);
				scaleCasuLabel.setForeground (new Color(255,255,255,255));
				specialLabel.setFont(policeTexte1);
				specialLabel.setForeground (new Color(255,255,255,255));
				//pro options
				noteLabel.setFont(policeTexte1);
				noteLabel.setForeground ( new Color(255,255,255,255));
				modeLabel.setFont(policeTexte1);
				modeLabel.setForeground ( new Color(255,255,255,255));
				genreLabel.setFont(policeTexte1);
				genreLabel.setForeground ( new Color(255,255,255,255));
				chordsLabel.setFont(policeTexte1);
				chordsLabel.setForeground ( new Color(255,255,255,255));
				melodyLabel.setFont(policeTexte1);
				melodyLabel.setForeground ( new Color(255,255,255,255));
				//general options
				timeUnitLabel.setFont(policeTexte1);
				timeUnitLabel.setForeground (new Color(255,255,255,255));
				melodyLengthLabel.setFont(policeTexte1);
				melodyLengthLabel.setForeground (new Color(255,255,255,255));
				tempoLabel.setFont(policeTexte1);
				tempoLabel.setForeground (new Color(255,255,255,255));
				//instruments options
				labelLeft.setFont(policeTexte1);
				labelLeft.setForeground (new Color(255,255,255,255));
				labelRight.setFont(policeTexte1);
				labelRight.setForeground (new Color(255,255,255,255));
				
				//POLICE ET FORME D'ECRITURE
				
				
				container[0][0].add(menubar);
				
				//CASUAL OPTIONS
				
				optionsCasual.setFont(policeTitre);
				optionsCasual.setBorder(BorderFactory.createLineBorder( new Color(255,255,255,255), 5, true));
				optionsCasual.setForeground (new Color(127,221,76,255));
				
				container[0][6].add(optionsCasual);
				container[0][8].add(feeling);
				container[0][8].add(feelingLabel);
				container[0][9].add(modeCasu);
				container[0][9].add(modeCasuLabel);
				container[0][10].add(scaleCasu);
				container[0][10].add(scaleCasuLabel);
				container[0][11].add(special);
				container[0][11].add(specialLabel);

				//CASUAL OPTIONS

				
				//ADVENCED OPTIONS
				
				optionsPro.setFont(policeTitre);
				optionsPro.setBorder(BorderFactory.createLineBorder( new Color(255,255,255,255), 5, true));
				optionsPro.setForeground (new Color(233,56,63,255));
				
				container[1][6].add(optionsPro);
				container[1][8].add(note);
				container[1][8].add(noteLabel);
				container[1][9].add(mode);
				container[1][9].add(modeLabel);
				container[1][10].add(genre);
				container[1][10].add(genreLabel);
				container[1][11].add(chords);
				container[1][11].add(chordsLabel);
				container[1][12].add(melody);
				container[1][12].add(melodyLabel);

				
				
				//redéfinition de l'icone du bouton playpause
				playPause.setOpaque(false);
				playPause.setContentAreaFilled(false); // pas le bouton degeu de base
				playPause.setBorderPainted(false); // bordures
				playPause.setFocusPainted(false); 
				playPause.setIcon(new ImageIcon("images\\playpauseicon.jpg"));
				playPause.setRolloverIcon(new ImageIcon("images\\playpauseiconclicked.jpg"));
				playPause.setPressedIcon(new ImageIcon("images\\playpauseicon.jpg"));
				
				playPauseLabel.setFont(new Font("Arial",Font.BOLD, 16));
				playPauseLabel.setForeground (new Color(255,255,255,255));
				
				container[1][23].add(playPause);
				container[1][23].add(playPauseLabel);

			
				//ADVENCED OPTIONS
				
				//GENERAL OPTIONS
				
				optionsGeneral.setFont(policeTitre);
				optionsGeneral.setBorder(BorderFactory.createLineBorder( new Color(255,255,255,255), 5, true));
				optionsGeneral.setForeground (new Color(247,255,60,250));
				
				container[2][6].add(optionsGeneral);
				container[2][8].add(timeUnit);
				container[2][8].add(timeUnitLabel);
				container[2][9].add(melodyLength);
				container[2][9].add(melodyLengthLabel);
				container[2][10].add(tempo);
				container[2][10].add(tempoLabel);
				
				//GENERAL OPTIONS
				
				//INSTRUMENTS OPTIONS
				
				optionsInstruments.setFont(policeTitre);
				optionsInstruments.setBorder(BorderFactory.createLineBorder( new Color(255,255,255,255), 5, true));
				optionsInstruments.setForeground (new Color(44,117,255,255));
				
				container[3][6].add(optionsInstruments);
				container[3][8].add(labelLeft);
				container[3][8].add(labelRight);
				container[3][9].add(leftHandCategory);
				container[3][9].add(labelespace);
				container[3][9].add(rightHandCategory);
				container[3][10].add(leftHand);
				container[3][10].add(labelespace);
				container[3][10].add(rightHand);
				
				//INSTRUMENTS OPTIONS

				
				
				
			// Ajout des Listeners //
				
				
				//CASUAL OPTIONS
				
				feeling.addActionListener(new ItemAction());
				modeCasu.addActionListener(new ItemAction());
				scaleCasu.addActionListener(new ItemAction());
				special.addActionListener(new ItemAction());
				
				//CASUAL OPTIONS

				
				//ADVENCED OPTIONS
			
				note.addActionListener(new ItemAction());
				mode.addActionListener(new ItemAction());
				genre.addActionListener(new ItemAction());
				chords.addActionListener(new ItemAction());
				melody.addActionListener(new ItemAction());
				playPause.addActionListener(new PlayPauseListener());
			
				//ADVENCED OPTIONS
				
				//GENERAL OPTIONS

				timeUnit.addActionListener(new ItemAction());
				melodyLength.addActionListener(new ItemAction());
				
				//GENERAL OPTIONS
				
				//INSTRUMENTS OPTIONS
				
				leftHandCategory.addActionListener(new CategoryAction());
				leftHand.addActionListener(new leftHandAction());
				rightHandCategory.addActionListener(new CategoryAction());
				rightHand.addActionListener(new rightHandAction());
				
				//GENERAL OPTIONS

				B.setVisible(true);
		}
		
		// CLASSES DE LECTURE ET ACTIONS //
		
		class ItemAction implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				
				
				String source = ((JComboBox<String>) e.getSource()).getSelectedItem().toString(); //did it
				
				File advencedOptions = new File ("data/advancedOptions.txt");
				
				Scanner scan = null;
				try {
					scan = new Scanner(advencedOptions);
					scan.useDelimiter(";|\n");
					while(scan.hasNext()) {
						if(scan.next().equals(source)){
							int num = scan.nextInt();
							int id = scan.nextInt();
							optionsAll[num] = id;
							System.out.print(optionsAll[num]);
							System.out.println(" case " + num);
						}
					}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				finally {
					if (scan!=null) scan.close();
				}
				
			}
		}
		
		class CategoryAction implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				
				switch(leftHandCategory.getSelectedItem().toString()){ 
				
				case "Piano" :
					leftHand.setModel(new JComboBox<String>(optionsPiano).getModel());
					break;
				case "Chromatic Percussion" :
					leftHand.setModel(new JComboBox<String>(optionsChromaticPercussion).getModel());
					break;
				case "Organ" :
					leftHand.setModel(new JComboBox<String>(optionsOrgan).getModel());
					break;
				case "Guitar" :
					leftHand.setModel(new JComboBox<String>(optionsGuitar).getModel());
					break;
				case "Bass" :
					leftHand.setModel(new JComboBox<String>(optionsBass).getModel());
					break;
				case "Strings" :
					leftHand.setModel(new JComboBox<String>(optionsString).getModel());
					break;
				case "Ensemble" :
					leftHand.setModel(new JComboBox<String>(optionsEnsemble).getModel());
					break;
				case "Brass" :
					leftHand.setModel(new JComboBox<String>(optionsBrass).getModel());
					break;
				case "Reed" :
					leftHand.setModel(new JComboBox<String>(optionsReed).getModel());
					break;
				case "Pipe" :
					leftHand.setModel(new JComboBox<String>(optionsPipe).getModel());
					break;
				case "Synth Lead" :
					leftHand.setModel(new JComboBox<String>(optionsSynthLead).getModel());
					break;
				case "Synth Pad" :
					leftHand.setModel(new JComboBox<String>(optionsSynthPad).getModel());
					break;
				case "Synth Effects" :
					leftHand.setModel(new JComboBox<String>(optionsSynthEffects).getModel());
					break;
				
				}
				
				switch(rightHandCategory.getSelectedItem().toString()){ 
				
				case "Piano" :
					rightHand.setModel(new JComboBox<String>(optionsPiano).getModel());
					break;
				case "Chromatic Percussion" :
					rightHand.setModel(new JComboBox<String>(optionsChromaticPercussion).getModel());
					break;
				case "Organ" :
					rightHand.setModel(new JComboBox<String>(optionsOrgan).getModel());
					break;
				case "Guitar" :
					rightHand.setModel(new JComboBox<String>(optionsGuitar).getModel());
					break;
				case "Bass" :
					rightHand.setModel(new JComboBox<String>(optionsBass).getModel());
					break;
				case "Strings" :
					rightHand.setModel(new JComboBox<String>(optionsString).getModel());
					break;
				case "Ensemble" :
					rightHand.setModel(new JComboBox<String>(optionsEnsemble).getModel());
					break;
				case "Brass" :
					rightHand.setModel(new JComboBox<String>(optionsBrass).getModel());
					break;
				case "Reed" :
					rightHand.setModel(new JComboBox<String>(optionsReed).getModel());
					break;
				case "Pipe" :
					rightHand.setModel(new JComboBox<String>(optionsPipe).getModel());
					break;
				case "Synth Lead" :
					rightHand.setModel(new JComboBox<String>(optionsSynthLead).getModel());
					break;
				case "Synth Pad" :
					rightHand.setModel(new JComboBox<String>(optionsSynthPad).getModel());
					break;
				case "Synth Effects" :
					rightHand.setModel(new JComboBox<String>(optionsSynthEffects).getModel());
					break;
				
				}
			}
		}
		

		class leftHandAction implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				
				File InstrumentsOptions = new File ("data/instruments.txt");
				
				String source = ((JComboBox<String>) e.getSource()).getSelectedItem().toString(); 
				
				
				Scanner scan = null;
				try {
					scan = new Scanner(InstrumentsOptions);
					scan.useDelimiter(";|\n");
					while(scan.hasNext()) {
						if(scan.next().equals(source)){
							int id = scan.nextInt();
							optionsAll[9] = id;
							System.out.print(optionsAll[9]);
							System.out.println(" case " + 9);
						}
					}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				finally {
					if (scan!=null) scan.close();
				}
				
			}
		}
		
		class rightHandAction implements ActionListener {
			public void actionPerformed(ActionEvent e) {
		
				File InstrumentsOptions = new File ("data/instruments.txt");

			
				String source = ((JComboBox<String>) e.getSource()).getSelectedItem().toString(); 
								
				Scanner scan = null;
				try {
					scan = new Scanner(InstrumentsOptions);
					scan.useDelimiter(";|\n");
					while(scan.hasNext()) {
						if(scan.next().equals(source)){
							int id = scan.nextInt();
							optionsAll[10] = id;
							System.out.print(optionsAll[10]);
							System.out.println(" case " + 10);
						}
					}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				finally {
					if (scan!=null) scan.close();
				}
			}
		}
				
		class PlayPauseListener implements ActionListener {
			public void actionPerformed(ActionEvent arg0){
				//TODO ici il faut démarer le lecteur de musique et dans la fonction d'initialisation, utiliser optionsAdvenced[0] pour définir la note de départ et optionsAdvenced[1] pour définir le mode
				PlayMusic playMusic = new PlayMusic(optionsAll);
			}
		}
		
		
			
}

