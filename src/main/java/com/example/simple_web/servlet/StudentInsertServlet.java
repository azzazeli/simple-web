package com.example.simple_web.servlet;

import com.example.simple_web.db.DbManager;
import com.example.simple_web.domain.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author AlexM
 * Date: 12/28/20
 **/
@WebServlet(name = "studentInsertServlet", value = "/student_insert")
public class StudentInsertServlet extends HttpServlet {
    private DbManager dbManager = new DbManager();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final long newId = dbManager.insertStudent(request.getParameter("first_name"), request.getParameter("last_name"));
        System.out.println("new id:" + newId);
        response.sendRedirect("student_get?id=" + newId);
    }
}
