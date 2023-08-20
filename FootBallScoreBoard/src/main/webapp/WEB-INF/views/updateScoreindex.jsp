<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collections" %>
<%@ page import="com.sr.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
 
  ArrayList<Match> matchList = (ArrayList<Match>)request.getAttribute("matchList");
  Integer matchId = (Integer) request.getAttribute("matchId");
  Integer homeTeamScore = (Integer) request.getAttribute("homeTeamScore");
  Integer awayTeamScore = (Integer) request.getAttribute("awayTeamScore");
  
%>
<form action="<%=request.getContextPath() %>/updateScore" method="POST">
   <table>
    <%  for (Match match : matchList) {
    	if(matchId==match.getMatchId()){%>
    
    <tr>
    <td>Home Team Name</td>
    <td> <%=match.getHomeTeamName()%></td>
    </tr>
    <tr>
    <td>Home Team Score</td>
    <td> <input type="text" name="homeTeamScore" value=<%=homeTeamScore %> maxlength="1" pattern="[0-9]" required>
    </td>
    </tr><tr>
    <td>Away Team Name</td>
    <td> <%= match.getAwayTeamName() %></td>
     </tr><tr>
    <td>Away Team Score</td>
    <td> <input type="text" name="awayTeamScore" value=<%=awayTeamScore%> maxlength="1" pattern="[0-9]" required>
    </td>
    </tr>
    <tr>
    
   <td>
   <input type="hidden" name="matchId" value="<%=match.getMatchId() %>">
   <input type="hidden" name="matchList" value="<%=matchList %>">
   <input type="submit" value="Update">

   </td></tr>
      <%}} %>
   </table>
   </form>

</body>
</html>