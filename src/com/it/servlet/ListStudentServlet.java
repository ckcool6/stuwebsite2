package com.it.servlet;

import com.it.bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/listStudentServlet")
public class ListStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //
        BufferedReader br = new BufferedReader(new FileReader("D:\\stu.txt"));

        ArrayList<Student> list = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null) {
            Student stu = new Student();
            String[] arr = line.split(",");
            stu.setName(arr[0]);
            stu.setAge(Integer.parseInt(arr[1]));
            stu.setScore(Integer.parseInt(arr[2]));
            list.add(stu);
        }

        resp.setContentType("text/html;charset=UTf-8");
        PrintWriter pw = resp.getWriter();
        for (Student s : list) {
            pw.write(s.getName() + "," + s.getAge() + "," + s.getScore());
            pw.write("<br>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
