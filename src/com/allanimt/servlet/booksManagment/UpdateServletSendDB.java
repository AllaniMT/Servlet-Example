package com.allanimt.servlet.booksManagment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UpdateServletSendDB")
public class UpdateServletSendDB extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UpdateServletSendDB() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();

        String booksIdString = request.getParameter("id");
        int id = Integer.parseInt(booksIdString);

        String booksName = request.getParameter("booksName");
        String authorsName = request.getParameter("authorsName");
        String topic = request.getParameter("topic");
        String state = request.getParameter("state");

        Book book = new Book(id, booksName, authorsName, topic, state);


        int executed = DBConnect.update(book);

        if (executed != 0) {
            response.sendRedirect("ViewServlet");
        } else {
            printWriter.println("<h2>Book not updated!</h2>");
        }

    }
}