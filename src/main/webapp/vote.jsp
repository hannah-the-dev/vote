<%@ page import="votes.domain.*"%>
<%@ page import="votes.service.*"%>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" 
  pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html style="width:600px">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Vote</title>
<link href="main.css" rel="stylesheet" type="text/css">
</head>
<script type="text/javascript" src="main.js"></script>
<body>
  
  <form action="voteInfo.jsp">
    <div class=voting>
      <div class="voteOpt">
        <label for="voteFor">누구에게 투표하나요?</label> <br> <select id="voteFor" name="idx" required>
          <option value="">후보자를 선택하세요</option>
          <%
          VoteServiceImpl voteSvc = new VoteServiceImpl();
          List<Candidates> candiList = voteSvc.voteFor();
          List<AgeInfo> ageList = voteSvc.voterAge();
          for (Candidates candidate : candiList) {
          %>
          <option value="<%=candidate.getCandiIdx()%>"><%=candidate.getCandiIdx()%>번
            <%=candidate.getCandiName()%></option>
          <%
          }
          %>
        </select>

      </div>
      <div class="voteOpt">
        <label for="voterAge">투표자 연령대를 선택해 주세요.</label> <br> <select id="voterAge" name="age"
          required>
          <option value="">나이를 선택하세요</option>
          <%
          for (AgeInfo age: ageList){
          %>
          <option value="<%=age.getAge()%>"><%=age.getAgeDesc()%></option>
          <%
          }
          %>
        </select>

      </div>
    </div>
    <center>
      <input type="submit" value="투표하기" style="display: block; margin-top: 30px;">
    </center>
  </form>


</body>
</html>