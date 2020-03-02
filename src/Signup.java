/**
 *
 * @author John Kyle Bess & Tony Alltop
 */

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet(urlPatterns={"/signup"})
public class Signup extends HttpServlet
{   
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        
        resp.setContentType("text/html");
        var pw = resp.getWriter();
        var username = (String) req.getParameter("username");
        var password = (String) req.getParameter("password");
        User new_account = new User();
        pw.printf("<!DOCTYPE HTML>\n");
        pw.printf("<HTML><head><meta charset=\"utf-8\"></head>");
        pw.printf("<body>");
        if( username == null || password == null){
            pw.printf("No account information provided. :(");
            pw.printf("<br>To signup an account please enter a Username, and a Password for your account.");
            pw.printf("<br>Example format signup?username=yourusername&password=yourpasword");
            pw.printf("<br>Click enter button when done to complete registration <3");
        } else {
            
            new_account.username = username;
            new_account.password = password;
            
            Main.user_list.add(new_account);
            
            pw.printf("Congratulations! your account has been created");
            pw.printf("\n"+ "Account Login Info is printed below");
            pw.printf("\n"+ "Username: "+username);
            pw.printf("\n"+ "Password: "+password);
        }
        
        pw.printf("</body></HTML>");
    }

}
