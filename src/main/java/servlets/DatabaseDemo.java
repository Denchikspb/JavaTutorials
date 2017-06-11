package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by Денис on 11.06.2017.
 */
public class DatabaseDemo extends HttpServlet {

    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/tutorials";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "root";
    static final String GET_ALL_DEVELOPERS_RECORDS = "SELECT * FROM developers";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        String title = "Database Demo";
        String docType = "<!DOCTYPE html>";

        try {
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(GET_ALL_DEVELOPERS_RECORDS);

            writer.println(docType + "<html><head><title>" + title + "</title></head><body>");
            writer.println("<h1>DEVELOPERS DATA</h1>");
            writer.println("<br/>");

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String specialty = resultSet.getString(4);
                int experience = resultSet.getInt(5);
                int salary = resultSet.getInt(6);

                writer.println("ID: " + id);
                writer.println("First name: " + firstName + "<br/>");
                writer.println("Last name: " + lastName + "<br/>");
                writer.println("Specialty: " + specialty + "<br/>");
                writer.println("Experience: " + experience + " years<br/>");
                writer.println("Salary: $" + salary + "<br/>");
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        writer.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
