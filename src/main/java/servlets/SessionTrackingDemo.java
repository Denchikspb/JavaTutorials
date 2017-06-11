package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by Денис on 11.06.2017.
 */
public class SessionTrackingDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String message = "";

        String sessionId = session.getId();
        Date sessionCreationDate = new Date(session.getCreationTime());
        Date lastSessionAccess = new Date(session.getLastAccessedTime());
        String userId = "userId";

        if (session.isNew()) {
            message = "Welcome!";
        } else {
            message = "Glad to see you again";
        }

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        String title = "Session Tracking Demo";
        String docType = "<!DOCTYPE html>";

        writer.println(docType + "<html>" +
                "<head>" +
                "<title>" + title +
                "</title>" +
                "</head>" +
                "<body>" +
                "<h1>Session Details</h1>" +
                "Session ID:" + sessionId +
                "<br/>" +
                "Created: " + sessionCreationDate +
                "<br/>" +
                "Last Accessed Date: " + lastSessionAccess +
                "<br/>" +
                "User ID: " + userId +
                "<br/>" +
                "Message: " + message +
                "</body>" +
                "</html>");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
