package mainpackage;

import java.util.Scanner;

public class Coaches extends Person implements Comparable
{
    Scanner scanner = new Scanner(System.in);
private int WorkingHours;
public Customers[]customers=new Customers[10];
private int NumberOfCustomers;
private boolean fullstatus;

    public Coaches(String Name, String PhoneNumber, String Email, String Gender, String Address,int WorkingHours, String id, int numberOfCustomers)
    {
        super(Name, PhoneNumber, Email, Gender, Address, id);
        this.WorkingHours=WorkingHours;
        this.NumberOfCustomers= numberOfCustomers;

    }
    public Coaches(String Name, String PhoneNumber, String Email, String Gender, String Address,int WorkingHours)
    {
        super(Name, PhoneNumber, Email, Gender, Address);
        this.WorkingHours=WorkingHours;
        ID=ID+"C";
    }

public void DisplayAllCustomers()
{

    for(int i=0;i<NumberOfCustomers;i++)
    {
        System.out.println((i+1)+"-");
        System.out.println("Customer Name :  "+customers[i].Name);
        System.out.println("Customer ID :  "+customers[i].ID);

    }

}


    private void Display_RepeatedCustomer(Customers[] customer , int Array_index )
    {
        int index=0;
        Scanner in = new Scanner(System.in);
        boolean check=false;
        System.out.println("Enter the ID");
        String id = in.next();

        for (int i =0 ; i<=Array_index ; i++)
        {
            if (customer[i].getID().equals(id))
            {
                check = true;
                index=i;
                break;
            }

        }

        if (check)
        customer[index].DisplayInfo();
        else
            System.out.println("Invald ID");

    }

    public void Display_inbody_History(  )
    {
        this.DisplayAllCustomers();

        Scanner in = new Scanner(System.in);
        System.out.println("which Customer you want to see his inbody history");
        System.out.println("Select the ID");
        String id="";
        boolean error_id= false;
        do {
            error_id = false;
            try {
                id = in.next();


            } catch (Exception e) {
                System.out.println("Invalid Choice Enter Correct Choice :(");


                error_id = true;
                in.nextLine();


            }

        } while (error_id);

        boolean found=false;
        boolean inbody_check= true;
        for (int i =0 ; i<NumberOfCustomers ; i++)
        {
            if (this.customers[i].getID().equals(id))
            {
                found=true;
                if( !this.customers[i].inbody_list.isEmpty())
                {
                    for (int j = 0; j < this.customers[i].inbody_list.size(); j++)
                    {
                        this.customers[i].inbody_list.get(j).DisplayInbodyInformation();
                    }
                }
                else
                {
                    inbody_check=false;
                    break;
                }
            }

        }
        if (!found)
            System.out.println("invalid ID");

        else if ( !inbody_check)
        {
            System.out.println("This customer has no inbody test");
        }
    }


    public  void Display_ByName(String name  )
    {
        Customers[]Common_name = new Customers[NumberOfCustomers];
        int counter=0;
        boolean Found=false;
        boolean repeated = false;
        for ( int i =0 ; i<NumberOfCustomers ; i++)
        {
            if (this.customers[i].getName().equals(name))
            {
                Found=true;
                Common_name[counter]=this.customers[i];
                for (int j=i+1 ; j<NumberOfCustomers ; j++)
                {
                    if (this.customers[j].getName().equals(name))
                    {
                        repeated=true;
                        counter++;
                        Common_name[counter]=this.customers[j];

                    }
                }


            }




        }

        if (Found==true && repeated==false)
        {
            Common_name[0].DisplayInfo();
        }

        else if (Found==true && repeated==true)
        {
            System.out.println("The common names");
            System.out.println("------------------\n");
            for (int i=0 ; i<=counter ; i++)
            {
                System.out.println("#"+Common_name[i].getID() +" "+Common_name[i].getName());
            }
            this.Display_RepeatedCustomer(Common_name, counter);

        }

        else
        {
            System.out.println("Customer not found");

        }
    }
    public void Display_ByGender(Coaches coach)
    {

        for( int i =0 ; i<NumberOfCustomers ; i++)
        {
            if (coach.customers[i].getGender().equalsIgnoreCase("male"))
            {
                System.out.println("Male Customers");
                System.out.println("#"+coach.customers[i].getID() + " "+ coach.customers[i].getName());

            }
        }
        System.out.println("---------------");
        for( int i =0 ; i<NumberOfCustomers ; i++)
        {
            if ( coach.customers[i].getGender().equalsIgnoreCase("female"))
            {
                System.out.println("Female Customers");
                System.out.println("#"+coach.customers[i].getID() + " "+ coach.customers[i].getName());

            }
        }

    }

public void DisplayInfo()
{

    System.out.println("Coach Name:"+Name);
    System.out.println("Coach E-mail:"+Email);
    System.out.println("Coach ID:"+ID);
    System.out.println("Coach Phone Number:"+PhoneNumber);

}


public int compareTo(Object coach)
{
    Coaches otherCoach = (Coaches) coach;
    if (this.NumberOfCustomers<otherCoach.NumberOfCustomers)
        return 1;
    else     if (this.NumberOfCustomers>otherCoach.NumberOfCustomers)
        return -1;
    else
        return 0;

}

    public int getNumberOfCustomers() {
        return NumberOfCustomers;
    }

    public void setNumberOfCustomers(int numberOfCustomers) {
        NumberOfCustomers = numberOfCustomers;
    }

    public int getWorkingHours() {
        return WorkingHours;
    }
}




