package com.ktds;

public class LGTV implements TV {

	private final int MIN_VOLUME = 0;
	private final int MAX_VOLUME = 10;
	
	private boolean isOn;
	private int channel;
	private int volume;
	
	@Override
	public void On() {
		System.out.println("TV전원을 켭니다");
		isOn = true;
	}

	@Override
	public void Off() {
		System.out.println("TV전원을 끕니다");
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
		if( isOn) {
			System.out.println("삑");
			System.out.println("볼륨을 올립니다.");
			volume++;
			
			if( volume > MAX_VOLUME) {
				volume = MAX_VOLUME;
			}
			
			System.out.println("Volume : " + volume);
		}
	}

	@Override
	public void volumeDown() {
		if( isOn) {
			System.out.println("삑");
			System.out.println("볼륨을 내립니다.");
			volume--;
			
			if( volume < MIN_VOLUME) {
				volume = MIN_VOLUME;
			}
			
			System.out.println("Volume : " + volume);
		}
	}
	
	
	public void mute() {
		System.out.println("음소거 모드");
		volume = MIN_VOLUME;
	}
	
	
	
}
