package html;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static model.Controller.*;
import model.Driver;

/**
 *
 * @author ig2348z.gre.ac.uk
 */
public class CreateDriverServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Speedy Taxis</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManagingDrivers at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Speedy Taxis</title>");
            out.println("</head>");
            out.println("<body><div align=\"center\">");
            out.println("<form action=\"\" method=\"post\">\n"
                    + "\n"
                    + "			Car\n"
                    + "			<input type=\"text\" name=\"car-md\" required/>\n"
                    + "<br></br>\n"
                    + "                         Username\n"
                    + "			<input type=\"text\" name=\"username-md\" required/>\n"
                    + "<br></br>\n"
                    + "Mobile <input type=\"text\" name=\"mobile-md\" required/>\n"
                    + "<br></br>\n"
                    + "Complete name <input type=\"text\" name=\"completename-md\" required/>\n"
                    + "<br></br>\n"
                    + "Password<input type=\"text\" name=\"password-md\" required/>\n"
                    + "<br></br>			\n"
                    + "			<input type=\"submit\" value=\"Submit\">	\n"
                    + "                        \n"
                    + "		\n"
                    + "		</form>");
            out.println("<form action=admin.jsp method=get>\n"
                    + "<input type=\"submit\" value=\"Go back to admin menu\">\n"
                    + "</form>");
            out.println("</div></body>");
            out.println("</html>");

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Driver d=new Driver(request.getParameter("car-md"), request.getParameter("mobile-md"),
                request.getParameter("username-md"), request.getParameter("completename-md"),
                request.getParameter("password-md"));
        if(retrieveDriver(request.getParameter("username-md"))==null){
        create(d );
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<body>");
            out.println("Added");
            out.println("<form action=admin.jsp method=get>\n"
                    + "<input type=\"submit\" value=\"Go back to admin menu\">\n"
                    + "</form>");
            out.println("</html>");
            out.println("</body>");
        }}else{
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<body>");
            out.println("This user already exists");
            out.println("<form action=admin.jsp method=get>\n"
                    + "<input type=\"submit\" value=\"Go back to admin menu\">\n"
                    + "</form>");
            out.println("</html>");
            out.println("</body>");
        }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
