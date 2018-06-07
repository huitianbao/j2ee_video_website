<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.model.Video"%>
<%@page import="com.model.Impl.VideoImpl2"%>

<%@page import="com.model.Impl.PinglunImpl"%>
<%@page import="com.model.Pinglun"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'Manager.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
		VideoImpl2 videoImpl2 = new VideoImpl2();
		ArrayList<Video> al = new ArrayList<Video>();
		al = videoImpl2.getVidoeList();
	%>



	<table width="70%" border="1" align="center" width="150">
		<tr>
			<th>视频</th>
			<th>操作</th>
		</tr>
		<%
			for (int i = 0; i < al.size(); i++) {
		%>
		<tr>
			<th><a href="htb_broadcast.jsp?id=<%=al.get(i).getId()%>">名称：<%=al.get(i).getName()%></a></th>
			<th><a href="DeleteVideo?id=<%=al.get(i).getId()%>">删除</a>
			<th>
		</tr>
		<%
			}
		%>
	</table>


	<!-- pppppppppppppppppppppppppppppppppppppppppppppppppppppppp -->
	<%
		PinglunImpl pinglunImpl = new PinglunImpl();
		ArrayList<Pinglun> all = new ArrayList<>();
		all = pinglunImpl.getPinglunList();
	%>

	<table width="70%" border="1" align="center" width="150">

		<tr>

			<th>id</th>

			<th>评论</th>
			<th>操作</th>


		</tr>
		<%
			for (int i = 0; i < all.size(); i++) {
		%>
		<tr>

			<td><%=all.get(i).getId()%></td>

			<td><%=all.get(i).getPl()%></td>
			<td><a href="DeletePingLun?id1=<%=all.get(i).getId()%>">删除</a></td>



		</tr>
		<%
			}
		%>

	</table>


	<div>
		<form action=upload2.jsp enctype="MULTIPART/FORM-DATA" method=post>
			<table width="70%" border="1" align="center" width="150">
				<tr>
					<td>作者:</td>
					<td><input type=text name=author></td>

				</tr>

				<tr>
					<td>选择要上载的文件</td>
					<td><input type=file name=filename></td>
				</tr>

				<tr>
					<td></td>
					<td><input type=submit value="Upload"></td>

				</tr>
			</table>

		</form>
	</div>

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
