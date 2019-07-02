package html;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static model.Controller.retrieveQualification;
import static model.Controller.update;
import model.Qualification;

/**
 *
 * @author ig2348z.gre.ac.uk
 */
public class EditQualificationServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditQualificationServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditQualificationServlet at " + request.getContextPath() + "</h1>");
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
                    + "                        <input type=\"text\" name=\"name-eq\" required/>\n"
                    + "                        <br></br>				\n"
                    + "			Description\n"
                    + "			<input type=\"text\" name=\"description-eq\" required/>\n"
                    + "<br></br>				\n"
                    + "			Years of validity\n"
                    + "			<input type=\"number\" name=\"years-eq\" required/>\n"
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
        String localVa = request.getParameter("name-eq");
        Qualification d = retrieveQualification(localVa);
if(d!=null){
        d.setDescription(request.getParameter("description-eq"));
        d.setName(localVa);
        d.setYearsOfValidity(Integer.parseInt(request.getParameter("years-eq")));

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
            out.println("Qualification not found");
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
