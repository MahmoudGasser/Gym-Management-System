package mainpackage;

import java.util.ArrayList;
import java.util.Random;

public abstract class Person
{
protected String Name;
protected String PhoneNumber;
public String Email;
protected String ID;
protected String Gender;
protected String Address;

    public Person(String Name,String PhoneNumber,String Email,String Gender,String Address, String ID ) // for files
    {
        this.Name = Name;
        this.PhoneNumber = PhoneNumber;
        this.Email = Email;
        this.ID = ID;
        this.Gender = Gender;
        this.Address = Address;
    }

public Person(String Name,String PhoneNumber,String Email,String Gender,String Address){
    this.Name=Name;
    this.PhoneNumber=PhoneNumber;
    this.Email=Email;
    this.Gender=Gender;
    this.Address=Address;
    ID=idassigner(Gender,Name);
}
    protected String idassigner(String Gender,String Name)
    {
        Random random= new Random();
        int x=random.nextInt(998)+1;
        return String.valueOf(Gender.charAt(0)+Name.charAt(0)+x);
        // it will be static for x ID
    }

 abstract protected void DisplayInfo();

    public String getName() {
        return Name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public String getID()
    {
        return ID;
    }

    public String getGender() {
        return Gender;
    }

    public String getAddress() {
        return Address;
    }


    public void setName(String name) {
        Name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
