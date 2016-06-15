<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div>
			<%
				ArrayList<String> title = (ArrayList<String>) request.getAttribute("getTitle");
				ArrayList<String> image = (ArrayList<String>) request.getAttribute("resultURL");
				String titles=title.get(0);
				String url=image.get(0);
				out.print("<h3>" +titles+ "</h3>");
				String href = "";
				href += "<img src='" + url + "'>";
				out.print(href + "");
				out.print("<br>");
				for(int i=1; i<image.size(); i++) {
					titles = title.get(i);
					String tmp = title.get(i-1);
					url = image.get(i);
				//for (String art : image) {
					if(titles.equals("Properties as a real function"))
						continue;
					if(!tmp.equals(titles)){
						out.print("<h3>" +titles+ "</h3>");
					}
					String sHref = "";
					sHref += "<img src='" + url + "'>";
					out.print(sHref + "");
					out.print("<br>");
				}
			%>
	</div>
</body>
</html>