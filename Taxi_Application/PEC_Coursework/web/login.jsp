<%-- 
    Document   : login
    Created on : 19-feb-2019, 18:00:42
    Author     : ig2348z.gre.ac.uk
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <title>Speedy Taxis</title>
    </head>

    <body>

        <fieldset  >
            <div align="center">
            <form action="LoginServlet" method="get"  >

                Please enter your username		
                <input type="text" name="username" required/>
                <br></br>				
                Please enter your password
                <input type="password" name="password" required/> <br></br>

                <input type="submit" value="Submit">	
                </div>
                 </fieldset>
            </form>
    </body>
</html>

