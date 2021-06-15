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
  Class.forName("com.mysql.cj.jdbc.Driver");
  Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.17:3306/kopoctc", "root", "kopoctc");
  Statement stmt = conn.createStatement();
  String select = "select * from candidates;";

  request.setCharacterEncoding("UTF-8");
  String idx = request.getParameter("idx");

  String delete = String.format("update candidates set valid=0 where candi_idx='%s';", idx);
  stmt.execute(delete);
  int updateCount = stmt.getUpdateCount();
  %>

  <div class="result">
    <div id="regRes">
      <%
      if (updateCount == -1) {
      %>
      <%=idx%>번 후보 등록 취소에 실패했습니다.
      <%
      } else {
      %>
      <%=idx%>번 후보 등록을 취소했습니다(<%=updateCount%>건).
      <%
      }
      stmt.close();
      conn.close();
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