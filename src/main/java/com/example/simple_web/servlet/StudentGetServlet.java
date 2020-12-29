package com.example.simple_web.servlet;

import com.example.simple_web.db.DbManager;
import com.example.simple_web.domain.Student;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "studentGetServlet", value = "/student_get")
public class StudentGetServlet extends HttpServlet {
    private DbManager dbManager = DbManager.instance();

    public void init() {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("test_student", dbManager.getStudent(Long.valueOf(request.getParameter("id"))));
        request.getRequestDispatcher("get.jsp").forward(request, response);
    }

    public void destroy() {
    }

}
