package com.pland.designpatterns.decarator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

/**
 * https://www.tutorialspoint.com/design_pattern/decorator_pattern.htm
 *
 */

public class Test {
	
	public static void main(String[] args){
		Circle cle = new Circle();
		ShapeDecoratorA da = new ShapeDecoratorA(cle);
		da.draw();
		ShapeDecoratorB db = new ShapeDecoratorB(cle);
		db.draw();
		ShapeDecoratorA da2 = new ShapeDecoratorA(cle);
		da2.draw();
		
		FileInputStream fi;
		BufferedInputStream bi;
	}

}
