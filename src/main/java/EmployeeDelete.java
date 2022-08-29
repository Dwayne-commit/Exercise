import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class EmployeeDelete extends HttpServlet {
    private String id ="";
    private Employee employee;
    private EmployeeDao employeeDao = EmployeeDaoFactory.getEmployeeDao();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        id = request.getParameter("id");
        employee = employeeDao.getEmployeeById(Integer.parseInt(id));
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>" +
                "<title>Employee Form</title>'" +
                "<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css'" +
                "integrity='sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N' crossorigin='anonymous'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form action='EmployeeDeleteServlet' method='post'>");
        out.println("<h2>Are you sure you want to delete this employee?</h2>");
        out.println(employee);
        out.println("<input type='submit' value='Delete'>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        employeeDao.deleteEmployee(employee);
        //request.getRequestDispatcher("EmployeeListServlet").include(request,response);
        response.sendRedirect("EmployeeListServlet");
    }
}