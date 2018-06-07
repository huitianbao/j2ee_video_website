package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conn.ConnectionFactory;
import com.model.Impl.UserImpl;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("textml;charset=UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		//System.out.print("username is " + username + "</br>" + "password is " + password);

		//PrintWriter pWriter = response.getWriter();
		//pWriter.write("username is " + username + "password is " + password);

		// 1.连接数据库
		ConnectionFactory cf = ConnectionFactory.getInstance();
		Connection connection = cf.makeConnection();

		UserImpl userImpl = new UserImpl();
		// ResultSet resultSet=userImpl.query(connection);
		ResultSet resultSet = userImpl.getAll(connection);
		boolean flag = false;
		try {
			while (resultSet.next()) {
				String uString = resultSet.getString(2);
				String pString = resultSet.getString(3);

				//pWriter.write("the ustring is " + uString + "</br>" + "the pString is " + pString);

				if (uString.equals(username) && pString.equals(password)) {
					request.getRequestDispatcher("/Manager.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("/error.jsp").forward(request, response);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		doGet(request, response);

	}

}
