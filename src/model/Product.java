package model;
import java.util.ArrayList;
public class Product{
	//Attributes
	private ArrayList<Residue> residues = new ArrayList<Residue>();
	private String identifier;
	private String name;
	private String description;

	//Methods
	public Product(String identifier, String name, String description){
		this.identifier = identifier;
		this.name = name;
		this.description = description;
	} 

}