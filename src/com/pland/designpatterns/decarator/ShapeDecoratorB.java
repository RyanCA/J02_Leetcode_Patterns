package com.pland.designpatterns.decarator;

public class ShapeDecoratorB implements ShapeDecoratorIntf{
	
	private ShapeIntf shape;
	
	public ShapeDecoratorB(ShapeIntf shape){
		this.shape = shape;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("This is ShapeDecoratorB begin ---->");
		shape.draw();
		System.out.println("This is ShapeDecoratorB end <----");
	}
	

}
