package pavitra;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class DisplayServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Login Info</title></head><body>");

        if (session != null && session.getAttribute("username") != null) {
            String username = (String) session.getAttribute("username");
            int loginCount = (Integer) session.getAttribute("loginCount");

            out.println("<h2>Welcome, " + username + "!</h2>");
            out.println("<p>You have logged in <strong>" + loginCount + "</strong> time(s).</p>");
        } else {
            out.println("<h3>No session found. Please <a href='login.html'>login</a> first.</h3>");
        }

        out.println("</body></html>");
    }
}




