package html;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static model.Controller.*;
import model.Driver;
import model.Schedule;
import model.Training;

/**
 *
 * @author ig2348z.gre.ac.uk
 */
public class ScheduleServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ScheduleServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ScheduleServlet at " + request.getContextPath() + "</h1>");
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
            out.println("<h1>Trainings available</h1>\n");
            List<Training> trainingList = retrieveTrainings();
            int p;
            out.println("<form action='' method='post'>");
            for (p = 0; p < trainingList.size(); p++) {
                out.println("<input type='radio' name='training' value='" + trainingList.get(p).getName() + "' required />" + trainingList.get(p).getName() + "<br></br>");
            }
            out.println("<h3>Insert required detail for scheduling the training: </h3>");
            out.println("Details: <input type='text' name='t-details' required /> <br></br>");
            out.println("Place: <input type='text' name='t-place' required /> <br></br>");
            out.println("Room space: <input type='number' name='t-room'required  /> <br></br>");
            out.println("<h4>Date: </h4>");

            out.println("Year: <input type='number' name='t-time1' required /> <br></br>");
            out.println("Month: <input type='number' name='t-time2' required /> <br></br>");
            out.println("Day: <input type='number' name='t-time3' required /> <br></br>");
            out.println("Hour: <input type='number' name='t-time4' required /> <br></br>");
            out.println("Min: <input type='number' name='t-time5' required /> <br></br>");
            out.println("<h1>Drivers</h1>\n");
            out.println("<h2>Choose the driver to be assessed</h2>\n");
            List<Driver> driverList = retrieve();
            int p2;
            for (p2 = 0; p2 < driverList.size(); p2++) {
                out.println("<input type='checkbox' name='drivers' value='" + driverList.get(p2).getId() + "'/>" + driverList.get(p2).getUserName() + "<br></br>");
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

        String [] tempArray=request.getParameterValues("drivers");
        int x;
        int[] arrayAssessment=new int[tempArray.length];
        for(x=0;x<tempArray.length;x++){
            arrayAssessment[x]=Integer.parseInt(tempArray[x]);
        }
        LocalDateTime myDateObj = LocalDateTime.of(Integer.parseInt(request.getParameter("t-time1")),
                Integer.parseInt(request.getParameter("t-time2")), Integer.parseInt(request.getParameter("t-time3")),
                Integer.parseInt(request.getParameter("t-time4")), Integer.parseInt(request.getParameter("t-time5")));
        create(new Schedule(request.getParameter("t-place"), myDateObj,
                retrieveTraining(request.getParameter("training")), request.getParameter("t-details"), Integer.parseInt(request.getParameter("t-room")),arrayAssessment));
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<body>");
            out.println("Scheduled");
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
