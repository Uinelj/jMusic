package chords;
import java.util.ArrayList;

import notes.HarmonicNote;
import notes.RythmicNote;


public class Chord {
	private ArrayList<HarmonicNote> notes;

	public Chord(ArrayList<HarmonicNote> notes){
		this.notes = notes;
	}
	public Chord(){
		notes = new ArrayList<HarmonicNote>();
	}
	
	public ArrayList<HarmonicNote> getNotes(){
		return notes;
	}
	
	public void addNote(HarmonicNote n){
		notes.add(n);
	}
	
	public void clear(){
		notes.clear();
	}
	
	/*
	 * Converts the ArrayList to a playable form, adding a note duration. This will make the Chord playable in a Player.
	 */
	public ArrayList<RythmicNote> toRythmicNote(int defaultNoteDuration){
		ArrayList<RythmicNote> ret = new ArrayList<RythmicNote>();
		for(HarmonicNote hn : notes ){
			ret.add(hn.toRythmicNote(defaultNoteDuration));
		}
		return ret;
	}
	
	public String toString(){
		return notes.toString();
	}
	/*
	 * By default, the chord will be a quarter note ( une noire ).
	 * */
	public ArrayList<RythmicNote> toRythmicNote(){
		return toRythmicNote(4);
	}
}
