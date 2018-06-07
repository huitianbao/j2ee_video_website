package com.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conn.ConnectionFactory;
import com.model.Pinglun;
import com.model.Impl.PinglunImpl;

/**
 * Servlet implementation class DeletePingLun
 */
@WebServlet("/DeletePingLun")
public class DeletePingLun extends HttpServlet {

       
    /**
     * @see HttpServlet#HttpServlet()
     */
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1
		ConnectionFactory cf = ConnectionFactory.getInstance();
		Connection connection = cf.makeConnection();
		
		//2
		Pinglun pinglun=new Pinglun();
		PinglunImpl pinglunImpl=new PinglunImpl();
		//3
		
		String  id=request.getParameter("id1");
		int int_id=Integer.parseInt(id);
		pinglun.setId(int_id);
		
		//4
		pinglunImpl.delete(pinglun, connection);
		
		response.sendRedirect("/krkr/Manager.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
