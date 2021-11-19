package Hash;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class HashSum {
	
	public String ReturnHash(String text) throws InterruptedException { //5 байт ХЭШ функция
		
		LinkedList<Long> mass = new LinkedList<>();
		
		for(char s : text.toCharArray()) mass.add((long) s);
		if (mass.size() < 5) { int k = 0; for (int i = mass.size(); i < 5; i ++) { mass.add(mass.get(k) * mass.size()); k++; }}

		for(int i = 0; i < mass.size()/2; i ++) {
			
			mass.set(i, mass.get(i) ^ mass.get((mass.size() - 1) - i)); //XOR симметричных элементов из списков до середины
			
		}

		for(int i = mass.size() - 1; i > mass.size()/2; i --) {
			
			mass.set(i, mass.get( i) <<  1); //XOR симметричных элементов из списков до середины
			
		}
	
		int k = 0;
		while (mass.size() > 5) {

			LinkedList<Long> massNew = new LinkedList<>();
			for (int i = 0; i < mass.size() - 1; i ++) {
				
				switch (k % 4) {
				
					case (1): 
						massNew.add( mass.get(i) ^ mass.get(mass.size() - 1 - i) );
						break;
					
					case(2):
						massNew.add( mass.get(i) | mass.get(mass.size() - 1 - i) );
						break;
					
					case(3):
						massNew.add( mass.get(i) & mass.get(mass.size() - 1 - i) );
						break;
					
					default:
						massNew.add(mass.get(i));
						break;
						
				}
				
				
			}
			
			mass = massNew;
			
			k++;
			
		}

		StringBuilder Hash = new StringBuilder();
		for (long value : mass) {
			
			Hash.append( ReturnASCII(value) );
			
		}
		
		return Hash.toString();
		
	} 
	
	private char ReturnASCII(long letter) throws InterruptedException {
		
		while (!(((letter <= 70)&&(letter >= 65)) || ((letter <= 57)&&(letter >= 48)))) {
			
			if(letter < 48) letter += 60 ;
			else letter -= 51;
			if(letter == 0) letter += 1000;
			
		}
		
		return ((char) letter);
		
	}
	
}
