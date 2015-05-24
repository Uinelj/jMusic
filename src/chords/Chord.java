package chords;
import java.util.ArrayList;
import java.util.LinkedList;

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
	public Chord getHarmonicChord(){ //Notes 0 to 12, without height.
		ArrayList<HarmonicNote> fhn = new ArrayList<HarmonicNote>();
		for(HarmonicNote note : notes){
			fhn.add(new HarmonicNote(note.getHeight()%12));
		}
		return new Chord(fhn);
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
	public LinkedList<RythmicNote> arpeggiate(){
		return arpeggiate(2);
	}
	public LinkedList<RythmicNote> arpeggiate(int defaultNoteDuration){
		LinkedList<RythmicNote> arp = new LinkedList<RythmicNote>();
		for(int i=0; i<notes.size(); i++){
			arp.add(new RythmicNote(notes.get(i).getHeight(), defaultNoteDuration));
		}
		return arp;
	}
	public String toString(){
		return notes.toString();
	}
	
	@Override
	public boolean equals(Object other){
		if(other == null) return false;
		if(!(other instanceof Chord )) return false;
		Chord otherChord = (Chord) other;
		if(otherChord.getNotes().equals(this.getNotes())){
			return true;
		}else{
			return false;
		}
	}
	/*
	 * By default, the chord will be a quarter note ( une noire ).
	 * */
	public ArrayList<RythmicNote> toRythmicNote(){
		return toRythmicNote(4);
	}
}
