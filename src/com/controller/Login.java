package com.controller;

import com.mypacket.Admin;
import com.mypacket.Client;
import com.mypacket.Database;
import com.mypacket.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    public Login (Database database, Scanner sc){
        System.out.println("Enter Email: ");
        String email = sc.next();
        System.out.println("Enter Password: ");
        String password = sc.next();

        ArrayList<User> users = new ArrayList<>();

        try {
            String select = "SELECT * FROM `Users`;";
            ResultSet rs = database.getStatement().executeQuery(select);
            while (rs.next()){
                User user;
                int ID = rs.getInt("ID");
                String firtstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String em = rs.getString("Email");
                String ph = rs.getString("PhoneNumber");
                String add = rs.getString("Address");
                String pass = rs.getString("Password");
                int type = rs.getInt("Type");
                switch (type){
                    case 0:
                        user = new Client();
                        break;
                    case 1:
                        user = new Admin();
                        break;
                    default:
                        user = new Client();
                        break;
                }
                user.setID(ID);
                user.setFirstName(firtstName);
                user.setLastName(lastName);
                user.setEmail(em);
                user.setPhoneNumber(ph);
                user.setAddress(add);
                user.setPassword(pass);
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (User user : users){
            if (user.getEmail().equals(email) && user.getPassword().equals(password)){
                System.out.println("Welcome "+user.getFirstName()+ "!");
                user.showList(database,sc);
            }
        }
    }
}
