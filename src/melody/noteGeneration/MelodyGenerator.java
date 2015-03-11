package melody.noteGeneration;

import notes.HarmonicNote;

public abstract class MelodyGenerator {

	private Melody melody;
	
	abstract Melody generateMelody(Integer index);

	abstract Integer rules(Integer position);
	
	protected Melody getMelody()
	{
		return melody;
	}
	
	protected HarmonicNote getFirst()
	{
		return melody.getFirst();
	}


	@Override
	public String toString() {
		return "MelodyGenerator [melody=" + melody + "]";
	}
	
	
}
