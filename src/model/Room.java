package model;

import java.util.Enumeration;

public class Room implements IRoom{
    private String RoomNumber;
    private double RoomPrice;
    private IRoom.RoomTypeEnumeration RoomTypeEnumeration;

    private boolean conflictReserve=false;//used to know if checkin/checkout date are conflict

    /*public Room(String RoomNumber,double RoomPrice,RoomTypeEnumeration RoomTypeEnumeration){
        this.RoomNumber=RoomNumber;
        this.RoomPrice=RoomPrice;
        this.RoomTypeEnumeration=RoomTypeEnumeration;

    }why if i have this constructor and my FreeRoom class's constructor will display error："there is no default constructor in upclass"?*/

    public boolean isFree(){
        if(this.RoomPrice==0){
            return true;
        }else return false;

    }
    @Override
    public String toString(){
        return ("Roomnumber: "+RoomNumber+ "-"+RoomTypeEnumeration+"bed"+"\r\n"+"RoomPrice: "+RoomPrice+"\r\n");
    }

    public String getRoomNumber(){
        return(RoomNumber);
    }
    public Double getRoomPrice(){
        return (RoomPrice);
    }
    public RoomTypeEnumeration getRoomTypeEnumeration(){
        return (RoomTypeEnumeration);
    }
    public boolean getConflictReserve(){
        return (conflictReserve);
    }
    public void setRoomNumber(String RoomNumber){
        this.RoomNumber=RoomNumber;
    }

    public void setRoomPrice(double RoomPrice){
        this.RoomPrice=RoomPrice;
    }

    public void setRoomTypeEnumeration(RoomTypeEnumeration RoomTypeEnumeration){
        this.RoomTypeEnumeration= RoomTypeEnumeration;
    }
    public void setConflictReserve(boolean a){
        this.conflictReserve=a;
    }

    public void setconflictReserve(boolean a){
        this.conflictReserve=a;
    }

    public boolean getconflictReserve(){
        return conflictReserve;
    }



}
