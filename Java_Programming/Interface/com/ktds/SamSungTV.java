package com.ktds;

public class SamSungTV implements TV {

	private boolean isOn;
	private int channel;
	private int volume;
	
	@Override
	public void On() {
		System.out.println("SAM SUNG");
		isOn = true;
	}

	@Override
	public void Off() {
		System.out.println("Good Bye~");
		isOn = false;
	}

	@Override
	public void channelUP() {
		if( isOn) {
			System.out.println("삑");
			System.out.println("채널을 올립니다.");
			channel++;
			System.out.println("채널번호 : " + channel);
		}
	}

	@Override
	public void channelDown() {
		if( isOn) {
			System.out.println("삑");
			System.out.println("채널을 내립니다.");
			channel--;
			System.out.println("채널번호 : " + channel);
		}
	}

	@Override
	public void volumeUp() {
		if( !isOn) {
			On();
		}
		
		System.out.println("삑");
		System.out.println("볼륨을 올립니다.");
		volume++;
		System.out.println("Volume : " + volume);
	}

	@Override
	public void volumeDown() {
		if( isOn) {
			On();
		}
		
		System.out.println("삑");
		System.out.println("볼륨을 내립니다.");
		volume--;
		System.out.println("Volume : " + volume);
	}
	
	
	
}
