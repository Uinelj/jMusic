//Dernier changement le 19/02/2015

package notes;

import chords.Chord;

public class HarmonicNote extends Note {
	

	public HarmonicNote(int height){
		super.setHeight(height); 
	}
	public RythmicNote toRythmicNote(int length){
		return new RythmicNote(getHeight(), length);
	}
	public RythmicNote toRythmicNote(){
		return toRythmicNote(4);
	}
	@Override
	public boolean equals(Object other){
		if(other == null) return false;
		if(!(other instanceof HarmonicNote )) return false;
		HarmonicNote otherNote = (HarmonicNote) other;
		if(otherNote.getHeight()==this.getHeight()){
			return true;
		}else{
			return false;
		}
	}
	public String toString(){
		String ret="";
		ret+=getHeight();
		return ret;
	}
}
