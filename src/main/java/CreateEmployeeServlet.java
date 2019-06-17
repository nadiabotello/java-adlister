import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateEmployeeServlet", urlPatterns = "/employees/create")
public class CreateEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/employees/create.jsp")
                .forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Employee employee = new Employee(
                Long.parseLong(request.getParameter("birth_date")),
                request.getParameter("first_name"),
                request.getParameter("last_name"),
                request.getParameter("gender"),
                Long.parseLong(request.getParameter("hire_date"))
        );
        DaoFactory.getEmployeesDao().save(employee);
        response.sendRedirect("/employees");
    }
}
