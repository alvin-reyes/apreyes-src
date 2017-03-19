package com.jpassion.dp;

public class Client {
	
	private static Rectangle getNewRectangle() {
		// BAD; Square changes the behavior of its parent class, Rectangle
		return new Square();
	}

	public static void main(String args[]) {
		Rectangle r = Client.getNewRectangle();

		r.setWidth(5);
		r.setHeight(10);

		System.out.println("Sqaure Rectangle with 10 and 10 = " + r.computeArea());
	}

}
