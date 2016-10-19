package com.pland.designpatterns.abstractfactory;

/**
 * https://www.tutorialspoint.com/design_pattern/abstract_factory_pattern.htm
 *
 */
public class Test {
	
	public static void main(String args[]){
		AbstractFactoryProducer.getInstance().getColorFactory().getColor("Red").fill();
		AbstractFactoryProducer.getInstance().getColorFactory().getColor("Green").fill();
		
		AbstractFactoryProducer.getInstance().getShapeFactory().getShape("Rectangle").draw();
		AbstractFactoryProducer.getInstance().getShapeFactory().getShape("Circle").draw();
	}

}
