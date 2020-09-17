package ui;
import model.*;
import java.util.Scanner;
public class Main{
	
	/**
	*Lee la cantidad de materiales por consola<br>
	*<b>pre: </b> La variable de la cantidad debe estar inicializada. <br>
	*<b>post: </b> Devuelve la cantidad de materiales para la obra. <br>
	*@param in debe haber sido inicializado
	*/
	public static int askQuantity(Scanner in){
		System.out.println("Ingrese la cantidad de materiales que desea ingresar");
		int quantity = in.nextInt();
		in.nextLine();/**   */
		return quantity;
	}
	
	
	/**
	*Lee la ubicacion del inmueble<br>
	*<b>pre: </b> La variable location debe haber sido inicializada. <br>
	*<b>post: </b> Devuelve un entero el cual indica la ubicacion del inmueble. <br>
	*@param in debe haber sido inicializado.
	*/
	public static int askLocation(Scanner in){
		System.out.println("Ingrese 1 si su inmueble se encuentra en el norte, 2 si esta en el centro y 3 si esta en el sur");
		int location = in.nextInt();
		in.nextLine();
		return location;
	}
	
	/**
	*Lee los precios para un producto en las 3 ferreterias y su utilizacion<br>
	*<b>pre: </b> El array auxiliar que va a capturar el array generado que se usara para distribuir los datos en los respectivos arrays debe estar inicializado. <br>
	*<b>post:</b> Devuelve un array con los datos necesarios. <br>
	*@param in debe haber sido inicializado
	*/
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
	
	/**
	*Calcula y muestra los datos del problema tales como los precios, mejores precios y valores a pagar<br>
	*<b>pre: </b>  <br>
	*<b>post: </b> Muestra los mejores precios y los precios totales a pagar. <br>
	*@param in Scanner debe haber sido declarado.
	*/
	public static void showData(Scanner in){
		int location = askLocation(in);
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
		System.out.println("El precio total para HomeCenter es con la mano de obra " + Operations.priceForPlace(priceHomeCenter));
		System.out.println("El precio para la ferreteria del centro es con la mano de obra "+ Operations.priceForPlace(priceFC));
		System.out.println("El precio para la ferreteria del barrio es con la mano de obra "+ Operations.priceForPlace(priceFB));
		
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
		int total = Operations.finalPrice(bestPrice,location);
		System.out.println("El precio total a pagar por los materiales y el domicilio "+total);
		
		System.out.println("A continuacion se muestran los materiales usados para la obra junto con su utilidad(utilizacion)");
		for(int i=0; i<quantity; i++){
			if(utility[i]==1){//obra negra
				System.out.println(materialsName[i]+" Obra negra");
			}
			else if(utility[i]==2){//obra blanca
				System.out.println(materialsName[i]+" Obra blanca");
			}
			else{//pintura
				System.out.println(materialsName[i]+" Pintura");
			}
			
		}
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		showData(in);
	}
}

