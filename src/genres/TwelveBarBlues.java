package genres;

import java.util.LinkedList;

import chords.Chord;

public class TwelveBarBlues extends Genre{
	//TODO: Voir comment balancer la septieme..
	public TwelveBarBlues(){
		int[] melodyInstruments = { 0, 1, 2, 3, 4, 5, 24,25,26,27,28 }; //Piano and guitar
		int[] chordInstruments = { 0, 1, 2, 3, 4, 5, 24,25,26,27,28, 20, 21, 22, 23}; //Same plus bass.
	}

}
