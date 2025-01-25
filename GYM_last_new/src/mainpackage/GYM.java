package mainpackage;

import java.util.ArrayList;

public class GYM
{

  public GYM()
    {
  

    }


    private String name = "Hammer Gym";
    private String address = "6 october";
    private String phone_num = "01203286718";
    public ArrayList<Coaches> coaches = new ArrayList<Coaches>();
    public ArrayList<Equipments> equipments = new ArrayList<Equipments>();
    public ArrayList<Customers> pendingcustomers = new ArrayList<Customers>();
    public ArrayList<Customers> customers = new ArrayList<>();

    public ArrayList<Coaches> pendingcoaches = new ArrayList<>();


    public void gym_info() {
        System.out.println("Gym Name: " + this.name);
        System.out.println("Gym Address: " + this.address);
        System.out.println("Gym Phone: " + this.phone_num);


    }
}
