package players;

import rythm.Rythm;
import chords.Chord;

public class ChordLoopPlayer extends ChordPlayer implements Runnable{
	
	public ChordLoopPlayer(int channel, int instrument, Rythm rythm){
		super(channel, instrument, rythm);
	}
	
	@Override
	public void run(){
		Chord curr;
		try{
			while(!chords.isEmpty()){
				curr = chords.removeFirst();
				play(curr);
				chords.add(curr);
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}