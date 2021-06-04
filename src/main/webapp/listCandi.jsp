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
<script type="text/javascript" src="main.js"></script> 
<body>
  <%
  Class.forName("com.mysql.cj.jdbc.Driver");
  Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.17:3306/kopoctc", "root", "kopoctc");
  Statement stmt = conn.createStatement();
  String select = "select * from candidates;";
  ResultSet rset = stmt.executeQuery(select);
  int nextInt = 1;
  %>
  <!-- write table with current data and input form for a new -->
  <div id="list">
    <div>
      <%
      while (rset.next()) {
      	nextInt = rset.getInt(1) + 1;
      %>
      <div>
        <form class="exsisting" method="get" name="<%=rset.getInt(3)%>">
          기호: <input type="number" class="idx" name="idx" value="<%=rset.getInt(1)%>" readonly>
          후보자명: <input type="text" class="name" name="name" value="<%=rset.getString(2)%>" readonly>
          <input type="submit" value=
            <%if (rset.getInt(3) == 1) { %>"등록 취소" 
            <% } else { %> "철회 완료" disabled 
            <% } %> formaction="cancelReg.jsp">
        </form>
      </div>
      <%
      }
      %>
    </div>
    <div>
      <form class="new" method="get" accept-charset="UTF-8" onsubmit="return isSubmittable();">
        기호: <input type="number" class="idx" name="idx" value="<%=nextInt%>" readonly> 
        후보자명: <input type="text" class="name" name="name" required> 
        <input type="submit" value="등록" formaction="register.jsp">
      </form>
    </div>
  </div>
  <%
  rset.close();
  stmt.close();
  conn.close();
  %>
</body>
</html>