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

  request.setCharacterEncoding("UTF-8");
  String idx = request.getParameter("idx");
  String name = request.getParameter("name");

  String insert = String.format("insert into candidates values(null, '%.20s', default);", name);

  stmt.execute(insert);
  int updateCount = stmt.getUpdateCount();
  %>

  <div class="result">
    <div id="regRes">
      <%
      if (updateCount == -1) {
      %>
      <%=idx%>번 후보를 등록하지 못했습니다.
      <%
      } else {
      %>
      <%=idx%>번 후보를 등록했습니다.
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