
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collections" %>
<%@ page import="com.sr.model.*" %>

<%
  // Declare and initialize the ArrayList of Match objects
  
 ArrayList<Match> matchList = (ArrayList<Match>)request.getAttribute("matchList");
	

%>

<!DOCTYPE html>
<html>
<head>
  <title>Matches</title>
 
</head>
<body>
<h2>Football Score Board</h2></br>
  <table >
  <thead>
  
  </thead>
    <tbody>
      <%  for (Match match : matchList) { %>
        <tr>
          <td><%= match.getHomeTeamName() %></td>
          <td><%= match.getHomeTeamScore() %></td>
          </tr>
          <tr>
          <td><%= match.getAwayTeamName() %></td>
          
          <td><%= match.getAwayTeamScore() %></td>
          <td>
            <% if (match.getHomeTeamScore() == "" && match.getAwayTeamScore() == "") { %>
              	<form action="<%=request.getContextPath() %>/startMatch" method="post">
  				<input type="hidden" name="matchId" value="<%=match.getMatchId() %>">
  				<input type="submit" value="Start Match">
				</form>
            <% }
            %><% else { %>
            <td>
            <form action="updatePage" method="post">
           		
  				<input type="hidden" name="matchId" value="<%=match.getMatchId() %>">
  				<input type="hidden" name="matchList" value="<%=matchList %>">
  				<input type="hidden" name="homeTeamScore" value="<%=match.getHomeTeamScore() %>">
  				<input type="hidden" name="awayTeamScore" value="<%=match.getAwayTeamScore() %>">
  				<input type="submit" value="Update Score">
				</form>
                   </td> <td>
              <form action="<%=request.getContextPath() %>/finishMatch" method="post">
           		
  				<input type="hidden" name="matchId" value="<%=match.getMatchId() %>">
  				<input type="submit" value="Finish Match">
				</form>
               </td>
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