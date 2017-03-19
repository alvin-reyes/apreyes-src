package com.jpassion.dp;

public class Client {
	
	private static Rectangle getNewRectangle() {
		return new Rectangle();
		// return new Square(); // GOOD: This results in a compile error
	}
	
	private static Square getSquare() {
		return new Square(); // GOOD: This results in a compile error
	}

	public static void main(String args[]) {
		
		Rectangle r = Client.getNewRectangle();
		r.setWidth(5);
		r.setHeight(10);
		System.out.println("Rectangle with 5 and 10 = " + r.computeArea());
		
		Square s = Client.getSquare();
		s.setWidth(6);
		System.out.println("Square with 5 = " + s.computeArea());
	}

}
