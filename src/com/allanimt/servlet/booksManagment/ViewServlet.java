package com.allanimt.servlet.booksManagment;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ViewServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();

        printWriter.print("<head>");
        printWriter.print("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\">");
        printWriter.print("</head>");
        printWriter.print("<body>");

        printWriter.print("<a href=\"index.html\" class=\"btn btn-info\" role=\"button\">Add Book</a>");

        printWriter.print("<h1>Books Table</h1>");

        List < Book > listOfBooks = DBConnect.getAllBooks();

        printWriter.print("<table border=\"1\" witdh=\"100%\">");

        printWriter.print("<tr><th>Id</th><th>Book name</th>" +
            "<th>Author name</th><th>Topic</th>" +
            "<th>State</th> <th>Edit</th> <th>Delete</th></tr>");

        for (Book book: listOfBooks) {
            printWriter.print("<tr><td>" + book.getId() + "</td><td>" + book.getBooksName() +
                "</td><td>" + book.getAuthorName() + "</td><td>" + book.getTopic() +
                "</td><td>" + book.getState() + "</td><td><a href =\"UpdateServlet?id=" + book.getId() + "\"" +
                ">edit</a>" + "</td><td><a href=\"DeleteServlet?id=" + book.getId() + "\"" + ">delete </a></td></tr>");

        }

        printWriter.print("</table>");
        printWriter.print("</body>");
    }



}