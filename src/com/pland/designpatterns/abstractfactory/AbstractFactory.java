package com.pland.designpatterns.abstractfactory;

public interface AbstractFactory {
	
	public ShapeFactory getShapeFactory();
	
	public ColorFactory getColorFactory();

}
