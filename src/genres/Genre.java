package genres;

import java.util.LinkedList;

import chords.Chord;

public class Genre {
	//Prototype
	private int minTempo;
	private int maxTempo;
	private int[] melodyInstruments;
	private int[] chordInstruments;
	private LinkedList<Chord> chordProgression;

	public Genre(int minTempo, int maxTempo, int[] melodyInstruments, int[] chordInstruments,  LinkedList<Chord> chordProgression){
		this.minTempo = minTempo;
		this.maxTempo = maxTempo;
		this.melodyInstruments = melodyInstruments;
		this.chordInstruments = chordInstruments;
		this.chordProgression = chordProgression;
	}
}
