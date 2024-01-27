package model;

public class Dice {
	
	private static int idCounter = 1;
	private Integer id;
	private int minValue;
	private int maxValue;
	private int result ;
	public Dice(int minValue, int maxValue, int result) {
		super();
		this.id=idCounter++;
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.result = result;
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
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "Dice [id=" + id + ", minValue=" + minValue + ", maxValue=" + maxValue + ", result=" + result + "]";
	}
	


}
