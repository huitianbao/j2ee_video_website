<%@page import="com.model.Video"%>
<%@page import="com.conn.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.model.Impl.VideoImpl2"%>
<%@ page contentType="text/html;charset=gb2312"%>

<jsp:useBean id="TheBean" scope="page" class="com.util.FileUploadBean" />

<%
	TheBean.setSavePath("D:/video/");

	//TheBean.doUpload1(request);

	TheBean.doUpload(request);

	out.println("Filename:" + TheBean.getFilename());



	out.println("<BR>作者:" + TheBean.getFieldValue("author"));
	
	ConnectionFactory cf = ConnectionFactory.getInstance();
	    Connection connection = cf.makeConnection();
	VideoImpl2 videoImpl2=new VideoImpl2();
	Video video =new Video();
	String path="D:/video";
	String filename=TheBean.getFilename();
	String realpath=path+"/"+filename;
	
	video.setName(filename);
	video.setAddress(realpath);
	
	videoImpl2.inseret(video, connection);
	
	application.setAttribute("message", "上传成功");
	
	response.sendRedirect("/krkr/Manager.jsp");
	

%>

