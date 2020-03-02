
/**
 *
 * @author John Kyle Bess & Tony Alltop
 */

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/logout"})
public class Logout 
{
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        req.getSession().removeAttribute("username");
        resp.setContentType("text/plain");
        var sess = req.getSession();
        var pw = resp.getWriter();
        pw.printf("Successfully Logged Out");
    }
}
