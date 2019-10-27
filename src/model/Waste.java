package model;
import java.util.ArrayList;

public class Waste{
	//Attributes
	private ArrayList<Product> products = new ArrayList<Product>();
	private	ArrayList<Residue> residues = new ArrayList<Residue>(); 
	//Methods
	public Waste(){
		super();
		residues = new ArrayList<Residue>();

	} 
	public void addResidue(String type, String descriptionHome,String descriptionIndustry,String identifier, String name, String origin, String color, int timeToDescompose,Product productToProduce){
		Recyclable resycable = new Recyclable(type,descriptionHome, descriptionIndustry, identifier, name, origin, color, timeToDescompose, productToProduce);
		residues.add(resycable);
	}
	public void addResidue(boolean composting,String identifier, String name, String origin, String color, int timeToDescompose,Product productToProduce){
		Biodegradable biodegradable = new Biodegradable(composting,identifier,name,origin, color, timeToDescompose, productToProduce);
		residues.add(biodegradable);
	}
	public void addResidue(String advice,String identifier, String name, String origin, String color, int timeToDescompose,Product productToProduce){
		Inert inert = new Inert(advice, identifier, name, origin, color, timeToDescompose, productToProduce);
		residues.add(inert);
	}
	public void showInfoName(String name){
		int aux=-1;
		String products = "";
		for(int i=0; i<residues.size();i++){
			if(residues.get(i).getName().equalsIgnoreCase(name)){
				aux = i;
				i = residues.size();
			}
		}
		if(aux != -1){
			System.out.println("identificador: "+residues.get(aux).getIdentifier());
			System.out.println("name: "+residues.get(aux).getName());
			System.out.println("origin: "+residues.get(aux).getOrigin());
			System.out.println("color: "+residues.get(aux).getColor());
			System.out.println("Tiempo de descomposición: "+residues.get(aux).getTimeToDescompose()+" dias");
			System.out.println("producto que lo produce: "+residues.get(aux).getProductToProduce());
		}else{
			System.out.println("este residuo no existe");
		}
	}
	public void addProduct(String identifier, String name, String description){
		Product product = new Product(identifier,name,description);
		products.add(product);
	}

	public void showInfoIdentifier(String identifier){
		int aux=-1;
		String residue = "";
		for(int i=0; i<residues.size();i++){
			if(residues.get(i).getProductToProduce().getIdentifier().equalsIgnoreCase(identifier)){
				residue = residues.get(i).getName();
				aux = residues.size();
			}
		}
		showInfoName(residue);
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

		return result;
		
	}
	public boolean calculateResidueUsable(String name){
		int aux= -1,timeToDescompose;
		String description1="",description2="";
		Recyclable recycable;
		Biodegradable biodegradable;
		boolean composting, result = false;

		for(int i=0; i<residues.size();i++){
			if(residues.get(i).getName().equalsIgnoreCase(name)){
				aux = i;
				break;
			}
		}		
		
		if(aux != -1){
			if(residues.get(aux) instanceof Biodegradable){
			timeToDescompose = residues.get(aux).getTimeToDescompose();
			biodegradable = (Biodegradable) residues.get(aux);
			composting = biodegradable.getComposting();
				if(timeToDescompose < 1){
					if(composting == true){
				result = true;
					}
				}

			}else if(residues.get(aux) instanceof Recyclable){
				recycable = (Recyclable) residues.get(aux);
				description1 = recycable.getDescriptionHome();
				description2 = recycable.getDescriptionIndustry();
				if(description1 != "" && description2 != ""){
				result = true;
				}
			}
		}
		
		return result;
	}
	
