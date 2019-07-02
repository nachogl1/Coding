package html;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Controller;
import static model.Controller.create;
import model.Qualification;

/**
 *
 * @author ig2348z.gre.ac.uk
 */
public class CreateQualificationServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateQualityServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateQualityServlet at " + request.getContextPath() + "</h1>");
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
                    + "			Name of the qualification		\n"
                    + "                        <input type=\"text\" name=\"nameq-mq\" required/>\n"
                    + "                        <br></br>				\n"
                    + "			Description\n"
                    + "			<input type=\"text\" name=\"descriptionq-mq\" required/>\n"
                    + "<br></br>\n"
                    + "                         Years of validity\n"
                    + "			<input type=\"number\" name=\"yearsq-mq\" required/>\n"
                    + "<br></br>\n"
                    + "			\n"
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
        Qualification d=new Qualification(request.getParameter("nameq-mq"), request.getParameter("descriptionq-mq"),
                Integer.parseInt(request.getParameter("yearsq-mq")));
       if(!d.equals(Controller.retrieveQualification(request.getParameter("nameq-mq")))){
        create(d);
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
            out.println("This qualification already exists");
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
