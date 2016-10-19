package com.pland.designpatterns.singleton;

/**
 * https://www.tutorialspoint.com/design_pattern/singleton_pattern.htm
 *
 */
public class Singleton {
	
	private static Singleton instance;

	//Option 2
//	static{
//		instance = new Singleton();
//	}
	
	public static Singleton getInstance(){
		
		if(instance == null){
			synchronized(Singleton.class){
				if(instance == null){
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
	
	private Singleton(){
		super();
	}

}
