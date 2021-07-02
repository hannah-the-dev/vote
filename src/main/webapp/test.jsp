<%@page import="votes.dao.*"%>
<%@page import="votes.domain.*"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	CandidateDaoImpl current = new CandidateDaoImpl();
		List<Candidate> listing = current.currentCandiList(); 
		for (Candidate candidate: listing) {
	%>
	<%= candidate.getCandiIdx() %>
	<%= candidate.getCandiName()%>
	<%= candidate.isValid()%>
    
	<br>
	<% 
	}
	%>
</body>
</html>