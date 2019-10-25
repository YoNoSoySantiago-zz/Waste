package model;
public class Residue{
	//Attributes;
	private String identifier;
	private String name;
	private String origin;
	private String color;
	private int timeToDescompose;
	private Product productToProduce;
	public final String INDUSTRUAL="industrial";
	public final String DOMICILIARY="domiciliario";
	public final String MUNICIPAL = "municipal";
	public final String BUILDING = "construccion";
	public final String HOSPITAL = "hospitalario";

	//Methods
	public Residue(String identifier, String name, String origin, String color, int timeToDescompose, Product productToProduce){
		this.identifier = identifier;
		this.name = name;
		this.origin = origin;
		this.color = color;
		this.timeToDescompose = timeToDescompose;
		this.productToProduce = productToProduce;

	}
	public String getIdentifier(){
		return this.identifier;
	}
	public String getName(){
		return this.name;
	}
	public String getOrigin(){
		return this.origin;
	}
	public String getColor(){
		return this.color;
	}
	public int getTimeToDescompose(){
		return this.timeToDescompose;
	}
	public Product getProductToProduce(){
		return this.productToProduce;
	}
	public String tipoClase(){	
		return this.getClass().getName();
	}
	

}