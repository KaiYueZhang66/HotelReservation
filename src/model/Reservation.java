package model;

import java.util.Date;

public class Reservation {
    private Customer customer;
    private IRoom room;
    private Date checkInDate;
    private Date checkOutDate;

    public Reservation(Customer customer,IRoom room,Date checkInDate,Date checkOutDate){
        this.customer=customer;
        this.room=room;
        this.checkOutDate=checkOutDate;
        this.checkInDate=checkInDate;

    }

    @Override
    public String toString(){
        return (customer+"\r\n"+room+"\r\n"+"Your check-in date is:"+checkInDate+"check-out date is:"+checkOutDate+"\r\n");
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setRoom(IRoom room) {
        this.room = room;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public IRoom getRoom() {
        return room;
    }

    public Customer getCustomer() {
        return customer;
    }
}
