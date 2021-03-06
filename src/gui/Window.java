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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import save.Save;



/**
 * Instancie une fen�tre pour pettre � l'utilisateur de choisir les options qu'il souhaite, de lancer la musique ou save/load le r�sultat
 * @author JOHAN
 *
 */
public class Window extends JFrame{
		
		private JButton playPause = new CustomButton("images/playpauseicon.jpg","images/playpauseiconclicked.jpg");
		private JLabel playPauseLabel = new JLabel("Play/Pause");
		private int playState = 0;
		private PlayMusic playMusic = null;
		private JOptionPane messages = new JOptionPane();
		
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
		private JLabel tempoLabel = new JLabel("Tempo ________");
		private JLabel chordLengthLabel = new JLabel("Chord Length __");
		
		private JButton tempoValidate = new CustomButton("./images/tempoValidate.jpg","./images/tempoValidateclicked.jpg");
			
		private JComboBox<String> timeUnit = new JComboBox<String>();
		
		private JComboBox<String> melodyLength = new JComboBox<String>();
		
		private JComboBox<String> chordLength = new JComboBox<String>();
		
		private JFormattedTextField tempo = new JFormattedTextField(new createMask("###"));
		
		
		
		
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
		
		
		private int optionsAll[] = {60, //case 0 -> note fondamentale
									1, // -> mode
									1, // -> gender
									1, // -> chords setting
									1, // -> melody speed
									1, // case 5 -> casu scale
									1, //-> special
									1, // -> time unit
									50, // -> melody size
									1, // -> left hand instru
									1, // case 10 -> right hand instru
									90, // -> tempo
									4 // -> number of chords in the loop
									};
		
