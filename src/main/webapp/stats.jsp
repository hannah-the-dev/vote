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

  String select = 
      "select "
      +   "c.candi_idx, "               //후보자 기호 및 이름
      +   "c.candi_name, "
      +   "count(d.candi_idx), "         //득표수
      +   "count(d.candi_idx)/(select count(d.candi_idx) from vote_data d, candidates c where c.valid=1 and c.candi_idx=d.candi_idx) "   //득표율
      + "from vote_data d "                     //투표데이터에서
      + "right outer join candidates c "        //후보자데이터를 아우터 조인 조건으로
      + "on d.candi_idx = c.candi_idx "         
      + "where c.valid=1 "                      //사퇴하지 않은 후보자들 중에서
      + "group by c.candi_idx;";                //후보자 기호로 조회
      
//      select c.candi_idx, count(d.candi_idx) from vote_data d, candidates c where c.valid=1 and c.candi_idx=d.candi_idx group by c.candi_idx;


  ResultSet rset = stmt.executeQuery(select);
  %>
  <ul id="total">
    <span>후보별 득표율</span>
    <%
    while (rset.next()) {
    %>
    <li class="indi">
      <ul>
        <li class="info"><a href="indi.jsp?idx='<%=rset.getInt(1)%>'"><%=rset.getInt(1)%>번 <%=rset.getString(2)%></a>
        </li>
        <li class="rate">
          <div class="chart" style="width:<%=(int) (rset.getDouble(4) * 75)%>%"></div> 
          <span><%=rset.getInt(3)%>표(<%=String.format("%.2f",rset.getDouble(4) * 100)%>%)</span>
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
<!--  
<div id="back">
    <form>
      <input type="submit" value="돌아가기" formaction="vote.jsp">
    </form>
  </div>
-->
</body>
</html>