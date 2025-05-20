package pavitra;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Dummy credential check
        if ("admin".equals(username) && "password1234".equals(password)) {
            HttpSession session = request.getSession();

            session.setAttribute("username", username);

            Integer count = (Integer) session.getAttribute("loginCount");
            count = (count == null) ? 1 : count + 1;
            session.setAttribute("loginCount", count);

            response.sendRedirect("display");
        } else {
            response.setContentType("text/html");
            response.getWriter().println("<h3>Invalid username or password!</h3><a href='login.html'>Try Again</a>");
        }
    }
}
