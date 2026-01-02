package polymorphism;

public class Triangle extends Shape {
		@ Override
		public void draw(){
			System.out.println("Drawing a Triangle");
		}
		@Override
		public void erase()
		{
			System.out.println("Erasing a Triangle");
		}
	}
