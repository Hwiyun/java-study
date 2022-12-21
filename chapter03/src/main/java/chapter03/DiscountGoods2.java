package chapter03;

import myPackage.Goods2; //ctrl + enter

public class DiscountGoods2 extends Goods2 { // 상속받을 때 extends
	private Long i = 22222222222222L;
	private float discountrate = 0.5f;
	
	public float getDiscountPrice() {
		// protected는 자식에서 접근할 수 있다.
		return discountrate*price;
	}
}
