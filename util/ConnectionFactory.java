package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// import java.util.Scanner;

public class ConnectionFactory {
    private static final String URL = "jdbc:mysql://localhost:3306/funeraria";

    public static Connection getConnection() throws SQLException {
        // Scanner scanner = new Scanner(System.in);
        // System.out.print("Usuário do MySQL: ");
        // String user = scanner.nextLine();
        // System.out.print("Senha do MySQL: ");
        // String password = scanner.nextLine();
        // scanner.close();
        return DriverManager.getConnection(URL, "root", "123456");
    }

    public static Connection getConnection(String user, String password) throws SQLException {
        return DriverManager.getConnection(URL, user, password);
    }
}
