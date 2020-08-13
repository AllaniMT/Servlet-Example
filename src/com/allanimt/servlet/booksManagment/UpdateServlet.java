package com.allanimt.servlet.booksManagment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UpdateServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter printWriter = response.getWriter();
        printWriter.println("<h1>Update Book Info</h1>");

        String booksIdString = request.getParameter("id");
        int id = Integer.parseInt(booksIdString);

        Book book = DBConnect.getBookById(id);

        printWriter.print("<head>");
        printWriter.print("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\">");
        printWriter.print("</head>");
        printWriter.print("<body>");
        printWriter.print("<form action=\"UpdateServletSendDB\" method=\"post\">");
        printWriter.print("<table>");

        printWriter.print("<tr><td></td><td><input name=\"id\" value=" + book.getId() + " /></td></tr>");
        printWriter.print("<tr><td>Name: </td><td><input type=\"text\" name=\"booksName\" value=" + book.getBooksName() + " /></td></tr>");
        printWriter.print("<tr><td>Author name: </td><td><input  type=\"text\" name=\"authorsName\" value=" + book.getAuthorName() + " /></td></tr>");
        printWriter.print("<tr><td>Topic: </td><td><input type=\"text\" name=\"topic\" value=" + book.getTopic() + " /></td></tr>");
        printWriter.print("<tr><td>State: </td><td><input type=\"text\" name=\"state\" value=" + book.getState() + " /></td></tr>");


        printWriter.print("</td></tr>");
        printWriter.print("<tr><td colspan='2'> <input type=\"submit\" value=\"submit\" /></td></tr>");
        printWriter.print("</table>");
        printWriter.print("</form>");
        printWriter.print("</body>");

    }



}