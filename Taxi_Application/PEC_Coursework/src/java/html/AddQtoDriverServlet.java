package html;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Controller;
import static model.Controller.create;
import static model.Controller.retrieve;
import model.Driver;
import model.Driver_qualification;
import model.Qualification;

/**
 *
 * @author ig2348z.gre.ac.uk
 */
public class AddQtoDriverServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Speedy taxis</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddQtoDriverServlet at " + request.getContextPath() + "</h1>");
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
            out.println("<h1>Add qualification</h1>");
            out.println("<form action=\"\" method=\"post\">\n"
                    + "\n"
                    + "		        Day	\n"
                    + "                        <input type=\"number\" name=\"day\" required/>\n"
                    + "			Month	\n"
                    + "                        <input type=\"number\" name=\"month\" required/>\n"
                    + "			Year	\n"
                    + "                        <input type=\"number\" name=\"year\" required/>\n"
                    + "                        <br></br>				\n"
                    + "			Remark\n"
                    + "			<input type=\"text\" name=\"remark\" required/>\n"
                    + "                        <br></br>				\n"
                    + "			Mark\n"
                    + "			<input type=\"text\" name=\"mark\" required/>   	\n"
                    + "");
            out.println("<h1>Drivers</h1>\n");
            List<Driver> driverList = retrieve();
            int p;
            for (p = 0; p < driverList.size(); p++) {
                out.println("<input type='radio' name='drivers' value='" + driverList.get(p).getUserName() + "'/>" + driverList.get(p).getUserName() + "<br></br>");
            }

            out.println("<h1>Qualifications</h1>\n");
            List<Qualification> qualificationList = Controller.retrieveQs();
            int p2;
            for (p2 = 0; p2 < qualificationList.size(); p2++) {
                out.println("<input type='radio' name='qualification' value='" + qualificationList.get(p2).getName() + "'/>" + qualificationList.get(p2).getName()+" ("+qualificationList.get(p2).getDescription() + ")<br></br>");
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
        Qualification q = Controller.retrieveQualification(request.getParameter("qualification"));
        LocalDateTime myDateObj = LocalDateTime.of(Integer.parseInt(request.getParameter("year")), Integer.parseInt(request.getParameter("month")), Integer.parseInt(request.getParameter("day")), 0, 0);

        create(new Driver_qualification(myDateObj,d, q, request.getParameter("remark"), Integer.parseInt(request.getParameter("mark"))));
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
