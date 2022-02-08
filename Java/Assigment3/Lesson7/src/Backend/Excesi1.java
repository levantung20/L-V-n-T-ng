package Backend;

import java.nio.channels.Pipe;
import java.util.Scanner;

import Entity.MyMath;

public class Excesi1 {
		public static void main(String[] args) {
		MyMath math = new MyMath();
		Scanner scanner = new Scanner(System.in);
		System.out.println("mời bạn nhập vào a : ");
		int a = scanner.nextInt();
		System.out.println(math.sum(a));
		}
	
		
}



		

