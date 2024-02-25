package model;

public class TimerClass {
	private int hour;
	private int minute;
	private int second;
	public TimerClass(int hour, int minute, int second) {
		super();
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
public String getCurrentTime() {
	return hour +":" + minute +":" + second;
}
public  TimerClass(String currectTime) {
	
	String[] time =currectTime.split(":");
	hour = Integer.parseInt(time[0]);
	minute = Integer.parseInt(time[1]);
	second = Integer.parseInt(time[2]);

}

public void oneSecondPassed() {
	second++;
	if(second == 60 ) {
		minute ++;
		second = 0;
	}
	if (minute == 60) {
		hour++;
		minute = 0;
	}
    if(hour == 24) {
    	hour =0;
    	
    }
}
}
