package mainpackage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Subscription
{
   private String CustomerID;
   private String AssignedCoachID;
    public Membership_plan Plan ;

    public Subscription(String customerID, String assignedCoachID, Membership_plan plan) // for files
    {
        CustomerID = customerID;
        AssignedCoachID = assignedCoachID;
        Plan = plan;
    }
    public Subscription(String CustomerID,String CoachID,int NumberOfMonthsRegistered,int MonthlyPlan){
        this.CustomerID=CustomerID;
        this.AssignedCoachID=CoachID;
         Plan = new Membership_plan(NumberOfMonthsRegistered,MonthlyPlan);


    }


       /* public Subscription createsubscription()
    {
        Subscription newsub= new Subscription(CustomerID,AssignedCoachID,Plan);
        return newsub;
    }
    */

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public void setAssignedCoachID(String assignedCoachID) {
        AssignedCoachID = assignedCoachID;
    }

    public void showsubscription(){
        System.out.println("Assigned Coach Id : "+AssignedCoachID);
        Plan.displaymembershipplan();
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public String getAssignedCoachID() {
        return AssignedCoachID;
    }
}