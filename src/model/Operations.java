package model;

public class Operations{
	
	private final static int ROUGHWORK = 1300000;
	private final static int SOFTWORK = 2600000;
	private final static int PAINTING = 980000;
	
	/**
	*Generate the final price to pay at each store with the work cost included<br>
	*<b>pre: </b> The total variable must already be initialized. <br>
	*<b>post: </b> Calculates the final price to pay for each store with the work cost included <br>
	*@param HarwareStore Store prices. HardwareStore[i] >= 0
	*@param quantity Amount of each material. quantity[i] > 0
	*@param location Number that indicates the location of the property. 3=>location>=1
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
		total = total + ROUGHWORK + SOFTWORK + PAINTING;
		return total;
	}
	
	/**
	*Generates an array with the best prices among the three stores.<br>
	*<b>pre: </b> The array for the best prices must already be intialized. <br>
	*<b>post: </b> Return the list with the best prices. <br>
	*@param HC Prices for HomeCenter. HC[i]>=0
	*@param FC Prices for la ferreteria del centro. FC[i]>=0
	*@param FB Prices for la ferretreria del barrio. FB[i]>=0
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
	*Generates an array with the index of the store with the best price for each material.<br>
	*<b>pre: </b> The array for the best prices store index must be already intialized. <br>
	*<b>post: </b> Returns the array with the index for the store with the best prices. <br>
	*@param HC Prices for HomeCenter. HC[i]>=0
	*@param FC Prices for la ferreteria del centro. FC[i]>=0
	*@param FB Prices for la ferretreria del barrio. FB[i]>=0
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
	*Generates the final cost of the products including the delivery.<br>
	*<b>pre: </b> The variable for the final price must be already initialized.<br>
	*<b>post: </b> Returns the cost of the products and it's delivery. <br>
	*@param bestPrices List of the best prices among the 3 stores. bestPrices[i]>=0
	*@param quantity List with the amount needed of each material. quantity[i]>0
	*@param location Integer that indicates the location of the property. 3>=location>=1
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