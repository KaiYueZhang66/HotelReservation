package model;

import java.util.Collections;

public interface IRoom {
    enum RoomTypeEnumeration{
        Single,
        Double
    }
    public String getRoomNumber();
    public Double getRoomPrice();
    public RoomTypeEnumeration getRoomTypeEnumeration();
    public boolean isFree();

    public void setConflictReserve(boolean a);

    public boolean getConflictReserve();

}
