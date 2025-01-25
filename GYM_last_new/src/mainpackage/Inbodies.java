package mainpackage;
import java.time.LocalDate;

public class Inbodies
{
    private  LocalDate Date_of_InBody;
    private float height;
    private float weight;
    private  float body_fat;
    private float minerals;
    private float body_water;


    private float protein;

    public Inbodies( float height, float weight, float body_fat, float minerals, float body_water, float protein,LocalDate date_of_InBody) {
        this.Date_of_InBody = date_of_InBody;
        this.height = height;
        this.weight = weight;
        this.body_fat = body_fat;
        this.minerals = minerals;
        this.body_water = body_water;
        this.protein = protein;
    }

    public Inbodies( float height, float weight, float body_fat, float minerals, float body_water, float protein) {
        this.Date_of_InBody = LocalDate.now();
        this.height = height;
        this.weight = weight;
        this.body_fat = body_fat;
        this.minerals = minerals;
        this.body_water = body_water;
        this.protein = protein;
    }

    public LocalDate getDate_of_InBody() {
        return Date_of_InBody;
    }

    public float getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }

    public float getBody_fat() {
        return body_fat;
    }

    public float getMinerals() {
        return minerals;
    }

    public float getBody_water() {
        return body_water;
    }

    public float getProtein() {
        return protein;
    }

    public void DisplayInbodyInformation()
    {
        System.out.println("Inbody Information Date: "+Date_of_InBody+"\n");

        System.out.println("Height: "+height);

        System.out.println("Weight: "+weight);

        System.out.println("Body fat: "+body_fat);

        System.out.println("Minerals: "+minerals);

        System.out.println("Body Water: "+body_water);

        System.out.println("Protein: "+protein);


    }



}
