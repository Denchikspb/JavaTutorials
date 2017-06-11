package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by Денис on 11.06.2017.
 */
public class CookieDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie sessionId = new Cookie("session_id", req.getRemoteAddr() + new Date().toString());
        Cookie language = new Cookie("language", req.getLocale().toString());

        resp.addCookie(sessionId);
        resp.addCookie(language);

        resp.setContentType("text/html");

        PrintWriter writer = resp.getWriter();
        String title = "Cookies Demo";
        String docType = "<!DOCTYPE html>";

        Cookie[] cookies = req.getCookies();

        writer.println(docType + "<html><head><title>" + title + "</title></head><body>");

        if (cookies != null) {
            writer.println("Cookies");
            for (int i = 0; i < cookies.length; i++) {
                writer.println("<hr/>");
                writer.println("Name: " + cookies[i].getName());
                writer.println("<br/>");
                writer.println("Value: " + cookies[i].getValue());
                writer.println("<hr/>");
            }
        } else {
            writer.println("No cookies");
        }
        writer.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
