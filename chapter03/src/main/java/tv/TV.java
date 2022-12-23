package tv;

public class TV {
	private int channel; // 1~255 
	private int volume;	 // 0~100
	private boolean power;
	
	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}
	
	public void power(boolean on) {
		this.power = on;
	}
	
	public void channel(int channel) {
		if(channel >255) {
			this.channel = 255;
		}
	}
	
	public void channel(boolean up) {
		if(up) {
			channel += 1;{
				if(channel > 255)
					this.channel = 1;
			}
		} else {
			channel -= 1;
			if(channel < 1)
				this.channel = 255;
		}
	}
	
	public void volume(int channel) {
		if(volume > 100) {
			this.volume = 100;
		}
		
	}
	public void volume(boolean up) {
		if(up) {
			volume += 1;
				if(volume > 100) {
					this.volume = 100;
				}
		} else {
			volume -= 1;
			if(volume < 1)
				this.volume = 1;
		}
		
	}
	public void status() {
		
		System.out.println(
				"TV[power=" + (power ? "on" : "off") + ","
				+ "channel=" + channel + ", " +
				"volume=" + volume + "]");
	}
}
