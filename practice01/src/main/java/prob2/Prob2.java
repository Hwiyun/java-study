package prob2;

public class Prob2 {
	public static void main(String[] args) {
		/* 코드 작성 */
//		int value=0;

        for(int i=1; i<10; i++) {
//                value = i;
            for(int j=i; j<10+i; j++) {
            	System.out.print(j+" ");
            } 
            System.out.println("");
        }
	}
}
