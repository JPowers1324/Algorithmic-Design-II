package Lab05;
//Jake Powers
public class Process {
	private String name;
	private double compTime;
	
	public Process() {
		name = "No Name";
		compTime = 0.0;
	}
	public Process(String xName, double xCompTime) {
		setName(xName);
		setCompletionTime(xCompTime);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCompletionTime() {
		return compTime;
	}
	public void setCompletionTime(double compTime) {
		if (compTime > 0)
			this.compTime = compTime;
	}
	public String toString() {
		return "Name: "+this.name+"\tCompletion Time: "+this.compTime;
	}
	
}
