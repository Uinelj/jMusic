package chords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import notes.HarmonicNote;
import scales.Scale;

//Meant to generate a cool chord suite. First implementation : the 2-5-1 cadenza.
public class ChordLoopGenerator {
	private ChordCollection chordCollection;
	private ArrayList<List<Integer>> chordFriends;
	private ArrayList<Chord> chordSuite;
	public ChordLoopGenerator(Scale scale){
		fillChordFriends();
		chordCollection = new ChordCollection(scale);
		chordSuite = new ArrayList<Chord>();
	}
	public ChordLoopGenerator(Scale scale, ArrayList<Integer> chordStructure){
		fillChordFriends();
		chordCollection = new ChordCollection(scale, chordStructure);
		chordSuite = new ArrayList<Chord>();
	}
	/*
	 * A friendly degree is a degree which sounds good after the initial one. 
	 * For example, the 5th degree sounds good after the 1st one.
	 * WARNING: 
	 * Degree I = chordFriends.get(0); and so on.
	 * */
	private void fillChordFriends(){
		chordFriends = new ArrayList<List<Integer>>();
		chordFriends.add(0, Arrays.asList(new Integer[]{5, 6}));
		chordFriends.add(1, Arrays.asList(new Integer[]{5}));
		chordFriends.add(2, Arrays.asList(new Integer[]{7}));
		chordFriends.add(3, Arrays.asList(new Integer[]{1}));
		chordFriends.add(4, Arrays.asList(new Integer[]{1, 6}));
		chordFriends.add(5, Arrays.asList(new Integer[]{2, 4}));
		chordFriends.add(6, Arrays.asList(new Integer[]{1}));
		
	}
	public ArrayList<List<Integer>> getAllChordFriends(){
		return chordFriends;
	}
	public List<Integer> getChordFriends(Integer degree){ //On lui file le degré I, il renvoie une List avec dedans 5 et 6.
		return chordFriends.get(degree-1);
	}
	/*
	 * A cadenza is the suite of degrees' chords. For example I-IV-II-VI.
	 * The method converts an ArrayList of Integer (1-2-5-4) and fills the chordSuite with chords related to these Integer.
	 * */
	public void makeCadenza(ArrayList<Integer> degrees){
		for(Integer i : degrees){
			chordSuite.add(chordCollection.getHarmonizedChords().get(i-1));
		}
	}
	/*
	 * This will generate random chords. 
	 * It'll have some parameters, for example the notes from the melody.
	 * For now it just have to make random things lolol.
	 * Output will be linked to the chordLoop object.
	 * */
	public ArrayList<Chord> getChordSuite(int length){
		//randoms things
		ArrayList<Integer> randDegrees = new ArrayList<Integer>();
		for(int i=0; i<length; i++){
			randDegrees.add((int)(Math.random()*7)+1); //7 en dur ? A changer.
		}
		System.out.println("Seed : " + randDegrees);
		makeCadenza(randDegrees);
		return chordSuite;
	}
	public ArrayList<Chord> getPrettyChordSuite(int length){
		return getPrettyChordSuite(length, 1);
	}
	public ArrayList<Chord> getPrettyChordSuite(int length, int startingDegree){
		int magic; //Where the magic happens.
		ArrayList<Integer> randDegrees = new ArrayList<Integer>();
		randDegrees.add(startingDegree); //We begin at the first degree.
		for(int i=1; i<length; i++){
			//System.out.println("Accord "+ (i+1) +" sur "+ (length));
			magic=(int)(Math.random()*(getChordFriends(1).size()+1));
			//magic = 0;
			//System.out.println("Magic Number : " + magic);
			if(magic < getChordFriends(randDegrees.get(i-1)).size()){
				System.out.println("H");
				randDegrees.add(i, getChordFriends(randDegrees.get(i-1)).get(magic));
				//System.out.println("Degré harmoniquement valide ajouté : " + randDegrees.get(i));
			}else{
				//System.out.println("Magic plus grand, on passe en random.");
				System.out.println("R");
				randDegrees.add((int)(Math.random()*chordCollection.getScale().getNotes().size())+1);
			}
			//System.out.println("Seed : " + randDegrees);
		}
		System.out.println(randDegrees);
		makeCadenza(randDegrees);
		return chordSuite;
	}
	public ArrayList<Chord> getModulationChords(Scale foreignScale, int numberOfChords){
		ArrayList<Chord> baseChords = chordCollection.getHarmonizedChords();
		ChordCollection foreignChordCollection = new ChordCollection(foreignScale);
		ArrayList<Chord> foreignChords = foreignChordCollection.getHarmonizedChords();
		ArrayList<Integer> commonDegrees = new ArrayList<Integer>();
		ArrayList<Chord> cleanBaseChords = new ArrayList<Chord>();
		ArrayList<Chord> cleanForeignChords = new ArrayList<Chord>();
		ArrayList<Chord> chordSuite = new ArrayList<Chord>();
		for(Chord chord : baseChords){
			cleanBaseChords.add(chord.getHarmonicChord());
		}
		for(Chord chord : foreignChords){
			cleanForeignChords.add(chord.getHarmonicChord());
		}
		//System.out.println(cleanBaseChords);
		//System.out.println(cleanForeignChords);
		for(int i=0; i<cleanForeignChords.size(); i++){
			if(cleanForeignChords.contains(cleanBaseChords.get(i))){
				commonDegrees.add(i);
			}
		}
		for(int i=0; i<numberOfChords; i++){
			chordSuite.add(baseChords.get(((int)(Math.random()*commonDegrees.size()))));
		}
		return chordSuite;
	}
	/*
	 * How to get pretty chord suites ?
	 * 
	 * */
	public ChordCollection getChordCollection(){
		return chordCollection;
	}
}
