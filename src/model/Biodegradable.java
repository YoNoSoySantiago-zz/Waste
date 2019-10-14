package model;
public class Biodegradable extends Residue{
	//attributes
	private boolean composting;

	//mothods
	public Biodegradable(boolean composting,String identifier, String name, String origin, String color, int timeToDescompose){
		super(identifier,name,origin,color,timeToDescompose);
		this.composting = composting;

	}
	public boolean getComposting(){
		return this.composting;
	}

}