package com.test;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import com.conn.ConnectionFactory;
import com.model.Pinglun;
import com.model.Video;
import com.model.Impl.PinglunImpl;

public class testPL {
public static void main(String [] args){
	//封装实体
    ConnectionFactory cf = ConnectionFactory.getInstance();
    Connection connection = cf.makeConnection();


	

	PinglunImpl pinglunImpl=new PinglunImpl();
	//pinglunImpl.inseret(pinglun, connection);
	//pinglunImpl.delete(pinglun, connection);
	//pinglunImpl.query(connection);
	ArrayList<Pinglun> aList=new ArrayList<>();
	aList=pinglunImpl.getPinglunList();

	for (int i = 0; i < aList.size(); i++) {
		System.out.println(aList.get(i).getDate());    
	}
	
}
}
