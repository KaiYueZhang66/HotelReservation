package Menus;

import api.HotelResource;

import model.IRoom;
import service.ReservationService;

import java.util.Scanner;
import java.util.Date;

import java.text.SimpleDateFormat;


public class MainMenu {
    public static void main(String[] args){
        MainMenu mainMenu=new MainMenu();
        mainMenu.getStart();

    }

    public void getStart(){
        boolean exsit=false;
        do {
            System.out.println("Please input the numbers showed below:"+"\r\n"+"1.Find and reserve a room"+"\r\n"+"2.See your reservations"+"\r\n"+"3.Create an account"+"\r\n"+"4.Admin"+"\r\n"+"5.Exist"+"\r\n");
            Scanner scanner=new Scanner(System.in);
            int number=scanner.nextInt();
            String y="y";
            String n="n";
            switch(number){
                case 1:
                    String ifHaveAccount;
                    String customerEmail;

                    Scanner scannerIfHaveAccount=new Scanner(System.in);
                    System.out.println("Do you already have our account? Please enter y/n");
                    ifHaveAccount=scannerIfHaveAccount.nextLine();
                    while(!(ifHaveAccount.equals(y)||ifHaveAccount.equals(n))){
                        System.out.println("Sorry,please only enter y/n");
                        scannerIfHaveAccount=new Scanner(System.in);
                        ifHaveAccount=scannerIfHaveAccount.nextLine();
                    }
                    if(ifHaveAccount.equals(y)){
                        System.out.println("Please enter your account email");
                        Scanner scanneremail=new Scanner(System.in);

                        while(!scanneremail.hasNext("^(.+)@(.+).(.+)$")){
                            System.out.println("Please enter in right email format:");
                            scanneremail=new Scanner(System.in);
                        }
                        customerEmail=scanneremail.nextLine();
                    }
                    else {
                        System.out.println("Please select 3.create an account first before you reserve a room");
                        break;
                    }

                    String Str;
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date checkInDate=null;
                    Scanner scannercheckindate=new Scanner(System.in);
                    System.out.println("Please enter your check-in date as format yyyy-MM-dd:");
                    while(!scannercheckindate.hasNext("^\\d{4}-\\d{2}-\\d{2}$")){
                        System.out.println("Please enter in right format,");
                        scannercheckindate=new Scanner(System.in);
                        System.out.println("Please enter your check-in date as format yyyy-MM-dd:");

                    }
                    Str = scannercheckindate.next("^\\d{4}-\\d{2}-\\d{2}$") ;
                    try{
                        checkInDate =dateFormat.parse(Str);
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }

                    String Str2;
                    Date checkOutDate=null;
                    Scanner scannercheckoutdate=new Scanner(System.in);
                    System.out.println("Please enter your check-out date as format yyyy-MM-dd:");
                    while(!scannercheckoutdate.hasNext("^\\d{4}-\\d{2}-\\d{2}$")){
                        System.out.println("Please enter in right format,");
                        scannercheckoutdate=new Scanner(System.in);
                        System.out.println("Please enter your check-out date as format yyyy-MM-dd:");

                    }
                    Str2 = scannercheckoutdate.next("^\\d{4}-\\d{2}-\\d{2}$") ;
                    try{
                        checkOutDate =dateFormat.parse(Str2);
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }

                    String Str3;
                    boolean ifInputVaild=false;
                    do {
                        System.out.println("All rooms available are blew, please input your prefer vaild number:");
                        System.out.println(ReservationService.getInstance().findRooms(checkInDate,checkOutDate));
                        Scanner scannerprefernumber=new Scanner(System.in);
                        Str3=scannerprefernumber.nextLine();

                        System.out.println(ReservationService.getInstance().findRooms(checkInDate,checkOutDate));
                        for(IRoom room:ReservationService.getInstance().findRooms(checkInDate,checkOutDate)){
                            if(room.getRoomNumber().equals(Str3)){
                                ifInputVaild=true;

                            }
                        }
                    }while(!ifInputVaild);


                    try{
                        HotelResource.getInstance().bookARoom(customerEmail,HotelResource.getInstance().getRoom(Str3),checkInDate,checkOutDate);
                    }
                    catch(Exception e){
                        System.out.println("Your account doesn't exist,please do reservation again");
                        e.printStackTrace();
                        break;
                    }
                    System.out.println("Your reservation have been completed!"+"\r\n");
                    System.out.println(HotelResource.getInstance().getCustomersRservations(customerEmail));
                    break;

                case 2:
                    String ifHaveAccount2;
                    String customerEmail2;
                    System.out.println("Do you already have our account? Please enter y/n");
                    Scanner scannerIfHaveAccount2=new Scanner(System.in);
                    ifHaveAccount2=scannerIfHaveAccount2.nextLine();
                    while(!(ifHaveAccount2.equals(y)||ifHaveAccount2.equals(n))){
                        System.out.println("Sorry,please only enter y/n");
                        scannerIfHaveAccount2=new Scanner(System.in);
                        ifHaveAccount2=scannerIfHaveAccount2.nextLine();
                    }
                    if(ifHaveAccount2.equals(y)){
                        System.out.println("Please enter your account email");
                        Scanner scanneremail2=new Scanner(System.in);

                        while(!scanneremail2.hasNext("^(.+)@(.+).(.+)$")){
                            System.out.println("Please enter in right email format:");
                            scanneremail2=new Scanner(System.in);
                        }
                        customerEmail2=scanneremail2.nextLine();
                    } else {
                            System.out.println("Please select 3.create an account first before you reserve a room");
                            break;

                    }
                    System.out.println(HotelResource.getInstance().getCustomersRservations(customerEmail2));
                    break;

                case 3:
                    String email;
                    System.out.println("Please enter your firstname:");
                    Scanner scannerFirstName=new Scanner(System.in);
                    /*while(!(scannerFirstName.nextLine() instanceof String)){
                        System.out.println("Please enter your firstname in right format:");
                        scannerFirstName=new Scanner(System.in);
                    }*/
                    String FN=scannerFirstName.nextLine();

                    System.out.println("Please enter your lastname:");
                    Scanner scannerLastName=new Scanner(System.in);
                    /*while(!(scannerLastName.nextLine() instanceof String)){
                        System.out.println("Please enter your lastname in right format:");
                        scannerLastName=new Scanner(System.in);
                    }*/
                    String LN=scannerLastName.nextLine();

                    System.out.println("Please enter your email address:");
                    Scanner scanneremailaddress=new Scanner(System.in);
                    while(!scanneremailaddress.hasNext("^(.+)@(.+).(.+)$")){
                        System.out.println("Please enter in right format:");
                        scanneremailaddress=new Scanner(System.in);
                    }
                    email=scanneremailaddress.nextLine();

                    HotelResource.getInstance().createACustomer(email,FN,LN);
                    System.out.println("Congras!Your account have been created,welcome to our hotel!");
                    break;

                case 4:
                    AdminMenu adminMenu=new AdminMenu();
                    adminMenu.getStart();

                case 5:
                    exsit=true;
                    break;

                default:
                    System.out.println("Please enter only the valid number showed below:");
                    break;
            }

        }
        while (!exsit);
        System.out.println("Looking forward to have you again!");
    }
}
