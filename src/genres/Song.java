package genres;

import java.util.LinkedList;

import notes.RythmicNote;
import melody.rythmicMelody.RythmicMelody;
import chords.Chord;


/**
 * @author Julien ABADJI
 *
 *	Chanson. Contient une ligne mélodique et une ligne d'accords, ainsi que la façon de jouer ces accords.
 */
public class Song {
	RythmicMelody melody;
	LinkedList<Chord> chords;
	String chordStyle;
	
	public Song(RythmicMelody melody, LinkedList<Chord> chords, String chordStyle) {
		// TODO Auto-generated constructor stub
		this.melody = melody;
		this.chords = chords;
		this.chordStyle = chordStyle;
	}

	public RythmicMelody getMelody() {
		return melody;
	}

	public LinkedList<Chord> getChords() {
		return chords;
	}
	public LinkedList<RythmicNote> getArpChords(){
		LinkedList<RythmicNote> arpNotes= new LinkedList<RythmicNote>();
		for(Chord c : chords){
			arpNotes.addAll(c.arpeggiate());
		}
		return arpNotes;
	}
	public String getChordStyle() {
		return chordStyle;
	}
	
	
}
