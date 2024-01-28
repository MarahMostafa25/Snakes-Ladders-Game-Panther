package model;

import java.util.Random;

public class Dice {
	
	private static int idCounter = 1;
	private Integer id;
	private int minValue;
	private int maxValue;
	private int result ;
	public Dice(int minValue, int maxValue) {
		super();
		this.id=idCounter++;
		if(minValue<0)
		{
			this.minValue=0;
		}
		else
		{
			this.minValue = minValue;
		}
		if(maxValue>10)
		{
			this.maxValue=10;
		}
		else
		{
			this.maxValue = maxValue;
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
	public void setMinValue(int minValue) {
		this.minValue = minValue;
	}
	public int getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}
	public int getResult() {
		
		Random random = new Random();
		return random.nextInt((this.maxValue - this.minValue) + 1) + this.minValue;
		
	}
	public void setResult(int result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "Dice [id=" + id + ", minValue=" + minValue + ", maxValue=" + maxValue + ", result=" + result + "]";
	}
	


}
