package com.citi;


/**
 * Consider Singleton as an example
 * 
 * The key is 
 * 1. static keyword for variable and method;
 * 2. null object can't be synchronized; so synchronize Singleton.class instead
 * 3. private constructor
 * 
 * Class objects are constructed automatically by the Java Virtual Machine as classes are 
	loaded and by calls to the defineClass method in the class loader;
	
	getClass(), or the class-literal - Foo.class return a Class object, 
	which contains some metadata about the class:
	name
	package
	methods
	fields
	constructors
	annotations
	
	Class objects are singleton per class loader
 * 
 * Actually I made all above mistakes during paper exam
 * 
 *
 */
public class Singleton {
	
	private static Singleton instance;
	
	public static Singleton getInstance(){
		
		if(instance == null){
			synchronized(Singleton.class){//synchronized(instance)
				if(instance == null){
					System.out.println("Into if block");
					instance = new Singleton();
				}
				else{
					System.out.println("Into else block");
				}
			}
		}
		return instance;
	}
	
	private Singleton(){
		super();
	}
	
	public static void main(String args[]){
		
		 Thread a = new Thread(){
			
			public void run(){
				System.out.println("Thread A start");
				Singleton.getInstance();
				System.out.println("Thread A end");
			}
			
		};
		
		Thread b = new Thread(){
			
			public void run(){
				System.out.println("Thread B start");
				Singleton.getInstance();
				System.out.println("Thread B end");
			}
			
		};
		
		a.start();

		b.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
