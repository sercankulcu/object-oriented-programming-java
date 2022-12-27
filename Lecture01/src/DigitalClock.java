public class DigitalClock {
  private int hour;
  private int minute;
  private int second;
  
  public DigitalClock(int hour, int minute, int second) {
    this.hour = hour;
    this.minute = minute;
    this.second = second;
  }
  
  public void incrementHour() {
    hour++;
    if (hour > 23) {
      hour = 0;
    }
  }
  
  public void incrementMinute() {
    minute++;
    if (minute > 59) {
      minute = 0;
      incrementHour();
    }
  }
  
  public void incrementSecond() {
    second++;
    if (second > 59) {
      second = 0;
      incrementMinute();
    }
  }
  
  public int getHour() {
    return hour;
  }
  
  public int getMinute() {
    return minute;
  }
  
  public int getSecond() {
    return second;
  }
  
  public void setTime(int hour, int minute, int second) {
    this.hour = hour;
    this.minute = minute;
    this.second = second;
  }
  
  public static void main(String[] args)
  {
	  DigitalClock clock = new DigitalClock(12, 0, 0);
	  clock.incrementHour();
	  System.out.println(clock.getHour()); // prints "13"

  }
}
