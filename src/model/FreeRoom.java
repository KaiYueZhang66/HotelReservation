package model;

public class FreeRoom extends Room{

    FreeRoom(){
        this.setRoomPrice(0);
    }

    @Override
    public String toString(){
        return ("Roomnumber is"+this.getRoomNumber()+ "\r\n"+"RoomPrice is"+this.getRoomPrice()+"\r\n"+"For"+this.getRoomTypeEnumeration());
    }
}
