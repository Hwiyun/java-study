package prob01;

import java.util.HashSet;
import java.util.Set;

public class Gugudan {
	private int lValue;
	private int rValue;
	
	public Gugudan(int lValue, int rValue) {
		this.lValue = lValue;
		this.rValue = rValue;
	}

	public int[] getList(int resultNumber) {
		Set<Integer> set = new HashSet<>();
		set.add(resultNumber);
		
		while(set.size()<=9) {
			int random = (int) (Math.random() * 9) + 1;
			int random2 = (int) (Math.random() * 9) + 1;
				set.add(random*random2);
		}
		set.remove(resultNumber);
		int [] p = set.stream()
                .mapToInt(Integer::intValue)
                .toArray();
		return p;
	}
}