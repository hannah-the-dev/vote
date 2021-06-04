<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.sql.*"
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
  Class.forName("com.mysql.cj.jdbc.Driver");
  Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.17:3306/kopoctc", "root", "kopoctc");
  Statement stmt = conn.createStatement();

  request.setCharacterEncoding("UTF-8");
  String idx = request.getParameter("idx");
  String age = request.getParameter("age");

  String insert = String.format("insert into vote_data values(null, %s, %s, null);", idx, age);
  stmt.execute(insert);
  int updateCount = stmt.getUpdateCount();
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
      <%=idx%>번 후보에 투표하셨습니다.
      <%
      }
      stmt.close();
      conn.close();
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