package model;
import java.util.ArrayList;
public class Residue{
	//Attributes;
	private String identifier;
	private String name;
	private String origin;
	private String color;
	private int timeToDescompose;
	private ArrayList<Product> productProduces = new ArrayList<Product>();
	public final String INDUSTRUAL="industrial";
	public final String DOMICILIARY="domiciliario";
	public final String MUNICIPAL = "municipal";
	public final String BUILDING = "construccion";
	public final String HOSPITAL = "hospitalario";

	//Methods
	public Residue(String identifier, String name, String origin, String color, int timeToDescompose){
		this.identifier = identifier;
		this.name = name;
		this.origin = origin;
		this.color = color;
		this.timeToDescompose = timeToDescompose;

	}
	public String getIdentifier(){
		return this.name;
	}
	public String getName(){
		return this.identifier;
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
	public ArrayList getProductProduces(){
		return this.productProduces;
	}

}