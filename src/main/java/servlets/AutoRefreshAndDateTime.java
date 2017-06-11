package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by Денис on 11.06.2017.
 */
public class AutoRefreshAndDateTime extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setIntHeader("Refresh", 1);
        resp.setContentType("text/html");

        String docType = "<!DOCTYPE html>";
        String title = "Date and Time Demo";
        Date currentDate = new Date();

        PrintWriter writer = resp.getWriter();

        writer.println(docType + "<html>" +
                "<head>" +
                "<title>" + title + "</title>" +
                "</head>" +
                "<body>" +
                "<h1>Current date and time: </h1>" +
                currentDate.toString() +
                "</body>" +
                "</html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
