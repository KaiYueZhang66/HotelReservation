package service;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ReservationService {
    static Set<IRoom> roomCollection=new HashSet<>();
    static Set<Reservation> reservedCollection=new HashSet<>();

    public static ReservationService reservationService=null;

    public static ReservationService getInstance(){
        if(null==reservationService) {
            reservationService = new ReservationService();
        }
        return(reservationService);
    }

    public void addRoom(IRoom Room){
        roomCollection.add(Room);
    }

    public IRoom getARoom(String RoomNumber){
        IRoom Thatitis;
        for(IRoom text:roomCollection){

            if(text.getRoomNumber().equals(RoomNumber)){

                return text;

            }

        }
        return null;


    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate,Date checkOutDate){
        Reservation add=new Reservation(customer,room,checkInDate,checkOutDate);
        reservedCollection.add(add);
        return add;
    }

    public Set<IRoom> findRooms(Date checkInDate,Date checkOutDate){
        /*Set<IRoom> findRooms=new HashSet<>();
        for(Reservation a:reservedCollection){
            if(a.checkInDate.compareTo(checkInDate)==1||(a.checkInDate.compareTo(checkInDate)==0)){
                return;
            }
            if(a.checkInDate.compareTo(checkInDate)==-1){
                if(a.checkOutDate.compareTo(checkOutDate)==-1||a.checkOutDate.compareTo(checkOutDate)==-1){
                    findRooms.add(a.room);
                }
            }
            if(a.checkInDate.compareTo(checkOutDate)==1||(a.checkInDate.compareTo(checkOutDate)==0)){
                findRooms.add(a.room);
            }
        }
        return(findRooms);*/
        Set<IRoom> roomsWithConfilctDate=new HashSet<>();
        Set<IRoom> roomsCanOffer=new HashSet<>();
        //Set<IRoom> roomCollectionsample=new HashSet<>();


        for(Reservation a:reservedCollection){
            if(checkInDate.compareTo(a.getCheckInDate())==1&&checkInDate.compareTo(a.getCheckOutDate())==-1){
                roomsWithConfilctDate.add(a.getRoom());
            }
            if(checkInDate.compareTo(a.getCheckInDate())==0){
                roomsWithConfilctDate.add(a.getRoom());
            }
            if(checkInDate.compareTo(a.getCheckInDate())==-1&&checkOutDate.compareTo(a.getCheckInDate())==1){
                roomsWithConfilctDate.add(a.getRoom());
            }
        }
        for(IRoom a:roomCollection){
            for(IRoom b:roomsWithConfilctDate){
                if(a.getRoomNumber()==b.getRoomNumber()){
                    a.setConflictReserve(true);
                }
            }
            if(a.getConflictReserve()==false){
                a.setConflictReserve(false);
                roomsCanOffer.add(a);
            }
        }
        
        return(roomsCanOffer);
    }

    public Set<Reservation> getCustomersReservation(Customer customer){
        Set<Reservation> reservationsOfOnePerson=new HashSet<>();
        for(Reservation reservation:reservedCollection){

            if(reservation.getCustomer().equals(customer)){
                reservationsOfOnePerson.add(reservation);
            }
        }
        return(reservationsOfOnePerson);
    }

    public void printAllReservation(){
        for(Reservation reservation:reservedCollection){
            System.out.println(reservation);
        }
    }

    public Set getRoomCollection(){
        return roomCollection;
    }

    public Set getReservationCollection(){
        return  reservedCollection;
    }
}
