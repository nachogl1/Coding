package html;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static model.Controller.retrieveDriver;
import model.Driver;

/**
 *
 * @author ig2348z.gre.ac.uk
 */
public class SearchDriverServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SearchDriverServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchDriverServlet at " + request.getContextPath() + "</h1>");
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
                    + "			Name 	\n"
                    + "                        <input type=\"text\" name=\"name\" required/>\n"
                    + "                        <br></br>			   \n"
                    + "			<input type=\"submit\" value=\"Submit\">	\n"
                    + "		</form>");
            out.println("<form action=admin.jsp method=get>\n"
                    + "<input type=\"submit\" value=\"Go back to admin menu\">\n"
                    + "</form>");
            out.println("<div align=\"center\"></body>");
            out.println("</html>");

        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String localVa = request.getParameter("name");
        Driver d = retrieveDriver(localVa);
        if(d!=null){
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Search driver</title>");
            out.println("</head>");
            out.println("<body><div align=\"center\">");
            out.println("\n");
            out.println("<h3>Driver ID: " + d.getId()+"</h3>");
            out.println("\n");
            out.println("Driver username: " + d.getUserName()+"<br></br>");
            out.println("\n");
            out.println("Driver complete name: " + d.getCompleteName()+"<br></br>");
            out.println("\n");
            out.println("Driver car information: " + d.getCar()+"<br></br>");
            out.println("\n");
            out.println("Driver mobile phone: " + d.getMobile()+"<br></br>");
            out.println("\n");
            out.println("Driver seniority: " + d.getSeniority()+"<br></br>");
            out.println("\n");
            out.println("<h3>Qualifications</h3> ");
            int m;
            for (m = 0; m < d.getDriver_qua_list().size(); m++) {
                out.println(d.getDriver_qua_list().get(m).getQualification().getName()+"| Details: "+d.getDriver_qua_list().get(m).getQualification().getDescription()+"|Achieved: "+d.getDriver_qua_list().get(m).getDateStart() +"<br></br>");
            }
            out.println("\n");
            out.println("<h3>Trainings </h3> ");
            int l2;
            for (l2 = 0; l2 < d.getTraining_p_list().size(); l2++) {
                out.println(d.getTraining_p_list().get(l2).getSchedule().getTraining().getName()+"| Details: "+ d.getTraining_p_list().get(l2).getSchedule().getTraining().getDetails()+ "<br></br>");
            }
            out.println("\n");
            out.println("<h3>Incident profile </h3> ");
            int l3;
            for (l3 = 0; l3 < d.getDisciplinary_r_p_list().size(); l3++) {
                out.println(d.getDisciplinary_r_p_list().get(l3).getIncident().getName()+" ("+d.getDisciplinary_r_p_list().get(l3).getDate_Occurrence()+")| Description: "+d.getDisciplinary_r_p_list().get(l3).getIncident().getDescription() + "<br></br>");
            }

            out.println("<form action=admin.jsp method=get>\n"
                    + "<input type=\"submit\" value=\"Go back to admin menu\">\n"
                    + "</form>");
            out.println("</div></body>");
            out.println("</html>");
        }}else{
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>No driver was found</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>No driver was found</h1>");
            out.println("<form action=admin.jsp method=get>\n"
                    + "<input type=\"submit\" value=\"Go back to admin menu\">\n"
                    + "</form>");
            out.println("</body>");
            out.println("</html>");
        }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
