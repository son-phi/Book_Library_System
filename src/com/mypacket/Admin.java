package com.mypacket;

import com.controller.AddNewAccount;

import java.util.Scanner;

public class Admin extends User {
    private Operation[] operations=new Operation[]{new AddNewAccount(1)};

    public Admin(){
        super();
    }

    @Override
    public void showList(Database database, Scanner sc) {
        System.out.println("\n1. Add new book");
        System.out.println("2. View book");
        System.out.println("3. Update book");
        System.out.println("4. Delete book");
        System.out.println("5. Add New Admin");
        System.out.println("6. Show rents");
        System.out.println("7. Exit\n");

        int i = sc.nextInt();
        operations[0].operation(database, sc, this);
    }

}