		private BufferedImage background;		
	
		
		
		
		/**
		 * objet fenetre ne prend pas de param�tre. il est cr�� dans le mainGUI
		 */
		public Window() {
			
			JFrame B = new JFrame("Background");
			
			try {
				background = ImageIO.read(new File("images"+File.separator+"background.jpg"));

				// Set your Image Here.
				B.setContentPane(new JLabel(new ImageIcon(background)));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			// cr�ation basique de la fenetre //
		
			B.setSize(background.getWidth(),background.getHeight());
			B.setTitle("Jmusic");
			B.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			B.setLocation(60,10);
			B.setResizable(false);
			B.pack();
			B.setVisible(true);
			
			
			
			// cr�ation de la barre sup�rieure
			
			
			  JMenuBar menubar = new JMenuBar();
		      
		      
		        JMenu file = new JMenu("File");
		        
		        JButton save = new JButton("Save");
		        save.setToolTipText("save current music");
		        save.addActionListener(new ActionListener() {
		            
		            public void actionPerformed(ActionEvent event) {
		                if(playState != 0){ //si la musique tourne
		                	String fileName = JOptionPane.showInputDialog(null, "Veuiller indiquer le nom du fichier � g�n�rer: ", "Save de la melodie", JOptionPane.QUESTION_MESSAGE);
		                	String path = "data/save/"+ fileName+".ser";
		                	System.out.println("coucou1");
		                	Save newSave = new Save(path, playMusic.getCurrentMelody());
		                	System.out.println("coucou1");

		                	newSave.save(path, playMusic.getCurrentMelody());
		                	System.out.println("coucou1");

		                	
		                }
		                else{
		                	JOptionPane.showMessageDialog(null, "Vous devez g�n�rer une melodie pour l'enregistrer", "ATTENTION! Save impossible", JOptionPane.WARNING_MESSAGE);
		                }
		            }
		        });
		        JButton load = new JButton("Load");
		        load.setToolTipText("import a previous music");
		        load.addActionListener(new ActionListener() {
		            
		            public void actionPerformed(ActionEvent event) {
		              
		            }
		        });
		        JButton help = new JButton("Help");
		        help.setToolTipText("get some help about options");
		        help.addActionListener(new ActionListener(){
		            
		            public void actionPerformed(ActionEvent event) { //fenetre de dialogue qui affiches des astuces et des aides en r�cuprant les string dans le txt data helpTexts.
		            	
		            	String options1[] = {"Quit","Next"};
		            	String options2[] = {"Quit","Previous","Next"};
		            	String options3[] = {"Previous","Exit"};


		            	int tips = 1;
		            	int page = 0;
		            	int pageMax = pageMax();
		            	
		            	while(tips != 0){
		            	File HelpText = new File ("data/helpTexts.txt");		    													
						Scanner scan = null;
						
						try {
							scan = new Scanner(HelpText);
							scan.useDelimiter(";|\n");
							while(scan.hasNext()) {
								if(scan.next().equals(Integer.toString(page))){
									
									String message = scan.next();
									message = message.replace("*","\n");
									
									JTextArea textArea = new JTextArea(10,50);
									textArea.setText(message);
									textArea.setEditable(false);
									JScrollPane scrollPane = new JScrollPane(textArea);
									textArea.setCaretPosition(0);//ligne pour mettre le scroll en haut
		        									
									if(page == 0){
						            	int result = JOptionPane.showOptionDialog(null, scrollPane, "Help",JOptionPane.CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options1, options1[1]);
						            	if(options1[result].equals("Next")){
						            			
						            		tips = 1;
						            		page ++;
						            	
						            	}
						            	else tips = 0;
									}
									else if(page < pageMax){
						            	int result = JOptionPane.showOptionDialog(null, scrollPane, "Help",JOptionPane.CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options2, options2[1]);
						            	if(options2[result].equals("Next")){
						            			
						            		tips = 1;
						            		page ++;
						            	
						            	}
						            	else if(options2[result].equals("Previous")){
					            			
						            		tips = 1;
						            		page --;
						            	
						            	}
						            	else tips = 0;
									}
									else if(page == pageMax){
										
										int result = JOptionPane.showOptionDialog(null, scrollPane, "Help",JOptionPane.CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options3, options3[1]);
						            	if(options3[result].equals("Previous")){
						            			
						            		tips = 1;
						            		page --;
						            	
						            	}
						            	else tips = 0;
									}
					            	
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
		        });

		        JMenuItem exit = new JMenuItem("Exit");
		        exit.setToolTipText("Exit application");
		        exit.addActionListener(new ActionListener() {
		            
		            public void actionPerformed(ActionEvent event) {
		                System.exit(0);
		            }
		        });

		        file.add(exit);
		        
		        menubar.add(file);
		        menubar.add(save);
		        menubar.add(load);
		        menubar.add(help);



		        setJMenuBar(menubar);
		        
			//cr�ation barre sup�rieure
		
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
										"Quinte diminu�e", "7th diminuated", "9th diminuated", "RagTime", "Walk bass"};
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
				
				String[] optionschordLength = {"uniq. chord__________","sequ. of 2","sequ. of 3","sequ. of 4","sequ. of 5","sequ. of 6","sequ. of 8","sequ. of 10"};
				chordLength = new JComboBox<String>(optionschordLength);
				
				
				tempo.setPreferredSize(new Dimension(90,30));
				tempo.setText("100");
				
				
				
				
				//GENERAL OPTIONS
				
				//INSTRUMENTS OPTIONS
				
				
				rightHandCategory = new JComboBox<String>(optionsCategory);
				
				rightHand = new JComboBox<String>(optionsPiano);

				leftHandCategory = new JComboBox<String>(optionsCategory);

				leftHand = new JComboBox<String>(optionsPiano);
				

				
				//INSTRUMENTS OPTIONS

				
				
			//remplissage de la grille  avec des JPanel (rang�s dans un tableau de JPanel � deux dimensions). GridLayout PRINCIPAL
				
				for(int j = 0; j < 30; j ++){ // ligne
					for(int i = 0; i <4; i ++) {   //colone
						container[i][j] = new JPanel();
						B.getContentPane().add(container[i][j]);
						container[i][j].setBackground(Color.WHITE); //zones vides ou fond de base
						container[i][j].setOpaque(false);
						
					}
				}
				
				
			
			//// placement des divers widgets (bouttons, champx de texte, labels ... ) ////
				//// ajout�s de haut en bas et de gauche � droite ////
				
				
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
				chordLengthLabel.setFont(policeTexte1);
				chordLengthLabel.setForeground (new Color(255,255,255,255));
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

				
				
				playPauseLabel.setFont(new Font("Arial",Font.BOLD, 16));
				playPauseLabel.setForeground (new Color(255,255,255,255));
				
				container[1][23].add(playPause);
				container[1][23].add(playPauseLabel);

			
				//ADVENCED OPTIONS
				
				//GENERAL OPTIONS
				
				optionsGeneral.setFont(policeTitre);
				optionsGeneral.setBorder(BorderFactory.createLineBorder( new Color(255,255,255,255), 5, true));
				optionsGeneral.setForeground (new Color(247,255,60,250));
				
				tempo.setFocusLostBehavior(JFormattedTextField.PERSIST);
				
				chordLength.setSelectedItem("sequ. of 4");
				
				
				container[2][6].add(optionsGeneral);
				container[2][8].add(timeUnit);
				container[2][8].add(timeUnitLabel);
				container[2][9].add(melodyLength);
				container[2][9].add(melodyLengthLabel);
				container[2][10].add(tempo);
				container[2][10].add(tempoValidate);
				container[2][10].add(tempoLabel);
				container[2][11].add(chordLength);
				container[2][11].add(chordLengthLabel);
				
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
				chordLength.addActionListener(new ItemAction());
				tempoValidate.addActionListener(new tempoAction());


				//GENERAL OPTIONS
				
				//INSTRUMENTS OPTIONS
				
				leftHandCategory.addActionListener(new LeftHandCategoryAction());
				leftHand.addActionListener(new leftHandAction());
				rightHandCategory.addActionListener(new RightHandCategoryAction());
				rightHand.addActionListener(new rightHandAction());
				
				//GENERAL OPTIONS

				B.setVisible(true);
		}
		
		// CLASSES DE LECTURE ET ACTIONS //
		
		/**
		 * g�re les actions sur les options casual pro et g�n�rales. Utilise des data.txt qui continennent les infos n�cessaire.
		 * @author JOHAN
		 *
		 */
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
		
		/**
		 * leftHandCategoryAction modifie les sous options de le main gauche.
		 * @author JOHAN
		 *
		 */
		class LeftHandCategoryAction implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String source = ((JComboBox<String>) e.getSource()).getSelectedItem().toString(); 

				switch(source){ 
				
				case "Piano" :
					leftHand.setModel(new JComboBox<String>(optionsPiano).getModel());
					optionsAll[9] = 1;
					break;
				case "Chromatic Percussion" :
					leftHand.setModel(new JComboBox<String>(optionsChromaticPercussion).getModel());
					optionsAll[9] = 12;
					break;
				case "Organ" :
					leftHand.setModel(new JComboBox<String>(optionsOrgan).getModel());
					optionsAll[9] = 18;
					break;
				case "Guitar" :
					leftHand.setModel(new JComboBox<String>(optionsGuitar).getModel());
					optionsAll[9] = 25;
					break;
				case "Bass" :
					leftHand.setModel(new JComboBox<String>(optionsBass).getModel());
					optionsAll[9] = 33;
					break;
				case "Strings" :
					leftHand.setModel(new JComboBox<String>(optionsString).getModel());
					optionsAll[9] = 41;
					break;
				case "Ensemble" :
					leftHand.setModel(new JComboBox<String>(optionsEnsemble).getModel());
					optionsAll[9] = 49;
					break;
				case "Brass" :
					leftHand.setModel(new JComboBox<String>(optionsBrass).getModel());
					optionsAll[9] = 57;
					break;
				case "Reed" :
					leftHand.setModel(new JComboBox<String>(optionsReed).getModel());
					optionsAll[9] = 65;
					break;
				case "Pipe" :
					leftHand.setModel(new JComboBox<String>(optionsPipe).getModel());
					optionsAll[9] = 73;
					break;
				case "Synth Lead" :
					leftHand.setModel(new JComboBox<String>(optionsSynthLead).getModel());
					optionsAll[9] = 81;
					break;
				case "Synth Pad" :
					leftHand.setModel(new JComboBox<String>(optionsSynthPad).getModel());
					optionsAll[9] = 89;
					break;
				case "Synth Effects" :
					leftHand.setModel(new JComboBox<String>(optionsSynthEffects).getModel());
					optionsAll[9] = 97;
					break;
				
				}
			}
		}
				/**
				 * modifie les sous options des instruments de la main droite.
				 * @author JOHAN
				 *
				 */
				class RightHandCategoryAction implements ActionListener {
					public void actionPerformed(ActionEvent e) {
						String source = ((JComboBox<String>) e.getSource()).getSelectedItem().toString(); 

				switch(rightHandCategory.getSelectedItem().toString()){ 
				
				case "Piano" :
					rightHand.setModel(new JComboBox<String>(optionsPiano).getModel());
					optionsAll[10] = 1;
					break;
				case "Chromatic Percussion" :
					rightHand.setModel(new JComboBox<String>(optionsChromaticPercussion).getModel());
					optionsAll[10] = 12;
					break;
				case "Organ" :
					rightHand.setModel(new JComboBox<String>(optionsOrgan).getModel());
					optionsAll[10] = 18;
					break;
				case "Guitar" :
					rightHand.setModel(new JComboBox<String>(optionsGuitar).getModel());
					optionsAll[10] = 25;
					break;
				case "Bass" :
					rightHand.setModel(new JComboBox<String>(optionsBass).getModel());
					optionsAll[10] = 33;
					break;
				case "Strings" :
					rightHand.setModel(new JComboBox<String>(optionsString).getModel());
					optionsAll[10] = 41;
					break;
				case "Ensemble" :
					rightHand.setModel(new JComboBox<String>(optionsEnsemble).getModel());
					optionsAll[10] = 49;
					break;
				case "Brass" :
					rightHand.setModel(new JComboBox<String>(optionsBrass).getModel());
					optionsAll[10] = 57;
					break;
				case "Reed" :
					rightHand.setModel(new JComboBox<String>(optionsReed).getModel());
					optionsAll[10] = 65;
					break;
				case "Pipe" :
					rightHand.setModel(new JComboBox<String>(optionsPipe).getModel());
					optionsAll[10] = 73;
					break;
				case "Synth Lead" :
					rightHand.setModel(new JComboBox<String>(optionsSynthLead).getModel());
					optionsAll[10] = 81;
					break;
				case "Synth Pad" :
					rightHand.setModel(new JComboBox<String>(optionsSynthPad).getModel());
					optionsAll[10] = 89;
					break;
				case "Synth Effects" :
					rightHand.setModel(new JComboBox<String>(optionsSynthEffects).getModel());
					optionsAll[10] = 97;
					break;
				
					}			
				}
			}

		/**
		 * LeftHandAction g�re les modifications d'instruments dans les sous cat�gories d'instruments. Il parse un data.txt qui contient les infos n�cessaires.
		 * @author JOHAN
		 *
		 */
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
		
		/**
		 * de meme que leftHand action mais pour la main droite
		 * @author JOHAN
		 *
		 */
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
		
		
		/**
		 * tempoaction g�re l'�v�nement "clique" sur valider le tempo. Il modifie la case du tableau d'options coresspondante.
		 * @author JOHAN
		 *
		 */
		class tempoAction implements ActionListener {
			public void actionPerformed(ActionEvent e){
				int i = 0;
				String fieldString = "";
				String main = tempo.getText();
				if(Character.toString(main.charAt(0)).equals("0")){
					
					
					fieldString = "0"+Character.toString(main.charAt(1)) + Character.toString(main.charAt(2));
					
					
					if(Character.toString(main.charAt(1)).equals("0")){
						
						i = Integer.parseInt(Character.toString(main.charAt(2)));
						fieldString = "00"+Character.toString(main.charAt(2));
						
						if(Character.toString(main.charAt(2)).equals("0")){
							
							i = 30;
							fieldString = "030";
						}
					}
					else if(Character.toString(main.charAt(2)).equals(" ")){
					i = Integer.parseInt(main.substring(1,2));
					}
					else{
					i = Integer.parseInt(main.substring(1));
					}
					tempo.setText(fieldString);	
				}
				
			
				if(Character.toString(main.charAt(2)).equals(" ")){
					
					
					fieldString = "0" + main;
				
					if(Character.toString(main.charAt(1)).equals(" ")){
						
						if(Character.toString(main.charAt(0)).equals(" ")){
							fieldString = "030";
							i = 30;
						}
						else{
						i = Integer.parseInt(main.substring(0,1));
						}
						fieldString = "00" + main;
					}
					else{
					i = Integer.parseInt(main.substring(0,2));
					}
					tempo.setText(fieldString);	

				}
				
				if(!(Character.toString(main.charAt(2)).equals(" "))){
					
					i = Integer.parseInt(tempo.getText());
					
				}
				
				
				optionsAll[11] = i;
				System.out.println(optionsAll[11]);
					
			}
		}
		
				
		/**
		 * PlayPauseListener g�re les �vnements du boutton playpause, il lance la musique en cr�ant un nouvel objet playmusic
		 * et en envoyant en param�tres les optiosn de l'utilisateur.
		 * Cliqu� une nouvelle fois le listener d�truit playmusic en appelant sa m�thode stopMuic()
		 * @author JOHAN
		 *
		 */
		class PlayPauseListener implements ActionListener {
			public void actionPerformed(ActionEvent arg0){

				switch(playState){
				case 0:
				playMusic = new PlayMusic(optionsAll);
				playState = 1;
				break;
				case 1 :
				playMusic.stopMusic();
				playState = 0;
				break;
				default :
				playState = 0;
				}

			}
		}
		
		/**
		 * @return le nombre max de page de la fenetre help
		 */
		public int pageMax(){
			
			int pageMax = 0;
			
			File helpTextsOptions = new File ("data/helpTexts.txt");			
							
			Scanner scan = null;
			
			try {
				scan = new Scanner(helpTextsOptions);
				scan.useDelimiter(";|\n");
				while(scan.hasNext()) {
					if(scan.next().equals(Integer.toString(pageMax))){
					pageMax ++;
					}
				}
				pageMax --;
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			finally {
				if (scan!=null) scan.close();
			}
			
			System.out.println(pageMax);
			
			return pageMax;
		}
		
			
}

