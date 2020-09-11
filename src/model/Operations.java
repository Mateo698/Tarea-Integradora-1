package model;

public class Operations{
	
	private static int blackWork = 1300000;
	private static int whiteWork = 2600000;
	private static int painting = 980000;
	
	public static int priceForPlace(int[] HardwareStore){
		int total = 0;
		for(int i=0; i<HardwareStore.length; i++){
			total += HardwareStore[i];
		}
		total = total + blackWork + whiteWork + painting;
		return total;
	}
	
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
			System.out.println(best[i]);
		}
		
		return best;
	}
	
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
			System.out.println(bestIndex[i]);
		}
		return bestIndex;
	}
}