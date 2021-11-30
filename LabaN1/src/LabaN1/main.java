package LabaN1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws IOException {
		
		String alphabet = "אבגדהו¸זחטיךכלםמןנסעףפץצקרשתûü‎‏ÿ";
		StringBuilder Text = new StringBuilder();
		File file = new File("File.txt");
		FileReader readFile = new FileReader(file); //Ñקטעûגאול סענמךף ג פאיכו
		BufferedReader buffer = new BufferedReader(readFile);
		String Line = buffer.readLine();
		
		while(Line != null) {
			Text.append(Line + "\n");
			Line = buffer.readLine();
		}
		
		buffer.close();
		
		StringBuilder KeyAlpha = new StringBuilder();
		Scanner scan = new Scanner(System.in);
		System.out.println("Âגוהטעו ךכ‏ק: ");
		StringBuilder Key = new StringBuilder(scan.nextLine());
		System.out.println("Âגוהטעו ןמחטצט‏: ");
		int pos = scan.nextInt();
		
		String result = Key.reverse().toString();
		result = result.replaceAll("(.)(?=.*\\1)", "");
		result = new StringBuilder(result).reverse().toString();

		KeyAlpha.append(result);
		StringBuilder Alpha = new StringBuilder(" " + alphabet);
		
		for (int i = 0; i < Alpha.length(); i ++) {
			
			for(int j = 0; j < KeyAlpha.length(); j ++) {
				
				if (Alpha.charAt(i) == KeyAlpha.charAt(j)) { Alpha.delete(i, i+1); i--; }
				
			}
			
		}
		
		Alpha.delete(0, 1);
		
		KeyAlpha.insert(0, Alpha.subSequence(Alpha.length()-pos, Alpha.length()));
		Alpha.delete(Alpha.length()-pos, Alpha.length());
		KeyAlpha.append(Alpha);
		System.out.println(alphabet + "\n" + KeyAlpha);
		StringBuilder EnText = new StringBuilder(Text.toString().toLowerCase());
		
		for (int i = 0; i < EnText.length(); i ++) {
			
			if(alphabet.contains(EnText.substring(i, i+1))) {
				
				int p = alphabet.indexOf(EnText.substring(i, i+1));
				EnText.replace(i, i+1, Character.toString(KeyAlpha.charAt(p)));
				
			} 
			
		}
		
		FileWriter writeFile = new FileWriter("EnText.txt");
		writeFile.write(EnText.toString());
		writeFile.close();
		
		String StatisticAlpha = "מואטםעסכגנךלהףןÿüבקûדחזיץר‏צש‎¸תפ";
		HashMap<String, Integer> mapStatEn = new HashMap<>();
		
		for (int i = 0; i < EnText.length(); i ++) {
			
			if(alphabet.contains(EnText.substring(i, i+1))) {
				String charI = EnText.substring(i, i+1);
				mapStatEn.put(charI, mapStatEn.getOrDefault(charI, 1) + 1);
				
			}
			
			
		}
		StringBuilder StatEnAlpha = new StringBuilder();
		HashMap <Integer, String> revMap = new HashMap<>();
		for(String s : mapStatEn.keySet()) revMap.put(mapStatEn.get(s), s);
		ArrayList <Integer> SortList = new ArrayList<>(revMap.keySet());
		Collections.sort(SortList, Collections.reverseOrder());
		
		for(Integer i : SortList) StatEnAlpha.append(revMap.get(i));
		
		System.out.println(StatisticAlpha + "\n" + StatEnAlpha);
		
		StringBuilder DecText = new StringBuilder(EnText);
		for (int i = 0; i < EnText.length(); i ++) {
			
			if(alphabet.contains(EnText.substring(i, i+1))) {
				
				int p = StatEnAlpha.indexOf(EnText.substring(i, i+1));
				DecText.replace(i, i+1, Character.toString(StatisticAlpha.charAt(p)));
				
			} 
			
		}
		
		writeFile = new FileWriter("DecTextFreq.txt");
		writeFile.write(DecText.toString());
		writeFile.close();
		
		HashMap<String, Integer> BiMapSour = new HashMap<>();
		HashMap<String, Integer> BiMapEn = new HashMap<>();
		
		for (int i = 0; i < Text.length() - 1; i++) {
			
			if( alphabet.contains(Text.substring(i, i+1)) && alphabet.contains(Text.substring(i+1, i+2)) ) {
				
				String charI = Text.substring(i, i+2);
				BiMapSour.put(charI, BiMapSour.getOrDefault(charI, 1) + 1);
				charI = EnText.substring(i, i+2);
				BiMapEn.put(charI, BiMapEn.getOrDefault(charI, 1) + 1);
				
			}
			
		}
		
		HashMap<Integer, String> BiMapSourRev = new HashMap<>();
		HashMap<Integer, String> BiMapEnRev = new HashMap<>();
		
		for (String s : BiMapSour.keySet()) {
			int k = BiMapSour.get(s);
			//while (BiMapSourRev.get(k) != null) k--;
			BiMapSourRev.put(k, s);
			
		}
		
		for (String s : BiMapEn.keySet()) {
			int k = BiMapEn.get(s);
			//while (BiMapEnRev.get(k) != null) k--;
			BiMapEnRev.put(k, s);
			
		}
		
		ArrayList <Integer> SortListBiSour = new ArrayList<>(BiMapSourRev.keySet());
		ArrayList <Integer> SortListBiEn = new ArrayList<>(BiMapEnRev.keySet());
		Collections.sort(SortListBiSour, Collections.reverseOrder());
		Collections.sort(SortListBiEn, Collections.reverseOrder());
		
		StringBuilder BiAlpha = new StringBuilder();
		StringBuilder BiAlphaEn = new StringBuilder();
		
		for(Integer i : SortListBiSour) BiAlpha.append(BiMapSourRev.get(i));
		for(Integer i : SortListBiEn) BiAlphaEn.append(BiMapEnRev.get(i));
		
		
		StringBuilder TextDeBi = new StringBuilder(EnText);
		
		for (int i = 0; i < Text.length() - 1; i++) {
			
			if( alphabet.contains(Text.substring(i, i+1)) && alphabet.contains(Text.substring(i+1, i+2)) ) {
				
				String charI = TextDeBi.substring(i, i+2);
				int p = BiAlphaEn.indexOf(charI);
				if(p != -1)
					TextDeBi.replace(i, i+2, BiAlpha.substring(p, p + 2));
				
			}
			
		}
		
		writeFile = new FileWriter("DecTextBiFreq.txt");
		writeFile.write(TextDeBi.toString());
		writeFile.close();
		
	}

}
