package com.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conn.ConnectionFactory;
import com.model.Video;
import com.model.Impl.VideoImpl2;

/**
 * Servlet implementation class DeleteVideo
 */
@WebServlet("/DeleteVideo")
public class DeleteVideo extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1
		// 1.连接数据库
		ConnectionFactory cf = ConnectionFactory.getInstance();
		Connection connection = cf.makeConnection();

		// 2
		
		Video video=new Video();
		VideoImpl2 videoImpl2=new VideoImpl2();
		
		//3
		
		String  id=request.getParameter("id");
		int int_id=Integer.parseInt(id);
		
		video.setId(int_id);
		videoImpl2.delete(video, connection);
		
		//request.getRequestDispatcher("/Manager.jsp").forward(request, response);
		
		response.sendRedirect("/krkr/Manager.jsp");
		
		
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
