package Menus;

import api.AdminResource;
import model.IRoom;
import model.Room;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AdminMenu {
    public static void main(String[] args){
        AdminMenu adminMenu=new AdminMenu();
        adminMenu.getStart();
    }

    public  void getStart(){
        boolean exsit=false;
        do {
            System.out.println("Please input the numbers showed below:"+"\r\n"+"1.See all customers"+"\r\n"+"2.See all rooms"+"\r\n"+"3.See all reservations"+"\r\n"+"4.Add a room"+"\r\n"+"5.Back to main menu"+"\r\n");
            Scanner scanner=new Scanner(System.in);
            int number=scanner.nextInt();
            switch (number) {
                case 1:
                    System.out.println(AdminResource.getInstance().getAllCustomers());
                    break;
                case 2:
                    System.out.println(AdminResource.getInstance().getAllRooms());
                    break;
                case 3:
                    AdminResource.getInstance().displayAllReservations();
                    break;
                case 4:
                    boolean exsit2=false;
                    String y="y";
                    String n="n";
                    Set<IRoom> roomCollectionOfAdd=new HashSet<>();
                    do {
                        System.out.println("Please enter room number:");
                        Scanner roomnumber=new Scanner(System.in);
                        while(!roomnumber.hasNextLine()){
                            System.out.println("Please enter room number in right format:");
                            roomnumber=new Scanner(System.in);
                        }
                        String rn=roomnumber.nextLine();

                        System.out.println("Please enter room price:");
                        Scanner roomprice=new Scanner(System.in);
                        while(!roomprice.hasNextDouble()){
                            System.out.println("Please enter room price in right format:");
                            roomprice=new Scanner(System.in);
                        }
                        double rp=roomprice.nextDouble();

                        System.out.println("please enter room RoomTypeEnumeration Single/Double:");
                        Scanner roomtypeenumeration=new Scanner(System.in);
                        String trans=roomtypeenumeration.nextLine();
                        while(!(trans.equals("Single")||trans.equals("Double"))){
                            System.out.println("Sorry, please enter room RoomTypeEnumeration only either Single/Double:");
                            roomtypeenumeration=new Scanner(System.in);
                            trans=roomtypeenumeration.nextLine();
                        }
                        IRoom.RoomTypeEnumeration RTE= IRoom.RoomTypeEnumeration.valueOf(trans);
                        Room add=new Room();
                        add.setRoomPrice(rp);
                        add.setRoomNumber(rn);
                        add.setRoomTypeEnumeration(RTE);
                        roomCollectionOfAdd.add(add);
                        System.out.println("Do you wanna add another room? y/n");
                        Scanner doyou=new Scanner(System.in);
                        String DY=doyou.nextLine();
                        if(DY.equals(n)){
                            exsit2=true;
                            AdminResource.getInstance().addRoom(roomCollectionOfAdd);
                        }
                    }while (!exsit2);
                    break;
                case 5:
                    MainMenu mainMenu = new MainMenu();
                    mainMenu.getStart();
                default:
                    System.out.println("Please enter only the valid number showed below:");
                    break;
            }
        }while (!exsit);

    }
}
