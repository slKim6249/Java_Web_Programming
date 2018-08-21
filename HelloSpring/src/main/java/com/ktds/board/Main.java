package com.ktds.board;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ktds.board.service.BoardService;

public class Main {

	public static void main(String[] args) {
		
		// applicationContext.xml 파일의 위치
		String applicationContext = "/applicationContext.xml";
		
		// Spring Framework를 실행해, applicationContext.xml파일을 읽어
		// bean(객체)을 생성하고 Bean Container에 적재한다.
		AbstractApplicationContext ctx =
				new ClassPathXmlApplicationContext(applicationContext);
		
		// Bean Container에서 board.service 객체를 참조한다.
		// getBean("id", 참조.class);
//		BoardService boardService = ctx.getBean("board.service", BoardService.class);
//		boardService.createBoard();
		
		// class명 가져와서 앞에있는것만 소문자로
		BoardService boardService = ctx.getBean("boardServiceImpl2", BoardService.class);
		boardService.createBoard();
		
	}

}