	public void generateReport(){
		int aux = 1;
		for(int i=0; i<residues.size();i++){
			
			if(residues.get(i) instanceof Recyclable){
				if(aux == 1){
					System.out.println(residues.get(i).tipoClase().toUpperCase());
				}
			System.out.println(aux+ 
				". "+residues.get(i).getName()+ " - "
				+residues.get(i).getOrigin()+" - "+ residues.get(i).getColor()+" - "+residues.get(i).getTimeToDescompose()+" dias en descomponerse"+" - identificador: "+residues.get(i).getIdentifier());
			aux++;
			}
		}
		aux = 1;
		for(int i=0; i<residues.size();i++){

			if(residues.get(i) instanceof Biodegradable){
				if(aux == 1){
					System.out.println(residues.get(i).tipoClase().toUpperCase());
				}
			System.out.println(aux+ 
				". "+residues.get(i).getName()+ " - "
				+residues.get(i).getOrigin()+" - "+ residues.get(i).getColor()+" - "+residues.get(i).getTimeToDescompose()+" dias en descomponerse"+" - identificador: "+residues.get(i).getIdentifier());
			aux++;
			}
		}
		aux = 1;
		for(int i=0; i<residues.size();i++){
			
			if(residues.get(i) instanceof Inert){
				if(aux == 1){
					System.out.println(residues.get(i).tipoClase().toUpperCase());
				}
			System.out.println(aux+ 
				". "+residues.get(i).getName()+ " - "
				+residues.get(i).getOrigin()+" - "+ residues.get(i).getColor()+" - "+residues.get(i).getTimeToDescompose()+" dias en descomponerse"+" - identificador: "+residues.get(i).getIdentifier());
			aux++;
			}
		}
 
 
	}
	public void showListResidueNosive(String product){
		double nocive = 0;
		ArrayList<String> max = new ArrayList<String>();
		ArrayList<Double> position = new ArrayList<Double>();
		ArrayList<Residue> residues2= new ArrayList<Residue>();
		for(int i = 0; i<residues.size(); i++){
			if(residues.get(i).getProductToProduce() != null){
				if(residues.get(i).getProductToProduce().getName().equalsIgnoreCase(product) || residues.get(i).getProductToProduce().getIdentifier().equalsIgnoreCase(product)){
				 
					residues2.add(residues.get(i));
				}
			}
			
		}
		if(!residues2.isEmpty()){
		for(int i=0;i<residues2.size();i++) {
			max.add(residues2.get(i).getName());
			nocive = calculateEfectPlanet(residues2.get(i).getName());
			position.add(nocive);
		}
		for (int i = 0; i < position.size(); i++) {
        	for (int j = 0; j < position.size()-i-1; j++) {
            	if(position.get(j) < position.get(j+1)){
                	double aux = position.get(j+1);
                	position.add(j+1,position.get(j));
                	position.add(j,aux);
                	String auxS = max.get(j+1);
                	max.add(j+1, max.get(j));
                	max.add(j, auxS);
            	}
        	}
        
        }
        for(int i = 0;i<max.size();i++){
        	System.out.println(max.get(i));
    	}


		}	
	}
	public boolean searchIdentifiers(String identifier){
		boolean result = false;
		    for(int i = 0; i<products.size();i++){
		    	if(products.get(i).getIdentifier().equalsIgnoreCase(identifier)){
		    		result = true;
		    		break;
		    	}
		    }
		    for(int i =0;i<residues.size();i++){
		    	if(residues.get(i).getIdentifier().equalsIgnoreCase(identifier)){
		    		result = true;
		    		break;
		    	}
		    }
		    return result;	
    }
    public boolean searchNames(String name){
		boolean result = false;
		    for(int i =0;i<residues.size();i++){
		    	if(residues.get(i).getName().equalsIgnoreCase(name)){
		    		result = true;
		    		break;
		    	}
		    }
		    return result;	
    }
    public boolean searchNamesProduct(String name){
		boolean result = false;
		    for(int i =0;i<products.size();i++){
		    	if(products.get(i).getName().equalsIgnoreCase(name)){
		    		result = true;
		    		break;
		    	}
		    }
		    return result;	
    }
    public Product addProductExist(String name){
    	Product result = null;
    	for(int i = 0; i < products.size();i++){
    		if(products.get(i).getName().equalsIgnoreCase(name)){
    			result =  products.get(i);
    			break;
    		}
    	}
    	return result;
    }
    public Product getLastProduct(){
    	int aux = products.size()-1;
    	System.out.println(products.get(aux).getIdentifier());
    	return this.products.get(aux);
    }
    
   
  



	
}
