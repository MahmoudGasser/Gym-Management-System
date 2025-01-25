
package mainpackage.Project;

import mainpackage.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class main_project {
    GYM gym = new GYM();
    Admin admin = new Admin();

    Register register = new Register();



    static Scanner in = new Scanner(System.in);

    public void save()
    {
        try
        {
            admin.SaveAllData(gym.customers,gym.pendingcustomers,gym.coaches,gym.pendingcoaches,gym.equipments);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void Loading() throws IOException
    {


        BufferedReader reader1 = new BufferedReader(new FileReader("files/customers.txt"));
        BufferedReader reader2 = new BufferedReader(new FileReader("files/customer_pending.txt"));
        BufferedReader reader3 = new BufferedReader(new FileReader("files/coaches.txt"));
        BufferedReader reader4 = new BufferedReader(new FileReader("files/coaches_pending.txt"));
        BufferedReader reader5 = new BufferedReader( new FileReader("files/subscription.txt"));
        BufferedReader reader6 = new BufferedReader( new FileReader("files/inbodies.txt"));
BufferedReader reader7 = new BufferedReader(new FileReader("files/equipments.txt"));

        String line ;



        while ( (line= reader7.readLine()) !=null )
        {

            String []details = line.split("->");
            String name = details[0];
            String code = details[1];
            int Quantity = Integer.parseInt(details[2]);
            String TargetMuscle= details[3];

gym.equipments.add(new Equipments(name,code, TargetMuscle, Quantity));
        }




        while ( (line= reader1.readLine()) !=null )
        {

            String []details = line.split("->");
            String name = details[0];
            String ID = details[1];
            String gender = details[2];
            String address= details[3];
            String phone = details[4];
            String email=details[5];
            boolean status = Boolean.parseBoolean(details[6]);
            gym.customers.add(new Customers(name, phone,email, gender,address, ID , status));

        }

        while ((line = reader2.readLine()) != null)
        {

            String[] details = line.split("->");
            String name = details[0];
            String ID = details[1];
            String gender = details[2];
            String address = details[3];
            String phone = details[4];
            String email = details[5];
            boolean status = Boolean.parseBoolean(details[6]);
           gym.pendingcustomers.add(new Customers(name, phone, email, gender, address, ID, status));


        }



        while ( (line= reader3.readLine()) !=null )
        {
int i =8;
            String []details = line.split("->");
            int Working_hours = Integer.parseInt(details[0]);
            String name=details[1];
            String ID = details[2];
            String gender = details[3];
            String address = details[4];
            String phone = details[5];
            String email = details[6];
            int CustomersNumber=Integer.parseInt(details[7]);
            Coaches coach=new Coaches(name, phone, email, gender, address,Working_hours,ID,CustomersNumber);
            gym.coaches.add(coach);
int counter=0;
while (i<details.length)
{
    String CID=details[i++];
    for ( int j =0 ; j<gym.customers.size(); j++)
    {
        if (gym.customers.get(j).getID().equals(CID))
        {
            coach.customers[counter] = gym.customers.get(j);
            counter++;
            break;
        }
    }

}


        }




        while ((line = reader4.readLine()) != null) {
            String[] details = line.split("->");
            int Working_hours = Integer.parseInt(details[0]);
            String name=details[1];
            String ID = details[2];
            String gender = details[3];
            String address = details[4];
            String phone = details[5];
            String email = details[6];
            int CustomersNumber=Integer.parseInt(details[7]);
            gym.pendingcoaches.add(new Coaches(name, phone, email, gender, address,Working_hours,ID,CustomersNumber));


        }



        while ( (line=reader5.readLine())!=null)
        {
            int i =1;
            String []details=line.split("->");
            String id = details[0];

            for (int j =0 ; j<gym.customers.size(); j++)
            {
                if (gym.customers.get(j).getID().equals(id))
                {
                    while (i < details.length)
                    {
                        String CoID = details[i++];
                        boolean checkMonthlyPlan = Boolean.parseBoolean(details[i++]);
                        int MonthlyPlan = Integer.parseInt(details[i++]);
                        boolean Discount = Boolean.parseBoolean(details[i++]);
                        int PriceOfMembership = Integer.parseInt(details[i++]);
                        String StartDate = details[i++];
                        String EndDate = details[i++];

                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        LocalDate startDate = LocalDate.parse(StartDate, formatter);
                        LocalDate endDate = LocalDate.parse(EndDate, formatter);
                        int NumberOfMonthsRegistered= Integer.parseInt(details[i++]);
                        i++;
                        Membership_plan plan = new Membership_plan(startDate,endDate,NumberOfMonthsRegistered,PriceOfMembership,Discount,checkMonthlyPlan,MonthlyPlan);
                        gym.customers.get(j).subscriptions.add( new Subscription(id,CoID , plan));
                    }
                }
            }

        }



        while ( (line=reader6.readLine())!=null)
        {
            int i =1;
            String []details=line.split("->");
            String id = details[0];

            for (int j =0 ; j<gym.customers.size(); j++)
            {
                if (gym.customers.get(j).getID().equals(id))
                {
                    while (i < details.length)
                    {
                        float height = Float.parseFloat(details[i++]);
                        float weight = Float.parseFloat(details[i++]);
                        float BodyFat = Float.parseFloat(details[i++]);
                        float minerals = Float.parseFloat(details[i++]);
                        float body_water = Float.parseFloat(details[i++]);
                        float protein = Float.parseFloat(details[i++]);
                        String Date = details[i++];
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        LocalDate localDate = LocalDate.parse(Date, formatter);
                        i++;
                        gym.customers.get(j).inbody_list.add(new Inbodies(height,weight,BodyFat,minerals,body_water,protein,localDate));
                    }
                }
            }






        }










    }




    public void main_menu() {

        int c1=0;


        do {


            int c2=0;
            char b;
            System.out.println("\n\nWelcome to our GYM \n" + "------------------\n");
            System.out.println("[1] Gym information\n[2] registeration  ");

            boolean error_c1=false;
            do {
                error_c1=false;
                try {
                    c1 = in.nextInt();
                }catch (Exception e)
                {
                    System.out.println("Invalid Choice Enter Correct Choice :(");


                    error_c1=true;
                    in.nextLine();


                }

            }while (error_c1);





            switch (c1) {
                case 1: {
                    gym.gym_info();
                    System.out.println("\nPress B to go Back");

                    do {
                        b = in.next().charAt(0);

                        if (b != 'b' && b != 'B')
                            System.out.println("invalid choice");
                        else
                            main_menu();


                    } while (b != 'b' && b != 'B');
                    break;


                }

                case 2: {

                    do {
                        System.out.println("[1] Sign Up\n[2] Login");
                        boolean error_c2=false;
                        do {
                            error_c2=false;
                            try {
                                c2 = in.nextInt();

                            }catch (Exception e)
                            {
                                System.out.println("Invalid Choice Enter Correct Choice :(");

                                error_c2=true;
                                in.nextLine();

                            }
                        }while (error_c2);
                    }while (c2 !=1 && c2!=2);


                    register_menu(c2);


                    break;
                }
                default:
                    System.out.println("invalid choice");
                    break;
            }


        } while (c1 != 1 && c1 != 2);


    }


    public void register_menu(int c) {
        boolean found = false;
        int c3=0;

        switch (c)
        {
            case 1:
            {



                do {
                    System.out.println("[1] Customer\n[2]Coach\n");
                    boolean error_c3=false;
                    do {
                        error_c3=false;
                        try {
                            c3 = in.nextInt();

                        }catch (Exception e)
                        {
                            System.out.println("Invalid Choice Enter Correct Choice :(");

                            error_c3=true;
                            in.nextLine();

                        }
                    }while (error_c3);
                }while (c3 !=1 && c3!=2);




                if (c3 == 1)
                {
                    register.AddCustomer(gym.pendingcustomers);
                   save();
                    main_menu();

                }
                if (c3 == 2)
                {
                    register.AddCoach(gym.pendingcoaches);
                    save();
                    main_menu();
                }
                break;
            }
            case 2:
            {
                int c4=0;
                do {
                    String username_email, password_phone;
                    int current_customer_coach = 0;

                    System.out.println("[1]Admin\n[2] Customer\n[3]Coach\n");

                    boolean error_c4 = false;

                    do {
                        error_c4 = false;
                        try {
                            c4 = in.nextInt();
                        } catch (Exception e) {
                            System.out.println("Invalid Choice Enter Correct Choice :(");



                            error_c4 = true;
                            in.nextLine();


                        }

                    } while (error_c4);


                    if (c4 == 1) {
                        System.out.println("Enter username");
                        username_email = in.next();
                        System.out.println("Enter the Password");
                        password_phone = in.next();
                        if (username_email.equalsIgnoreCase(admin.getID()) && password_phone.equalsIgnoreCase(admin.getPassword())) {
                            Admin();
                        } else {
                            System.out.println("Account not Found");
                            main_menu();
                        }


                    } else if (c4 == 2) {
                        System.out.println("Enter your Email");
                        username_email = in.next();
                        System.out.println("Enter your Phone Number");
                        password_phone = in.next();
                        for (int i = 0; i < gym.customers.size(); i++) {
                            if (gym.customers.get(i).getEmail().equals(username_email) && gym.customers.get(i).getPhoneNumber().equals(password_phone)) {
                                found = true;
                                current_customer_coach = i;
                                break;

                            }


                        }
                        if (found)
                            Customers(current_customer_coach);
                        else {
                            System.out.println("Account not Found");
                            main_menu();
                        }

                    } else if (c4 == 3) {
                        System.out.println("Enter your Email");
                        username_email = in.next();
                        System.out.println("Enter your Phone Number");
                        password_phone = in.next();
                        for (int i = 0; i < gym.coaches.size(); i++) {
                            if (gym.coaches.get(i).getEmail().equals(username_email) && gym.coaches.get(i).getPhoneNumber().equals(password_phone)) {
                                found = true;
                                current_customer_coach = i;
                                break;

                            }

                        }
                        if (found)
                            Coach(current_customer_coach);
                        else {
                            System.out.println("Account not Found");
                            main_menu();
                        }

                    } else {
                        System.out.println("invalid choice :(");
                    }
                }while (c4!=1 && c4!=2 && c4!=3);
            }

            break;


            default:
                System.out.println("Invalid choice");
                break;
        }




    }







    public void Admin()
    {
        int c5=0;

        System.out.println("Welcome Admin\n-----------");
        System.out.println("[1]Gym Equipments\n[2]Gym Customers\n[3]Gym Coaches\n[4]Total Income in A Given Month\n[10]To Logout");

        boolean error_c5 = false;

        do {
            error_c5 = false;
            try {
                c5 = in.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid Choice Enter Correct Choice :(");


                error_c5 = true;
                in.nextLine();


            }

        } while (error_c5);



        switch (c5)
        {
            case 1:
            {
                Admin_equipments();

                break;
            }
            case 2:
            {
                Admin_Customers();
                break;
            }

            case 3:
            {

                Admin_Coach();
                break;
            }

            case 4:
            {
                int total;
                String Month;
                System.out.println("Enter The Month You Want");
                Month=in.next();
                total=admin.DisplayGymIncomeInA_Month(gym.customers,Month);
                System.out.println("Total Income Is "+total);
                GoBackForAdmin();

            }

            case 10:
                System.out.println("Logout Done");
                main_menu();
                break;

            default:
                System.out.println("invalid choice");
                Admin();
        }

    }

    private void Admin_equipments()
    {
        int c6=0;
        boolean check=false;
        do {
            check=false;

            System.out.println("[1] Add Equipment\n[2] Edit Equipment\n[3] Delete Equipment\n[4]To Go Back");

            boolean error_c6 = false;

            do {
                error_c6 = false;
                try {
                    c6 = in.nextInt();
                } catch (Exception e) {
                    System.out.println("Invalid Choice Enter Correct Choice :(");


                    error_c6 = true;
                    in.nextLine();


                }

            } while (error_c6);

            if (c6 == 1) {
                admin.AddEquipments(gym.equipments);
                System.out.println("Successfully Added");
                save();
                Admin();
            } else if (c6 == 2)
            {

                if (gym.equipments.size() != 0)
                {
                    in.nextLine(); // to take the \n
                    String name;
                    admin.DisplayAllEquipments(gym.equipments);
                    System.out.println("Enter The Name of The Equipment ");
                    name = in.nextLine();

                    admin.EditEquipments(gym.equipments, name);
                    save();
                    Admin();
                } else
                {
                    char choice;
                    System.out.println("No Equipments Found -- Add a Machine ? (y/n)");
                    choice = in.next().charAt(0);
                    while (true) {
                        if (choice != 'y' && choice != 'n')
                        {
                            System.out.println("Invalid choice Enter your choice Again");
                            choice = in.next().charAt(0);
                        } else {
                            if (choice == 'y' || choice == 'Y') {
                                admin.AddEquipments(gym.equipments);
                                save();
                                System.out.println("Succesfully Added-- Backing To Main Menu\n");
                                Admin();
                            } else
                                Admin();


                        }
                    }

                }
            } else if (c6 == 3)
            {
                if (gym.equipments.size() != 0)
                {
                    admin.DeleteEquipments(gym.equipments);
                    save();
                    Admin();
                }
                {
                    char choice;
                    System.out.println("No Equipments Found -- Add a Machine ? (y/n)");
                    choice = in.next().charAt(0);
                    while (true) {
                        if (choice != 'y' && choice != 'n') {
                            System.out.println("Invalid choice Enter your choice Again");
                            choice = in.next().charAt(0);
                        } else {
                            if (choice == 'y' || choice == 'Y') {
                                admin.AddEquipments(gym.equipments);
                                System.out.println("Succesfully Added-- Backing To Main Menu\n");
                                Admin();
                            } else
                                Admin();


                        }
                    }

                }


            }
            else if (c6==4)
            {
                Admin();
            }
            else
            {
                System.out.println("invalid choice :(");
                check=true;
            }


        }while (check);





    }

    private void Admin_Customers()
    {
        int c7=0, index=0;
        System.out.println("[1]Approve Customers\n[2]Edit information\n[3]Delete Customers\n[4]Show Customers Subscriptions\n[5]Customers by specific coach\n[6]All Custmomers Subscribed in A Date\n[7]To Go Back");
        boolean check=false;
        do {


            boolean error_c7 = false;
            do {
                error_c7 = false;


                try {
                    c7 = in.nextInt();
                } catch (Exception e) {
                    System.out.println("invalid choice :(");


                    error_c7 = true;
                    in.nextLine();


                }

            } while (error_c7);


            if (c7 == 1) {
                if (gym.pendingcustomers.size() != 0)
                {
                    for (int i = 0; i < gym.pendingcustomers.size(); i++)
                        System.out.println((i + 1) + "-Name: " + gym.pendingcustomers.get(i).getName());


                    System.out.println("\nEnter your choice");
                    boolean error_index=false;
                    do {
                        error_index=false;
                        try {
                            index = in.nextInt();
                            while (true)
                            {
                                if (index >= 1 && index <= gym.pendingcustomers.size()) {
                                    admin.ApproveCustomer(gym.pendingcustomers, gym.customers, (index - 1));
                                    System.out.println("Customer Approved");
                                    save();
                                    Admin();
                                } else {
                                    System.out.println("invalid choice Enter correct choice");
                                    index = in.nextInt();
                                }
                            }
                        }catch (Exception e)
                        {
                            System.out.println("Invalid Choice Enter Correct Choice :(");


                            error_index=true;
                            in.nextLine();


                        }

                    }while (error_index);

                } else {
                    System.out.println("No Customers in Waiting -- Going Back To Main Menu");
                    Admin();
                }

            } else if (c7 == 2)  // choice 2 Edit info for customers
            {
                if (gym.customers.size()==0)
                {
                    System.out.println("The Gym Do not have any Customers ");
                    Admin();

                }
                admin.ShowAllCusomers(gym.customers);
                admin.EditCustomers(gym.customers);
                save();
                Admin();
            } else if (c7 == 3) // Delete Customers
            {
                if (gym.customers.size()==0)
                {
                    System.out.println("The Gym Do not have any Customers ");
                    Admin();

                }
                else {
                    admin.ShowAllCusomers(gym.customers);
                    System.out.println("\nEnter The Customer");


                    boolean error_index = false;
                    do {
                        error_index = false;
                        try {
                            index = in.nextInt();

                            while (true)
                            {
                                if (index < 1 || index > gym.customers.size())
                                {
                                    System.out.println("invalid choice Enter correct choice");
                                    index = in.nextInt();
                                } else
                                    break;
                            }

                        } catch (Exception e) {
                            System.out.println("Invalid Choice Enter Correct Choice :(");


                            error_index = true;
                            in.nextLine();


                        }

                    } while (error_index);

                    admin.DeleteCustomers(gym.customers, index - 1);
                    save();
                    Admin();

                }
            } else if (c7 == 4)
            {
                char b;
                if (gym.customers.isEmpty())
                {
                    System.out.println("No customers Available");
                    Admin();
                }
                admin.ShowAllCusomers(gym.customers);
                System.out.println("Enter Your Choice");
                boolean error_index=false;
                do {
                    error_index=false;
                    try {
                        index = in.nextInt();

                        while (true) {
                            if (index < 1 || index > gym.customers.size()) {
                                System.out.println("invalid choice Enter correct choice");
                                index = in.nextInt();
                            } else
                                break;
                        }

                    }catch (Exception e)
                    {
                        System.out.println("Invalid Choice Enter Correct Choice :(");


                        error_index=true;
                        in.nextLine();


                    }

                }while (error_index);
                admin.ShowSubscriptionHistory(gym.customers.get(index - 1));
                save();

                GoBackForAdmin();
            } else if (c7 == 5)
            {
                if ( gym.coaches.isEmpty())
                {
                    System.out.println("No Coaches Available");
                    Admin();
                }
                System.out.println("Available Coaches\n--------------");
                admin.ShowAllCoaches(gym.coaches);
                System.out.println("\nEnter Your Choice");
                boolean error_index=false;
                do {
                    error_index=false;
                    try {
                        index = in.nextInt();

                    }catch (Exception e)
                    {
                        System.out.println("Invalid Choice Enter Correct Choice :(");


                        error_index=true;
                        in.nextLine();


                    }

                }while (error_index);
                while (true)
                {
                    if (index >= 1 && index <= gym.coaches.size()) {
                        admin.ShowCustomersOfaCoach(gym.coaches.get(index - 1));
                        GoBackForAdmin();
                    } else {
                        System.out.println("invalid choice Enter correct choice");
                        boolean error_index2=false;
                        do {
                            error_index2=false;
                            try {
                                index = in.nextInt();

                            }catch (Exception e)
                            {
                                System.out.println("Invalid Choice Enter Correct Choice :(");


                                error_index2=true;
                                in.nextLine();


                            }

                        }while (error_index2);
                    }
                }


            } else if (c7 == 6)
            {
                if (gym.customers.isEmpty())
                {
                    System.out.println("No customers Available");
                    Admin();
                }

                String Date;
                System.out.println("Enter the Date (Year-Month-Day)");
                Date= in.next();
                admin.DisplayAllCustomersSubscribedInDate(gym.customers, Date);
                Admin();
            }
            else if (c7 == 7)
            {
                Admin();
            }
            else
            {
                System.out.println("invalid choice :(");
                check=true;
            }
        }while (check);
    }

    private void  Admin_Coach() {
        int c7=0;

        do {


            int index=0;

            System.out.println("[1]Approve Coaches\n[2]Edit information\n[3]Delete Coaches\n[4]Most Assign Coaches\n[5]To Go Back");

            boolean error_c7=false;
            do {
                error_c7=false;
                try {
                    c7 = in.nextInt();

                }catch (Exception e)
                {
                    System.out.println("Invalid Choice Enter Correct Choice :(");


                    error_c7=true;
                    in.nextLine();


                }

            }while (error_c7);


            if (c7 == 1) {
                if (gym.pendingcoaches.size() != 0)
                {
                    admin.ShowAllCoaches(gym.pendingcoaches);


                    System.out.println("\nEnter your choice");

                    boolean error_index1=false;
                    do {
                        error_index1=false;
                        try {
                            index = in.nextInt();
                            while (true)
                            {
                                if (index >= 1 && index <= gym.pendingcoaches.size()) {
                                    admin.ApproveCoach(gym.pendingcoaches, gym.coaches, (index - 1));
                                    System.out.println("Coach Approved");
                                    save();
                                    Admin();
                                } else
                                {
                                    System.out.println("invalid choice Enter correct choice");
                                    index = in.nextInt();
                                }
                            }
                        }catch (Exception e)
                        {
                            System.out.println("Invalid Choice Enter Correct Choice :(");


                            error_index1=true;
                            in.nextLine();


                        }

                    }while (error_index1);


                } else
                {
                    System.out.println("No Coaches in Waiting -- Going Back To Main Menu");
                    Admin();
                }

            } else if (c7 == 2)
            {
                if (gym.coaches.isEmpty())
                {
                    System.out.println("No Coaches To Edit");
                    Admin();
                }
                admin.ShowAllCoaches(gym.coaches);

                boolean error_index=false;
                do {
                    error_index=false;
                    try
                    {

                        while (true)
                        {

                                admin.EditCoaches(gym.coaches);
                            save();
                                Admin();
                        }
                    }catch (Exception e)
                    {
                        System.out.println("Invalid Choice Enter Correct Choice :(");


                        error_index=true;
                        in.nextLine();


                    }

                }while (error_index);



            } else if (c7 == 3)
            {
                if (gym.coaches.isEmpty())
                {
                    System.out.println("No Coaches To delete");
                    Admin();
                }
                admin.ShowAllCoaches(gym.coaches);
                System.out.println("\nEnter The Coach");

                boolean error_index=false;
                do
                {
                    error_index=false;
                    try {
                        index = in.nextInt();
                        while (true)
                        {
                            if (index >= 1 && index <= gym.coaches.size())
                            {

                                admin.DeleteCoach_ReAssignForCustomer(gym.coaches,gym.customers, index-1);
                                save();
                                Admin();

                            } else
                            {
                                System.out.println("invalid choice Enter correct choice");
                                index = in.nextInt();
                            }
                        }
                    }catch (Exception e)
                    {
                        System.out.println("Invalid Choice Enter Correct Choice :(");


                        error_index=true;
                        in.nextLine();


                    }

                }while (error_index);





            } else if (c7 == 4)
            {
                if (gym.coaches.isEmpty())
                {
                    System.out.println("No Coaches To Display");
                    Admin();
                }
                admin.DisplayCoachesInSorting(gym.coaches);
                save();
                GoBackForAdmin();
            }
            else if (c7==5)
            {
                Admin();
            }
            else
            {
                System.out.println("Invalid Choice Enter Correct Choice");

                boolean error_index=false;
                do {
                    error_index=false;
                    try
                    {
                        index = in.nextInt();

                    }catch (Exception e)
                    {
                        System.out.println("Invalid Choice Enter Correct Choice :(");


                        error_index=true;
                        in.nextLine();


                    }

                }while (error_index);


            }
        } while (c7!= 1 && c7!=2 && c7!=3 && c7!=4);
    }


    public void Customers(int current)
    {
        int c5=0;
        System.out.println("Welcome "+gym.customers.get(current).getName() +" ID: "+ gym.customers.get(current).getID() +"\n---------------" );


        System.out.println("1-Display All Equipments\n2-Display Coach Info\n3-Subscribe\n4-Show Current Plan\n5-Inbodies\n6-Show Inbody in Specific date\n press 10 to log out");
        do {


            boolean error_c5 = false;
            do {
                error_c5 = false;
                try {
                    c5 = in.nextInt();

                } catch (Exception e) {
                    System.out.println("Invalid Choice Enter Correct Choice :(");


                    error_c5 = true;
                    in.nextLine();


                }

            } while (error_c5);


            switch (c5) {

                case 1: {

                    if (!gym.equipments.isEmpty()) {
                        admin.DisplayAllEquipments(gym.equipments);
                        GoBackForCustomer(current);
                    }
                    else{

                        System.out.println("There is No Equipment");
                        Customers(current);
                    }

                    break;
                }

                case 2: {
                    if (gym.customers.get(current).statuschecker(gym.customers.get(current).subscriptions)) {
                        gym.customers.get(current).DisplayCoachInfo(gym.coaches);
                        GoBackForCustomer(current);
                    } else {
                        System.out.println("You Must Subscribe in Gym");
                        Customers(current);
                    }

                    break;


                }
                case 3:
                {
                    boolean available=false;
                    if (!gym.coaches.isEmpty())
                    {
                        for (int i = 0; i < gym.coaches.size(); i++)
                        {

                            if (gym.coaches.get(i).getNumberOfCustomers() != 10) {
                                available = true;
                                break;
                            }
                        }
                        if (!available)
                        {
                            System.out.println("No Coaches Available You Can't Subscribe");
                            Admin();
                        }

                    }
                    else
                    {
                        System.out.println("No Coaches Available");
                        Admin();
                    }


                    if (gym.customers.get(current).statuschecker(gym.customers.get(current).subscriptions) == false)
                    {
                        gym.customers.get(current).AddSubscription(gym.coaches, admin);

                        gym.customers.get(current).subscriptions.get(gym.customers.get(current).subscriptions.size() - 1).showsubscription();
                        save();
                        GoBackForCustomer(current);
                    } else {

                        System.out.println("Customer Already Subscribed");

                        Customers(current);
                    }


                    break;
                }

                case 4: {
                    if (gym.customers.get(current).statuschecker(gym.customers.get(current).subscriptions))
                    {
                        gym.customers.get(current).subscriptions.get(gym.customers.get(current).subscriptions.size() - 1).showsubscription();
                        GoBackForCustomer(current);
                    } else {
                        System.out.println("You Must Subscribe in Gym\n");
                        Customers(current);
                    }

                    break;
                }

                case 5: {
                    System.out.println("1-Do inbody\n2-Display Last Inbody\n3-To Go Back");
                    int c8=0;
                    do {


                        boolean error_c8 = false;
                        do {
                            error_c8 = false;
                            try {
                                c8 = in.nextInt();

                            } catch (Exception e) {
                                System.out.println("Invalid Choice Enter Correct Choice :(");


                                error_c8 = true;
                                in.nextLine();


                            }

                        } while (error_c8);


                        if (c8 == 1) {
                            if (gym.customers.get(current).statuschecker(gym.customers.get(current).subscriptions))
                            {
                                gym.customers.get(current).inputInbody();
                                save();
                                GoBackForCustomer(current);
                            } else {
                                System.out.println("You Must Subscribe in Gym\n");
                                Customers(current);
                            }
                        } else if (c8 == 2)
                        {
                            int size = gym.customers.get(current).inbody_list.size();
                            if (gym.customers.get(current).inbody_list.size() == 0) {
                                System.out.println("You Must Do Inbody");
                                Customers(current);
                            } else {

                                if (gym.customers.get(current).inbody_list.get(size - 1) != null) {
                                    gym.customers.get(current).inbody_list.get(size - 1).DisplayInbodyInformation();
                                    gym.customers.get(current).DisplayKilos();
                                    GoBackForCustomer(current);

                                }
                            }
                        } else if (c8 == 3) {
                            Customers(current);
                        }
                        else
                            System.out.println("Invalid Choice Enter Correct Choice :(");
                    }while (c8!=1&&c8!=2&&c8!=3);
                    break;
                }

                case 6: {
                    gym.customers.get(current).Display_InbodyInfo_with_SpecficDate();
                    GoBackForCustomer(current);
                    break;
                }

                case 10:
                    System.out.println("Logout Done");
                    main_menu();

            }

            if (c5!=1&&c5!=2&&c5!=3&&c5!=4&&c5!=5&&c5!=6&&c5!=10)
            {
                System.out.println("Invalid Choice Enter Correct Choice :(");

            };
        }while (c5!=1&&c5!=2&&c5!=3&&c5!=4&&c5!=5&&c5!=6&&c5!=10);

    }

    public void Coach(int current)
    {
        int c5=0;
        System.out.println("Welcome "+gym.coaches.get(current).getName() +"ID: "+ gym.coaches.get(current).getID() +"\n----------------" );
        System.out.println("1-Display All of Your Customers\n2-Search For Customer\n3-Display Customers By Gender\n4-Display Inbody History of A Customer\nPress 10 to log out");
       boolean check=false;
        do {


            boolean error_c5 = false;
            check=false;
            do {
                error_c5 = false;
                try
                {
                    c5 = in.nextInt();
                } catch (Exception e)
                {
                    System.out.println("Invalid Choice Enter Correct Choice :(");
                    error_c5 = true;
                    in.nextLine();
                }

            } while (error_c5);

            switch (c5) {

                case 1:
                {
                    if (gym.coaches.get(current).getNumberOfCustomers()!=0)
                    {
                        gym.coaches.get(current).DisplayAllCustomers();
                        GoBackForCoach(current);
                        break;
                    }
                    else
                    {
                        System.out.println("You Have No Customers Subscribed");
                        Coach(current);
                    }
                }

                case 2:
                {
                    if (gym.coaches.get(current).getNumberOfCustomers()!=0)
                    {
                        String name;
                        System.out.println("Enter The Name of The Customer");
                        name = in.next();
                        gym.coaches.get(current).Display_ByName(name);
                        GoBackForCoach(current);
                        break;
                    }
                    else
                    {
                        System.out.println("You Have No Customers Subscribed");
                        Coach(current);
                    }
                }

                case 3:
                {
                    if (gym.coaches.get(current).getNumberOfCustomers()!=0)
                    {
                        gym.coaches.get(current).Display_ByGender(gym.coaches.get(current));
                        GoBackForCoach(current);
                    }

                    else
                    {
                        System.out.println("You Have No Customers Subscribed");
                        Coach(current);
                    }
                    break;
                }

                case 4:
                {
                    if (gym.coaches.get(current).getNumberOfCustomers()!=0) {
                        gym.coaches.get(current).Display_inbody_History();
                        GoBackForCoach(current);
                    }
                    else
                    {
                        System.out.println("You Have No Customers Subscribed");
                        Coach(current);
                    }
                    break;
                }

                case 10: {
                    System.out.println("Logout Done");
                    main_menu();
                }
                default:
                {
                    System.out.println("Invalid Choice Enter Correct Choice :(");
                    check=true;
                }

            }
        }while (check);

    }


    void GoBackForAdmin()
    {
        char b;
        System.out.println("\nPress B to go Back");

        do {
            b = in.next().charAt(0);

            if (b != 'b' && b != 'B')
                System.out.println("invalid choice");
            else
                Admin();


        } while (b != 'b' && b != 'B');
    }

    void GoBackForCoach(int Current)
    {
        char b;
        System.out.println("\nPress B to go Back");

        do {
            b = in.next().charAt(0);

            if (b != 'b' && b != 'B')
                System.out.println("invalid choice");
            else
                Coach(Current);


        } while (b != 'b' && b != 'B');
    }

    void GoBackForCustomer(int Current)
    {
        char b;
        System.out.println("\nPress B to go Back");

        do {
            b = in.next().charAt(0);

            if (b != 'b' && b != 'B')
                System.out.println("invalid choice");
            else
                Customers(Current);


        } while (b != 'b' && b != 'B');
    }

}
