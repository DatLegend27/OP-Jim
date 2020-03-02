/**
 *
 * @author John Kyle Bess & Tony Alltop
 */

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet(urlPatterns={"/home"})
public class Home extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        resp.setContentType("text/html");
        var pw = resp.getWriter();
        var sess = req.getSession();
        pw.printf("<!DOCTYPE HTML>\n");
        pw.printf("<HTML><head><meta charset=\"utf-8\"></head>");
        pw.printf("<body>");
        pw.printf("Welcome!");
        pw.printf("<br>This is the Home Page");
        
        if( req.getSession().getAttribute("username") == null ){
            pw.printf("<br>You are not currently logged in :(");
            pw.printf("<br>To change that sad fact choose one of the following options!:");
            pw.printf("<br><a href = \"http://localhost:2020/srv/login\"> <b>Login Here!</b></a>");
            pw.printf("<br><b>or</b>");
            pw.printf("<br><a href = \"http://localhost:2020/srv/signup\"> Signup Here!");
        } else {
            pw.printf("<br>You are Logged in as "+ req.getSession().getAttribute("username"));
            pw.printf("<br> click here to Logout of your account so those pesky hackers wont getcha ;)");
            pw.printf("<br><a href = \"http://localhost:2020/srv/logout\"> Logout Here!");
        }
        pw.printf("</body></html>");
    }

}
