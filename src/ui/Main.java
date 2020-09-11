package ui;
import model.*;
import java.util.Scanner;
public class Main{
	

	
	public static int askQuantity(Scanner in){
		System.out.println("Ingrese la cantidad de materiales que desea ingresar");
		int quantity = in.nextInt();
		in.nextLine();
		return quantity;
	}
	
	public static String[] askForMaterials(Scanner in){
		String[] material = new String[5];
		System.out.println("Ingrese el nombre del producto");
		material[0] = in.nextLine();
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
	
	public static void showData(Scanner in){
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
		
		int[] bestPrice = new int[quantity];
		int[] bestIndex = new int[quantity];
		bestPrice = Operations.bestPrice(priceHomeCenter, priceFC, priceFB);
		bestIndex = Operations.bestIndex(priceHomeCenter, priceFC, priceFB);
		
		for(int i=0; i<quantity; i++){
			switch(bestIndex[i]){
				case 1:
					System.out.println("El mejor lugar para comprar "+materialsName[i]+" es en HomeCenter con un precio de "+bestPrice[i]);
				break;
				
				case 2:
					System.out.println("El mejor lugar para comprar "+materialsName[i]+" es en la ferreteria del centro con un precio de "+bestPrice[i]);
				break;
				
				case 3:
					System.out.println("El mejor lugar para comprar "+materialsName[i]+" es en la ferreteria del barrio con un precio de "+bestPrice[i]);
				break;
				
				default:
			}
		}
		
		for(int i=0; i<quantity; i++){
			System.out.println(materialsName[i] + " " + priceHomeCenter[i] + " " + priceFC[i] + " " + priceFB[i]);
			
		}
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		showData(in);
	}
}

