package com.test;

import java.sql.Connection;
import java.sql.Date;

import com.conn.ConnectionFactory;
import com.model.Pinglun;
import com.model.User;
import com.model.Impl.PinglunImpl;
import com.model.Impl.UserImpl;

public class TestUser {
	public static void main(String [] args){
		//封装实体
	    ConnectionFactory cf = ConnectionFactory.getInstance();
	    Connection connection = cf.makeConnection();
		User user =new User();
		user.setId(233);
		
		user.setPassword("233");
		user.setUsername("htbddd");

		UserImpl userImpl=new UserImpl();
		//userImpl.inseret(user, connection);
		//userImpl.delete(user, connection);
		userImpl.query(connection);
	}
}
