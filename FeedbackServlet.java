package com.feedbackapp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FeedbackServlet extends HttpServlet {
    private static String escape(String value) {
        if (value == null) return "";
        return value.replace("&", "&amp;").replace("<", "&lt;")
                    .replace(">", "&gt;").replace("\"", "&quot;")
                    .replace("'", "&#39;");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = escape(request.getParameter("name"));
        String type = escape(request.getParameter("feedbackType"));
        String comments = escape(request.getParameter("comments"));
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html><html lang='en'><head><meta charset='UTF-8'><title>Feedback Received</title></head><body>");
            out.println("<h2>Thank you, " + name + " for your feedback!</h2>");
            out.println("<p><strong>Feedback Type:</strong> " + type + "</p>");
            out.println("<p><strong>Comments:</strong> " + comments.replace("\n", "<br>") + "</p>");
            out.println("<p><strong>Date and Time:</strong> " + dateTime + "</p>");
            out.println("<a href='feedback.html'>Submit another response</a></body></html>");
        }
    }
}
