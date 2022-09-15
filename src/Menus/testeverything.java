package Menus;

import model.IRoom;
import model.Room;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class testeverything {
    public static void main(String[] args){
        Set<IRoom> test= new HashSet<> ();
        Set<IRoom> to=new HashSet<>();
        Room a= new Room();
        a.setRoomPrice(100);

        test.add(a);
        for(IRoom room:test){
            room.setConflictReserve(true);
        }
        String b="abc";
        System.out.println(b instanceof String);
    }
}
