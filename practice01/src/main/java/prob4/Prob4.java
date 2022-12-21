package prob4;

import java.util.Scanner;

public class Prob4 {

	public static void main(String[] args) {

		System.out.print("문자열을 입력하세요 : ");
			Scanner scanner = new Scanner(System.in);
			String text = scanner.nextLine();
			scanner.close();
			
		char [] a = text.toCharArray();
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j <= i; j++) {
					System.out.print(a[j]);
				}
				System.out.println();
			}
			

		
		scanner.close();
	}

}
