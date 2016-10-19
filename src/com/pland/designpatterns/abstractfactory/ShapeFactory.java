package com.pland.designpatterns.abstractfactory;

public interface ShapeFactory extends Factory{
	
	public Shape getShape(String shape);

}
