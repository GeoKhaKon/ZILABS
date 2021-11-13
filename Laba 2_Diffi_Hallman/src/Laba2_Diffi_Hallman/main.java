package Laba2_Diffi_Hallman;

import java.math.BigInteger;
import java.util.Random;

public class main {

	public static void main(String[] args) {
		
		Generator ProstoeChislo = new Generator();
		int p = ProstoeChislo.CozdatChislo();
		int q = ProstoeChislo.CozdatChislo();
		
		//Random chislo = new Random();
		int a = ProstoeChislo.CozdatChislo();
		int b = ProstoeChislo.CozdatChislo();
		
		BigInteger A = new BigInteger(Integer.toString(q));
		BigInteger B = new BigInteger(Integer.toString(q));
		BigInteger KeyA = new BigInteger(Integer.toString(q));
		BigInteger KeyB = new BigInteger(Integer.toString(q));
		BigInteger stepenA = new BigInteger(Integer.toString(a));
		BigInteger stepenB = new BigInteger(Integer.toString(b));
		BigInteger modP = new BigInteger(Integer.toString(p));
		
		A = A.modPow(stepenA, modP);
		B = B.modPow(stepenB, modP);
		
		KeyA = A;
		KeyB = B;
		
		KeyA = B.modPow(stepenA, modP);
		KeyB = A.modPow(stepenB, modP);
		
		System.out.print("p = " + p + " q = " + q  +"\n" + "a = " + a + " b = " + b + "\n"+ "A = " + A +" B = " + B + "\n" + "KeyA = " + KeyA + " KeyB = " + KeyB);
		
		

	}

}
