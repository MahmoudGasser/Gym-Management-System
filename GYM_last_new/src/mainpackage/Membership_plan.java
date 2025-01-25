package mainpackage;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Membership_plan
{
  private   LocalDate StartDate;
   private LocalDate EndDate;
    private int NumberOfMonthsRegistered;
   private int PriceOfMembership;
   private boolean Discount=false;
   private boolean checkMonthlyPlan=false;
    private int MonthlyPlan;


    public Membership_plan(LocalDate startDate, LocalDate endDate, int numberOfMonthsRegistered, int priceOfMembership, boolean discount, boolean checkMonthlyPlan, int monthlyPlan) // for files
    {
        StartDate = startDate;
        EndDate = endDate;
        NumberOfMonthsRegistered = numberOfMonthsRegistered;
        PriceOfMembership = priceOfMembership;
        Discount = discount;
        this.checkMonthlyPlan = checkMonthlyPlan;
        MonthlyPlan = monthlyPlan;
    }

    public Membership_plan(int NumberOfMonthsRegistered,int MonthlyPlan)
    {
        this.NumberOfMonthsRegistered=NumberOfMonthsRegistered;
        this.MonthlyPlan=MonthlyPlan;
        StartDate= LocalDate.now();
        EndDate=StartDate.plusMonths(NumberOfMonthsRegistered);
        if(NumberOfMonthsRegistered>=3){
            Discount=true;
        }
        else
        {
            Discount=false;
        }
        if(MonthlyPlan==6){
            checkMonthlyPlan=true;
        }
        else
        {
            checkMonthlyPlan=false;
        }

    }

    private void CalcDiscount() {
        if(NumberOfMonthsRegistered==12)
        {
            System.out.println("You Have A Special Discount 30% :)");
            PriceOfMembership-=(PriceOfMembership*0.3);

        }
        else {
            if (Discount) {
                System.out.println("You Have A 20% Discount");
                PriceOfMembership -= (PriceOfMembership * 0.2);
            } else {
                System.out.println("You Have No Discounts");
            }
        }
    }

    /* To take date from user
            String userInput = scanner.nextLine();//take date in string
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("y-M-d");//format date
            LocalDate enteredDate = LocalDate.parse(userInput, dateFormatter);

    */
    //to save old dates
    public void setStartDate(LocalDate startDate) {
        StartDate = startDate;
        EndDate=StartDate.plusMonths(NumberOfMonthsRegistered);

    }

    public boolean validitychecker()
    {
        if(LocalDate.now().isAfter(EndDate))
        {
            return false; // no sub
        }
        else
            return true; // sub
    }
    private void calcpriceofmembership()
    {
        if (checkMonthlyPlan)
        {
            PriceOfMembership=NumberOfMonthsRegistered*700;
        } else
        {
            PriceOfMembership=NumberOfMonthsRegistered*400;

        }
    }
    public void displaymembershipplan(){
        System.out.println("\nMembership Start Date : "+StartDate);
        System.out.println("======================================");
        System.out.println("Membership End Date : "+EndDate);
        System.out.println("======================================");

        System.out.println("Number Of Months Registered : "+NumberOfMonthsRegistered);
        System.out.println("======================================");

        calcpriceofmembership();
        CalcDiscount();
        System.out.println("Membership Price : "+PriceOfMembership);
        System.out.println("======================================");

        if(checkMonthlyPlan) {
            System.out.println("You Are On The Diamond Membership");
            System.out.println("======================================");


        }
        else
        {
            System.out.println(" On The Gold Membership");
            System.out.println("======================================");

        }
    }

    public LocalDate getStartDate() {
        return StartDate;
    }

    public LocalDate getEndDate() {
        return EndDate;
    }

    public int getNumberOfMonthsRegistered() {
        return NumberOfMonthsRegistered;
    }

    public int getPriceOfMembership() {
        return PriceOfMembership;
    }

    public boolean isDiscount() {
        return Discount;
    }

    public boolean isCheckMonthlyPlan() {
        return checkMonthlyPlan;
    }

    public int getMonthlyPlan() {
        return MonthlyPlan;
    }
}