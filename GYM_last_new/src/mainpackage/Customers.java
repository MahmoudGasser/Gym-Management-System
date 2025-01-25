package mainpackage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.temporal.ChronoUnit;

public class Customers extends Person {

    Scanner in = new Scanner(System.in);
    public ArrayList<Subscription> subscriptions = new ArrayList<Subscription>();
    public ArrayList<Inbodies>inbody_list = new ArrayList<>();
    private boolean Status = statuschecker(subscriptions);

    public Customers(String Name, String PhoneNumber, String Email, String Gender, String Address, String ID, boolean status)
    {
        super(Name, PhoneNumber, Email, Gender, Address, ID);
        this.Status=status;
    }

    public Customers(String Name, String PhoneNumber, String Email, String Gender, String Address)
    {
        super(Name, PhoneNumber, Email, Gender, Address);
        this.Status = false;
    }

    public boolean statuschecker(ArrayList<Subscription> subscriptions)
    {

        if ( subscriptions.size()==0)
            return false;
        else
        {
            int index = subscriptions.size() - 1;
            if (!subscriptions.get(index).Plan.validitychecker()) {
                return false;
            } else
                return true;
        }
    }

    public void AddSubscription(ArrayList<Coaches>coaches,Admin admin )
    {



        Scanner in = new Scanner(System.in);
        int monthly_plan=0, numberofmonths=0;
        System.out.println("Enter your monthly plan (3/6)");
        while (true) {
            boolean error_monthly_plan=false;
            do {
                error_monthly_plan=false;
                try {
                    monthly_plan = in.nextInt();

                }catch (Exception e)
                {
                    System.out.println("Invalid Choice Enter Correct Choice :(");


                    error_monthly_plan=true;
                    in.nextLine();


                }

            }while (error_monthly_plan);

            if (monthly_plan==6||monthly_plan==3)
            {
                break;
            }
            else
            {
                System.out.println("You must Enter (3/6) only : ");
            }
        }
        System.out.println("How many months");
        while (true) {


            boolean error_numberofmonths=false;
            do {
                error_numberofmonths=false;
                try {
                    numberofmonths = in.nextInt();

                }catch (Exception e)
                {
                    System.out.println("Invalid Choice Enter Correct Choice :(");


                    error_numberofmonths=true;
                    in.nextLine();


                }

            }while (error_numberofmonths);

            if (numberofmonths>=1&&numberofmonths<=12)
            {
                break;
            }
            else if(numberofmonths<1)
            {
                System.out.println("You must not Enter number less than 1 :(");
            }
            else
            {
                System.out.println("You must not Enter number greater than 12 :(");

            }
        }
        Subscription subscribe = new Subscription(this.ID, admin.AssignCoachToCustomer(coaches, this),numberofmonths,monthly_plan) ;

        this.subscriptions.add(subscribe);

    }



    public  void DisplayInfo()
    {
        System.out.println("Customer info#");
        System.out.println("Name: "+this.Name);
        System.out.println("ID: " +"#"+ this.ID);
        System.out.println("Address: " +this.Address);
        System.out.println("Phone: "+ this.PhoneNumber);
        System.out.println("Email:" +this.Email);
    }


    public void DisplayCoachInfo(ArrayList<Coaches> coaches)
    {
        String coachId;
        int index=0;
        coachId=this.subscriptions.get(subscriptions.size()-1).getAssignedCoachID();

        for (int i =0 ; i<coaches.size(); i++)
        {
            if (coaches.get(i).getID().equals(coachId))
            {
                index=i;
                break;
            }

        }
        coaches.get(index).DisplayInfo();




    }


    public void Display_Inbody_Dates() {
        short i = 1;

        for (Inbodies Inbody : inbody_list) {
            System.out.println("Inbody Date " + i + ": " + Inbody.getDate_of_InBody() + "\n");
i++;

        }

    }

    public void Display_InbodyInfo_with_SpecficDate()

    {

        Display_Inbody_Dates();

        System.out.println("Enter the Date You Want (Year-Month-Day)");
        String InputDate =  in.next();




        System.out.println("\n\n");

        boolean found =false;

        for (int i =0 ; i< inbody_list.size(); i++)
        {
            String Date = inbody_list.get(i).getDate_of_InBody().toString();
            if (Date.equals(InputDate))
            {

                found=true;

                inbody_list.get(i).DisplayInbodyInformation();

                break;
            }



        }
        if (found==false)
        {
            System.out.println("No Inbody with That Date");
        }
    }





    private float AverageGood_BMI ()
    {

        return (Gender.equalsIgnoreCase("male")) ? 22f : 21.5f;
    }

    private double IdealWeight()
    {

        Inbodies LastInbody =  inbody_list.get(inbody_list.size()-1);

        double Ideal_Weight = AverageGood_BMI()*((LastInbody.getHeight()/100)*(LastInbody.getHeight())/100);

        return Ideal_Weight;

    }

    public void DisplayKilos()
    {
        Inbodies LastInbody =  inbody_list.get(inbody_list.size()-1);

        if (LastInbody.getWeight()>IdealWeight())
        {
            System.out.println("You are Overweight and you Need to Reduce"+ (LastInbody.getWeight()-IdealWeight()));
        }
        else if (LastInbody.getWeight()<IdealWeight())
        {

            System.out.println("You are Underweight and you Need to Increase"+ (IdealWeight()-LastInbody.getWeight()));
        }
        else {
            System.out.println("You are Normal Weighted");
        }
    }

    private float handling_inbody()
    {
       float test =0;

        boolean error = false;
        do {
            error = false;
            try {
                test = in.nextFloat();

            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid Choice Enter Correct Choice :(");


                error = true;
                in.nextLine();


            }

        } while (error);
        return test;
    }


    public  void inputInbody()
    {
        Scanner in= new Scanner(System.in);

        if (InbodydateCheck()>=30 )
        {
            float height;
            System.out.println("Enter Your Height: ");

                  height =in.nextFloat();



            System.out.println("Enter Your Weight: ");
//we should handle it---------------------------------------------------
            float Weight =in.nextFloat();

            System.out.println("Enter Body Fat: ");

           float Body_fat =in.nextFloat();


            System.out.println("Enter Body Minerals: ");

            float BodyMinerals =in.nextFloat();

            System.out.println("Enter Body Water: ");

            float Body_water =in.nextFloat();

            System.out.println("Enter Body Protein:" );

            float BodyProtein =in.nextFloat();

            Inbodies inbody = new Inbodies(height,Weight,Body_fat,BodyMinerals,Body_water,BodyProtein);

            this.inbody_list.add(inbody);
            DisplayKilos();
        }

        else
        {

            System.out.println("You Can't do Inbody Now you Have to Wait  "+(30-InbodydateCheck()) );
        }
    }
    private long InbodydateCheck()
    {
        if (!inbody_list.isEmpty())
        {
            long Daydifference = ChronoUnit.DAYS.between(inbody_list.get(inbody_list.size() - 1).getDate_of_InBody(), LocalDate.now());
            return Daydifference;

        }
        return 31;
    }


    public boolean isStatus() {
        return Status;
    }
}



