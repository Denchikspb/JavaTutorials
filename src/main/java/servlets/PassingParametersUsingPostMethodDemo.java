package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Денис on 07.06.2017.
 */
public class PassingParametersUsingPostMethodDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter writer = resp.getWriter();
        String title = "Passing parameters using POST method";
        String docType = "<!DOCTYPE html>";

        writer.println("<html>" +
                "<head><title>" + title + "</title></head>\n" +
                "<body><h2>Specialty: </h2>" + req.getParameter("specialty") +
                "<h2>Experience: </h2>" + req.getParameter("experience")
                + "</body>" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
