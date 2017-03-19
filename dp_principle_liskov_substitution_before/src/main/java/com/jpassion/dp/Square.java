package com.jpassion.dp;

// BAD: Square changes the behavior of computeArea()
// method of the parent class, Rectangle.
class Square extends Rectangle {
	
	public void setWidth(int width) {
		this.width = width;
		this.height = width;
	}

	public void setHeight(int height) {
		this.width = height;
		this.height = height;
	}

}