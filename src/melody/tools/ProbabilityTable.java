package melody.tools;

import java.util.ArrayList;

public class ProbabilityTable {
	
	private ArrayList<Integer> proba;
	
	public ProbabilityTable()
	{
		proba = new ArrayList<Integer>();
	}

	@Override
	public String toString() {
		return "ProbabilityTable [proba=" + proba + "]";
	}

	public ArrayList<Integer> getProba() {
		return proba;
	}

	public void setProba(ArrayList<Integer> proba) {
		this.proba = proba;
	}
	
	public void add(Integer probability)
	{
		proba.add(probability);
	}
	
	public void remove(int index)
	{
		proba.remove(index);
	}
	
	public void removeFirst()
	{
		proba.remove(0);
	}
	
	public void samePercent(Integer percent)
	{
		while(total()<100-percent)
		{
			proba.add(percent);
		}
		
		if(!centPercent())
		{
			int rest = 100-total();
			proba.add(rest);
		}
	}
	public int total()
	{
		int total=0;
		
		for(int i=0;i<proba.size();i++)
		{
			total=total+proba.get(i);
		}
		
		return total;
	}
	
	public boolean centPercent()
	{
		return (total()==100);
	}
	
	public Integer getProba(int index)
	{
		return proba.get(index);
	}
}
