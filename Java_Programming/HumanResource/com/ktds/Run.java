package com.ktds;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Run extends Sqle {

	@Override
	public PreparedStatement preparedStatement(Connection conn) {
		return null;
	}

	@Override
	public void printRow(ResultSet rs) {
		
	}
	
}
