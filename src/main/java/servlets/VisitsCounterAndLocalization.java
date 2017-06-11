package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

/**
 * Created by Денис on 11.06.2017.
 */
public class VisitsCounterAndLocalization extends HttpServlet {
    private volatile int visitCounter;

    public void init(){
        visitCounter = 0;
    }

    synchronized void increaseAmountOfVisits(){
        visitCounter++;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Locale locale = new Locale("rf_ru");

        increaseAmountOfVisits();

        String language = locale.getLanguage();


        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        String docType = "<!DOCTYPE html>";
        String title = "Visits Counter and Locale Demo";
        PrintWriter writer = resp.getWriter();

        if (locale.getLanguage().equalsIgnoreCase("rf_ru")) {
            title = "Демонстрация локализации";
            writer.println(docType + "<html>" +
                    "<head>" +
                    "<title>" + title +
                    "</title>" +
                    "</head>" +
                    "<body>" +
                    "<h1>Данные локализации: </h1>" +
                    "<h2>Локализация: </h2>" + locale +
                    "<h2>Язык:  </h2>" + language +
                    "<h2>Количество посещений:  </h2>" + visitCounter +
                    "</body>" +
                    "</html>");
        } else {
            writer.println(docType + "<html>" +
                    "<head>" +
                    "<title>" + title +
                    "</title>" +
                    "</head>" +
                    "<body>" +
                    "<h1>Locale Details: </h1>" +
                    "<h2>Locale: </h2>" + locale +
                    "<h2>Language:  </h2>" + language +
                    "<h2>Visits counter:  </h2>" + visitCounter +
                    "</body>" +
                    "</html>");
        }
    }
}
