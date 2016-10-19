package com.pland.designpatterns.decarator;

public class ShapeDecoratorA implements ShapeDecoratorIntf{
	
	private ShapeIntf shape;
	
	public ShapeDecoratorA(ShapeIntf shape){
		this.shape = shape;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("This is ShapeDecoratorA begin ---->");
		shape.draw();
		System.out.println("This is ShapeDecoratorA end <----");
	}
	

}
