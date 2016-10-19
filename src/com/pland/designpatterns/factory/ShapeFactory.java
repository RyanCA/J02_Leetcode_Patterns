package com.pland.designpatterns.factory;

public class ShapeFactory implements Factory {
	
	public static Shape getShape(String shape){
		if("Circle".equals(shape)){
			return new Circle();
		}
		else if ("Rectangle".equals(shape)){
			return new Rectangle();
		}
		return null;
	}

}
