package Laba3;

import java.util.ArrayList;
import java.util.Random;

public class Generator { //���������� ������� ����� ������� ������ ����������
	
	
	public int CozdatChislo() {
		
		ArrayList <Integer> ListChisel = new ArrayList(); //������ �� 0 �� k
		ArrayList <Boolean> ListChiselBool = new ArrayList(); 
		
		Random random = new Random();
		int k = random.nextInt(1000); //���������� ��������� ����� �� 1000
		
		for (int i = 0; i <= k; i ++) { ListChisel.add(i); ListChiselBool.add(true); } //��������� ������ ����� �������
		
		for (int i = 2; i*i <= k; i ++) {
			
			if (ListChiselBool.get(i)) { //���� ����� �������, �� ����� �� ���� ��� ���������� � �������
				
				
					for (int j = i*i; j <= k; j ++) if (ListChisel.get(j) % i == 0)  { ListChiselBool.set(j, false); }//���� ����� � ������� ������� ������, �� ������������� ����
				
				
			}
			
		}
		
		//System.out.print(ListChisel + "\n" + ListChiselBool + "\n");
		
		for (int i = ListChisel.size() - 1; i > 0; i --) if(ListChiselBool.get(i)) return ListChisel.get(i);  //���������� ��������� ������� �����
		
		return -1;
		
	}
	
}
