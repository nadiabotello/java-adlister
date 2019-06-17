import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ViewEmployeesServlet", urlPatterns = "/employees")
public class ViewEmployeesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("employees", DaoFactory.getEmployeesDao().findAll());
        request.getRequestDispatcher("/WEB-INF/employees/index.jsp").forward(request, response);
    }
}
