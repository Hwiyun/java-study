package prob3;

import java.util.Scanner;

public class Prob3 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		/* 코드 작성 */
		System.out.println("숫자값을 입력하세요");
		int num = scanner.nextInt();
		int	sum = 0;
		
		if(num%2 == 0) {
			for(int i=2;i<=num;i++)
				if(i%2 == 0)
		System.out.println("결과 값 :" + sum);
		
		else {
			for(int j=1;j<=num;j++)
				if(j%2 !== 0);
		}
		System.out.println("결과 값 :" + sum);
		}
		
		scanner.close();
	}
}
