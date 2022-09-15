package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class AdminResource {
    public static AdminResource adminResource=null;

    public static AdminResource getInstance(){
        if(adminResource==null){
            adminResource=new AdminResource();
        }
        return(adminResource);
    }

    public Customer getCustomer(String Email){
        return (CustomerService.getInstance().getCustomer(Email));
    }

    public void addRoom(Set<IRoom> rooms){
        for(IRoom room:rooms){
            ReservationService.getInstance().addRoom(room);
        }
    }

    public Set getAllRooms(){
        return(ReservationService.getInstance().getRoomCollection());
    }

    public Map getAllCustomers(){
        return (CustomerService.getInstance().getCustomerCollection());
    }

    public void displayAllReservations(){
        ReservationService.getInstance().printAllReservation();
    }
}
