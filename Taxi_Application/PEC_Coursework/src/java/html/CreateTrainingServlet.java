package html;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static model.Controller.*;
import model.Training;

/**
 *
 * @author ig2348z.gre.ac.uk
 */
public class CreateTrainingServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateTrainingServlet</title>");
            out.println("</head>");
            out.println("<body><div align=\"center\">");
            out.println("<h1>Servlet CreateTrainingServlet at " + request.getContextPath() + "</h1>");
            out.println("</div></body>");
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
                    + "			Area of training 		\n"
                    + "                        <input type=\"text\" name=\"area-mt\" required/>\n"
                    + "                        <br></br>				\n"
                    + "			Details of training \n"
                    + "			<input type=\"text\" name=\"details-mt\" required/>\n"
                    + "<br></br>\n"
                    + "                         Duration of training (hours) \n"
                    + "			<input type=\"number\" name=\"durationInHours-mt\" required/>\n"
                    + "<br></br>\n"
                    + "Name of training  <input type=\"text\" name=\"name-mt\" required/>\n"
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
        
        Training d=new Training(request.getParameter("area-mt"), request.getParameter("details-mt"),
                Integer.parseInt(request.getParameter("durationInHours-mt")), request.getParameter("name-mt")) ;
        if(!d.equals(retrieveTraining(request.getParameter("name-mt")))){
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
            out.println("This training already exists");
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
