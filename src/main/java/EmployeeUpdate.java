import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class EmployeeUpdate extends HttpServlet{
    private String id ="";
    private EmployeeDao employeeDao = EmployeeDaoFactory.getEmployeeDao();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        id = request.getParameter("id");
        Employee employee = employeeDao.getEmployeeById(Integer.parseInt(id));
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>" +
                "<title>Employee Form</title>'" +
                "<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css'" +
                "integrity='sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N' crossorigin='anonymous'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form action='EmployeeUpdateServlet' method='post'>");
        out.println("<h2>Update Employee Form</h2>");
//        request.getRequestDispatcher("form.html").include(request,response);
        out.println("<div>\n" +
                "  <div>\n" +
                "    <label for=\"name\">Name</label>\n" +
                "    <input type=\"text\" name=\"name\" id=\"name\" value='"+employee.getName() + "'/>\n" +
                "  </div>\n" +
                "  <div>\n" +
                "    <label for=\"email\">Email</label>\n" +
                "    <input type=\"text\" name=\"email\" id=\"email\" value='"+employee.getEmail() + "'/>\n" +
                "  </div>\n" +
                "  <div>\n" +
                "    <label for=\"age\">Age</label>\n" +
                "    <input type=\"number\" name=\"age\" id=\"age\" min=\"1\" max=\"120\" value='"+employee.getAge() + "'/>\n" +
                "  </div>\n" +
                "  <p>Gender:</p>\n" +
                "  <div>\n" +
                "    <label for=\"male\">Male</label>\n" +
                "    <input type=\"radio\" name=\"gender\" id=\"male\" value=\"Male\" />\n" +
                "  </div>\n" +
                "  <div>\n" +
                "    <label for=\"female\">Female</label>\n" +
                "    <input type=\"radio\" name=\"gender\" id=\"female\" value=\"Female\" />\n" +
                "  </div>\n" +
                "  <div>\n" +
                "    <label for=\"other\">Other</label>\n" +
                "    <input type=\"radio\" name=\"gender\" id=\"other\" value=\"Other\" />\n" +
                "  </div>\n" +
                "\n" +
                "  <div>\n" +
                "    <input type=\"submit\" value=\"Save\">\n" +
                "  </div>\n" +
                "  <div>\n" +
                "    <a href=\"EmployeeListServlet\">View List</a>\n" +
                "  </div>\n" +
                "</div>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        Employee employee = employeeDao.getEmployeeById(Integer.parseInt(id));
        employee.setName(request.getParameter("name"));
        employee.setEmail(request.getParameter("email"));
        employee.setAge(Integer.parseInt(request.getParameter("age")));
        employee.setGender(request.getParameter("gender"));

        employeeDao.updateEmployee(employee);
        //request.getRequestDispatcher("EmployeeListServlet").include(request,response);
        response.sendRedirect("EmployeeListServlet");
    }
}