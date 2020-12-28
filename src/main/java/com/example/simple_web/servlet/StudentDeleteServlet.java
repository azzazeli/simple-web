package com.example.simple_web.servlet;

import com.example.simple_web.db.DbManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "studentDeleteServlet", value = "/student_delete")
public class StudentDeleteServlet extends HttpServlet {
    private DbManager dbManager = new DbManager();

    public void init() {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        dbManager.deleteStudent(Long.valueOf(request.getParameter("id")));
        response.sendRedirect("students");
    }

    public void destroy() {
    }

}
