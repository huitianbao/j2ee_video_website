package com.model.Interface;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.model.User;
import com.model.Video;

public interface VideoInter {
	 public void inseret(Video video,Connection connection);
	 public void delete(Video video,Connection connection);
	 public ResultSet query(Connection connection);
	 
	 public ArrayList<Video> getVidoeList();
}
