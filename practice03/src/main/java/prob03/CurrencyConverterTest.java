package prob03;

// import java.util.Scanner;

public class CurrencyConverterTest {

	public static void main(String[] args) {
		//  환율을 세팅 합니다.
		int setRate= 0;
		CurrencyConverter.setRate(1197.0);
		
		// Scanner input = new Scanner(System.in);
		
		double dollar = CurrencyConverter.toDollar( 1000000. );
		System.out.println( "백만원은 " + dollar + "달러 입니다" );
		
		double krw = CurrencyConverter.toKRW( 100. );
		System.out.println( "백달러는 " + krw + "만원 입니다" );
	}

}
