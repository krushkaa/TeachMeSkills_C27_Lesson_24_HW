package com.task2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/age")
public class AgeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader bufferedReader = req.getReader();
        PrintWriter printWriter = resp.getWriter();
        String age = bufferedReader.readLine().toString();
        char[] digits = age.toCharArray();

        for (int i = 0; i < digits.length; i++) {
            if (!Character.isDigit(digits[i])) {
                printWriter.write("Illegal age!");
                printWriter.close();
                return;
            }
        }
        if (Integer.parseInt(age) < 0 || Integer.parseInt(age) > 110) {
            printWriter.write("Illegal age!");
            printWriter.close();
            return;
        }
        if (Integer.parseInt(age) >= 18) printWriter.write("You are adult");
        else printWriter.write("You are underage");

        printWriter.close();

        resp.setContentType("text/html");
    }
}

