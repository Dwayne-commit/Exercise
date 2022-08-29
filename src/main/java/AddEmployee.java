import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddEmployee extends HttpServlet {
    EmployeeDao employeeDao = EmployeeDaoFactory.getEmployeeDao();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.getRequestDispatcher("index.html").include(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Employee employee = new Employee();

        employee.setName(request.getParameter("name"));
        employee.setEmail(request.getParameter("email"));
        employee.setAge(Integer.parseInt(request.getParameter("age")));
        employee.setGender(request.getParameter("gender"));
        employeeDao.saveEmployee(employee);
        out.println("Successfully added Employee");
        request.getRequestDispatcher("index.html").include(request,response);

    }
}