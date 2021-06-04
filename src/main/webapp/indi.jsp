<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.sql.*"
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
  Class.forName("com.mysql.cj.jdbc.Driver");
  Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.17:3306/kopoctc", "root", "kopoctc");
  Statement stmt = conn.createStatement();
  
  request.setCharacterEncoding("UTF-8");
  String idx = request.getParameter("idx");
  
  String select = String.format(
      "select "
                        //후보자 기호 및 이름
      +   "a.age, "
      +   "(select count(age) from vote_data where vote_data.age = a.age and vote_data.candi_idx=%s), "         //득표수
      +   "(select count(age) from vote_data where vote_data.age = a.age and vote_data.candi_idx=%s)/(select count(age) from vote_data where vote_data.candi_idx=%s) as rate "   //득표율
      + "from vote_data d "                     //투표데이터에서
      + "right outer join age_info a "        //후보자데이터를 아우터 조인 조건으로
      + "on d.candi_idx=%s "         
  
      + "group by a.age;"                //후보자 기호로 조회
      , idx, idx, idx, idx);
      

  ResultSet rset = stmt.executeQuery(select);
  %>
  <ul id="total">
    <span>득표 성향 분석</span>
    <%
    while (rset.next()) {
    %>
    <li class="indi">
      <ul>
        <li class="info"><%=rset.getInt(1)*10%>대
        </li>
        <li class="rate">
          <div class="chart" style="width:<%=(int) (rset.getDouble(3) * 75)%>%"></div> 
          <span><%=rset.getInt(2)%>표(<%=String.format("%.2f",rset.getDouble(3) * 100) %>%)</span>
        </li>
      </ul>
    </li>

    <%
    }
    rset.close();
    stmt.close();
    conn.close();
    %>
  </ul>
  <div id="back">
    <form>
      <input type="submit" value="돌아가기" formaction="stats.jsp">
    </form>
  </div>
</body>
</html>