<%@ page import="votes.domain.*"%>
<%@ page import="votes.service.*"%>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" 
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vote processing</title>
<link href="main.css" rel="stylesheet" type="text/css">
</head>
<script type="text/javascript" src="main.js"></script>
<body>
  <%
  VoteServiceImpl voteSvc = new VoteServiceImpl();
  request.setCharacterEncoding("UTF-8");
  int updateCount = voteSvc.voting(request);
  %>

  <div class="result">
    <div id="regRes">
      <%
      if (updateCount == -1) {
      %>
      투표에 실패했습니다.
      <%
      } else {
      %>
      투표에 성공했습니다.
      <%
      }
      %>
    </div>

 <!-- 
    <div id="back">
     <form>
        <input type="submit" value="돌아가기" formaction="listCandi.jsp">
      </form>
    </div>
  -->
  </div>

</body>
</html>