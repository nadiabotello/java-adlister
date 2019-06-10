import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import javax.servlet.*;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if ((request.getParameter("name") != null)) {
            String pageMessage = request.getParameter("name");
            out.println("<h1>Hello, " + pageMessage + "!</h1>");
        } else {
            out.println("<h1>Hello, World!</h1>");
        }

    }


}
