package chords;

import java.util.ArrayList;

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
	public ChordCollection(Scale scale){
		this.scale = scale;
		Chord chordBuffer;
		for(int i=1; i<=scale.getNotes().size(); i++){
			chordBuffer = new Chord();
			chordBuffer.addNote(scale.getDegree(i));
			chordBuffer.addNote(scale.getDegree((i+2)));
			chordBuffer.addNote(scale.getDegree((i+4)));
			harmonizedChords.add(chordBuffer);
		}
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

