package com.pland.designpatterns.abstractfactory;

public class ShapeFactoryProducer implements ShapeFactory{

	private static ShapeFactoryProducer instance = new ShapeFactoryProducer();
	
	public static ShapeFactoryProducer getInstance(){
		return instance;
	}
	
	@Override
	public Shape getShape(String shape) {
		// TODO Auto-generated method stub
		if("Rectangle".equals(shape)){
			return new Rectangle();
		}
		else if("Circle".equals(shape)){
			return new Circle();
		}
		return null;
	}

}
