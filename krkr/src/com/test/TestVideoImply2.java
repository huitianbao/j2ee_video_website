package com.test;

import java.sql.Connection;
import java.util.ArrayList;

import com.conn.ConnectionFactory;
import com.model.Video;
import com.model.Impl.VideoImpl2;

public class TestVideoImply2 {
	public static void main(String[] args){
		
		//封装实体
	    ConnectionFactory cf = ConnectionFactory.getInstance();
	    Connection connection = cf.makeConnection();
		Video video=new Video();
		
		VideoImpl2 videoImpl2=new VideoImpl2();
		
		
		video.setAddress("address1");
		video.setId(2);
		video.setName("name2");
		
		
		//videoImpl2.inseret(video, connection);
		
		//videoImpl2.delete(video, connection);
		
		//videoImpl2.query(connection);
		
		ArrayList<Video> aList=new ArrayList<Video>();
		aList=videoImpl2.getVidoeList();
//		if (aList==null) {
//			System.out.println("nulllllllll");
//		}
		
		for (int i = 0; i < aList.size(); i++) {
			System.out.println(aList.get(i).getAddress());    
		}
		
		
	}

}
