package com.allanimt.servlet.booksManagment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DBConnect {

    public static Connection getConnection() {

        Connection connection = null;
        //String url = "jdbc:mysql://localhost/servlet";
        String driver = "com.mysql.jdbc.Driver";

        try {
            String url = "jdbc:mysql://localhost/servlet?serverTimezone=UTC";
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, "root", "root");
        } catch (ClassNotFoundException | SQLException exception) {
            exception.printStackTrace();
            System.out.println(exception);
        }

        System.out.println("--------------------------------------------" + connection);
        return connection;
    }

    public static int insert(Book book) {

        String insertQuery = "INSERT INTO `booksinfo`(`booksname`, `authorsname`, `topic`, `state`) VALUES (?,?,?,?)";
        Connection connection = DBConnect.getConnection();
        int executed = 0;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            preparedStatement.setString(1, book.getBooksName());
            preparedStatement.setString(2, book.getAuthorName());
            preparedStatement.setString(3, book.getTopic());
            preparedStatement.setString(4, book.getState());

            executed = preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println(sqlException);
        }
        return executed;
    }

    public static int update(Book book) {

        String insertQuery = "UPDATE `booksinfo` SET `booksname`=?,`authorsname`=?,`topic`=?,`state`=? WHERE ?";



        Connection connection = DBConnect.getConnection();
        int executed = 0;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            preparedStatement.setString(1, book.getBooksName());
            preparedStatement.setString(2, book.getAuthorName());
            preparedStatement.setString(3, book.getTopic());
            preparedStatement.setString(4, book.getState());
            preparedStatement.setInt(5, book.getId());

            executed = preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println(sqlException);
        }
        System.out.println(insertQuery);
        return executed;
    }

    public static int delete(int id) {

        String insertQuery = "DELETE FROM `booksinfo` WHERE id=?";
        Connection connection = DBConnect.getConnection();
        int executed = 0;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            preparedStatement.setInt(1, id);

            executed = preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println(sqlException);
        }
        return executed;
    }

    public static Book getBookById(int id) {

        Book book = new Book();

        String insertQuery = "SELECT * FROM `booksinfo` WHERE id=?";
        Connection connection = DBConnect.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                book.setId(resultSet.getInt(1));

                book.setBooksName(resultSet.getString(2));
                book.setAuthorName(resultSet.getString(3));
                book.setTopic(resultSet.getString(4));
                book.setState(resultSet.getString(5));
            }

            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println(sqlException);
        }
        return book;
    }

    public static List < Book > getAllBooks() {

        List < Book > listOfBooks = new ArrayList < Book > ();

        try {
            String insertQuery = "SELECT * FROM `booksinfo`";
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt(1));
                book.setBooksName(resultSet.getString(2));
                book.setAuthorName(resultSet.getString(3));
                book.setTopic(resultSet.getString(4));
                book.setState(resultSet.getString(5));
                listOfBooks.add(book);
            }

            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println(sqlException);
        }
        return listOfBooks;
    }


}