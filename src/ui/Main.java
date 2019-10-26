package ui;
import model.*;
import java.util.Scanner;
 public class Main{
 	private Waste waste = new Waste();
 	private Scanner s = new Scanner(System.in);
 	private	Scanner n = new Scanner(System.in);
 	public static void main(String[] args){
 		Main main = new Main();
 		main.showMenu();
 		main.start();


 	}
 	public void showMenu(){
 		System.out.println(
 		"1. agregar Nuevo residuo \n"+
 		"2. agregar Nuevo producto \n"+
 		"3. Mostrar reporte de lso productos registrados \n"+
 		"4. Mostrar informacion de un residuo \n"+
 		"5. Mostrar lista de productos registrados \n"+
 		"6. Calcular efecto nocivo de un residuo \n"+
 		"7. Determinar si un residuo biodegradable o reciclable es aprovechable \n"+
 		"8. Listar residuos de un producto, en orden nocivo");	
 	}
 	public void start(){
 		int seleccion;
 		seleccion = n.nextInt();
 		switch (seleccion){
 			case 1:
 			
 		}
 	}
 	public void addResidue(){
 		int seleccion,timeToDescompose,seleccion2;
 		String teclado,identifier="",name="",origin="",color="",name2 ="",type ="",descriptionHome="",descriptionIndustry="";
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
 			if(continue1 == false){
 				System.out.println("este identificador esta en uso");
 			}
 			}while(continue1 == false);
 		do{
 			System.out.println("indique un nombre: ");
 			name = s.nextLine();
 			continue1 = waste.searchNames(name);
 			if(continue1 == false){
 				System.out.println("este nombre esta en uso");
 			}
 		}while(continue1 == false);	
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
 				System.out.println("");
 			}while(descriptionHome == "" || descriptionIndustry == "");

 			//String advice


 		}
 		do{
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
 				break;
 				case 2:
 				
 			}

 		}while(product == null);
 		

 	}
 }	

 