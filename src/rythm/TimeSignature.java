package rythm;

import notes.RythmicNote;

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

	public float noteTime(int note)
	{
		float time=0;
		switch(note)
		{
		case 0:
			 time=1;
			 break;
		case 1:
			time=2;
			break;
		case 2:
			time=4;
			break;
		case 4:
			time=8;
			break;
		case 5:
			time=12;
			break;
		case 6:
			time=16;
			break;
		case 7:
			time=20;
			break;
		case 8:
			time=32;
			break;
		case 9:
			time=48;
			break;
		}
		
		switch (measureUnit)
		{
		case 1:
			time=time/32;
			break;
		case 2:
			time=time/16;
			break;
		case 4:
			time=time/8;
			break;
		case 8:
			time=time/4;
			break;
		}
		return time;
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
