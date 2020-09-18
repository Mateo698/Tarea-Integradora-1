package ui;
import model.*;
import java.util.Scanner;
public class Main{
	
	/**
	*Read the quantity through the console<br>
	*<b>pre: </b> La variable de la cantidad debe estar inicializada. <br>
	*<b>post: </b> Devuelve la cantidad de materiales para la obra. <br>
	*@param in debe haber sido inicializado
	*/
	public static int askQuantity(Scanner in){
		System.out.println("Ingrese la cantidad de materiales diferentes que desea ingresar");
		int quantity = in.nextInt();
		in.nextLine();/**   */
		return quantity;
	}
	
	public static void showUtility(String[] materialsName, int quantity, int[] utility, Scanner in){
		boolean end = false;
		for(int p=1; p!=0 && !end; p++){
			System.out.println("Ingrese 1 si desea ver los materiales de obra negra");
			System.out.println("Ingrese 2 si desea ver los materiales de obra blanca");
			System.out.println("Ingrese 3 si desea ver los materiales para pintura");
			System.out.println("Ingrese 4 si desea ver todos los materiales");
			System.out.println("Ingrese 5 si desea terminar");
			int decision = in.nextInt();
			switch(decision){
				case 1:
					for(int i=0; i<materialsName.length; i++){
						if(utility[i] == 1){
							System.out.println(materialsName[i]);
						}
					}
				break;
			
				case 2:
					for(int i=0; i<materialsName.length; i++){
						if(utility[i] == 2){
							System.out.println(materialsName[i]);
						}
					}
				break;
			
				case 3:
					for(int i=0; i<materialsName.length; i++){
						if(utility[i] == 3){
							System.out.println(materialsName[i]);
						}
					}
				break;
			
				case 4:
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
				break;
				
				case 5:
				end = true;
				break;
				
				default:
		
			}
		}
		
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
		String[] material = new String[6];
		System.out.println("Ingrese el nombre del producto");
		material[0] = in.nextLine();
		System.out.println("Ingrese la cantidad del material por unidad");
		material[1]= in.nextLine();
		System.out.println("Ingrese el precio para Home Center");
		material[2] = in.nextLine();
		System.out.println("Ingrese el precio para la Ferreteria del centro");
		material[3] = in.nextLine();
		System.out.println("Ingrese el precio para la Ferreteria del barrio");
		material[4] = in.nextLine();
		System.out.println("Ingrese 1 si es para Obra Negra, 2 si es para Obra Blanca y 3 si es para Pintura");
		material[5] = in.nextLine();
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
		int[] quantityOfProduct = new int[quantity];
		for(int i=0; i<quantity ; i++){
			String[] material = new String[6];
			material = askForMaterials(in);
			materialsName[i] = material[0];
			quantityOfProduct[i] = Integer.parseInt(material[1]);
			priceHomeCenter[i] = Integer.parseInt(material[2]);
			priceFC[i] = Integer.parseInt(material[3]);
			priceFB[i] = Integer.parseInt(material[4]);
			utility[i] = Integer.parseInt(material[5]);
		}
		System.out.println("El precio total para HomeCenter es con la mano de obra " + Operations.priceForPlace(priceHomeCenter,quantityOfProduct,location));
		System.out.println("El precio para la ferreteria del centro es con la mano de obra "+ Operations.priceForPlace(priceFC,quantityOfProduct,location));
		System.out.println("El precio para la ferreteria del barrio es con la mano de obra "+ Operations.priceForPlace(priceFB,quantityOfProduct,location));
		
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
		int total = Operations.finalPrice(bestPrice,quantityOfProduct,location);
		System.out.println("El precio total a pagar por los materiales y el domicilio "+total);
		
		showUtility(materialsName, quantity, utility, in);
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		showData(in);
	}
}

