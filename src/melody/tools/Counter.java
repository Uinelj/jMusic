package melody.tools;

public class Counter {

	private int value;
	public Counter(int value)
	{
		setValue(value);
	}
	
	public void increment(int incrementValue)
	{
		setValue(value+incrementValue);
	}
	
	public void decrement(int decrementValue)
	{
		setValue(value-decrementValue);
	}
	
	public void setValue(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public String toString()
	{
		return ""+value;
	}
}
