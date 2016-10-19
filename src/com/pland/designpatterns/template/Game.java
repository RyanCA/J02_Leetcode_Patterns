package com.pland.designpatterns.template;

public abstract class Game {
	
	public void play(){
		initialize();
		startGame();
		endGame();
	}
	public abstract void initialize();
	public abstract void startGame();
	public abstract void endGame();

}
