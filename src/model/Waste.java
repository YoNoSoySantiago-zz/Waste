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
			System.out.println("identificador: "+residues.get(aux).getIdentifier());
			System.out.println("name: "+residues.get(aux).getName());
			System.out.println("origin: "+residues.get(aux).getOrigin());
			System.out.println("color: "+residues.get(aux).getColor());
			System.out.println("Tiempo de descomposición: "+residues.get(aux).getTimeToDescompose()+" dias");
			System.out.println("productos que lo producen: "/**metodo para mostrar los productos segun el nombre*/);
		}else{
			System.out.println("este residuo no existe");
		}
	}

	public void showInfoIdentifier(String identifier){
		int aux=-1;
		for(int i=0; i<residues.size();i++){
			for(int j=0;j<residues.get(i).getProductProduces().size();j++){
			if(residues.get(i).getProductProduces().get(j).getIdentifier().equalsIgnoreCase(identifier)){
				aux = i;
				i = residues.size();
				j = products.size();
			}
		}
		}
		if(aux != -1){
			System.out.println("identificador: "+residues.get(aux).getIdentifier());
			System.out.println("name: "+residues.get(aux).getName());
			System.out.println("origin: "+residues.get(aux).getOrigin());
			System.out.println("color: "+residues.get(aux).getColor());
			System.out.println("Tiempo de descomposición: "+residues.get(aux).getTimeToDescompose()+" dias");
			System.out.println("productos que lo producen: "/**metodo para mostrar los productos segun el nombre*/);
		}else{
			System.out.println("este residuo no existe");
		}
	}
	public void showListProducts(){
		for(int i=0;i<products.size();i++){
			System.out.println(products.get(i).getName());
		}
	}
	public String showIdentifierProduct(String name){
		String result="";
		for(int i=0;i<products.size();i++){
			if(products.get(i).getName().equalsIgnoreCase(name)){
				result = products.get(i).getIdentifier();
				i = products.size();
			}
		}
		return result;
	}
	public double calculateEfectPlanet(String residueName){
		Residue residue;
		Biodegradable biodegradable;
		int aux=-1;
		double result = 0;
		for(int i = 0;i<residues.size();i++){
			if(residues.get(i).getName().equalsIgnoreCase(residueName)){
				aux = i;
				i = residues.size();
			}
		}
		if(aux != -1){
			switch (residues.get(aux).getOrigin()){
				case "idustrial":
				result = 0.1;
				break;
				case "domiciliario":
				result = 0.05;
				break;
				case "municipal":
				result = 0.08;
				break;
				case "construccion":
				result = 0.12;
				break;
				case "hospitalario":
				result = 0.15;
				break;

		}
		result *= residues.get(aux).getTimeToDescompose();
		if(residues.get(aux) instanceof Recyclable){
			result -= result*0.02;
		}else if(residues.get(aux) instanceof Biodegradable){
			residue = residues.get(aux);
			biodegradable = (Biodegradable) residue;
			if(biodegradable.getComposting() == true){
				result -= result*0.01;
			}
		}
		}
		
	}

}