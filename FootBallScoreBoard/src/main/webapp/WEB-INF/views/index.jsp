
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collections" %>
<%@ page import="com.sr.model.*" %>

<%
  // Declare and initialize the ArrayList of Match objects
  
  ScoreBoard sb = (ScoreBoard)request.getAttribute("matchList");
  
  // Sort the ArrayList in descending order of total score and updated score time
 /* Collections.sort(sb.getMatchList().get(index), (m1, m2) -> {
    if (m1.getTotalScore() == m2.getTotalScore()) {
      return m2.getUpdatedScoreTime().compareTo(m1.getUpdatedScoreTime());
    } else {
      return m2.getTotalScore() - m1.getTotalScore();
    }
  });*/
%>

<!DOCTYPE html>
<html>
<head>
  <title>Matches</title>
</head>
<body>
  <table >
  <thead>
  Football Score Board
  </thead>
    <tbody>
      <%  for (Match match : sb.getMatchList()) { %>
        <tr>
          <td><%= match.getHomeTeamName() %></td>
          <td><%= match.getHomeTeamScore() %></td>
          </tr>
          <tr>
          <td><%= match.getAwayTeamName() %></td>
          
          <td><%= match.getAwayTeamScore() %></td>
          <td>
            <% if (match.getHomeTeamScore() == "" && match.getAwayTeamScore() == "") { %>
              <a href="#">Start Match</a>
            <% } else { %>
              <a href="#">Update Score</a>
              <a href="#">Finish Match</a>
            <% } %>
          </td>
          </tr>
         <tr>
         <td></td>
         <td></td>
      </tr>
    
      <% } %>
     
    </tbody>
  </table>
</body>
</html>