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
  // Sort the ArrayList in descending order of total score and updated score time
 /* Collections.sort(sb.getMatchList().get(index), (m1, m2) -> {
    if (m1.getTotalScore() == m2.getTotalScore()) {
      return m2.getUpdatedScoreTime().compareTo(m1.getUpdatedScoreTime());
    } else {
      return m2.getTotalScore() - m1.getTotalScore();
    }
  });*/
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
    <td> <input type="text" name="homeTeamScore" value=<%=match.getHomeTeamScore() %>>
    </td>
    </tr><tr>
    <td>Away Team Name</td>
    <td> <%= match.getAwayTeamName() %></td>
     </tr><tr>
    <td>Away Team Score</td>
    <td> <input type="text" name="awayTeamScore" value=<%=match.getAwayTeamScore()%>>
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