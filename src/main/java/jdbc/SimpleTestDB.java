package jdbc;

import java.sql.*;

/**
 * Created by Денис on 11.06.2017.
 */
public class SimpleTestDB {
    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/tutorials";

    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static final String GET_ALL = "SELECT * FROM developers";
    private static final String UPDATE_SALARY = "UPDATE developers SET salary = ? WHERE id = ?";
    private static final String INSERT_INTO = "INSERT INTO developers VALUES (6, 'Misha', 'wcewcwec', 'tester', 2, 900)";


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = null;

        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        connection.setAutoCommit(false);
        Savepoint savepoint = null;
        try {
            getAll(connection);
            setUpdateSalary(connection);
            savepoint = connection.setSavepoint();

            insert(connection);
            connection.commit();

            getAll(connection);
        } catch (SQLException ex) {
            ex.printStackTrace();
            connection.rollback(savepoint);
        } finally {
            connection.close();
        }
    }

    private static void insert(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
        preparedStatement.executeUpdate();
        System.out.println("--------- After insert ------------");
    }

    private static void setUpdateSalary(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SALARY);
        preparedStatement.setInt(1, 3000);
        preparedStatement.setInt(2, 1);
        preparedStatement.executeUpdate();
        System.out.println("--------- After update ------------");
    }

    private static void getAll(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("first_name");
            String specialty = rs.getString("specialty");
            int salary = rs.getInt("salary");

            System.out.println("id: " + id);
            System.out.println("Name: " + name);
            System.out.println("Specialty: " + specialty);
            System.out.println("Salary: " + salary);
            System.out.println("\n============================\n");
        }
        rs.close();
    }
}
