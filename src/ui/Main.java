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
 		String teclado,identifier,name,origin,color;
 		boolean continue1 = false;
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
 		switch (seleccion){
 			//boolean composting,String identifier, String name, String origin, String color, int timeToDescompose
 			
 			


 		}
 		

 	}
 }	

 