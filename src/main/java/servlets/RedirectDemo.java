package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Денис on 11.06.2017.
 */
public class RedirectDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String docType = "<!DOCTYPE html>";
        String title = "Redirect Demo";
        String redirectionWebsite = "http://vk.com/";
        PrintWriter writer = resp.getWriter();

        writer.println(docType + "<html>" +
                "<head>" +
                "<title>" + title +
                "</title>" +
                "</head>" +
                "<body>" +
                "<h1>You will be redirected to http://vk.com/</h1>" +
                "</body>" +
                "</html>");

        resp.setStatus(resp.SC_MOVED_PERMANENTLY);
        resp.setHeader("Location", redirectionWebsite);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
