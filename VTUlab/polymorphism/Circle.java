package polymorphism;

public class Circle extends Shape {
	@ Override
	public void draw() {
		System.out.println("Drawing a Circle");
	}
	@Override
	public void erase()
	{
		System.out.println("Erasing a Circle");
	}
}
