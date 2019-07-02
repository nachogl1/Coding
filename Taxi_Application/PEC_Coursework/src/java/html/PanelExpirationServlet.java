package html;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static model.Controller.getPossibleExpiredCourses;
import static model.Controller.getPossibleExpiredTrainings;
import static model.Controller.retrieve;
import model.Driver;

/**
 *
 * @author ig2348z.gre.ac.uk
 */
public class PanelExpirationServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PanelExpirationServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PanelExpirationServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Driver> localList=retrieve();
        int i;
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Speedy Taxis</title>");
            out.println("</head>");
            out.println("<body><div align=\"center\">");
            if(!localList.isEmpty()){
            for(i=0;i<localList.size();i++){               
            out.println("<h1>User: "+localList.get(i).getUserName()+"</h1>");
            
            out.println("<h3>Qualifications</h3>");
            List<String> localList2=getPossibleExpiredCourses(localList.get(i).getId());
            int m;
            if(!localList2.isEmpty()){
                for(m=0;m<localList2.size();m++){                  
                    out.println("<p style=\"background-color:Tomato;\">"+  localList2.get(m) +" course is about to expiry</p>");
                }
            }else{
            out.println("<h4>No expired courses</h4>");
            }

            out.println("<h3>Trainings</h3>");
            List<String> localList3=getPossibleExpiredTrainings(localList.get(i).getId());
            int m2;
            if(!localList3.isEmpty()){
                for(m2=0;m2<localList3.size();m2++){                  
                    out.println("<p style=\"background-color:Blue;\">"+  localList3.get(m2) +" training is about to expiry</p>");
                }
            }else{
            out.println("<h4>No expired trainings</h4>");
            }

            }
            out.println("<form action=admin.jsp method=get>\n"
                    + "<input type=\"submit\" value=\"Go back to admin menu\">\n"
                    + "</form>");
            out.println("</div></body>");
            out.println("</html>");
        }else{
            out.println("<h4>No drivers available</h4>");
            out.println("<form action=admin.jsp method=get>\n"
                    + "<input type=\"submit\" value=\"Go back to admin menu\">\n"
                    + "</form>");
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
        return "Short description";
    }

}
