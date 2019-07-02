package html;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Controller;

/**
 *
 * @author ig2348z.gre.ac.uk
 */
public class LoginServlet extends HttpServlet {

    Controller controller = Controller.getInstance();

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
            out.println("<h1>Servlet myServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean isSession = controller.getUserValidation(request.getParameter("username"),
                request.getParameter("password"));
        if (isSession && request.getParameter("username").equals("admin")) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<html>");
                out.println("<body><div align=\"center\">");
                out.println("<h1>Welcome admin</h1>");
                out.println("<form action=admin.jsp method=get>"
                        + "<input type=submit value='Continue'>"
                        + "</form><div align=\"center\">");
                out.println("</body>");
                out.println("</html>");
            }
        } else {
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Error</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Wrong username or password</h1>");
                out.println("<form action=login.jsp method=get>"
                        + "<input type=submit value='Go back'>"
                        + "</form>");
                out.println("</body>");
                out.println("</html>");
                out.println("</body>");
                out.println("</html>");

            }
        }

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "ADMIN login page";
    }

}
