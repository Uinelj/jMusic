package genres;

import java.util.ArrayList;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class Genre {
		
		String prettyName;
		Integer minTempo;
		Integer maxTempo;
		ArrayList<Integer> melodyInstruments = new ArrayList<Integer>();
		ArrayList<Integer> chordInstruments = new ArrayList<Integer>();
		String form;
		ArrayList<Integer> chordStructure = new ArrayList<Integer>();
		ArrayList<Integer> progression = new ArrayList<Integer>();
		String chordStyle;
		int mode;
		
	public Genre(String name) throws XPathExpressionException{ //Complexity : O(scary)
		XPathFactory xpf = XPathFactory.newInstance();
        XPath xPath = xpf.newXPath();
        InputSource is = new InputSource("trunk/data/genres/" + name + ".xml");
        
      //Name
        XPathExpression nameExpression = xPath.compile("genre//name");
      //minTempo
        XPathExpression minTempoExpression = xPath.compile("genre//tempo//min");
      //maxTempo
        XPathExpression maxTempoExpression = xPath.compile("genre//tempo//max");
      //form
        XPathExpression formExpression = xPath.compile("genre//architecture//form");
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
        XPathExpression modeExpression = xPath.compile("genre//mode");
        
        prettyName = (String) nameExpression.evaluate(is, XPathConstants.STRING);
        
        Double minTempoDouble = (Double) minTempoExpression.evaluate(is, XPathConstants.NUMBER);
        minTempo = minTempoDouble.intValue();
        
        Double maxTempoDouble = (Double) maxTempoExpression.evaluate(is, XPathConstants.NUMBER);
        maxTempo = maxTempoDouble.intValue();
        
        form = (String) formExpression.evaluate(is, XPathConstants.STRING);
        
        String progressionString = (String) progressionExpression.evaluate(is, XPathConstants.STRING);
        String[] splittedPS = progressionString.split("");
        for (int i = 0; i < splittedPS.length; i++) {
			progression.add(Integer.parseInt(splittedPS[i]));
		}
        
        String chordStructureString = (String) chordStructureExpression.evaluate(is, XPathConstants.STRING);
        String[] splittedCSS = chordStructureString.split("");
        for (int i = 0; i < splittedCSS.length; i++) {
			chordStructure.add(Integer.parseInt(splittedCSS[i]));
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
        
        Double modeDouble = (Double) modeExpression.evaluate(is, XPathConstants.NUMBER);
        mode = modeDouble.intValue();
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
	
	public String getForm(){
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
	public Integer getMode(){
		return mode;
	}
	
}