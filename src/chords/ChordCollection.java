package chords;

import java.util.ArrayList;
import java.util.Arrays;

import modes.Mode;
import notes.HarmonicNote;
import scales.Scale;
/*
 * Here we will have various forms of getting chords from a scale. 
 * The most evident one is the harmonized chords, but we'll implements many others. 
 * TODO: Think about how we'll manage the generated chords. Generate on the constructor, or on demand ? And so on..
 * */
public class ChordCollection {
	ArrayList<Chord> harmonizedChords = new ArrayList<Chord>();
	Scale scale;
	public ChordCollection(Scale scale, ArrayList<Integer> chordStructure){
		this.scale = scale;
		Chord chordBuffer;
		Integer degBuffer;
		if(chordStructure == null){ //ugly. On peut tester un Builder sinon.
			chordStructure = getDefaultStructure();
		}
		for(int i=1; i<=scale.getNotes().size(); i++){
			chordBuffer = new Chord();
			for(int j=0; j<chordStructure.size(); j++){
				degBuffer = i+chordStructure.get(j)-1;
				chordBuffer.addNote(scale.getDegree(degBuffer));
				System.out.println(degBuffer);
			}
			harmonizedChords.add(chordBuffer);
		}
	}
	public ChordCollection(Scale scale){
		this(scale, null);
	}
	
	private ArrayList<Integer >getDefaultStructure(){
		ArrayList<Integer> chordStructure = new ArrayList<Integer>();
		chordStructure.add(1);
		chordStructure.add(3);
		chordStructure.add(5);
		return chordStructure;
	}
	public ArrayList<Chord> getHarmonizedChords(){
		return harmonizedChords;
	}
	public ArrayList<Chord> getHarmonizedChordsFromMode(Mode mode){
		Scale otherScale = new Scale(scale.getFundamental(), mode);
		ChordCollection otherCollection = new ChordCollection(otherScale);
		return otherCollection.getHarmonizedChords();
	}
	public String toString(){
		return harmonizedChords.toString();
	}
	public Scale getScale(){
		return scale;
	}
}

