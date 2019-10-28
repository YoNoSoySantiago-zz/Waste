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
	public void addProduct(String identifier, String name, String description){
		Product product = new Product(identifier,name,description);
		products.add(product);
	}
	/**
	*<p> desc: <P> This method receives a string of characters, it allows to display on screen the attributes of the residual class, corresponding to the parameter in relation to the class, by comparing the parameter with the name attribute of the class.
	*<p> pre: <p> the residue class, must already be created and installed as a reidue ArrayList, you must also have the toString method in the residue class.
	*@param name, is a string of characters that represent the value to look for in the attribute of the residue class
	*/
	public void showInfoName(String name){
		int aux=-1;
		String products = "";
		for(int i=0; i<residues.size();i++){
			if(residues.get(i).getName().equalsIgnoreCase(name)){
				aux = i;
				break;
			}
		}
		if(aux != -1){
			System.out.println(residues.get(aux).toString());
		}else{
			System.out.println("este residuo no existe");
		}
	}

	
	/**
	*<p> desc: <P> This method receives a string of characters, allows to display on screen the attributes of the residual class, corresponding to the parameter in relation to the class, comparing the parameter with the identifier attribute of the class.
 	*<p> pre: <p> the residue class, must already be created and installed as a reidue ArrayList, you must also have the toString method in the residue class.
	*@param identifier, is a string of characters that represent the value to look for in the attribute of the residue class
	*/
	
	public void showInfoIdentifier(String identifier){
		
		String residue = "";
		for(int i=0; i<residues.size();i++){
			if(residues.get(i).getIdentifier().equalsIgnoreCase(identifier)){
				residue = residues.get(i).getName();
				break;
			}
		}
		showInfoName(residue);
	}
	/**
	*<p> desc: <p> This method allows you to display a list of the name attribute of all product objects on screen, stored in the ArrayList of product
	*<p> pre: <p> the product class must be created and instantiated as an ArrayList of product
	*/
	public void showListProducts(){
		for(int i=0;i<products.size();i++){
			System.out.println(products.get(i).getName());
		}
	}
	/**
	*<p> desc: <p> receives a string of characters, this method allows you to calculate the harmful effect that a waste has on the planet, multiplying a factor determined by its origin and the time it takes to decompose, if it is corresponding waste it is recyclable 2% is subtracted from this value, if it is a biodegradable waste suitable for composting, 1% is subtracted.
	*<p> pre: <p> the residue class, must already be created and installed as a reray ArrayList
	*@param residueName this parameter is a string of characters, which represents the name attribute of the waste class to search
	*@return this method returns a positive decimal number that represents the harmful effect of that residue on the planet
	*/
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
	/**
	*<p> desc: <p> receives a string of characters, this method allows you to calculate whether a waste is usable or not,
	to recyclable and biodegradable waste. for biodegradable is usable, it must be fulfilled that time
	Decomposition is less than one year and is suitable for composting. For recyclable waste, it must be met that there is
	The description of the proper way to dispose of waste.
	*<p> pre: <p> the residue class, must already be created and installed as a reray ArrayList
	*@param name parameter is a string of characters, which represents the name attribute of the residual class to look for
	*@return this method returns a true value that indicates whether the residue is usable or not
	*/
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
	/**
	*<p> desc: <p> This method allows you to display a report with the attributes of existing waste, sorted by type of waste (biodegradable, recyclable, inert)}
	*<P> pre: <p> the residue class, must already be created and installed as a reray ArrayList
	*/
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
	/**
	*<p> desc: <p> receives a string of characters, this method allows you to display on the screen a list of waste belonging to a product, from the most harmful to the least harmful
	*<p> pre: <p> the residue class must already be created and installed as a reidue ArrayList, also the calculateEfectPlanet method must be working
	*@param product is a string of characters, this parameter represents the name of the product to which the list of waste generated will be displayed	
	*/
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
	/**
	*<p> desc: <p> receives a string of characters, this method allows to verify if an identifier already exists or not
	*<p> pre: <p> the product class, must already be created and installed as an ArrayList of product
	*@param identifier is a string of characters, this parameter represents the identifier to find if one already exists
	*@return this method returns a truth value that indicates whether the identifier already exists or not
	*/
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
    /**
    *<p> desc: <p> receives a string of characters, this method allows to verify if a residue name already exists
    *<p> pre: <p> the residue class, must already be created and installed as a residue ArrayList
    *@param name parameter is a string of characters, which represents the name attribute of the residual class to look for
    *@return this method returns a true value, which indicates whether a residue already exists with the same name or not
    */
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
    /**
    *<p> desc: <p> receives a string of characters, this method allows to verify if a product name already exists
    *<p> pre: <p> the product class, must already be created and installed as an ArrayList of product
	*@param name parameter is a string of characters, which represents the name attribute of the product class to search
	*@return this method returns a true value, which indicates whether a product already exists with the same name or not
    */
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
    /**
    *<p> desc: <p> receives a string of characters, this method allows you to search and deliver a product object based on its name attribute
    *<p> pre: <p> the product class, must already be created and installed as an ArrayList of product
    *@param name parameter is a string of characters, which represents the name attribute of the product class to search
    *@return this method returns an object of type product, which is the product with the name equal to the parameter
    */
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
    /**
    *<p> desc: <p> this method allows you to search and return the last object of type product added to the ArrayList of product
    *<p> pre: <p> the product class, must already be created and installed as an ArrayList of product
    *@return this method returns an object of type product is which represents the last added to the list		
    */
    public Product getLastProduct(){
    	int aux = products.size()-1;
    	System.out.println(products.get(aux).getIdentifier());
    	return this.products.get(aux);
    }
    
   
  



	
}
