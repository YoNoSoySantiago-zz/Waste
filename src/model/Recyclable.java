package model;
public class Recyclable extends Residue{
	//Attributes
	private String type;
	private String descriptionHome;
	private String descriptionIndustry;
	public final String PAPER="papel";
	public final String CARTOON="carton";
	public final String GLASS="vidrio";
	public final String PLASTIC="plastico";

	//Mothods
	public Recyclable(String type, String descriptionHome,String descriptionIndustry,String identifier, String name, String origin, String color, int timeToDescompose){
		super(identifier,name,origin,color,timeToDescompose);
		this.type = type;
		this.descriptionHome = descriptionHome;
		this.descriptionIndustry = descriptionIndustry;

	}
	public String getType(){
		return this.type;
	}
	public String getDescriptionHome(){
		return this.descriptionHome;
	}
	public String getDescriptionIndustry(){
		return this.descriptionIndustry;
	}

}