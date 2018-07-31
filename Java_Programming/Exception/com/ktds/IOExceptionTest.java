package com.ktds;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IOExceptionTest {

	public static void main(String[] args) {
		new IOExceptionTest().run();
	}
	
	public void run() {
		File file = new File("D:/abc.txt");
		
		FileReader fr = null;
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e) {
			System.out.println(e + " 예외 발생");
		}
		
		if ( fr != null ) {
			BufferedReader br = new BufferedReader( fr );
			
			String line = null;
			try {
				while ( (line = br.readLine()) != null ) {
					System.out.println(line);
				}
			} catch (IOException e) {
				System.out.println( e.getMessage() );
			}
		}
		
	}

}
