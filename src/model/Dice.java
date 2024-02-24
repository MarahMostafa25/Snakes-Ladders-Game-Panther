package model;

import java.util.Random;

import utils.Level;

public class Dice {
	
	private static int idCounter = 1;
	private Integer id;
	private int minValue;
	private int maxValue;
	private int result ;
	private Level levelGame;
	public Dice(int minValue, int maxValue , Level levelGame) {
		this.levelGame=levelGame;
		this.id=idCounter++;
		if(minValue<0)
		{
			this.minValue=0;
		}
		else
		{
			this.minValue = minValue;
		}
		if(levelGame.equals(Level.Easy))
		{
			this.maxValue=8;
		}
		else
		{
			if(levelGame.equals(Level.Medium))
			{
				this.maxValue = 13;

			}
		}

		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getMinValue() {
		return minValue;
	}
	
	public int getMaxValue() {
		return maxValue;
	}
	
	public int getResult() {
		
		Random random = new Random();
		return random.nextInt((this.maxValue - this.minValue) + 1) + this.minValue;
		
	}
	public void setResult(int result) {
		this.result = result;
	}
	
	
	public static int getIdCounter() {
		return idCounter;
	}
	public static void setIdCounter(int idCounter) {
		Dice.idCounter = idCounter;
	}
	public Level getLevelGame() {
		return levelGame;
	}
	public void setLevelGame(Level levelGame) {
		this.levelGame = levelGame;
	}
	
	@Override
	public String toString() {
		return "Dice [id=" + id + ", minValue=" + minValue + ", maxValue=" + maxValue + ", result=" + result + "]";
	}
	


}
