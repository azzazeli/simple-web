package com.example.simple_web.db;

import com.example.simple_web.domain.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author AlexM
 * Date: 12/19/20
 **/
public class DbManager {
    //todo: must be singleton with one time init for driver
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // connection string
    private final String conectionUrl = "jdbc:mysql://localhost/student";
    // the name of the user
    private final String user_name = "root";
    // the password of the user
    private final String pwd = "manager";


    private Connection dbcon() {
        Connection dbcon = null;
        try {
            dbcon = DriverManager.getConnection(conectionUrl, user_name, pwd);
            System.out.println("You are now connected to the server");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return dbcon;
    }

    public List<Student> allStudents() {
        List<Student> all = new ArrayList<>();
        String sql = "select * from student";
        try (Connection connection = dbcon(); PreparedStatement pstmt = connection.prepareStatement(sql)) {
            final ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getLong("id"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("last_name"));
                all.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return all;
    }

    public void deleteStudent(Long id) {
        String sql = "DELETE FROM student WHERE id = ?";

        try (Connection connection = dbcon();
             PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Student getStudent(Long id) {
        final Student student = new Student();
        String sql = "select * from student where id=?";
        try (Connection connection = dbcon(); PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            final ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                student.setId(resultSet.getLong("id"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("last_name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return student;
    }

    public long insertStudent(String firstName, String lastName) {
        String sql = "INSERT INTO student( first_name, last_name) VALUES(?,?)";
        long id = 0;

        try (Connection connection = dbcon();
             PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ) {
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);

            int rowsAffected = pstmt.executeUpdate();
            // this will check the affected row(s)
            if (rowsAffected > 0) {
                // then we get the ID of the affected row(s)
                try(ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }

}
