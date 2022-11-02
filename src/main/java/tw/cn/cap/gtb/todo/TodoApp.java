package tw.cn.cap.gtb.todo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TodoApp {
    public static void main(String[] args) throws SQLException {
        if (args.length == 0) return;

        String cmd = args[0];
        // 1. init
        if ("init".equals(cmd)) {
            String createSql = "CREATE TABLE IF NOT EXISTS `tasks`\n" +
                    "(\n" +
                    "    `id`     INT AUTO_INCREMENT PRIMARY KEY,\n" +
                    "    `title`  VARCHAR(255) NOT NULL,\n" +
                    "    `status` INT NOT NULL DEFAULT 0\n" +
                    ");";
            String url = "jdbc:mysql://localhost:13306/todoapp";
            String username = "root";
            String password = "p@ssword";
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement preStat = conn.prepareStatement(createSql);
            preStat.executeUpdate();
            System.out.println("Initialized successfully.");
        }
        // 2. list

        // 3. add

        // 4. mark

        // 5. remove
    }
}
