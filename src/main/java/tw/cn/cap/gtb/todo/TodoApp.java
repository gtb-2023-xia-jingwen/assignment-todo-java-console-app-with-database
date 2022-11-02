package tw.cn.cap.gtb.todo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TodoApp {
    public static void main(String[] args) throws SQLException {
        if (args.length == 0) return;
        TodoApp todoApp = new TodoApp();

        String cmd = args[0];
        // 1. init
        if ("init".equals(cmd)) {
            String createSql = "CREATE TABLE IF NOT EXISTS `tasks`\n" + "(\n" + "    `id`     INT AUTO_INCREMENT PRIMARY KEY,\n" + "    `title`  VARCHAR(255) NOT NULL,\n" + "    `status` INT NOT NULL DEFAULT 0\n" + ");";
            try (Connection conn = todoApp.getConnection();
                 PreparedStatement preStat = conn.prepareStatement(createSql)) {
                preStat.executeUpdate();
                System.out.println("Initialized successfully.");
            }
            return;
        }

        // check if `tasks` table exist
        String querySql = "SHOW TABLES LIKE 'tasks';";
        try (Connection conn = todoApp.getConnection();
             ResultSet rs = conn.createStatement().executeQuery(querySql)) {
            if (!rs.next()) {
                System.out.printf("Please run 'todo init' before running '%s' command.\n", cmd);
                return;
            }
        }

        // 2. list

        // 3. add

        // 4. mark

        // 5. remove
    }

    private Connection getConnection() throws SQLException {
        final String url = "jdbc:mysql://localhost:13306/todoapp";
        final String username = "root";
        final String password = "p@ssword";
        return DriverManager.getConnection(url, username, password);
    }
}
