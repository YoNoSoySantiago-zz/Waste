package model;
import java.util.ArrayList;

public class Waste{
	//Attributes
	private ArrayList<Product> products = new ArrayList<Product>();
	private	ArrayList<Residue> residues = new ArrayList<Residue>();

	//Methods
	public void showInfoName(String name){
		int aux=-1;
		for(int i=0; i<residues.size();i++){
			if(residues.get(i).getName().equalsIgnoreCase(name)){
				aux = i;
				i = products.size();
			}
		}
		if(aux != -1){
			System.out.println("identificador: "+residues.get(i).getIdentifier());
			System.out.println("name: "+residues.get(i).getName());
			System.out.println("origin: "+residues.get(i).getOrigin());
			System.out.println("color: "+residues.get(i).getColor());
			System.out.println("Tiempo de descomposición: "+residues.get(i).getTimeToDescompose()+" dias");
			System.out.println("productos que lo producen: "/**metodo para mostrar los productos segun el nombre*/);
		}else{
			System.out.println("este producto no existe");
		}
	}

	public void showInfoIdentifier(String identifier){

	}
	public void showListProducts(){
		for(int i=0;i<products.size();i++){
			System.out.println(products.get(i).getName());
		}
	}

}