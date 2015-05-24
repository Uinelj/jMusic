package chords;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Permet la manipulation de la liste chaînée contenant les accords. 
 * Le nom n'est pas en accord avec la structure, mais l'objet est traité comme tel une boucle dans le player. 
 * 
 * @author Julien ABADJI
 *
 */
public class ChordLoop {
	private LinkedList<Chord> buffer;
	
	public ChordLoop(){
		buffer = new LinkedList<Chord>();
	}
	public ChordLoop(ArrayList<Chord> initialBuffer){
		buffer = new LinkedList<>(initialBuffer);
	}
	public void add(Chord toAdd){
		buffer.add(toAdd);
	}
	public void add(ArrayList<Chord> toAdd){
		for(Chord chord : toAdd){
			buffer.add(chord);
		}
	}
	public Chord removeFirst(){
		return buffer.removeFirst();
	}
	public LinkedList<Chord> getBuffer(){
		return buffer;
	}
}
