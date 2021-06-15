<%@page import="votes.service.RegisterServiceImpl"%>
<%@page import="votes.dao.RegisterDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
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
  RegisterServiceImpl registerSvc = new RegisterServiceImpl();
  int updateCount = registerSvc.register(request);
  %>

  <div class="result">
    <div id="regRes">
      <%
      if (updateCount == -1) {
      %>
      후보를 등록하지 못했습니다.
      <%
      } else {
      %>
      후보를 등록했습니다.
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