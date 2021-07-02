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
  VoteDataServiceImpl voteSvc = new VoteDataServiceImpl();
    request.setCharacterEncoding("UTF-8");
    int candiIdx = Integer.parseInt(request.getParameter("idx"));
    String candiName = request.getParameter("name");
    List<IndiDataDTO> voteResult = voteSvc.indiResult(new Candidate(candiIdx, candiName));
  %>
  <ul id="total">
    <span>득표 성향 분석</span>
    <%
    for (IndiDataDTO each : voteResult){
    %>
    <li class="indi">
      <ul>
        <li class="info"><%=each.getAgeGroup()*10%>대
        </li>
        <li class="rate">
          <div class="chart" style="width:<%=(int) (each.getVoteRate() * 75)%>%"></div> 
          <span><%=each.getVoteCount()%>표(<%=String.format("%.2f", each.getVoteRate() * 100) %>%)</span>
        </li>
      </ul>
    </li>

    <%
    }
    %>
  </ul>
  <div id="back">
    <form>
      <input type="submit" value="돌아가기" formaction="stats.jsp">
    </form>
  </div>
</body>
</html>