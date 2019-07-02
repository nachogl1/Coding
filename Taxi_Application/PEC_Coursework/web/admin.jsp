<%-- 
    Document   : admin
    Created on : 20-feb-2019, 1:09:38
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Speedy Taxis</title>
    </head>
    <body>
        <div align="center">
        <h1>Welcome ADMIN</h1>
        Manage drivers
        <form action="CreateDriverServlet" method="get">
			<input type="submit"  value="Create">
        </form>
        <form action="SearchDriverServlet" method="get">
                        <input type="submit"  value="Search">
         </form>               
        <form action="DeleteDriverServlet" method="get">
                        <input type="submit"  value="Delete">
         </form>               
        <form action="EditDriverServlet" method="get">
                        <input type="submit"  value="Update">
         </form>               
        <form action="PanelExpirationServlet" method="get">
                        <input type="submit"  value="Check Q´s and T´s about to expire">
        </form>
        Manage qualifications
        <form action="CreateQualificationServlet" method="get">
			<input type="submit" value="Create">
        </form>
        <form action="DeleteQualificationServlet" method="get">
                        <input type="submit" value="Delete">
        </form>
        <form action="EditQualificationServlet" method="get">
                        <input type="submit" value="Update">
        </form>
        <form action="AddQtoDriverServlet" method="get">
                        <input type="submit" value="Add Q to a driver">
        </form>
        Manage trainings
        <form action="CreateTrainingServlet" method="get">
			<input type="submit" value="Create training">
        </form>
        <form action="DeleteTrainingServlet" method="get">
                        <input type="submit" value="Delete training">
        </form>
        <form action="EditTrainingServlet" method="get">
                        <input type="submit" value="Update training">
        </form>
        <form action="ManageTrainingServlet" method="get">
                        <input type="submit" value="Record training grades">
        </form>
        <form action="ScheduleServlet" method="get">
                        <input type="submit" value="Schedule training">
        </form>
        Incidents
        <form action="CreateIncidentServlet" method="get">
			<input type="submit" value="Create Incident">
        </form>
        <form action="AddItoDriver" method="get">
			<input type="submit" value="Add incident to a driver">
        </form>
        </div>
    </body>
</html>
