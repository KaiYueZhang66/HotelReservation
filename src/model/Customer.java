package model;


import java.util.regex.Pattern;

public class Customer {
    private String FirstName;
    private String LastName;
    private String Email;

    @Override
    public String toString(){
        return ("Costumer's Name is "+LastName+" "+FirstName+",email is "+Email+"\r\n");
    }

    String emailRegex = "^(.+)@(.+).(.+)$";
    Pattern pattern = Pattern.compile(emailRegex);

    public Customer(String FirstName,String LastName,String Email){
        if(!pattern.matcher(Email).matches()){
            throw new IllegalArgumentException("please enter in correct email format");
        }
        this.Email=Email;
        this.FirstName=FirstName;
        this.LastName=LastName;
    }

    public void setFirstName(String FirstName){
        this.FirstName=FirstName;
    }

    public String getFirstName(){
        return FirstName;
    }

    public void setLastName(String LastName){
        this.LastName=LastName;
    }

    public String getLastName(){
        return LastName;
    }

    public void setEmail(String Email){
        this.Email=Email;
    }

    public String getEmail(){
        return Email;
    }
}
