package Laba3;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
	
		Generator chislo = new Generator();
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine(); //��������� �������
		scanner.close(); 
		
		BigInteger p = new BigInteger( Integer.toString(chislo.CozdatChislo()) );
		BigInteger q = new BigInteger( Integer.toString(chislo.CozdatChislo()) );
		BigInteger m = new BigInteger( p.multiply(q).toString() ); //������ ��� ���������� ���������� m = p * q
		BigInteger e = new BigInteger( Integer.toString(chislo.CozdatChislo()) ); // {m, e} - �������� ����, �������� ����
		BigInteger fi = new BigInteger( p.subtract( BigInteger.ONE ).multiply( q.subtract( BigInteger.ONE ) ).toString() ); // fi = (p-1)*(q-1)
		
		while ( fi.mod(e) == BigInteger.ZERO )  { BigInteger value = new BigInteger ( Integer.toString(chislo.CozdatChislo()) );  e = value; }
		
		BigInteger d = new BigInteger ( e.modInverse(fi).toString() ); // {m, d} - �������� ����, �������� ������ 1 ������������
		
		System.out.println("p = " + p + " q = " + q + "\nm = " + m + " e = " + e + "\nfi = " + fi + " d = " + d);
		
		//������� ���� ������� ����������� ��������� �����
		LinkedList<BigInteger> BigListShifr = new LinkedList<>();
		for( char s : text.toCharArray() ) { //�� ������� �������� ������
			
			BigInteger value = new BigInteger( Integer.toString( (int) s ) );
			value = value.modPow(e, m); // ����� ^ e % m
			BigListShifr.add(value);
			
		}
		
		//����������� ���� ������� ����������� ��������� �����
		StringBuilder DeshifrText = new StringBuilder(); //��� ����� ������� ������������� �������
		for( BigInteger value : BigListShifr ) {
			
			value = value.modPow(d, m); // ����������� ����� ^ d % m
			DeshifrText.append((char) value.intValue() ); //�������� ��� ���� �����
			
		}
		
		System.out.println("�������� ���� ������� = " + text + "\n����������� ���� ������� = " + BigListShifr + "\n������������� ���� ������� = " + DeshifrText);
		

	}

}
