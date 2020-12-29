package com.example.simple_web.servlet;

import com.example.simple_web.db.DbManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author AlexM
 * Date: 12/19/20
 **/
@WebServlet(name = "studentsListServlet", value = {"", "/students"})
public class StudentsListServlet extends HttpServlet {
    private DbManager dbManager = DbManager.instance();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("test_students", dbManager.allStudents());
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }
}
