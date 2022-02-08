package Vnext.com.vn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.println("nhập số phần tử của mảng ");
			int n = sc.nextInt();
			List<Integer> numbers = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				System.out.println("nhập phần tử thứ " + (i + 1 ) +  " : ");
				numbers.add(sc.nextInt());
				
			}
			int count = 1;
			for (int i = 0; i < numbers.size(); i++) {
				for(int j = i + 1 ; j < numbers.size(); j ++)
				if(numbers.get(i).equals(numbers.get(j))) {
				numbers.remove(j);
				count++;
				j--;
			}
			System.out.println(numbers.get(i) + " Xuất Hiện " +  count);
			count = 1;
		}
		
		}	
}
