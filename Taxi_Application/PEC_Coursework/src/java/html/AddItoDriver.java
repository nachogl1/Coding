package html;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Controller;
import static model.Controller.create;
import static model.Controller.retrieve;
import model.Disciplinary_records_profile;
import model.Driver;
import model.Incident;

/**
 *
 * @author ig2348z.gre.ac.uk
 */
public class AddItoDriver extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddItoDriver</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddItoDriver at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html><div align=\"center\">");
            out.println("<head>");
            out.println("<title>Speedy Taxis</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action='' method=post>");
            out.println("<h1>Drivers</h1>\n");
            List<Driver> driverList = retrieve();
            int p;
            for (p = 0; p < driverList.size(); p++) {
                out.println("<input type='radio' name='drivers' value='" + driverList.get(p).getUserName() + "'/>" + driverList.get(p).getUserName() + "<br></br>");
            }
            out.println("<h1>Incidents</h1>\n");
            List<Incident> IncidentList = Controller.retrieveIncidents();
            int p2;
            for (p2 = 0; p2 < IncidentList.size(); p2++) {
                out.println("<input type='radio' name='incident' value='" + IncidentList.get(p2).getName()+ "'/>"+ IncidentList.get(p2).getName()+"<br></br>");
            }
            out.println("<input type='submit' value='Submit' />");
            out.println("</form>");
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
        
        Driver d = Controller.retrieveDriver(request.getParameter("drivers"));
        Incident q = Controller.retrieveIncident(request.getParameter("incident"));
        
        create(new Disciplinary_records_profile(d,q,new Date()));
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<body>");
            out.println("Added");
            out.println("<form action=admin.jsp method=get>\n"
                    + "<input type=\"submit\" value=\"Go back to admin menu\">\n"
                    + "</form>");
            out.println("</html>");
            out.println("</body>");

        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
