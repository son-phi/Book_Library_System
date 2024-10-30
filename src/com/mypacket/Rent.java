package com.mypacket;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Rent {
    private int ID;
    private User user;
    private Book book;
    private LocalDateTime dateTime;
    private int hours;
    private double total;
    private String status;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private int rentDate;
    private int returnDate;

    public Rent(){
        dateTime = LocalDateTime.now();
    }

    //getter+setter: ID, User, Book, dateTime, hours, total, status
}
