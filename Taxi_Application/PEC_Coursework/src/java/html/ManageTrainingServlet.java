package html;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static model.Controller.create;
import static model.Controller.retrieve;
import static model.Controller.retrieveDriver;
import static model.Controller.retrieveDriverById;
import static model.Controller.retrieveSchedule;
import static model.Controller.retrieveSchedules;
import model.Driver;
import model.Schedule;
import model.Training_profile;

/**
 *
 * @author ig2348z.gre.ac.uk
 */
public class ManageTrainingServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ManageTrainingServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManageTrainingServlet at " + request.getContextPath() + "</h1>");
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
            out.println("<h1>Scheduled training</h1>\n");
            List<Schedule> scheduleList = retrieveSchedules();
            int y;
            out.println("<form action='' method='post'>");
            for (y = 0; y < scheduleList.size(); y++) {
                out.println("<input type='radio' name='training' value='" + scheduleList.get(y).getSchedule_Id() + 
                        "' />"
                        + scheduleList.get(y).getTraining().getName() + " on " + 
                        scheduleList.get(y).getTime_Start()+" to "+scheduleList.get(y).getTime_Finish() + "<br></br>");
           
                out.println("Attendance list: ");
                int y2;
                int [] localArray=scheduleList.get(y).getArrayAssessment();
                for(y2=0;y2<localArray.length;y2++){
                    out.println(retrieveDriverById(localArray[y2]).getUserName()+"/");
                }
                out.println("<br></br>\n");
            }

            out.println("<h1>Drivers</h1>\n");
            out.println("<h2>Choose the driver to be assessed</h2>\n");
            List<Driver> driverList = retrieve();
            int p;
            for (p = 0; p < driverList.size(); p++) {
                out.println("<input type='radio' name='drivers' value='" + driverList.get(p).getUserName() + "' required/>" + driverList.get(p).getUserName() + "<br></br>");
            }

            out.println("Remark about the performance: <input type='text' name='performance' required /><br></br>");
            out.println("Mark: <input type='number' name='mark' required /><br></br>");
            out.println("Attendance (Y/N): <input type='text' name='attendance' required /><br></br>");
            
            out.println("Year: <input type='number' name='t-time1' required /> <br></br>");
            out.println("Month: <input type='number' name='t-time2' required /> <br></br>");
            out.println("Day: <input type='number' name='t-time3' required /> <br></br>");
            out.println("Hour: <input type='number' name='t-time4' required /> <br></br>");
            out.println("Min: <input type='number' name='t-time5' required /> <br></br>");

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
        String driver = request.getParameter("drivers");
        boolean attendance;
        if (request.getParameter("attendance").equals("y") || request.getParameter("attendance").equals("Y")) {
            attendance = true;
        } else {
            attendance = false;
        }
        LocalDateTime myDateObj = LocalDateTime.of(Integer.parseInt(request.getParameter("t-time1")),
                Integer.parseInt(request.getParameter("t-time2")), Integer.parseInt(request.getParameter("t-time3")),
                Integer.parseInt(request.getParameter("t-time4")), Integer.parseInt(request.getParameter("t-time5")));
        create(new Training_profile(
                request.getParameter("performance"),
                Integer.parseInt(request.getParameter("mark")),
                retrieveSchedule(Integer.parseInt(request.getParameter("training"))),
                retrieveDriver(request.getParameter("drivers")), attendance,myDateObj));
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<body>");
            out.println("Marked");
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
