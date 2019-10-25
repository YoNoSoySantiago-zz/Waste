package model;
public class Inert extends Residue{
	//Attributes
	private String advice;

	//Methods
	public Inert(String advice,String identifier, String name, String origin, String color, int timeToDescompose,Product productToProduces){
		super(identifier,name,origin,color,timeToDescompose,productToProduces);
		this.advice = advice;

	}
	public String getAdvice(){
		return this.advice;
	}

}