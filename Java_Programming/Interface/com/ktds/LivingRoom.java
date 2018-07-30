package com.ktds;

public class LivingRoom {
	
	// Interface TV
	// private TV tv;

	public static void main(String[] args) {
		
		new LivingRoom().run( new LGTV() );
		
	}
	
	public void run( LGTV tv ) {
		// Sub Class is a Super Class
		// Sub Class => LGTV
		// Super Class => TV
		
		// tv = new LGTV();
		
		tv.On();
		
		// tv가 MutableTV인지 확인
		if( tv instanceof MutableTV )  { 
			MutableTV mTV = (MutableTV) tv;
			mTV.Mute();
		}
		
		tv.channelUP();
		tv.channelDown();
		tv.volumeUp();
		tv.volumeUp();
		tv.volumeUp();
		tv.volumeUp();
		tv.volumeDown();
		tv.Off();
		
	}
	
//	public void runSamSung( Tv tv ) {
//		// Sub Class is a Super Class
//		// Sub Class => SAMSUNGTV
//		// Super Class => TV
//		tv = new SamSungTV();
//		
//		tv.On();
//		tv.channelUP();
//		tv.channelDown();
//		tv.volumeUp();
//		tv.volumeUp();
//		tv.volumeUp();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.Off();
//		
//	}

}
