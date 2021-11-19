package Laba3;

import java.util.ArrayList;
import java.util.Random;

public class Generator { //Генерируем простое число методом решета Эратосфена
	
	
	public int CozdatChislo() {
		
		ArrayList <Integer> ListChisel = new ArrayList(); //Список от 0 до k
		ArrayList <Boolean> ListChiselBool = new ArrayList(); 
		
		Random random = new Random();
		int k = random.nextInt(1000); //Генерируем случайное число до 1000
		
		for (int i = 0; i <= k; i ++) { ListChisel.add(i); ListChiselBool.add(true); } //Заполняем массив всеми числами
		
		for (int i = 2; i*i <= k; i ++) {
			
			if (ListChiselBool.get(i)) { //Если число простое, то делим на него все оставшиеся в массиве
				
				
					for (int j = i*i; j <= k; j ++) if (ListChisel.get(j) % i == 0)  { ListChiselBool.set(j, false); }//Если число в массиве делится нацело, то устанавливаем ложь
				
				
			}
			
		}
		
		//System.out.print(ListChisel + "\n" + ListChiselBool + "\n");
		
		for (int i = ListChisel.size() - 1; i > 0; i --) if(ListChiselBool.get(i)) return ListChisel.get(i);  //Возвращаем последнее простое число
		
		return -1;
		
	}
	
}
