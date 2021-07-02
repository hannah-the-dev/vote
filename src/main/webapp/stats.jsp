<%@ page import="votes.domain.*"%>
<%@ page import="votes.service.*"%>
<%@ page import="votes.dto.*"%>
<%@ page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" 
  pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vote Statistics</title>
</head>
<link href="stats.css" rel="stylesheet" type="text/css">
<link href="main.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="main.js"></script>
<body>
  <%
  VoteDataServiceImpl dataSvc = new VoteDataServiceImpl();
  List<VoteDataDTO> voteResult = dataSvc.voteResult();
  %>
  <ul id="total">
    <span>후보별 득표율</span>
    <%
    for (VoteDataDTO each : voteResult) {
    %>
    <li class="indi">
      <ul>
        <li class="info"><a href="indi.jsp?idx=<%=each.getCandiIdx()%>&name='<%=each.getCandiName()%>'">
        <%=each.getCandiIdx()%>번 <%=each.getCandiName()%></a>
        </li>
        <li class="rate">
          <div class="chart" style="width:<%=(int) (each.getVoteRate() * 75)%>%"></div> 
          <span><%=each.getVoteCount()%>표(<%=String.format("%.2f",each.getVoteRate() * 100)%>%)</span>
        </li>
      </ul>
    </li>

    <%
    }
 
    %>
  </ul>
<!--  
<div id="back">
    <form>
      <input type="submit" value="돌아가기" formaction="vote.jsp">
    </form>
  </div>
-->
</body>
</html>