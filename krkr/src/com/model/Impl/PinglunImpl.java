package com.model.Impl;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import com.conn.ConnectionFactory;
import com.model.Pinglun;
import com.model.Video;
import com.model.Interface.PinglunInter;

public class PinglunImpl implements PinglunInter {

	@Override
	public void inseret(Pinglun pinglun, Connection connection) {
		java.sql.PreparedStatement ps;
		String sqlString = "insert into pinglun (id,pl,date) values(?,?,?)";
		try {
			ps = connection.prepareStatement(sqlString);
			ps.setInt(1, pinglun.getId());
			ps.setString(2, pinglun.getPl());
			ps.setDate(3, pinglun.getDate());
			ps.executeUpdate();

			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// connection.commit();
		// connection.close();

	}

	@Override
	public void delete(Pinglun pinglun, Connection connection) {
		try {
			// 这里的 实体只需 set uid 和did
			String sql = "delete from pinglun where id='" + pinglun.getId() + "'";
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
			ps.executeUpdate();

			ps.close();
			// connection.commit();
			// connection.close();

		} catch (SQLException ex) {
			Logger.getLogger(Pinglun.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	@Override
	public ResultSet query(Connection connection) {
		try {
			String sqlString = "select * from pinglun";
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sqlString);

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
		} catch (SQLException ex) {
			Logger.getLogger(Pinglun.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
		

	}

	@Override
	public ArrayList<Pinglun> getPinglunList() {
		
		ArrayList<Pinglun> al = new ArrayList<>();
        ConnectionFactory cf = ConnectionFactory.getInstance();
        Connection connection = cf.makeConnection();
        
        PinglunImpl pinglunImpl=new PinglunImpl();
       // ResultSet resultSet =videoImpl.query(connection);
        try {
        	PreparedStatement ps;
    		String sqlString = "select * from pinglun";
    		ps = connection.prepareStatement(sqlString);
			ResultSet resultSet = ps.executeQuery();
			while(resultSet.next()){
				Pinglun pinglun=new Pinglun();
				pinglun.setId(resultSet.getInt("id"));
				pinglun.setPl(resultSet.getString("pl"));
				pinglun.setDate(resultSet.getDate("date"));
				al.add(pinglun);
				

			 }
			return al;
	
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		
	}

}}
