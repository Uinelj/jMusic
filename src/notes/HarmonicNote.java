//Dernier changement le 19/02/2015

package notes;


/**
 * HarmonicNote instancie une note harmonique, c'est a dire qui ne possède qu'une hauteur. les notes
 * Harmonique sont utilisées dans les gammes et ceratins Generator.
 *
 * @author JOHAN
 *
 */
public class HarmonicNote extends Note {
	

	/**
	 * 
	 * @param height integer de al hauteur de la note harmonique
	 */
	public HarmonicNote(int height){
		super.setHeight(height); 
	}
	/**
	 * @param length rytme que l'on veut attribuer à la harmonique note
	 * @return une rythmic note
	 */
	public RythmicNote toRythmicNote(int length){
		return new RythmicNote(getHeight(), length);
	}
	/**
	 * @return la note convertie en noire
	 */
	public RythmicNote toRythmicNote(){
		return toRythmicNote(4);
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		String ret="";
		ret+=getHeight();
		return ret;
	}
}
