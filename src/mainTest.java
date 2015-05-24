import java.util.ArrayList;
import java.util.LinkedList;

import modes.Mode;
import notes.HarmonicNote;
import notes.RythmicNote;
import players.ChordLoopPlayer;
import players.NotePlayer;
import players.ThreadedChordPlayer;
import players.ThreadedNotePlayer;
import rythm.Rythm;
import rythm.TimeSignature;
import scales.Scale;
import chords.Chord;
import chords.ChordCollection;
import chords.ChordLoopGenerator;

public class mainTest {
	public static void main(String[] args) {
		Rythm r = new Rythm(new TimeSignature(4, 4, 120));
		ThreadedChordPlayer tcp = new ThreadedChordPlayer(new ChordLoopPlayer(1, 12, r));
		ThreadedNotePlayer tnp = new ThreadedNotePlayer(new NotePlayer(2, 12, r));
		Scale doMaj = new Scale(new HarmonicNote(60), new Mode(10));
		
//		MelodyGenerator mg = new MelodyGenerator(doMaj, 120);
//		mg.generateMelody(30);
//		RythmedMelody rm = new RythmedMelody(mg.getMelody(), doMaj, 120, new TimeSignature(4, 4, 120));
//		rm.generateRythmicMelody();
		
		ArrayList<Integer> degreesj = new ArrayList<Integer>(); 
		degreesj.add(1);
		degreesj.add(2);
		degreesj.add(5);
		degreesj.add(6);
		ChordCollection cc = new ChordCollection(doMaj, degreesj);
		ChordLoopGenerator clg = new ChordLoopGenerator(doMaj);
		
		LinkedList<RythmicNote> buf = new LinkedList<RythmicNote>();
		LinkedList<Chord> bufl = new LinkedList<Chord>();
		buf.addAll(cc.getHarmonizedChords().get(0).arpeggiate(2));
		buf.addAll(cc.getHarmonizedChords().get(3).arpeggiate(2));
		buf.addAll(cc.getHarmonizedChords().get(5).arpeggiate(2));
		buf.addAll(cc.getHarmonizedChords().get(0).arpeggiate(2));
		buf.addAll(cc.getHarmonizedChords().get(5).arpeggiate(2));
		
//		bufl.add(cc.getHarmonizedChords().get(0));
//		bufl.add(cc.getHarmonizedChords().get(1));
//		bufl.add(cc.getHarmonizedChords().get(2));
//		bufl.add(cc.getHarmonizedChords().get(3));
//		bufl.add(cc.getHarmonizedChords().get(4));
//		bufl.add(cc.getHarmonizedChords().get(5));
//		bufl.add(cc.getHarmonizedChords().get(6));
		
		tnp.play(buf);
		//tcp.play(bufl);
	}
}