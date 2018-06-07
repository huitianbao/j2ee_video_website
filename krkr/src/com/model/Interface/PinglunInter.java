package com.model.Interface;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.model.Pinglun;
import com.model.Video;

public interface PinglunInter {

	 public void inseret(Pinglun pinglun,Connection connection);
	 public void delete(Pinglun pinglun,Connection connection);
	 public ResultSet query(Connection connection);
	 public ArrayList<Pinglun> getPinglunList();
}
