package com.allanimt.servlet.booksManagment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public InsertServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();

        String booksName = request.getParameter("booksName");
        String authorsName = request.getParameter("authorsName");
        String topic = request.getParameter("topic");
        String state = request.getParameter("state");

        Book book = new Book(booksName, authorsName, topic, state);

        int executed = DBConnect.insert(book);

        if (executed != 0) {
            printWriter.println("<h2>Book insert!</h2>");
            request.getRequestDispatcher("index.html").include(request, response);;
        } else {
            printWriter.println("<h2>Book not insert!</h2>");
        }
    }

}