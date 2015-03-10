package rythm;

public class TimeSignature {
	private int numberOfTime;//nombre de temps dans une mesure
	private int measureUnit;//unit� de temps
	private int tempo;//tempo : croche par minute
	public TimeSignature(int numberOfTime, int measureUnit, int tempo)
	{
		this.setNumberOfTime(numberOfTime);
		this.setMeasureUnit(measureUnit);
		this.setTempo(tempo);
	}

	public int getNumberOfTime() {
		return numberOfTime;
	}

	public void setNumberOfTime(int numberOfTime) {
		this.numberOfTime = numberOfTime;
	}

	public int getMeasureUnit() {
		return measureUnit;
	}

	public void setMeasureUnit(int measureUnit) {
		this.measureUnit = measureUnit;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
	
	

}
