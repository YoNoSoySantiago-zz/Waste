package model;
public class Residue{
	//Attributes;
	private String identifier;
	private String name;
	private String origin;
	private String color;
	private int timeToDescompose;
	private String productProduces;
	public final String INDUSTRUAL="industrial";
	public final String DOMICILIARY="domiciliario";
	public final String MUNICIPAL = "municipal";
	public final String BUILDING = "construccion";
	public final String HOSPITAL = "hospital";

	//Methods
	public Residue(String identifier, String name, String origin, String color, int timeToDescompose,String productProduces){
		this.identifier = identifier;
		this.name = name;
		this.origin = origin;
		this.color = color;
		this.timeToDescompose = timeToDescompose;
		this.productProduces = productProduces;

	}
	

}