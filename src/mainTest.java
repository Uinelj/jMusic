/*
import java.util.ArrayList;


import notes.Note;
import scales.Scale;
import modes.DiatonicCollection;
import modes.Mode;
import notes.HarmonicNote;
import notes.RythmicNote;
import templates.TrilleTemplate;

import rythm.Rythm;
import rythm.TimeSignature;
import scales.Scale;
import chords.Chord;
import chords.ChordLoop;
import chords.ChordLoopGenerator;

import java.util.ArrayList;

import modes.DiatonicCollection;
import notes.HarmonicNote;
import notes.RythmicNote;

public class mainTest {
	public static void main(String[] args){
		ArrayList<RythmicNote> buffer = new ArrayList<RythmicNote>();
		DiatonicCollection diatonicModes = new DiatonicCollection();
		Scale domaj = new Scale(new HarmonicNote(60), diatonicModes.getDiatonicModes().get(2));
		Player p = new Player(1, 1, new Rythm(new TimeSignature(4, 4, 120)));

		System.out.println(diatonicModes.getDiatonicModes().get(1).getIntervals());

		ArrayList<RythmicNote> doMajRyth = new ArrayList<RythmicNote>();
		for(HarmonicNote n : domaj.getNotes()){
			doMajRyth.add(new RythmicNote(n.getHeight(), 4));
		Rythm rythm = new Rythm(new TimeSignature(4, 4, 120));
		Player chordPlayer = new Player(1, 1, rythm);
		Scale doMaj = new Scale(new HarmonicNote(55), new Mode(1));
		ChordLoopGenerator clg = new ChordLoopGenerator(doMaj);
		ChordLoop cl = new ChordLoop(clg.getPrettyChordSuite(4));
		while(!cl.getBuffer().isEmpty()){
			try {
				Chord curr = cl.removeFirst();
				chordPlayer.playAlong(curr.toRythmicNote());
				cl.add(curr);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		try {
			p.play(doMajRyth);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<Note> test = new ArrayList<Note>();
			
		RythmicNote note = new RythmicNote(60 , 1);
		test.add(note);		
		TrilleTemplate trille = new TrilleTemplate(test);
		
	}
}
}
}
*/