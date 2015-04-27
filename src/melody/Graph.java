package melody;

public class Graph 
{

	private int graph[][];
	int inputSize;
	int outputSize;
	
	public Graph (int inputSize, int outputSize)
	{
		graph = new int[inputSize][outputSize];
		this.inputSize=inputSize;
		this.outputSize=outputSize;
	}
	
	public void addValue(int input, int output, int value)
	{
		graph[input][output]= value;
	}
	
	
	public int totalInputPercent(int input)
	{
		int total=0;
		
		for(int i=0;i<outputSize;i++)
		{
			total=total+graph[input][i];
		}
		
		return total;
	}
	
	public boolean centPercent(int input)
	{
		return (totalInputPercent(input)==100);
	}
	
	public Integer getProba(int input, int output)
	{
		return graph[input][output];
	}
}
