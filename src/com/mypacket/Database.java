package com.mypacket;

import com.sun.jdi.connect.Connector;

import java.sql.*;

public class Database {
    private String user = "sonphi";
    private String pass = "pqts0710";
    private String url = "jdbc:mysql://localhost/BookLibrarySystem";
    private Statement statement;

    public Database(){
        try{
            Connection connection = DriverManager.getConnection(url,user, pass);
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (Exception e){
            e.printStackTrace();
        }
    };

    public Statement getStatement() {
        return statement;
    };
}
