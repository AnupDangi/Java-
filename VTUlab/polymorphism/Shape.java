package polymorphism;

public class Shape {
	
	public void draw() {
		System.out.println("Drawing a Shape");
	}
	public void erase() {
		System.out.println("Erasing a Shape");
	}
	public static void main(String[] args) {
		Shape s1=new Circle();
		Shape s2=new Square();
		Shape s3=new Triangle();
		s1.draw();
		s1.erase();
		s2.draw();
		s2.erase();
		s3.draw();
		s3.erase();
	}
}