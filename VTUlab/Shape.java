package labprog;

abstract public class Shape {
abstract double CalculateArea();
abstract double CalculatePerimeter();
}

class Circle extends Shape{
	private double radius;
	
	public Circle(double radius)
	{
		this.radius=radius;
	}
	@Override
	double CalculateArea() {
		// TODO Auto-generated method stub
		return Math.PI*radius*radius;                                                                                                                                                                                                                                                                                                                                                   
	}


	@Override
	double CalculatePerimeter() {
		// TODO Auto-generated method stub
		return 2*Math.PI*radius;
	}
}
	
class Triangle extends Shape{
	private double side1;
	private double side2;
	private double side3;
	
	public Triangle(double side1, double side2,double side3)
	{
		this.side1=side1;
		this.side2=side2;
		this.side3=side3;
	}

	@Override
	double CalculateArea() {
		// TODO Auto-generated method stub
		double s=(side1+side2+side3)/2;
		return Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
	}

	@Override
	double CalculatePerimeter() {
		// TODO Auto-generated method stub
		return side1+side2+side3;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle circle=new Circle(5);
		System.out.println("Circle Area:"+circle.CalculateArea());
		System.out.println("Circle Perimeter:"+circle.CalculatePerimeter());
		Triangle triangle =new Triangle(3,4,5);
		System.out.println("Triangle Area:"+triangle.CalculateArea());
		System.out.println("Triangle Perimeter"+triangle.CalculatePerimeter());
	}

}
