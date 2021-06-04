<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.sql.*"
  pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html style="width:530px">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Vote</title>
<link href="main.css" rel="stylesheet" type="text/css">
</head>
<script type="text/javascript" src="main.js"></script>
<body>
  <%
  Class.forName("com.mysql.cj.jdbc.Driver");
  Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.17:3306/kopoctc", "root", "kopoctc");
  Statement stmt = conn.createStatement();
  String select = "select * from candidates where valid=true;";
  ResultSet rset = stmt.executeQuery(select);
  %>
  <form action="voteInfo.jsp">
    <div class=voting>
      <div class="voteOpt">
        <label for="voteFor">누구에게 투표하나요?</label> <br> <select id="voteFor" name="idx" required>
          <option value="">후보자를 선택하세요</option>
          <%
          while (rset.next()) {
          %>
          <option value="<%=rset.getInt(1)%>"><%=rset.getInt(1)%>번
            <%=rset.getString(2)%></option>
          <%
          }
          %>
        </select>

        <%
        select = "select * from age_info";
        rset = stmt.executeQuery(select);
        %>
      </div>
      <div class="voteOpt">
        <label for="voterAge">투표자 연령대를 선택해 주세요.</label> <br> <select id="voterAge" name="age"
          required>
          <option value="">나이를 선택하세요</option>
          <%
          while (rset.next()) {
          %>
          <option value="<%=rset.getInt(1)%>"><%=rset.getString(2)%></option>
          <%
          }
          rset.close();
          stmt.close();
          conn.close();
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