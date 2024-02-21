package Rooms;

import java.io.FileReader;
import java.io.FileWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ManagingRooms {
    private Room[] rooms;

    public ManagingRooms(){
        rooms = new Room[50];
        this.loadRoom();
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void updateRoom(){
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management_system", "root", "Tanvir420");

            Statement statement = connect.createStatement();

            for (int i = 1; i <= 50; i++) {
                PreparedStatement A = connect.prepareStatement("Update HotelLog SET customerName = ?, phoneNumber = ?, periodOfStay = ?, city = ?, nationality = ?, noOfGuest = ?, date = ?, roomType = ?, expence = ? WHERE roomNo= ?");
                A.setString(1, rooms[i - 1].getCustomerName());
                A.setInt(2, Integer.parseInt(rooms[i - 1].getPhoneNumber()));
                A.setInt(3, rooms[i - 1].getPeriodOfStay());
                A.setString(4, rooms[i - 1].getCity());
                A.setString(5, rooms[i - 1].getNationality());
                A.setInt(6, rooms[i - 1].getMemberStaying());
                A.setString(7, String.valueOf(rooms[i - 1].getDate()));
                A.setString(8, rooms[i - 1].getRoomType());
                A.setDouble(9, rooms[i - 1].getExpense());
                A.setInt(10, i);

                A.executeUpdate();
            }

        }catch (Exception EX){
            System.out.println("MY prob");
        }
    }

    public void loadRoom(){
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management_system", "root", "Tanvir420");

            Statement statement = connect.createStatement();

            ResultSet resultSet= statement.executeQuery("SELECT * FROM HotelLog");

            int index = 0;

            while (resultSet.next()){
                Room r = new Room();

                try {
                    r.setDate(new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(resultSet.getString("date")));
                }catch (Exception E){
                    System.out.println("msg");
                }

                r.setRoomNo(resultSet.getInt("roomNo"));
                r.setCustomerName(resultSet.getString("customerName"));
                r.setPhoneNumber(String.valueOf(resultSet.getInt("phoneNumber")));
                r.setPeriodOfStay(resultSet.getInt("periodOfStay"));
                r.setCity(resultSet.getString("city"));
                r.setNationality(resultSet.getString("nationality"));
                r.setMemberStaying(resultSet.getInt("noOfGuest"));

                r.setRoomType(resultSet.getString("roomType"));
                r.setExpense(resultSet.getDouble("expence"));

                rooms[index++] = r;
            }
        }catch (Exception S){
            System.out.println("jdbc");
        }
    }

    public Room searchByNameAndNumber(String name, String number){
        for (int i = 0; i < rooms.length; i++){
            if(rooms[i].getCustomerName().equals(name) && rooms[i].getPhoneNumber().equals(number)) return rooms[i];
        }

        return null;
    }
}
