package com.pland.designpatterns.abstractfactory;

public class AbstractFactoryProducer implements AbstractFactory {

	private static AbstractFactoryProducer instance = new AbstractFactoryProducer();
	
	public static AbstractFactoryProducer getInstance(){
		return instance;
	}
	
	@Override
	public ShapeFactory getShapeFactory() {
		// TODO Auto-generated method stub
		return ShapeFactoryProducer.getInstance();
		
		
	}

	@Override
	public ColorFactory getColorFactory() {
		// TODO Auto-generated method stub
		return ColorFactoryProducer.getInstance();
	}

}
