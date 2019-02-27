package Homework00;
//Jake Powers
public class Prize {
	private String name;
	private Double prize;
	
	public Prize() {
		this.prize = 50.0;
		this.name = "no name";
	}
	public Prize(String xName, Double xPrize) {
		//TODO
		setName(xName);
		setPrize(xPrize);
	}
	
	public Double getPrize() {
		return prize;
	}
	public void setPrize(Double xPrize) {
		this.prize = xPrize;
	}
	public String getName() {
		return name;
	}
	public void setName(String xName) {
		this.name = xName;
	}
	/*
	public String print() {
		return (this.getName()+"\t"+this.getPrize());
	}
	*/
	
}
