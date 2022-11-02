package tw.cn.cap.gtb.todo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

        switch (cmd) {
            case "list":
                todoApp.list();
                break;
            case "add":
                String title = Arrays.stream(args).skip(1).collect(Collectors.joining(" "));
                todoApp.add(title);
                break;
            case "mark":
            case "remove":
                List<Integer> numbers = Arrays.stream(args).skip(1).filter(TodoApp::checkIsNumber).
                        map(Integer::parseInt).collect(Collectors.toList());
                if ("mark".equals(cmd)) {
                    todoApp.mark(numbers);
                }
                if ("remove".equals(cmd)) {
                    todoApp.remove(numbers);
                }
                break;
        }
    }

    public static boolean checkIsNumber(String s) {
        boolean res = true;
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            res = false;
        }
        return res;
    }

    private void remove(List<Integer> numbers) throws SQLException {
        String removeSql = "UPDATE `tasks` SET `status`=2 WHERE `id`=? and `status`!=2;";
        try (Connection conn = getConnection();
             PreparedStatement preStat = conn.prepareStatement(removeSql)) {
            for (Integer id : numbers) {
                preStat.setInt(1, id);
                preStat.executeUpdate();
            }
        }
    }

    private void mark(List<Integer> numbers) throws SQLException {
        String markSql = "UPDATE `tasks` SET `status`=1 WHERE `id`=? and `status`=0;";
        try (Connection conn = getConnection();
             PreparedStatement preStat = conn.prepareStatement(markSql)) {
            for (Integer id : numbers) {
                preStat.setInt(1, id);
                preStat.executeUpdate();
            }
        }
    }

    private void add(String title) throws SQLException {
        String addSql = "INSERT INTO `tasks`(`title`) VALUES (?)";
        try (Connection conn = getConnection();
             PreparedStatement preStat = conn.prepareStatement(addSql)) {
            preStat.setString(1, title);
            preStat.executeUpdate();
        }
    }

    private void list() throws SQLException {
        String listSql = "SELECT * FROM `tasks`;";
        try (Connection conn = getConnection();
             ResultSet rs = conn.createStatement().executeQuery(listSql)) {
            ArrayList<String> tbdList = new ArrayList<>();
            ArrayList<String> doneList = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                int status = rs.getInt("status");
                if (status == 0) {
                    tbdList.add(id + " " + title);
                }
                if (status == 1) {
                    doneList.add(id + " " + title);
                }
            }
            System.out.println("# To be done");
            if (!tbdList.isEmpty()) {
                tbdList.forEach(System.out::println);
            } else {
                System.out.println("Empty");
            }
            System.out.println("# Completed");
            if (!doneList.isEmpty()) {
                doneList.forEach(System.out::println);
            } else {
                System.out.println("Empty");
            }
        }
    }

    private Connection getConnection() throws SQLException {
        final String url = "jdbc:mysql://localhost:13306/todoapp";
        final String username = "root";
        final String password = "p@ssword";
        return DriverManager.getConnection(url, username, password);
    }
}
