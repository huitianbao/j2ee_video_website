<%@ page contentType="text/html;charset=gb2312"%>

<jsp:useBean id="TheBean" scope="page" class="com.util.FileUploadBean" />

<%
	TheBean.setSavePath("D:\\java\\myeclipse\\kerokero\\WebRoot\\video\\");

	//TheBean.doUpload1(request);

	TheBean.doUpload(request);

	out.println("Filename:" + TheBean.getFilename());

	out.println("<BR>��������:" + TheBean.getContentType());

	out.println("<BR>����:" + TheBean.getFieldValue("author"));

	out.println("<BR>��˾:" + TheBean.getFieldValue("company"));

	out.println("<BR>˵��:" + TheBean.getFieldValue("comment"));
%>

