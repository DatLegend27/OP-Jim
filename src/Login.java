/**
 *
 * @author John Kyle Bess & Tony Alltop
 */

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/login"})
public class Login extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        resp.setContentType("text/plain");
        var pw = resp.getWriter();
        
        var username = req.getParameter("username");
        var password = req.getParameter("password");
        if( username == null ){
            pw.printf("No username provided" + "\n" + "try again hacker");
        }
        else if( password == null ){
            pw.printf("No password provided" + "\n" + "try again hacker");
        }
        else{
            for (int i = 0; i < Main.user_list.size(); i++)
            {
                if (Main.user_list.get(i).username.equals(username))
                {
                    if (Main.user_list.get(i).password.equals(password))
                    {
                        var sess = req.getSession();
                        sess.setAttribute("username", username);
                        pw.printf("Logged in as " + username);
                    }
                    else
                    {
                        pw.printf("Wrong Username and/or Password" + "\n" + "Try again hacker");
                    }
                }
                else
                {
                    pw.printf("Wrong Username and/or Password" + "\n" + "Try again Hacker");
                }
            }
        }
    }

}
