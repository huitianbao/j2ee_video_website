package com.test;

import java.sql.Connection;

import com.conn.ConnectionFactory;

public class Testconn {
	public static void main(String[] args){
	    ConnectionFactory cf = ConnectionFactory.getInstance();
	    Connection connection = cf.makeConnection();
	}

}
