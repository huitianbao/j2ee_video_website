package com.model.Impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.model.Pinglun;
import com.model.User;
import com.model.Video;
import com.model.Interface.UserInter;
import com.mysql.jdbc.PreparedStatement;

public class UserImpl implements UserInter {

	@Override
	public void inseret(User user, Connection connection) {
		java.sql.PreparedStatement ps;
		String sqlString = "insert into t_user (id,username,password) values(?,?,?)";
		try {
			ps = connection.prepareStatement(sqlString);
			ps.setInt(1, user.getId());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
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
	public void delete(User user, Connection connection) {
		try {
			// 这里的 实体只需 set uid 和did
			String sql = "delete from t_user where id='" + user.getId() + "'";
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
			ps.executeUpdate();

			ps.close();
			// connection.commit();
			// connection.close();

		} catch (SQLException ex) {
			Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	@Override
	public ResultSet query(Connection connection) {
		try {
			String sqlString = "select * from t_user";
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
			resultSet.beforeFirst();
			return resultSet;
		} catch (SQLException ex) {
			Logger.getLogger(Video.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
		

	}

	@Override
	public ResultSet getAll(Connection connection) {
		// TODO Auto-generated method stub
		String sqlString = "select * from t_user";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) connection.prepareStatement(sqlString);
			ResultSet resultSet = ps.executeQuery();
			return resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		

		
		
	}

}
