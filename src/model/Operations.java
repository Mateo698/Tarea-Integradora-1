package model;

public class Operations{
	
	public static int priceForPlace(int[] HardwareStore){
		int total = 0;
		for(int i=0; i<HardwareStore.length; i++){
			total += HardwareStore[i]
		}
		total =+ 1300000 + 2600000 + 980000 
		return total;
	}
	
	public static int[] bestPrice(int[] HC, int[] FC, int[] FB){
		int[] best = new int[HC.length];
		for(int i=0; i<best.length; i++){
			if(HC[i]<FC[i] && HC[i]<FB[i]){
				best[i] = HC[i]
			}
			else if(FC[i]<HC[i] && FC[i]<FB[i]){
				best[i]= FB[i]
			}
			else{
				best[i]=FB
			}
		}
		
		return bestPrices;
	
	
	public static int[] bestIndex(int[] HC, int[] FC, int[] FB){
		int[] bestIndex = new int[HC.length];
		for(int i=0; i<best.length; i++){
			if(HC[i]<FC[i] && HC[i]<FB[i]){
				best[i] = 1//Aqui se usan convenciones donde el 1 es el index usado para identificar a Home Center
			}
			else if(FC[i]<HC[i] && FC[i]<FB[i]){
				best[i]= 2//El 2 para la Ferreteria del centro
			}
			else{
				best[i]=3//Y el 3 para la Ferreteria del barrio
		
		
		return bestIndex;
}