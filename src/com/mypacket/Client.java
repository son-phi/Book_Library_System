package com.mypacket;

import java.util.Scanner;

public class Client extends User{
    public Client(){
        super();
    }

    @Override
    public void showList(Database database, Scanner sc) {
        System.out.println("\n1. View Books");
        System.out.println("2. Rent Book");
        System.out.println("3. Return Book");
        System.out.println("4. Show My Rents");
        System.out.println("5. Edit My Data");
        System.out.println("6. Exit\n");
    }
}
