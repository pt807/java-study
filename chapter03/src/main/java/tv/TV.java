package tv;

public class TV {
	private int channel; // 1~255
	private int volume; // 0~100
	private boolean power;
<<<<<<< HEAD
=======

>>>>>>> refs/remotes/origin/master
	
	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}

	public void power(boolean on) {
		this.power = on;
	}

	public void channel(boolean up) {
		if (up) {
			channel(channel + 1);
		} else {
			channel(channel - 1);
		}
	}

	public void channel(int channel) {
		if (channel < 1) {
			channel = 255;
		} else if (channel > 255) {
			channel = 1;
		}
		this.channel = channel;
	}

	public void volume(boolean up) {
		if (up) {
			volume(volume + 1);
		} else {
			volume(volume - 1);
		}
	}

	public void volume(int volume) {
		if (volume < 0) {
			volume = 100;
		} else if (volume > 100) {
			volume = 0;
		}

		this.volume = volume;
	}

	public void status() {
		System.out.println("TV[power =" + (power ? "on" : "off") + ", " + "channel =" + channel + ", " + "volume ="
				+ volume + "]");
	}

}
