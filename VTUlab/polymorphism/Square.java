package polymorphism;

public class Square extends Shape {
		@ Override
		public void draw() {
			System.out.println("Drawing a Square");
		}
		@Override
		public void erase()
		{
			System.out.println("Erasing a Square ");
		}
	}
