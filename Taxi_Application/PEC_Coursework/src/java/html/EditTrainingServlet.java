package html;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static model.Controller.retrieveTraining;
import static model.Controller.update;
import model.Training;

/**
 *
 * @author ig2348z.gre.ac.uk
 */
public class EditTrainingServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditTrainingServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditTrainingServlet at " + request.getContextPath() + "</h1>");
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
                    + "			Name 	\n"
                    + "                        <input type=\"text\" name=\"name-et\" required/>\n"
                    + "                        <br></br>				\n"
                    + "			Details\n"
                    + "			<input type=\"text\" name=\"details-et\" required/>\n"
                    + "<br></br>				\n"
                    + "			Area\n"
                    + "			<input type=\"text\" name=\"area-et\" required/>\n"
                    + "<br></br>				\n"
                    + "			Duration (hours)\n"
                    + "			<input type=\"number\" name=\"duration-et\" required/>\n"
                    + "<br></br>                       \n"
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
        String localVa = request.getParameter("name-et");
        Training d = retrieveTraining(localVa);
if(d!=null){
        d.setArea(request.getParameter("area-et"));
        d.setDetails(request.getParameter("details-et"));
        d.setDurationInHours(Integer.parseInt(request.getParameter("duration-et")));
        d.setName(localVa);

        update(d);

        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<body>");
            out.println("Updated");
            out.println("<form action=admin.jsp method=get>\n"
                    + "<input type=\"submit\" value=\"Go back to admin menu\">\n"
                    + "</form>");
            out.println("</html>");
            out.println("</body>");
        }}else{
try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<body>");
            out.println("Training not found");
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
