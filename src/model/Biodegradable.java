package model;
public class Biodegradable extends Residue{
	//attributes
	private boolean composting;

	//mothods
	public Biodegradable(boolean composting,String identifier, String name, String origin, String color, int timeToDescompose,Product productToProduces){
		super(identifier,name,origin,color,timeToDescompose,productToProduces);
		this.composting = composting;

	}
	public boolean getComposting(){
		return this.composting;
	}

}