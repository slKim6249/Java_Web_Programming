package com.ktds;

import java.util.ArrayList;
import java.util.List;

public class IndexOutofExceptionTest {

	public static void main(String[] args) {
		new IndexOutofExceptionTest().run();
	}

	public void run() {
		List<String> nameList = new ArrayList<String>();
		// System.out.println(nameList.get(0));
		for (String name : nameList) {
			System.out.println(name);
		}
	}
	
}
