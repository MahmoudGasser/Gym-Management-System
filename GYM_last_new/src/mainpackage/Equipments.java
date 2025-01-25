package mainpackage;

public class Equipments
{
    private String Name;
    private String Code;
    private int Quantity;
    private String TargetedMuscle;


    public Equipments(String Name,String Code,String TargetedMuscle, int Quantity)
    {
        this.Name=Name;
        this.Code=Code;
        this.TargetedMuscle=TargetedMuscle;
        this.Quantity=Quantity;
    }

public void DisplayEquipments()
{
    System.out.println("Equipment Name:"+Name);
    System.out.println("Equipment Targeted Muscle:"+TargetedMuscle);

}



    public String getName() {
        return Name;
    }

    public String getCode() {
        return Code;
    }

    public String getTargetedMuscle() {
        return TargetedMuscle;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setCode(String code) {
        Code = code;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public void setTargetedMuscle(String targetedMuscle) {
        TargetedMuscle = targetedMuscle;
    }

    public int getQuantity() {
        return Quantity;
    }
}

