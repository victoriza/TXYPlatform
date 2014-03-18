<%--
  Created by IntelliJ IDEA.
  User: victor
  Date: 17/03/14
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Meetup MVC Form Handling</title>
</head>
<body>

<h2>Meetup Information</h2>
<form:form method="POST" action="/meetup/addMeetup" modelAttribute="meetup">
    <table>
        <tr>
            <td><form:label path="userA">UserA</form:label></td>
            <td><form:input path="userA" /></td>
        </tr>
        <tr>
            <td><form:label path="userB">UserB</form:label></td>
            <td><form:input path="userB" /></td>
        </tr>
        </tr>
        <tr>
            <td><form:label path="relationshipType">Rel Name</form:label></td>
            <td><form:input path="relationshipType" /></td>
        </tr>
        <tr>
            <td><form:label path="elapsedTime">Elapsed time</form:label></td>
            <td><form:input path="elapsedTime" /></td>
        </tr>
        <tr>
            <td><form:label path="feeling">Feeling</form:label></td>
            <td><form:input path="feeling" /></td>
        </tr>

        <tr>
            <td><form:label path="location.lat">lat</form:label></td>
            <td><form:input path="location.lat" /></td>
        </tr>

        <tr>
            <td><form:label path="location.lon">long</form:label></td>
            <td><form:input path="location.lat" /></td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>