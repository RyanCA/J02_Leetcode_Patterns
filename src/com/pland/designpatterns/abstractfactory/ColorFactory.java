package com.pland.designpatterns.abstractfactory;

public interface ColorFactory extends Factory{
	
	public Color getColor(String color);

}
