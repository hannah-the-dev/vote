<%@ page import="votes.domain.*"%>
<%@ page import="votes.service.*"%>

<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add record</title>
<link href="main.css" rel="stylesheet" type="text/css">
<script
  src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<script type="text/javascript" src="main.js"></script>
<body>
  <div id="list">
    <div>
      <%
      CandidateServiceImpl candiSvc = new CandidateServiceImpl();
      List<Candidate> listing = candiSvc.currentCandiList();
      for (Candidate candidate : listing) {
      %>
      <div>
        <form class="exsisting" method="get"
          name="<%=candidate.isValid()%>">
          기호: 
          <input type="number" class="idx" name="idx"
            value="<%=candidate.getCandiIdx()%>" readonly> 
          후보자명:
          <input type="text" class="name" name="name"
            value="<%=candidate.getCandiName()%>" readonly>   
          <input
            type="submit" value=<%if (candidate.isValid()) {%> "등록 취소" 
            <%} else {%> "철회 완료" disabled <%}%>
            formaction="cancelReg.jsp">
        </form>
      </div>
      <%
      }
      %>
    </div>
    <div>
      <form class="new" method="get" accept-charset="UTF-8"
        onsubmit="return isSubmittable();">
        기호: 
        <input type="number" class="idx" name="idx"
          value="<%=listing.size() + 1%>" readonly> 
        후보자명: 
        <input
          type="text" class="name" name="name" required> 
        <input
          type="submit" value="등록" formaction="register.jsp">
      </form>
    </div>
  </div>

</body>
</html>