package com.model.Interface;

import java.sql.Connection;
import java.sql.ResultSet;

import com.model.Pinglun;
import com.model.User;

public interface UserInter {
	 public void inseret(User user,Connection connection);
	 public void delete(User user,Connection connection);
	 public ResultSet query(Connection connection);
	 public ResultSet getAll(Connection connection);
}
