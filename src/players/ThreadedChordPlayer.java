package players;

import java.util.LinkedList;

import chords.Chord;

public class ThreadedChordPlayer{
	ChordPlayer player;
	Thread thread;
	public ThreadedChordPlayer(ChordPlayer player) {
		this.player = player;
		thread = new Thread(player);
	}
	
	public void play(LinkedList<Chord> notes){
		player.fill(notes);
		thread.start();
	}
	public void stop(){
		thread.interrupt();
	}
	public Player getChordPlayer(){
		
		return this.player;
	}
}
