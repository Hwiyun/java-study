package prob6;

public class Rectangle extends Shape implements Resizable  {

	public double width;
	public double height;
	
	public double getArea() {
		return width * height;
	}
	
	public double getPerimeter() {
		return (width + height)*2;
	}
	
	
	public Rectangle(int i, int j) {
		this.width = i;
		this.height = j;
		
	}

	@Override
	public void resize(double d) {
		width = width * d;
		height = height * d;
		
	}

}
