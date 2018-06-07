package com.model.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.conn.ConnectionFactory;
import com.model.Video;
import com.model.Interface.VideoInter;


public class VideoImpl2 implements VideoInter{

	@Override
	public void inseret(Video video, Connection connection) {
		PreparedStatement ps;
		String sqlString="insert into video (id,address,name) values(?,?,?)";
		try {
			ps = connection.prepareStatement(sqlString);
			ps.setInt(1,video.getId());
			ps.setString(2, video.getAddress());
			ps.setString(3, video.getName());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void delete(Video video, Connection connection) {
		try {
			// 这里的 实体只需 set id 和id
			String sql = "delete from video where id='" + video.getId() + "'";
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
			ps.executeUpdate();

			ps.close();
			// connection.commit();
			// connection.close();

		} catch (SQLException ex) {
			Logger.getLogger(Video.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		
	}

	@Override
	public ResultSet query(Connection connection) {
		// TODO Auto-generated method stub
		PreparedStatement ps;
		String sqlString = "select * from video";
		
		try {
			
			ps = connection.prepareStatement(sqlString);
			ResultSet resultSet = ps.executeQuery();
			System.out.println("===========================");

			int col = resultSet.getMetaData().getColumnCount();
			System.out.println("col= " + col);
			while (resultSet.next()) {
				for (int i = 1; i <= col; i++) {
					System.out.print(resultSet.getString(i) + "   ");

				}
				System.out.println("");

			}
			System.out.println("==========================");
			return resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ArrayList<Video> getVidoeList() {
		
		ArrayList<Video> al = new ArrayList<>();
        ConnectionFactory cf = ConnectionFactory.getInstance();
        Connection connection = cf.makeConnection();
        
        VideoImpl2 videoImpl=new VideoImpl2();
       // ResultSet resultSet =videoImpl.query(connection);
        try {
        	PreparedStatement ps;
    		String sqlString = "select * from video";
    		ps = connection.prepareStatement(sqlString);
			ResultSet resultSet = ps.executeQuery();
			while(resultSet.next()){
				 Video video=new Video();
				 video.setId(resultSet.getInt("id"));
				 video.setName(resultSet.getString("name"));
				 video.setAddress(resultSet.getString("address"));
				 
				 al.add(video);
				 
			 }
			return al;
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
        
			
		
	}
	

}
