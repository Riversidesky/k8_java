<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String val = request.getParameter("val");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
if (val == null) {
	for(int k=2; k<10; k+=3) {
		for(int i=0; i<10; i++) {
			out.print("<br/>");
			for(int j=0; j<3; j++) {
				if ((j+k) < 10) {
					if(i==0) out.print((j+k)+"단");
					else out.print((j+k)+"*"+i+"="+i*(j+k)+"\t");	
				}
			}
		}
	}
}

else {
%>
<table>
<%	
for(int k=2; k<10; k+=Integer.parseInt(val)) {
	
		for(int i=0; i<10; i++) {
			
			out.print("<br/>");
			//tr
			for(int j=0; j<Integer.parseInt(val); j++) {
				
				if ((j+k) < 10) { 
					//td
					if(i==0) out.print((j+k)+"단");
					///td
					///tr
					//tr
					//td
					else out.print((j+k)+"*"+i+"="+i*(j+k)+"\t");	
					///td
					///tr
				}
			}
		}
	} 
%>
</table>
<%	
}
%>

<%
for(int k=0; k<3; k++) {
	for(int i=1; i<10; i++) {
		out.print("</br>");
		for(int j=2; j<=(Integer.parseInt(val)+1); j++) {
			out.print(j+"*"+i+"="+(i*j)+"\t");
		}
	}
}
%>
</body>
</html>