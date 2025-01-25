package mainpackage;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class Admin
{
    String ID="admin";
    String Password="admin";
    Scanner scanner = new Scanner(System.in);





    public void ApproveCustomer(ArrayList<Customers> pendingcustomers, ArrayList<Customers>customers, /*Coaches coach,*/ int input)
    {
// we display all names and ids of pendingcustomers in main
        //  coach.customers[coach.NumberOfCustomers] = pendingcustomers.get(input);
        // coach.customers[coach.NumberOfCustomers].assigncoach(coach.ID); deleted no assign in approve
        customers.add(pendingcustomers.get(input));
        pendingcustomers.remove(input);

    }

    public void ApproveCoach(ArrayList<Coaches> pendingcoaches, ArrayList<Coaches> coaches, int input)
    {
        coaches.add(pendingcoaches.get(input));
        pendingcoaches.remove(input);
    }

    public void AddEquipments(ArrayList<Equipments> equipments) {
        Scanner scanner = new Scanner(System.in);
        String name;
        String code;
        String Targetedmuscles;
        int quantity=0;
        while (true) {

            System.out.println("Please Enter The Equipment Name");
            name = scanner.nextLine();
            if (!name.equalsIgnoreCase("admin")) {
                break;
            }
            System.out.println("Name Cannot Be admin");
        }
        while (true) {

            System.out.println("Please Enter The Machine Code");
            code = scanner.nextLine();
            if (code.length() < 9) {
                break;
            }
            System.out.println("Code Cannot Exceed 8 Numbers");
        }

        System.out.println("Please Enter The Equipment Quantity");

        boolean error_q = false;

        do {
            error_q = false;


            try {
                quantity = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid Choice Enter Correct Choice :(");


                error_q = true;
                scanner.nextLine();


            }

        } while (error_q);



        scanner.nextLine();

        System.out.println("Please Enter The Machine Targeted Muscles");
        Targetedmuscles = scanner.nextLine();

        equipments.add(  new Equipments(name, code, Targetedmuscles, quantity));

    }
    public void EditEquipments(ArrayList<Equipments> equipments , String name)
    {
        boolean found=false;
        int index=0,choice=0, changedint=0;
        for (int i =0 ; i < equipments.size() ; i++)
        {
            if ( equipments.get(i).getName().equalsIgnoreCase(name))
            {
                found=true;
                index=i;
                break;
            }

        }

        if (found)
        {
            System.out.println("Machine Found -- What Do you want to Edit\n-------------------------------\n");


            do
            {
                String changed;
                System.out.println("1-Name\n2-Code\n3-Targeted Muscle\n4-Quantity");


                boolean error_choice=false;
                do {
                    error_choice=false;
                    try {
                        choice = scanner.nextInt();


                    }catch (Exception e)
                    {

                        System.out.println("Invalid Choice Enter Correct Choice :(");
                        error_choice=true;
                        scanner.nextLine();

                    }
                }while (error_choice);

                scanner.nextLine();
                switch (choice)
                {

                    case 1:
                    {

                        System.out.println("Enter the New Name");
                        changed= scanner.nextLine();
                        equipments.get(index).setName(changed);
                        System.out.println("Succesfully Edited -- Backing to Main Menu");

                        break;
                    }
                    case 2:
                    {
                        System.out.println("Enter the New Code");
                        changed= scanner.nextLine();
                        equipments.get(index).setCode(changed);
                        System.out.println("Succesfully Edited -- Backing to Main Menu");

                        break;
                    }
                    case 3:
                    {
                        System.out.println("Enter the Targeted Muscle");
                        changed= scanner.nextLine();
                        equipments.get(index).setTargetedMuscle(changed);
                        System.out.println("Succesfully Edited -- Backing to Main Menu");

                        break;
                    }
                    case 4:
                    {
                        System.out.println("Enter the New Quantity");
                        boolean error_changedint=false;
                        do {
                            error_changedint=false;
                            try {
                                changedint= scanner.nextInt();

                            }catch (Exception e)
                            {
                                System.out.println("Invalid Choice Enter Correct Choice :(");


                                error_changedint=true;
                                scanner.nextLine();


                            }

                        }while (error_changedint);

                        equipments.get(index).setQuantity(changedint);
                        System.out.println("Succesfully Edited -- Backing to Main Menu");
                        break;
                    }
                    default:
                        System.out.println("Invalid choice -- Enter your choice Again");
                        break;
                }

            }while (choice!=1 && choice!=2 && choice!=3 && choice!=4);
        }
        else
            System.out.println("Machine Not Found");


    }

    public void DeleteEquipments(ArrayList<Equipments> equipments) {
        int index=0;
        for (int i = 0; i < equipments.size(); i++) {
            System.out.println("List ot Equipments\n-----------------\n\nMachine " + (i + 1) + "\n-----------");
            equipments.get(i).DisplayEquipments();


        }
        System.out.println("\nEnter your choice (Machine Number)");

        boolean error_index = false;

        do {
            error_index = false;
            try {
                index = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid Choice Enter Correct Choice :(");



                error_index = true;
                scanner.nextLine();


            }

        } while (error_index);


        while (true)
        {
            if (index >= 1 && index <= equipments.size())
            {
                equipments.remove(index-1);
                System.out.println("Equipment Removed -- Backing TO Main Menu");
                break;
            }
            else
            {
                System.out.println("invalid choice Enter correct choice");

                boolean error_index2 = false;

                do {
                    error_index2 = false;
                    try {
                        index = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println("Invalid Choice Enter Correct Choice :(");



                        error_index2 = true;
                        scanner.nextLine();


                    }

                } while (error_index2);

            }

        }
    }
//you should ------------------------------------------------------------------------------------------------------------
    public void EditCoaches(ArrayList<Coaches> coaches) {

        System.out.println("Enter Coach:");
        int index =0;
        boolean error_inx=false;
        do {
            error_inx=false;
            try {
                index = scanner.nextInt();
                while (index<1 || index>coaches.size())

                {
                    System.out.println("Invaild Choice Enter Again:");

                    index = scanner.nextInt();
                }
            }catch (Exception e)
            {
                System.out.println("Invalid Choice Enter Correct Choice :(");


                error_inx=true;
                scanner.nextLine();


            }

        }while (error_inx);


        EditMenu();

        System.out.println("Enter Your choice: ");

        int choice = 0;
        boolean error_index=false;
        do {
            error_index=false;
            try {
                choice = scanner.nextInt();

            }catch (Exception e)
            {
                System.out.println("Invalid Choice Enter Correct Choice :(");


                error_index=true;
                scanner.nextLine();


            }

        }while (error_index);

        switch (choice)
        {
            case 1:
                scanner.nextLine();
                System.out.println("Enter New Name: ");

                String Name = scanner.nextLine();

                coaches.get(index-1).setName(Name);

                break;

            case 2:

                System.out.println("Please Enter New Phone Number");
                String phoneNumber = scanner.next();
                while (true)
                {
                    if (phoneNumber.length()==11)
                        break;
                    else {
                        System.out.println("Phone Num Must Be 11 Number");
                        phoneNumber = scanner.next();

                    }
                }

                coaches.get(index-1).setPhoneNumber(phoneNumber);

                break;

            case 3:
                String email;
                while (true)
                {
                    System.out.println("Please Enter The Coach email");
                    email = scanner.next();
                    if (email.contains("@"))
                    {
                        break;
                    }
                    System.out.println("Please Enter A Valid Email");
                }

                coaches.get(index-1).setEmail(email);

                break;
            case 4:

                System.out.println("Enter New Address: ");

                String Address = scanner.nextLine();

                coaches.get(index-1).setAddress(Address);

                break;
        }


    }
    public void DeleteCoaches(ArrayList<Coaches> coaches, int index)
    {
        String name= coaches.get(index).getName();
        coaches.remove(index);
        System.out.println("Coach :"+ name+" has been Removed\nBacking to Main Menu" );

    }

    public void EditCustomers(ArrayList<Customers> customers)
    {

        System.out.println("Enter Customer:");
        int index =0;
        boolean error_inx=false;
        do {
            error_inx=false;
            try {
                index = scanner.nextInt();
                while (index<1 || index>customers.size())

                {
                    System.out.println("Invaild Choice Enter Again:");

                    index = scanner.nextInt();
                }
            }catch (Exception e)
            {
                System.out.println("Invalid Choice Enter Correct Choice :(");


                error_inx=true;
                scanner.nextLine();


            }

        }while (error_inx);


        EditMenu();

        System.out.println("Enter Your choice: ");

        int choice = 0;
        boolean error_index=false;
        do {
            error_index=false;
            try {
                choice = scanner.nextInt();

            }catch (Exception e)
            {
                System.out.println("Invalid Choice Enter Correct Choice :(");


                error_index=true;
                scanner.nextLine();


            }

        }while (error_index);

        switch (choice)
        {
            case 1:
                scanner.nextLine();
                System.out.println("Enter New Name: ");

                String Name = scanner.nextLine();

                customers.get(index-1).setName(Name);

                break;

            case 2:

                System.out.println("Please Enter New Phone Number");
                String phoneNumber = scanner.next();
                while (true)
                {
                    if (phoneNumber.length()==11)
                        break;
                    else {
                        System.out.println("Phone Num Must Be 11 Number");
                        phoneNumber = scanner.next();

                    }
                }

                customers.get(index-1).setPhoneNumber(phoneNumber);

                break;

            case 3:
                String email;
                while (true)
                {
                    System.out.println("Please Enter The Customer email");
                    email = scanner.next();
                    if (email.contains("@"))
                    {
                        break;
                    }
                    System.out.println("Please Enter A Valid Email");
                }

                customers.get(index-1).setEmail(email);

                break;
            case 4:

                System.out.println("Enter New Address: ");

                String Address = scanner.nextLine();

                customers.get(index-1).setAddress(Address);

                break;
        }



    }
    public void DeleteCustomers(ArrayList<Customers> customers, int index) {
        String name = customers.get(index).getName();
        customers.remove(index);
        System.out.println("Customer :"+ name +" has been Removed\nBacking to Main Menu" );
    }





    public String AssignCoachToCustomer(ArrayList<Coaches> Coaches, Customers CurrentCustomer)
    {
        int Min = Coaches.get(0).getNumberOfCustomers();
        int index=0;

        for (int i=0;i<Coaches.size();i++)
        {

            if (Coaches.get(i).getNumberOfCustomers()<Min)
            {
                Min = Coaches.get(i).getNumberOfCustomers();

                index = i;

            }

        }
        int num=Coaches.get(index).getNumberOfCustomers()+1;
        Coaches.get(index).setNumberOfCustomers(num);
        Coaches.get(index).customers[Coaches.get(index).getNumberOfCustomers()-1]=CurrentCustomer;

        return Coaches.get(index).ID;

    }
    private void EditMenu()
    {
        System.out.println("1-Name");
        System.out.println("2-Phone Number");
        System.out.println("3-Email");
        System.out.println("4-Address");

    }








    public void ShowAllCusomers(ArrayList<Customers>customers )
    {
        for (int i =0 ; i < customers.size(); i++)
        {
            System.out.println("Customer " +(i+1) +" Name : "+customers.get(i).getName()+"#"+ customers.get(i).getID());
        }
    }
    public void ShowAllCoaches(ArrayList<Coaches>coaches )
    {
        for (int i =0 ; i < coaches.size(); i++)
        {
            System.out.println("Coach " +(i+1) +" Name : "+coaches.get(i).getName()+"#"+ coaches.get(i).getID());
        }
    }
    public void ShowSubscriptionHistory(Customers customer)
    {
        if ( !customer.subscriptions.isEmpty()) {
            System.out.println("-------------------------------------\nCustomer History\n");
            for (int i = 0; i < customer.subscriptions.size(); i++)
                customer.subscriptions.get(i).showsubscription();
            System.out.println("-----------------------------------------------------------------");
        }
        else
            System.out.println("This Customer Has No Subscriptions YET");

    }

    public void ShowCustomersOfaCoach(Coaches coach)
    {
if (coach.getNumberOfCustomers()!=0)
{
    coach.DisplayAllCustomers();
}
else
    System.out.println("This Coach Has No Customers");
    }

    public void DisplayCoachesInSorting(ArrayList<Coaches> coaches)
    {
        Collections.sort(coaches);
        System.out.println("List of Coaches\n------------");
        this.ShowAllCoaches(coaches);


    }

    public int DisplayGymIncomeInA_Month(ArrayList<Customers>customers, String Month)
    {

        int totalprice = 0;

        for ( int i =0 ; i< customers.size() ; i++)
        {
            for (int j =0 ; j< customers.get(i).subscriptions.size() ; j++)
            {
                String m= String.valueOf(customers.get(i).subscriptions.get(j).Plan.getStartDate().getMonth().getValue());
                if (m.equals(Month))
                {
                    totalprice+=customers.get(i).subscriptions.get(j).Plan.getPriceOfMembership();
                }
            }
        }


        return totalprice;
    }


    public void DisplayAllEquipments( ArrayList<Equipments>equipments)
    {
        System.out.println("List ot Equipments\n-----------------");
        for (int i = 0; i < equipments.size(); i++)
        {
            System.out.println("Equipment " + (i+1));
            equipments.get(i).DisplayEquipments();
            System.out.println("-----------------------");


        }


    }


    public void DeleteCoach_ReAssignForCustomer(ArrayList<Coaches> coaches, ArrayList<Customers> Customers, int index)
    {
        String ID = coaches.get(index).ID;

        DeleteCoaches(coaches,  index);

        for (int i=0;i<Customers.size();i++)
        {
            if (!Customers.get(i).subscriptions.isEmpty())
                if (Customers.get(i).subscriptions.get(Customers.get(i).subscriptions.size()-1).getAssignedCoachID().equals(ID))
                {
                    Customers.get(i).subscriptions.get(Customers.get(i).subscriptions.size()-1).setAssignedCoachID(AssignCoachToCustomer(coaches, Customers.get(i))  );
                }

        }

    }

    public void DisplayAllCustomersSubscribedInDate(ArrayList<Customers> Customers, String inputDate)
    {

        boolean found = false;

        for (int i=0;i<Customers.size();i++)

        {

            for  (int j=0;j<Customers.get(i).subscriptions.size();j++)
            {

                if (Customers.get(i).subscriptions.get(j).Plan.getStartDate().toString().equalsIgnoreCase(inputDate))
                {

                    System.out.println("Customer: "+Customers.get(i).getID()+Customers.get(i).getName());

                    found = true;

                }
            }

        }
        if (found==false)
        {
            System.out.println("There is no Customers Subscribed on This Date");
        }

    }



    public String getID() {
        return ID;
    }

    public String getPassword() {
        return Password;
    }










    public static void  SaveAllData(ArrayList<Customers> customers,ArrayList<Customers> pendingcustomers,ArrayList<Coaches> coaches,ArrayList<Coaches> pendingcoaches,ArrayList<Equipments> equipments) throws IOException, IOException {
        FileWriter fw = new FileWriter("files/customers.txt");
        FileWriter fw1 = new FileWriter("files/customer_pending.txt" );
        FileWriter fw2 = new FileWriter("files/subscription.txt");
        FileWriter fw3 = new FileWriter("files/coaches.txt");
        FileWriter fw5 = new FileWriter("files/coaches_pending.txt" );
        FileWriter fw6 = new FileWriter("files/equipments.txt" );
        FileWriter fw7 = new FileWriter("files/inbodies.txt");

        for (int i = 0 ; i < coaches.size() ; i++)
        {

            fw3.write(Integer.toString(coaches.get(i).getWorkingHours()));
            fw3.write("->");
            fw3.write(coaches.get(i).getName());
            fw3.write("->");
            fw3.write(coaches.get(i).getID());
            fw3.write("->");
            fw3.write(coaches.get(i).getGender());
            fw3.write("->");
            fw3.write(coaches.get(i).getAddress());
            fw3.write("->");
            fw3.write(coaches.get(i).getPhoneNumber());
            fw3.write("->");
            fw3.write(coaches.get(i).getEmail());
            fw3.write("->");
            fw3.write(Integer.toString(coaches.get(i).getNumberOfCustomers()));
            fw3.write("->");
            for (int j =0 ; j<coaches.get(i).getNumberOfCustomers() ; j++)
            {
                fw3.write(coaches.get(i).customers[j].getID());
                fw3.write("->");
            }
fw3.write("\n");
        }

        for (int i = 0; i < customers.size(); i++)
        {
            if (i != 0) {
                fw.write("\n");
            }
            fw.write(customers.get(i).getName());
            fw.write("->");
            fw.write((customers.get(i).getID()));
            fw.write("->");
            fw.write(customers.get(i).getGender());
            fw.write("->");
            fw.write(customers.get(i).getAddress());
            fw.write("->");
            fw.write(customers.get(i).getPhoneNumber());
            fw.write("->");
            fw.write(customers.get(i).getEmail());
            fw.write("->");
            fw.write(String.valueOf(customers.get(i).isStatus()));

        }
        for (int i = 0 ; i <pendingcustomers.size() ; i++)
        {
            if (i != 0){
                fw1.write("\n");
            }
            fw1.write(pendingcustomers.get(i).getName());
            fw1.write("->");
            fw1.write(pendingcustomers.get(i).getID());
            fw1.write("->");
            fw1.write(pendingcustomers.get(i).getGender());
            fw1.write("->");
            fw1.write(pendingcustomers.get(i).getAddress());
            fw1.write("->");
            fw1.write(pendingcustomers.get(i).getPhoneNumber());
            fw1.write("->");
            fw1.write(pendingcustomers.get(i).getEmail());
            fw1.write("->");
            fw1.write(String.valueOf(pendingcustomers.get(i).isStatus()));

        }
        for (int i =0 ; i < customers.size() ; i++)
        {
            for ( int j =0 ; j<customers.get(i).subscriptions.size(); j++)
            {
                fw2.write(customers.get(i).subscriptions.get(j).getCustomerID());
                fw2.write("->");
                fw2.write(customers.get(i).subscriptions.get(j).getAssignedCoachID());
                fw2.write("->");
                fw2.write(String.valueOf(customers.get(i).subscriptions.get(j).Plan.isCheckMonthlyPlan()));
                fw2.write("->");
                fw2.write(Integer.toString(customers.get(i).subscriptions.get(j).Plan.getMonthlyPlan()));
                fw2.write("->");
                fw2.write(String.valueOf(customers.get(i).subscriptions.get(j).Plan.isDiscount()));
                fw2.write("->");
                fw2.write( Integer.toString(customers.get(i).subscriptions.get(j).Plan.getPriceOfMembership()));
                fw2.write("->");
                fw2.write(String.valueOf(customers.get(i).subscriptions.get(j).Plan.getStartDate()));
                fw2.write("->");
                fw2.write(String.valueOf(customers.get(i).subscriptions.get(j).Plan.getEndDate()));
                fw2.write("->");
                fw2.write( Integer.toString(customers.get(i).subscriptions.get(j).Plan.getNumberOfMonthsRegistered()));
                fw2.write("->");
            }
            fw2.write("\n");
        }
       /* for (int i=0 ; i<coaches.size() ; i++)
        {
            for (int j =0 ; j<coaches.get(i).getNumberOfCustomers() ; j++)
            {
                fw4.write(coaches.get(i).customers[j].getName());
                fw4.write("->");
                fw4.write(coaches.get(i).customers[j].getGender());
                fw4.write("->");
                fw4.write(coaches.get(i).customers[j].getPhoneNumber());
                fw4.write("->");
                fw4.write(coaches.get(i).customers[j].getEmail());
                fw4.write("->");
                fw4.write(coaches.get(i).customers[j].getID());
                fw4.write("\n");

            }
        }
        */

        for (int i = 0 ; i < pendingcoaches.size() ; i++)
        {
            if (i != 0)
            {
                fw5.write("\n");
            }
            fw5.write(Integer.toString(pendingcoaches.get(i).getWorkingHours()));
            fw5.write("->");
            fw5.write(pendingcoaches.get(i).getName());
            fw5.write("->");
            fw5.write(pendingcoaches.get(i).getID());
            fw5.write("->");
            fw5.write(pendingcoaches.get(i).getGender());
            fw5.write("->");
            fw5.write(pendingcoaches.get(i).getAddress());
            fw5.write("->");
            fw5.write(pendingcoaches.get(i).getPhoneNumber());
            fw5.write("->");
            fw5.write(pendingcoaches.get(i).getEmail());
            fw5.write("->");
            fw5.write(Integer.toString(pendingcoaches.get(i).getNumberOfCustomers()));


        }
        for (int i = 0 ; i < equipments.size() ; i++)
        {
            if (i != 0){
                fw6.write("\n");
            }
            fw6.write(equipments.get(i).getName());
            fw6.write("->");
            fw6.write(equipments.get(i).getCode());
            fw6.write("->");
            fw6.write(Integer.toString(equipments.get(i).getQuantity()));
            fw6.write("->");
            fw6.write(equipments.get(i).getTargetedMuscle());

        }


        for (int i = 0; i < customers.size() ; i++)
        {
            for (int k = 0; k < customers.get(i).inbody_list.size() ; k++)
            {

                fw7.write(customers.get(i).getID());
                fw7.write("->");
                fw7.write(Float.toString(customers.get(i).inbody_list.get(k).getHeight()));
                fw7.write("->");
                fw7.write(Float.toString(customers.get(i).inbody_list.get(k).getWeight()));
                fw7.write("->");
                fw7.write(Float.toString(customers.get(i).inbody_list.get(k).getBody_fat()));
                fw7.write("->");
                fw7.write(Float.toString((customers.get(i).inbody_list.get(k).getMinerals())));
                fw7.write("->");
                fw7.write(Float.toString((customers.get(i).inbody_list.get(k).getBody_water())));
                fw7.write("->");
                fw7.write(Float.toString((customers.get(i).inbody_list.get(k).getProtein())));
                fw7.write("->");
                fw7.write((customers.get(i).inbody_list.get(k).getDate_of_InBody().toString()));
                fw7.write("->");
            }
            fw7.write("\n");

        }
        fw.close();
        fw1.close();
        fw2.close();
        fw3.close();
        //fw4.close();
        fw5.close();
        fw6.close();
        fw7.close();


    }

}







