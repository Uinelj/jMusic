package players;

import java.util.LinkedList;

import rythm.Rythm;
import chords.Chord;

public class ChordPlayer extends Player implements Runnable{
	LinkedList<Chord> chords;
	public ChordPlayer(int channel, int instrument, Rythm rythm){
		super(channel, instrument, rythm);
	}
	@Override
	public void run(){
		try{
			while(!chords.isEmpty()){
				play(chords.removeFirst());
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	public void fill(LinkedList<Chord> chords){
		this.chords = chords;
	}
}
