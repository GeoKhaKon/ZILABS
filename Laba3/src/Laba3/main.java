package Laba3;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
	
		Generator chislo = new Generator();
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine(); //Считываем строчку
		scanner.close(); 
		
		BigInteger p = new BigInteger( Integer.toString(chislo.CozdatChislo()) );
		BigInteger q = new BigInteger( Integer.toString(chislo.CozdatChislo()) );
		BigInteger m = new BigInteger( p.multiply(q).toString() ); //Модуль для модулярной арифметики m = p * q
		BigInteger e = new BigInteger( Integer.toString(chislo.CozdatChislo()) ); // {m, e} - Открытый ключ, известен всем
		BigInteger fi = new BigInteger( p.subtract( BigInteger.ONE ).multiply( q.subtract( BigInteger.ONE ) ).toString() ); // fi = (p-1)*(q-1)
		
		while ( fi.mod(e) == BigInteger.ZERO )  { BigInteger value = new BigInteger ( Integer.toString(chislo.CozdatChislo()) );  e = value; }
		
		BigInteger d = new BigInteger ( e.modInverse(fi).toString() ); // {m, d} - Закрытый ключ, известен только 1 пользователю
		
		System.out.println("p = " + p + " q = " + q + "\nm = " + m + " e = " + e + "\nfi = " + fi + " d = " + d);
		
		//Шифруем нашу строчку посредством открытого ключа
		LinkedList<BigInteger> BigListShifr = new LinkedList<>();
		for( char s : text.toCharArray() ) { //По каждому элементу строки
			
			BigInteger value = new BigInteger( Integer.toString( (int) s ) );
			value = value.modPow(e, m); // буква ^ e % m
			BigListShifr.add(value);
			
		}
		
		//Дешифрируем нашу строчку посредством закрытого ключа
		StringBuilder DeshifrText = new StringBuilder(); //Тут будем хранить дешифрованную строчку
		for( BigInteger value : BigListShifr ) {
			
			value = value.modPow(d, m); // шифрованная буква ^ d % m
			DeshifrText.append((char) value.intValue() ); //Получаем уже саму букву
			
		}
		
		System.out.println("Исходная наша строчка = " + text + "\nШифрованная наша строчка = " + BigListShifr + "\nДешифрованная наша строчка = " + DeshifrText);
		

	}

}
