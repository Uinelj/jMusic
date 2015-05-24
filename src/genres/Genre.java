package genres;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * @author Julien ABADJI
 *
 *	Genre permet d'extraire les données de genre des fichiers XML, de les convertir au bon format, et enfin de remplir au choix la forme ou la progression d'accords en fonction de la s
 *  structure du morceau
 */
public class Genre {
		
		String prettyName;
		Integer minTempo;
		Integer maxTempo;
		ArrayList<Integer> melodyInstruments = new ArrayList<Integer>();
		ArrayList<Integer> chordInstruments = new ArrayList<Integer>();
		ArrayList<Character> form = new ArrayList<Character>();
		int formLength;
		ArrayList<Integer> chordStructure = new ArrayList<Integer>();
		ArrayList<Integer> progression = new ArrayList<Integer>();
		String chordStyle;
		int melodyMode;
		int chordsMode;
		
	/**
	 * @param name - nom exact du fichier de genre, en omettant ".xml"
	 * @throws XPathExpressionException - Si le fichier xml n'est pas valide.
	 */
	public Genre(String name) throws XPathExpressionException{
		XPathFactory xpf = XPathFactory.newInstance();
        XPath xPath = xpf.newXPath();
        InputSource is = new InputSource("trunk/data/genres/" + name + ".xml"); //Nécessaire au parsage par xPath
        /*
         * On crée les requêtes propres à chaque caractéristique du genre
         * */
      //Name
        XPathExpression nameExpression = xPath.compile("genre//name");
      //minTempo
        XPathExpression minTempoExpression = xPath.compile("genre//tempo//min");
      //maxTempo
        XPathExpression maxTempoExpression = xPath.compile("genre//tempo//max");
      //form
        XPathExpression formExpression = xPath.compile("genre//architecture//form");
      //formLength
        XPathExpression formLengthExpression = xPath.compile("genre//architecture//form_length");
      //progression
        XPathExpression progressionExpression = xPath.compile("genre//architecture//progression");
      //chordStructure
        XPathExpression chordStructureExpression = xPath.compile("genre//architecture//chord_structure");
      //chordStyle
        XPathExpression chordStyleExpression = xPath.compile("genre//architecture//chord_style");
      //melodyInstruments
        XPathExpression melodyInstrumentsExpression = xPath.compile("genre//instruments//melody//instrument");
      //chordInstruments
        XPathExpression chordInstrumentsExpression = xPath.compile("genre//instruments//chords//instrument");
       //mode
        XPathExpression melodyModeExpression = xPath.compile("genre//modes//melody//mode");
        XPathExpression chordsModeExpression = xPath.compile("genre//modes//chords//mode");
        
        /*
         * On les exécute en opérant des conversions pour avoir les bons formats. 
         * */
        prettyName = (String) nameExpression.evaluate(is, XPathConstants.STRING);
        
        Double minTempoDouble = (Double) minTempoExpression.evaluate(is, XPathConstants.NUMBER);
        minTempo = minTempoDouble.intValue();
        
        Double maxTempoDouble = (Double) maxTempoExpression.evaluate(is, XPathConstants.NUMBER);
        maxTempo = maxTempoDouble.intValue();
        
        String formString = (String) formExpression.evaluate(is, XPathConstants.STRING);
        if(formString != ""){
	        String[] splittedFS = formString.split("");
	        for (int i=0; i < splittedFS.length; i++){
	        	form.add(splittedFS[i].charAt(0));
	        }
        }else{ //Si la forme n'est pas précisée, on n'aura qu'une seule entité.
        	form.add('A');
        }
        
        Double formLengthDouble = (Double) formLengthExpression.evaluate(is, XPathConstants.NUMBER);
        formLength = formLengthDouble.intValue();
        System.out.println(formLength);
        if(formLength == 0){
        	formLength = 4;
        } //Si la longueur des entités n'est pas précisée, nous aurons quatre unités de temps par entité.
        String progressionString = (String) progressionExpression.evaluate(is, XPathConstants.STRING);
        if(!(progressionString == "")){
        	form = null;
        	formLength = 0;
	        String[] splittedPS = progressionString.split("");
	        for (int i = 0; i < splittedPS.length; i++) {
				progression.add(Integer.parseInt(splittedPS[i]));
			}
        }
        
        String chordStructureString = (String) chordStructureExpression.evaluate(is, XPathConstants.STRING);
        String[] splittedCSS = chordStructureString.split("");
        if(splittedCSS[0] == ""){
        	chordStructure = null;
        }else{
	        for (int i = 0; i < splittedCSS.length; i++) {
				chordStructure.add(Integer.parseInt(splittedCSS[i]));
			}
        }
       
        chordStyle = (String) chordStyleExpression.evaluate(is, XPathConstants.STRING);

        NodeList instrumentsNode = (NodeList) melodyInstrumentsExpression.evaluate(is, XPathConstants.NODESET);
        for (int i = 0; i < instrumentsNode.getLength(); i++) {
			melodyInstruments.add(Integer.parseInt(instrumentsNode.item(i).getTextContent()));
        }
        
        instrumentsNode = (NodeList) chordInstrumentsExpression.evaluate(is, XPathConstants.NODESET);
        for (int i = 0; i < instrumentsNode.getLength(); i++) {
			chordInstruments.add(Integer.parseInt(instrumentsNode.item(i).getTextContent()));
        }
        
        String melodyModeString = (String) melodyModeExpression.evaluate(is, XPathConstants.STRING);
        melodyMode = Integer.parseInt(melodyModeString);
        String chordsModeString = (String) chordsModeExpression.evaluate(is, XPathConstants.STRING);
        chordsMode = Integer.parseInt(chordsModeString);
	}
        
	
		public int getFormLength() {
		return formLength;
	}


