package model;
public class Inert extends Residue{
	//Attributes
	private String advice;

	//Methods
	public Inert(String advice,String identifier, String name, String origin, String color, int timeToDescompose){
		super(identifier,name,origin,color,timeToDescompose);
		this.advice = advice;

	}
	public String getAdvice(){
		return this.advice;
	}

}