package com.controller;

import com.mypacket.Database;
import com.mypacket.Operation;
import com.mypacket.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AddNewAdmin implements Operation {
    @Override
    public void operation(Database database, Scanner sc, User user){
        System.out.println("Enter First Name: ");
        String firstName = sc.next();
        System.out.println("Enter Last Name: ");
        String lastName = sc.next();
        System.out.println("Enter Email: ");
        String email = sc.next();
        System.out.println("Enter Phone Number: ");
        String phoneNumber = sc.next();
        System.out.println("Enter Address: ");
        String address = sc.next();
        System.out.println("Enter Password: ");
        String password = sc.next();
        System.out.println("Confirm Password: ");
        String confirmPassword = sc.next();
        while (!password.equals(confirmPassword)){
            System.out.println("Password doesn't match. Try again.");
            System.out.println("Enter Password: ");
            password = sc.next();
            System.out.println("Confirm Password: ");
            confirmPassword = sc.next();
        }
        int accType = 1;

        try {
            ResultSet rs = database.getStatement().executeQuery("SELECT COUNT(*);");
            rs.next();
            int id = rs.getInt("COUNT(*)") + 1;
            database.getStatement().executeUpdate("INSERT INTO `user` (`ID`, `FirstName`, `LastName`, `Email`, `PhoneNumber`, `Address`, `Password`, `Type`) VALUES ('" + id + "', '" + firstName + "', '" + lastName + "', '" + email + "', '" + phoneNumber + "', '" + address + "', '" + password + "', '" + accType + "');");
            System.out.println("New Admin Added Successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