		public void setPrettyName(String prettyName) {
		this.prettyName = prettyName;
	}


	public void setMinTempo(Integer minTempo) {
		this.minTempo = minTempo;
	}


	public void setMaxTempo(Integer maxTempo) {
		this.maxTempo = maxTempo;
	}


	public void setMelodyInstruments(ArrayList<Integer> melodyInstruments) {
		this.melodyInstruments = melodyInstruments;
	}

	public void setMelodyInstruments(Integer melodyInstrument) {
		ArrayList<Integer> melodyInstrumentAL = new ArrayList<Integer>();
		melodyInstrumentAL.add(melodyInstrument);
		this.melodyInstruments = melodyInstrumentAL;
	}
	
	public void setChordInstruments(ArrayList<Integer> chordInstruments) {
		this.chordInstruments = chordInstruments;
	}

	public void setChordInstruments(Integer chordInstrument) {
		ArrayList<Integer> chordInstrumentAL = new ArrayList<Integer>();
		chordInstrumentAL.add(chordInstrument);
		this.melodyInstruments = chordInstrumentAL;
		this.chordInstruments = chordInstrumentAL;
	}

	public void setForm(ArrayList<Character> form) {
		this.form = form;
	}


	public void setChordStructure(ArrayList<Integer> chordStructure) {
		this.chordStructure = chordStructure;
	}


	public void setProgression(ArrayList<Integer> progression) {
		this.progression = progression;
	}


	public void setChordStyle(String chordStyle) {
		this.chordStyle = chordStyle;
	}


	public void setMelodyMode(int melodyMode) {
		this.melodyMode = melodyMode;
	}


	public void setChordsMode(int chordsMode) {
		this.chordsMode = chordsMode;
	}


		/**
		 * 
		 * Permet de créer un genre sans passer par les XML. Utile pour modifier des données extraites.
		 * @param prettyName
		 * @param minTempo
		 * @param maxTempo
		 * @param melodyInstruments
		 * @param chordInstruments
		 * @param form
		 * @param chordStructure
		 * @param progression
		 * @param chordStyle
		 * @param melodyMode
		 * @param chordsMode
		 */
		public Genre(String prettyName, Integer minTempo, Integer maxTempo,
			ArrayList<Integer> melodyInstruments,
			ArrayList<Integer> chordInstruments, ArrayList<Character> form,
			ArrayList<Integer> chordStructure, ArrayList<Integer> progression,
			String chordStyle, int melodyMode, int chordsMode) {
		super();
		this.prettyName = prettyName;
		this.minTempo = minTempo;
		this.maxTempo = maxTempo;
		this.melodyInstruments = melodyInstruments;
		this.chordInstruments = chordInstruments;
		this.form = form;
		this.chordStructure = chordStructure;
		this.progression = progression;
		this.chordStyle = chordStyle;
		this.melodyMode = melodyMode;
		this.chordsMode = chordsMode;
	}


		/**
		 * @param path - Chemin vers les xml
		 * @return - Une liste des genres disponibles
		 * @throws IOException - Si le chemin n'existe pas/ n'est pas accessible
		 */
		public static List<String> listGenres(String path) throws IOException{
			List<String> genres = new ArrayList<String>();
			File[] files = new File(path).listFiles();
			for(File file : files){
				if(file.isFile()){
					int i = file.getName().lastIndexOf('.');
					if ((i>0) && file.getName().substring(i+1).equals("xml")) {
						genres.add(file.getName().substring(0, i));
					}
				}
			}
			return genres;
			
		}
	public String getName(){
		return prettyName;
	}
	
	public int getMinTempo(){
		return minTempo;
	}
	
	public int getMaxTempo(){
		return maxTempo;
	}
	
	public ArrayList<Integer> getMelodyInstruments(){
		return melodyInstruments;
	}
	
	public ArrayList<Integer> getChordInstruments(){
		return chordInstruments;
	}
	
	public ArrayList<Character> getForm(){
		return form;
	}
	
	public ArrayList<Integer> getProgression(){
		return progression;
	}
	
	public ArrayList<Integer> getChordStructure(){
		return chordStructure;
	}
	
	public String getChordStyle(){
		return chordStyle;
	}
	public Integer getMelodyMode(){
		return melodyMode;
	}
	public Integer getChordsMode(){
		return chordsMode;
	}
	public String toString(){
		String ret ="";
		ret = "Name : " + prettyName + "\n"
		+ "minTempo : " + minTempo + "\n"
		+ "maxTempo : " + maxTempo + "\n"
		+ "Melody Instruments : " + melodyInstruments.toString() + "\n"
		+"Chord Instruments : " + chordInstruments.toString() + "\n"
		+ "Form : " + form + "\n"
		+ "Progression" + progression.toString() + "\n"
		+ "Chord Structure : " + chordStructure + "\n"
		+ "Chord Style : " + chordStyle + "\n"
		+ "Melody Mode : " + melodyMode + "\n"
		+"Chords Mode : " + chordsMode;
		
		return ret;
	}
	
}