<%@ page import ="votes.service.*" %>
<%@ page import ="votes.domain.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.sql.*"
  pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add record</title>
<link href="main.css" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
  <%
  request.setCharacterEncoding("UTF-8");
  int candiIdx =  Integer.parseInt(request.getParameter("idx"));
  String candiName = request.getParameter("name");
  CandidateServiceImpl resignSvc = new CandidateServiceImpl();
  int succeed = resignSvc.resign(new Candidate(candiIdx, candiName));
  %>

  <div class="result">
    <div id="regRes">
      <%
      if (succeed < 1) {
      %>
      <%=candiIdx%>번 후보 등록 취소에 실패했습니다.
      <%
      } else {
      %>
      <%=candiIdx%>번 후보 등록을 취소했습니다.
      <%
      }
      %>
    </div>

    <div id="back">
      <form>
        <input type="submit" value="돌아가기" formaction="listCandi.jsp">
      </form>
    </div>
  </div>

</body>
</html>