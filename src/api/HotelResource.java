package api;

import model.Customer;
import model.IRoom;
import service.CustomerService;
import service.ReservationService;
import model.*;
import java.util.Date;
import java.util.Set;

public class HotelResource {
    public static HotelResource hotelResource=null;

    public static HotelResource getInstance(){
        if(hotelResource==null){
            hotelResource=new HotelResource();
        }
        return(hotelResource);
    }

    public Customer getCustomer(String Email){
        return CustomerService.getInstance().getCustomer(Email);
    }

    public void createACustomer(String Email,String FirstName,String LastName){
        CustomerService.getInstance().addCustomer(Email,FirstName,LastName);
    }

    public IRoom getRoom(String roomNumber){
        return(ReservationService.getInstance().getARoom(roomNumber));
    }

    public Reservation bookARoom(String customerEamil,IRoom room,Date checkInDate,Date checkOutDate){
        return(ReservationService.getInstance().reserveARoom(CustomerService.getInstance().getCustomer(customerEamil),room,checkInDate,checkOutDate));
    }

    public Set<Reservation> getCustomersRservations(String customerEmail){
        return(ReservationService.getInstance().getCustomersReservation(CustomerService.getInstance().getCustomer(customerEmail)));
    }

    public Set<IRoom> findARoom(Date checkInDate,Date checkOutDate){
        return ReservationService.getInstance().findRooms(checkInDate,checkOutDate);
    }


}
