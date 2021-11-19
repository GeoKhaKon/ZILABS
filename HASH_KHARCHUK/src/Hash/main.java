package Hash;

import java.util.Scanner;

public class main {

	public static void main(String[] args) throws InterruptedException {

		HashSum hash = new HashSum();
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine();
		scanner.close();
		System.out.println("Õýø = " + hash.ReturnHash(text));

	}

}
