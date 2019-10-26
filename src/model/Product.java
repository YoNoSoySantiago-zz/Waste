package model;
import java.util.ArrayList;
public class Product{
	//Attributes
	private ArrayList<Residue> residues = new ArrayList<Residue>();
	private String identifier;
	private String name;
	private String description;

	//Methods
	public Product(String identifier, String name, String description, Residue residue){
		this.identifier = identifier;
		this.name = name;
		this.description = description;
		residues.add(residue);
	} 
	public String getIdentifier(){
		return this.identifier;
	}
	public String getName(){
		return this.name;
	}
	public String getDescription(){
		return this.description;
	}
	public ArrayList<Residue> getResidues(){
		return this.residues;
	}
	public void setResidue(Residue residue){
		residues.add(residue);
	}

}