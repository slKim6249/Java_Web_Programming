package com.ktds;

import java.util.ArrayList;
import java.util.List;

public class Ktds {

	public static void main(String[] args) {
		
		new Ktds().run();
		
	}
	
	public void run() {
		
		List<Friend> friendList = new ArrayList<Friend>();
		
		// Sun Class is a Super Class
		// KtdsFriend is a Friend
		
		// SuperClass name = new SubClass();
		Friend friend = new KtdsFriend();
		
		friend.setName("상무");
		
		if( friend instanceof KtdsFriend ) {
			KtdsFriend ktFriend = (KtdsFriend) friend;
			ktFriend.setPhone("010-8941-6248");
			ktFriend.setAge(26);
		}
		
		friendList.add(friend);
		
		friend = new Friend();
		friend.setName("전상무");
		friendList.add(friend);
		
		for (Friend f : friendList) {
			System.out.println(f.getName());
			
			if( f instanceof KtdsFriend ) {
				KtdsFriend kf = (KtdsFriend) f;
				System.out.println(kf.getAge());
				System.out.println(kf.getPhone());
			}
			
		}
	}

}
