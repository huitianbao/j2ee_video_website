package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conn.ConnectionFactory;
import com.jiemian.pinglun;
import com.model.Pinglun;
import com.model.Impl.PinglunImpl;

/**
 * Servlet implementation class AddPinglun
 */
@WebServlet("/AddPinglun")
public class AddPinglun extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("textml;charset=UTF-8");
		String Review = request.getParameter("Review");
	

		System.out.print("Review is " + Review);

		PrintWriter pWriter = response.getWriter();
		pWriter.write("Review is " + Review);
		
		ConnectionFactory cf = ConnectionFactory.getInstance();
		Connection connection = cf.makeConnection();
		//2.
		PinglunImpl pinglunImpl =new PinglunImpl();
		Pinglun pinglun =new Pinglun();
		pinglun.setPl(Review);
		pinglun.setDate(new Date(System.currentTimeMillis()));
		//3
		pinglunImpl.inseret(pinglun, connection);
		//request.getRequestDispatcher("Review.jsp").forward(request, response);
		response.sendRedirect("/krkr/Review.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doGet(request, response);
	}

}
