//Dernier changement le 19/02/2015

package notes;

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
	public String toString(){
		String ret="";
		ret+=getHeight();
		return ret;
	}
}
