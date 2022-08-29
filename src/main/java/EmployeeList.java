import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class EmployeeList extends HttpServlet {
    EmployeeDao employeeDao = EmployeeDaoFactory.getEmployeeDao();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        List<Employee> employees = employeeDao.getAllEmployees();
        request.getRequestDispatcher("list.html").include(request,response);

        for(Employee e: employees){
            out.println("<div>"+e+"<div><form action='EmployeeUpdateServlet' method='get'><input type='hidden' name='id' value='"+e.getId()+"'/><input type='submit' value='Update Employee' /> </form></div><form action='EmployeeDeleteServlet' method='get'><input type='hidden' name='id' value='"+e.getId()+"'/><input type='submit' value='Delete Employee' /> </form></div></div>");
        }

    }
}