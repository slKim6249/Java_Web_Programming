package com.ktds;

public class Main {

	public static void main(String[] args) {
		
		new Main().run();
		
	}
	
	public void run() {
		
		Logging logger = new MessageLogger();
		
		logger.printLogging();
	}

}
