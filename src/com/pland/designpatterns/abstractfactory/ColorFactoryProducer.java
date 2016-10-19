package com.pland.designpatterns.abstractfactory;

public class ColorFactoryProducer implements ColorFactory {

	private static ColorFactoryProducer instance = new ColorFactoryProducer();
	
	public static ColorFactoryProducer getInstance(){
		return instance;
	}
	
	@Override
	public Color getColor(String color) {
		// TODO Auto-generated method stub
		if("Red".equals(color)){
			return new Red();
		}
		else if("Green".equals(color)){
			return new Green();
		}
		return null;
	}

}
