package ui;
import model.*;
import java.util.Scanner;
import java.util.ArrayList;
 public class Main{
 	private Waste waste = new Waste();
 	private Scanner s = new Scanner(System.in);
 	private	Scanner n = new Scanner(System.in);
 	private boolean finish = false;
 	public static void main(String[] args){
 		Main main = new Main();
 		main.init();
 		do{

 			main.showMenu();
 			main.start();
		}while(main.finish == false);
 		
 
 	}
 	public void showMenu(){
 		System.out.println("\n"+
 		"////////////////////////////////////////////////////////////////////////////\n"+
 		"1. agregar Nuevo residuo \n"+
 		"2. agregar Nuevo producto \n"+
 		"3. Mostrar reporte de los residuos registrados \n"+
 		"4. Mostrar informacion de un residuo \n"+
 		"5. Mostrar lista de productos registrados \n"+
 		"6. Calcular efecto nocivo de un residuo \n"+
 		"7. Determinar si un residuo biodegradable o reciclable es aprovechable \n"+
 		"8. Listar residuos de un producto, en orden nocivo\n"+
 		"0. Salir");	
 	}
 	public void start(){
 		double nocive;
 		Product product;
 		Residue residue;
 		String name,identifier;
 		boolean usable;
 		int seleccion,seleccion2;
 		seleccion = n.nextInt();
 		switch (seleccion){
 			case 1:
 			addResidue(true);
 			break;
 		
 			case 2:
 			addProduct(true);
 			break;

 			case 3:
 			waste.generateReport();
 			break;

 			case 4:
 			System.out.println("1. nombre\n"+"2. identificador");
 			seleccion2 = n.nextInt();
 			if(seleccion2 == 1){
 				System.out.println("indique el nombre del residuo que desea buscar: ");
 				name = s.nextLine();
 				waste.showInfoName(name);
 			}else if(seleccion2 == 2){
 				System.out.println("indique el identificador del residuo que desea buscar: ");
 				identifier = s.nextLine();
 				waste.showInfoIdentifier(identifier);
 			}
 			break;

 			case 5:
 			waste.showListProducts();
 			break;


 			case 6:
 			System.out.println("indique el nombre del residuo que desea Calcular: ");
 			name = s.nextLine();
 			nocive = waste.calculateEfectPlanet(name);
 			System.out.println("el efecto Nocivo es: "+ nocive);
 			break;

 			case 7:
 			System.out.println("indique el nombre del residuo que sea Calcular: ");
 			name = s.nextLine();
 			usable = waste.calculateResidueUsable(name);
 			if(usable == true){
 				System.out.println("El residuo es aprovechable");
 			}else{
 				System.out.println("El residuo no es aprovechable");
 			}
 			break;

 			case 8:
 			System.out.println("indique el nombre o el identificador del Product que desea buscar: ");
 			name = s.nextLine();
 			waste.showListResidueNosive(name);
 			break;

 			case 0:
 			finish = true;
 			
 		}
 	}
 	public void addResidue(boolean conditional){
 		ArrayList<Residue> residues = new ArrayList<Residue>();
 		Residue residue;
 		int seleccion,timeToDescompose,seleccion2;
 		String teclado,identifier="",name="",origin="",color="",name2 ="",type ="",descriptionHome="",descriptionIndustry="",advice = "";
 		Product product = null;
 		boolean continue1 = false,composting = false;
 		System.out.println("porfavor indique el tipo de residuo que desea agregar \n"+
 			"1. Biodegradable \n"+
 			"2. Reciclable \n"+
 			"3. Inerte");
 		seleccion = n.nextInt();
 		do{ 
 			System.out.println("indique un identificador para este residuo: ");
 			identifier = s.nextLine();
 			continue1 = waste.searchIdentifiers(identifier);
 			if(continue1 == true){
 				System.out.println("este identificador esta en uso");
 			}
 			}while(continue1 == true);
 		do{
 			System.out.println("indique un nombre: ");
 			name = s.nextLine();
 			continue1 = waste.searchNames(name);
 			if(continue1 == true){
 				System.out.println("este nombre esta en uso");
 			}
 		}while(continue1 == true);	
 		do{
 		System.out.println("indique de donde proviene: \n"+
 			"1. industrial\n"+
 			"2. domiciliario\n"+
 			"3. municipal\n"+
 			"4. construccion\n"+
 			"5. hospitalario");
 		seleccion2 =  n.nextInt();
 		
 			switch (seleccion2){
 				case 1:
 				origin = "industrial";
 				break;
 				case 2:
 				origin = "domiciliario";
 				break;
 				case 3:
 				origin = "municipal";
 				break;
 				case 4:
 				origin = "construccion";
 				break;
 				case 5:
 				origin = "hospitalario";
 				break;
 			}	
 		}while(origin == "");
 		System.out.println("indique el color: ");
 		color = s.nextLine();
 		System.out.println("indique el tiempo de descompocicion en dias: ");
 		timeToDescompose = n.nextInt();
 		if(conditional == true){
 			do{
 				continue1 = true;
 				System.out.println("indique el producto que la produce:\n "+
 				"0. Mostrar los existente\n"+
 				"1. Añadir uno existente\n"+
 				"2. Añadir uno nuevo");
 				seleccion2 = n.nextInt();
 				switch (seleccion2){
 					case 0:
 					waste.showListProducts();
 					break;
 					case 1:
 					System.out.println("indique el nombre del producto que desea agregar");
 					name2 = s.nextLine();
 					product = waste.addProductExist(name2);
 					if(product == null){
 						continue1 = true;
 					}else{
 						continue1 = false;
 					}
 					
 					break;
 					case 2:
 					addProduct(false);
 					product = waste.getLastProduct();
 					continue1 = false;
 					break;
 				}

 			}while(continue1 == true);

 		
 		}else{
 			product = waste.getLastProduct();
 		}
 		//String identifier, String name, String description, ArrayList<Residue> residues
 		switch (seleccion){
 			//boolean composting
 			case 1:
 		do{
 			System.out.println("este residuo es apto para compostaje: \n"+"1. si\n"+"2. No");
 			seleccion2 = n.nextInt();
 			if(seleccion2 == 1){
 				composting = true;
 			}else if(seleccion2 == 2){
 				composting = false;
 			}
 		}while(seleccion2 != 1 && seleccion2 != 2);
 		//boolean composting,String identifier, String name, String origin, String color, int timeToDescompose,Product productToProduce
 			waste.addResidue(composting,identifier,name,origin,color,timeToDescompose,product);
 			break;

 			//String type;String descriptionHome; String descriptionIndustry;
 			case 2:
 			do{
 				System.out.println("indique el material del residuo: \n"+
 					"1. papel\n"+
 					"2. carton\n"+
 					"3. vidrio\n"+
 					"4. plastico");
 				seleccion2 = n.nextInt();
 				switch (seleccion2){
 					case 1:
 					type = "papel";
 					break;
 					case 2:
 					type = "carton";
 					break;
 					case 3:
 					type = "vidrio";
 					break;
 					case 4:
 					type = "plastico";
 					break;
 						
 				}
 			}while(type == "");
 			do{
 				System.out.println("indique una descripción de cuál es la manera más adecuada de realizar la disposición de estos elementos para los hogares: ");
 				descriptionHome = s.nextLine();

 				System.out.println("indique una descripción de cuál es la manera más adecuada de realizar la disposición de estos elementos para la industria: ");
 				descriptionIndustry = s.nextLine();
 			}while(descriptionHome == "" || descriptionIndustry == "");
 			waste.addResidue(type,descriptionHome,descriptionIndustry,identifier,name,origin,color,timeToDescompose,product);
 			break;
 			//String advice
 			case 3:
 			do{
 				System.out.println("indique consejos para reducir su uso");
 				advice = s.nextLine();
 			}while(advice == "");
 			waste.addResidue(advice,identifier,name,origin,color,timeToDescompose,product);
 			break;


 		} 		
 	}
 	//String identifier, String name, String description, Residue residue
 	public void addProduct(boolean conditional){
 		int aux;
 		Product product;
 		String identifier="",name="",description ="";
 		boolean continue1=false;
 		do{ 
 			System.out.println("indique un identificador para este producto: ");
 			identifier = s.nextLine();
 			continue1 = waste.searchIdentifiers(identifier);
 			if(continue1 == true){
 				System.out.println("este identificador esta en uso");
 			}
 			}while(continue1 == true);
 		do{
 			System.out.println("indique un nombre: ");
 			name = s.nextLine();
 			continue1 = waste.searchNamesProduct(name);
 			if(continue1 == true){
 				System.out.println("este nombre esta en uso");
 			}
 		}while(continue1 == true);
 		do{
 			System.out.println("indique una descripción del producto: ");
 			description = s.nextLine();
 		}while(description == "");
 		waste.addProduct(identifier,name,description);		
 		if(conditional == true){
 			System.out.println("a continuacion porfavor indique el o los residuos que este genera: ");
 			do{	
 				addResidue(false);
 				System.out.println("desea guardor otro? \n"+"1. Si\n"+"2. No");
 				aux = n.nextInt();
 			}while(aux == 1);
 		}

 	}
 	public void init(){
 		Product product;
 		waste.addProduct("MU3BL3","Mueble","El mueble es un elemento funcional doméstico pensado y diseñado para favorecer la comodidad y facilidad del uso de los espacios al ser humano atendiendo a sus necesidades cotidianas");		
 		product = waste.getLastProduct();
 		waste.addResidue(true,"M4D3R4","Madera","domiciliario","cafe",730,product);
 		waste.addProduct("1MPR3N74","Imprenta","la imprenta es una maquina destinada a reproducir textos e imagenes sobre un papel.");
 		product = waste.getLastProduct();
 		waste.addResidue("evitar desecharlos y usarlos al maximo, por su largo tiempo de vida se le peuden dar muchas usos diferentes durante todoe ese tiempo","M374L","Metal","idustrial","plata",10950,product);
 		waste.addResidue("papel","Aprovechar ambos lados de la hoja al utilizar cuadernos o papel sucio.Promover la producción de papel reciclado casero","Usar más la pizarra y el proyector que hojas sueltas para impartir las lecciones.Facilitar el reciclaje colocando cestos o carpetas en salas y oficinas.","P4P3L","Papel","idustrial","blanco",365,product);
 		
 	}
 }	

 