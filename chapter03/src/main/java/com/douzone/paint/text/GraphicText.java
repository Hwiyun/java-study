package com.douzone.paint.text;

import com.douzone.paint.i.Drawable;

public class GraphicText implements Drawable {
	private String text;
	
	public GraphicText(String text) {
		this.text = text;
	}

	@Override
	public void draw() {
		System.out.println("텍스트 '" + "'를 그렸습니다.'");
		
		// TODO Auto-generated method stub

	}

}
