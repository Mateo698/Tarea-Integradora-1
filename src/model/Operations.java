package model;

public class Operations{
	
	private final static int blackWork = 1300000;
	private final static int whiteWork = 2600000;
	private final static int painting = 980000;
	
	/**
	*Genera el total a pagar para cada establecimiento mas la mano de obra<br>
	*<b>pre: </b> La lista de precios para la tienda debe haber sido incializada y declarada. <br>
	*<b>post: </b> Se genera el total a pagar <br>
	*@param HarwareStore Tienda a calcular precio total. HardwareStore[i] >= 0
	*/
	public static int priceForPlace(int[] HardwareStore, int[] quantity, int location){
		int total = 0;
		for(int i=0; i<HardwareStore.length; i++){
			total += HardwareStore[i]*quantity[i];
		}
		switch(location){
			case 1:
				if(total<80000){
					total += 120000;
				}
				else if(total<300000){
					total += 28000;
				}			
			break;
			
			case 2:
				if(total<80000){
					total += 50000;
				}
			break;
			
			case 3:
				if(total<80000){
					total += 120000;
				}
				else if(total<300000){
					total += 55000;
				}	
			break;
			
			default:
			
		}
		total = total + blackWork + whiteWork + painting;
		return total;
	}
	
	/**
	*Genera el array con los mejores precios para cada producto de las 3 tiendas<br>
	*<b>pre: </b> La listas de precios deben haber sido incializadas y declaradas con numeros naturales. <br>
	*<b>post: </b> Devuelve la lista o array con los mejores precios de las 3 tiendas. <br>
	*@param HC Precios en HomeCenter. HC[i]>=0
	*@param FC Precios en la ferreteria del centro. FC[i]>=0
	*@param FB Precios en la ferretreria del barrio. FB[i]>=0
	*/
	public static int[] bestPrice(int[] HC, int[] FC, int[] FB){
		int[] best = new int[HC.length];
		for(int i=0; i<best.length; i++){
			if(HC[i]<FC[i] & HC[i]<FB[i]){
				best[i] = HC[i];
			}
			else if(FC[i]<HC[i] & FC[i]<FB[i]){
				best[i]= FC[i];
			}
			else if(FB[i]<HC[i] & FB[i]<FC[i]){
				best[i]=FB[i];
			}
			
		}
		
		return best;
	}
	
	/**
	*Genera un array con el index identificador que identifica donde se compra el producto al mejor precio.<br>
	*<b>pre: </b> La listas de precios deben haber sido incializadas y declaradas con numeros naturales. <br>
	*<b>post: </b> Devuelve la lista o array con los mejores precios de las 3 tiendas. <br>
	*@param HC Precios en HomeCenter. HC[i]>=0
	*@param FC Precios en la ferreteria del centro. FC[i]>=0
	*@param FB Precios en la ferretreria del barrio. FB[i]>=0
	*/
	public static int[] bestIndex(int[] HC, int[] FC, int[] FB){
		int[] bestIndex = new int[HC.length];
		for(int i=0; i<bestIndex.length; i++){
			if(HC[i]<FC[i] & HC[i]<FB[i]){
				bestIndex[i] = 1;//Aqui se usan convenciones donde el 1 es el index usado para identificar a Home Center
			}
			else if(FC[i]<HC[i] & FC[i]<FB[i]){
				bestIndex[i]= 2;//El 2 para la Ferreteria del centro
			}
			else if(FB[i]<HC[i] & FB[i]<FC[i]){
				bestIndex[i]=3;//Y el 3 para la Ferreteria del barrio
			}
			
		}
		return bestIndex;
	}
	
	/**
	*Genera el precio a pagar de todos los productos a su mejor precio junto con el valor del domicilio.<br>
	*<b>pre: </b> Los precios para cada tienda deben haber sido declarados. <br>
	*<b>post: </b> Devuelve el precio a pagar por los productos. <br>
	*@param bestPrices Lista de los mejores precios. bestPrices[i]>=0
	*@param location Entero que indica la ubicacion del inmueble. 3>=location>=1
	*/
	public static int finalPrice(int[] bestPrices,int[] quantity, int location){
		int total= 0;
		for(int i=0; i<bestPrices.length; i++){
			total += bestPrices[i]*quantity[i];
		}
		switch(location){
			case 1:
				if(total<80000){
					total += 120000;
				}
				else if(total<300000){
					total += 28000;
				}			
			break;
			
			case 2:
				if(total<80000){
					total += 50000;
				}
			break;
			
			case 3:
				if(total<80000){
					total += 120000;
				}
				else if(total<300000){
					total += 55000;
				}	
			break;
			
			default:
			
		}
		
		return total;
	}
	
}