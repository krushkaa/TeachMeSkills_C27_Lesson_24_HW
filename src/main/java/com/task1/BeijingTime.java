package com.task1;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class BeijingTime extends HttpServlet {
    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter respWriter = resp.getWriter();
        respWriter.write("<b><h3>Beijing time: </h3></b><br>");
        respWriter.write(String.valueOf(ZonedDateTime.now(ZoneId.of("Hongkong"))));
        respWriter.close();
        resp.setContentType("text/html");
    }
}
