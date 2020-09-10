package ui;
import model.*;
import java.util.Scanner;
public class Main{
	
	public static String askName(Scanner in){
		System.out.println("Ingrese el  nombre del producto");
		String name = in.nextLine();
		in.nextLine();
		return name;
	}
	
	public static int askQuantity(Scanner in){
		System.out.println("Ingrese la cantidad de materiales que desea ingresar");
		int quantity = in.nextInt();
		return quantity;
	}
	
	public static String[] askForMaterials(Scanner in){
		String[] material = new String[5];
		System.out.println("Ingrese el nombre del producto");
		material[0] = in.nextLine();
		in.nextLine();
		System.out.println("Ingrese el precio para Home Center");
		material[1] = in.nextLine();
		System.out.println("Ingrese el precio para la Ferreteria del centro");
		material[2] = in.nextLine();
		System.out.println("Ingrese el precio para la Ferreteria del barrio");
		material[3] = in.nextLine();
		System.out.println("Ingrese 1 si es para Obra Negra, 2 si es para Obra Blanca y 3 si es para Pintura");
		material[4] = in.nextLine();
		return material;
	
	}
	
	public static void mostrarDatos(Scanner in){
		int quantity = askQuantity(in);
		String[] materialsName = new String[quantity];
		int[] priceHomeCenter = new int[quantity];
		int[] priceFC = new int[quantity];
		int[] priceFB = new int[quantity];
		int[] utility = new int[quantity];
		for(int i=0; i<quantity ; i++){
			String[] material = new String[5];
			material = askForMaterials(in);
			materialsName[i] = material[0];
			priceHomeCenter[i] = Integer.parseInt(material[1]);
			priceFC[i] = Integer.parseInt(material[2]);
			priceFB[i] = Integer.parseInt(material[3]);
			utility[i] = Integer.parseInt(material[4]);
		}
		System.out.println("El precio total para HomeCenter es " + Operations.priceForPlace(priceHomeCenter));
		System.out.println("El precio para la ferreteria del centro es "+ Operations.priceForPlace(priceFC));
		System.out.println("El precio para la ferreteria del barrio es "+ Operations.priceForPlace(priceFB));
		
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		for(int i=0; i<quantity ; i++){
			System.out.println(materialsName[i] + " " + priceHomeCenter[i] + " " + priceFC[i] + " " + priceFB[i] + utility[i]);
		}
	}
}