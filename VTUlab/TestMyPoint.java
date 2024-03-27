package labprog;

import java.util.Scanner;
public class TestMyPoint {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		// Test default constructor
		MyPoint point1 =new MyPoint();
		System.out.println("Default Constructor - Point 1 coordinate : " + point1.toString());
		
		// Test overloaded constructor
		System.out.println("Enter the x coordinate for Point 2:");
		int x2 = in.nextInt();
		System.out.println("Enter the y coordinate for Point 2:");
		int y2 = in.nextInt();
		MyPoint point2 = new MyPoint(x2,y2);
		System.out.println("Overloaded Constructor - Point 2 coordinate : " + point2.toString());
		
		//test setXY method
		System.out.println("Enter new X coordinate for point 1: ");
		int newX=in.nextInt();
		System.out.println("Enter new Y coordinate for point 1: ");
		int newY=in.nextInt();
		point1.setXY(newX, newY);
		System.out.println("After setXY method - Point 1 coordinates: "+ point1.toString());
		
		//test getXY method
		int[] point2Coordinates = point2.getXY();
        System.out.println("getXY Method - Point 2 coordinates : (" + point2Coordinates[0] +","+ point2Coordinates[1]);
		
		System.out.println("toString Method - Point 1:" +point1);
		
		System.out.println("Enter the x coordinate for New Point:");
		int x3 = in.nextInt();
		System.out.println("Enter the y coordinate for New Point:");
		int y3 = in.nextInt();
		MyPoint newPoint = new MyPoint(x3,y3);
		
		System.out.println("Distance from Point 1 to new point : "+ point1.distance(newPoint));
		System.out.println("Distance from Point 2 to new point : "+ point2.distance(newPoint));
		System.out.println("Distance from Point 1 to origin(0,0) : "+ point1.distance());
		
		in.close();
}
}