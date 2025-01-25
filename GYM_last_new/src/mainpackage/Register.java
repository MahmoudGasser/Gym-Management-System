package mainpackage;

import java.util.ArrayList;
import java.util.Scanner;

public class Register
{
Scanner scanner= new Scanner(System.in);

    public void AddCoach(ArrayList<Coaches> pendingcoaches) {
        String name;
        String id;
        String gender;
        String phoneNumber;
        String email;
        while (true) {

            System.out.println("Please Enter The Coach Name");
            name = scanner.nextLine();
            if (!name.equalsIgnoreCase("admin")) {
                break;
            }
            System.out.println("Name Cannot Be admin");
        }
        while (true) {
            System.out.println("Please Enter The Coach Gender");
            gender = scanner.nextLine();
            if (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")) {
                break;
            }
            System.out.println("Please Enter A Valid Gender");
        }
        System.out.println("Please Enter The Coach Address");
        String address = scanner.nextLine();
        System.out.println("Please Enter The Coach Phone Number");
        phoneNumber = scanner.nextLine();
        while (true) {
            if (phoneNumber.length() == 11)
                break;
            else {
                System.out.println("Phone Num Must Be 11 Number");
                phoneNumber = scanner.nextLine();

            }
        }
        while (true) {
            System.out.println("Please Enter The Coach email");
            email = scanner.nextLine();
            if (email.contains("@")) {
                break;
            }
            System.out.println("Please Enter A Valid Email");
        }

        System.out.println("Please Enter The Coach Working Hours");
        int workinghours;
        while (true) {

            workinghours = scanner.nextInt();
            if (workinghours >= 1 && workinghours <= 10) {
                break;
            } else {
                System.out.println("You must Enter The Coach Working Hours From 1 TO 10 only :(");
            }
        }
        scanner.nextLine();
        System.out.println("Sign up Done -> Waiting for Admin Approve");


        pendingcoaches.add(new Coaches(name, phoneNumber, email, address, gender, workinghours));
    }
    public void AddCustomer(ArrayList<Customers>pendingcustomers) {
        Scanner scanner = new Scanner(System.in);
        String name;
        String id;
        String gender;
        String phoneNumber;
        String email;
        while (true) {

            System.out.println("Please Enter The Customer Name");
            name = scanner.nextLine();
            if (!name.equalsIgnoreCase("admin")) {
                break;
            }
            System.out.println("Name Cannot Be admin");
        }
        System.out.println("Please Enter The Customer Gender");

        while (true)
        {
           // System.out.println("Please Enter The Customer Gender");
            gender = scanner.nextLine();
            if (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")) {
                break;
            }
            System.out.println("Please Enter A Valid Gender");
        }
        System.out.println("Please Enter The Customer Address");
        String address = scanner.nextLine();
        System.out.println("Please Enter The Customer Phone Number");
        phoneNumber = scanner.next();
        while (true)
        {
            if (phoneNumber.length()==11)
                break;
            else {
                System.out.println("Phone Num Must Be 11 Number");
                phoneNumber = scanner.next();

            }
        }
        System.out.println("Please Enter The Customer email");

        while (true)
        {
           // System.out.println("Please Enter The Customer email");
            email = scanner.next();
            if (email.contains("@"))
            {
                break;
            }
            System.out.println("Please Enter A Valid Email");
        }
        System.out.println("Sign up Done -> Waiting for Admin Approve");
        pendingcustomers.add(new Customers(name, phoneNumber, email, gender, address));

        // passing the pending customers
    }



}
