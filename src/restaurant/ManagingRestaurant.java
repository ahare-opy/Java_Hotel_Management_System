package restaurant;

import Rooms.ManagingRooms;
import Rooms.Room;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import java.sql.*;

public class ManagingRestaurant extends Restaurant{
    ArrayList<Restaurant>ra=new ArrayList<>();
    ArrayList<Restaurant>ra1=new ArrayList<>();
    ArrayList<Restaurant>ra2=new ArrayList<>();
    ArrayList<Restaurant>ra3=new ArrayList<>();
    ArrayList<Restaurant>ra4=new ArrayList<>();

    public  void LoadResFile() {
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management_system", "root", "Tanvir420");

            Statement stt1 = connect.createStatement();
            ResultSet ip= stt1.executeQuery("SELECT * FROM RestaurantLog");
            while (ip.next()){
                Restaurant r1=new Restaurant();
                int id = ip.getInt("roomNo");
                int id1 =ip.getInt("foodCode");
                int id2 =ip.getInt("quantity");
                double id3= ip.getDouble("totalprice");

                r1.setRoom(String.valueOf(id));r1.setCode(String.valueOf(id1));r1.setQuantity(String.valueOf(id2));r1.setPrice(String.valueOf(id3));

                ra.add(r1);

            }
            ip.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public  void LoadBreFile() {
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management_system", "root", "Tanvir420");
            Statement stt1 = connect.createStatement();
            ResultSet ip= stt1.executeQuery("SELECT * FROM Breakfast");

            while (ip.next()){
                Restaurant r1 = new Restaurant();

                int id = ip.getInt("foodCode");
                double id1 =ip.getDouble("price");
                String id2 =ip.getString("foodName");
                r1.setCode(String.valueOf(id));r1.setBDT("BDT");r1.setPrice(String.valueOf(id1));r1.setName(id2);
                ra1.add(r1);
            }
            ip.close();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public  void LoadLunFile() {
        try {

            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management_system", "root", "Tanvir420");
            Statement stt1 = connect.createStatement();
            ResultSet ip= stt1.executeQuery("SELECT * FROM Lunch");
            while (ip.next()){
                Restaurant r1 = new Restaurant();
                int id = ip.getInt("foodCode");
                double id1 =ip.getDouble("price");
                String id2 =ip.getString("foodName");

                r1.setCode(String.valueOf(id));r1.setBDT("BDT");r1.setPrice(String.valueOf(id1));r1.setName(id2);

                ra2.add(r1);
            }
            ip.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public  void LoadDinFile() {
        try {


            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management_system", "root", "Tanvir420");
            Statement stt1 = connect.createStatement();
            ResultSet ip= stt1.executeQuery("SELECT * FROM Dinner");
            while (ip.next()){
                Restaurant r1 = new Restaurant();
                int id = ip.getInt("foodCode");
                double id1 =ip.getDouble("price");
                String id2 =ip.getString("foodName");
                r1.setCode(String.valueOf(id));r1.setBDT("BDT");r1.setPrice(String.valueOf(id1));r1.setName(id2);

                ra3.add(r1);
            }
            ip.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public  void LoadBeverageFile() {
        try {

            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management_system", "root", "Tanvir420");
            Statement stt1 = connect.createStatement();
            ResultSet ip= stt1.executeQuery("SELECT * FROM Beverage");
            while (ip.next()){
                Restaurant r1 = new Restaurant();
                int id = ip.getInt("foodCode");
                double id1 =ip.getDouble("price");
                String id2 =ip.getString("foodName");
                r1.setCode(String.valueOf(id));r1.setBDT("BDT");r1.setPrice(String.valueOf(id1));r1.setName(id2);

                ra4.add(r1);
            }
            ip.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void Display(int i){
        if(i==0){
            for (Restaurant r: ra){
                System.out.println(r.writeFile2());
            }
        }
        else if(i==1){
            for (Restaurant r: ra1){
                System.out.println(r.writeFile());
            }
        }
        else if(i==2){
            for (Restaurant r: ra2){
                System.out.println(r.writeFile());
            }
        }
        else if(i==3){
            for (Restaurant r: ra3){
                System.out.println(r.getCode()+"     "+r.getBDT()+"    "+r.getPrice()+"     "+r.getName());
            }
        }
        else {
            for (Restaurant r: ra4){
                System.out.println(r.writeFile());
            }
        }
    }

    public void UPdate(int n){
        if(n==0){
            try{

                Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management_system", "root", "Tanvir420");
                Statement stt1 = connect.createStatement();
                ResultSet ip= stt1.executeQuery("SELECT * FROM RestaurantLog");
                //BufferedWriter w=new BufferedWriter(new FileWriter("files/Restaurant Log.txt"));
                while (ip.next()){
                    Restaurant r1 =new Restaurant();
                    int id = ip.getInt("roomNo");
                    int id1 =ip.getInt("foodCode");
                    int id2 =ip.getInt("quantity");
                    double id3= ip.getDouble("totalprice");
                    //  r1.setRoom(String.valueOf(id));r1.setCode(String.valueOf(id1));r1.setQuantity(String.valueOf(id2));r1.setPrice(String.valueOf(id3));
                    PreparedStatement P= connect.prepareStatement("Update HotelLog SET foodCode=?,quantity=?,totalprice=? WHERE roomNo= ?");
                    P.setInt(1,id1);
                    P.setInt(2,id2);
                    P.setDouble(3,id3);
                    P.setInt(4,id);
                    P.executeUpdate();
                }

                ip.close();
            }catch (Exception e){
                e.printStackTrace();}
        }
        else if(n==1) {
            try {
                Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management_system", "root", "Tanvir420");
                Statement stt1 = connect.createStatement();
                ResultSet ip = stt1.executeQuery("SELECT * FROM Breakfast");
                int i = 0;
                //BufferedWriter w=new BufferedWriter(new FileWriter("files/Restaurant Log.txt"));
                while (ip.next() && i < ra1.size()) {
                    Restaurant r1 = new Restaurant();
//                    foodCode int,
//                    price double,
//                    foodName varchar(30)
                    int id = ip.getInt("foodCode");
                    double id1 = ip.getDouble("price");
                    String id2 = ip.getString("foodName");
                    //  r1.setRoom(String.valueOf(id));r1.setCode(String.valueOf(id1));r1.setQuantity(String.valueOf(id2));r1.setPrice(String.valueOf(id3));
                    PreparedStatement P = connect.prepareStatement("Update Breakfast SET price=?,foodName=? WHERE foodCode=?");
                    P.setDouble(1, id1);
                    P.setString(2, id2);
                    P.setInt(3, id);
                    P.executeUpdate();
                    i++;
                }
            } catch (Exception Ex) {
                System.out.println(Ex.getStackTrace());
            }
        }
        else if(n==2){
            try{
                BufferedWriter w=new BufferedWriter(new FileWriter("files/Lunch.txt"));
                for (int i = 0; i <ra2.size() ; i++) {

                    w.write(ra2.get(i).writeFile());
                    w.newLine();
                }
                w.close();
            }catch (Exception e){
                e.printStackTrace();}
        }
        else if(n==3){
            try{
                BufferedWriter w=new BufferedWriter(new FileWriter("files/Dinner.txt"));
                for (int i = 0; i <ra3.size() ; i++) {

                    w.write(ra3.get(i).writeFile());
                    w.newLine();
                }
                w.close();
            }catch (Exception e){
                e.printStackTrace();}
        }
        else {
            try{
                BufferedWriter w=new BufferedWriter(new FileWriter("files/Beverage.txt"));
                for (int i = 0; i <ra4.size() ; i++) {

                    w.write(ra4.get(i).writeFile());
                    w.newLine();
                }
                w.close();
            }catch (Exception e){
                e.printStackTrace();}
        }
    }
    public void RemoveFood(int n,String name)
    {
        if(n==0){
            ManagingRooms M= new ManagingRooms();
            M.loadRoom();
            Room[] rooms = M.getRooms();
            try{
                FileWriter fr = new FileWriter("files/Restaurant Log.txt", true);

                for (int i = 0; i < ra.size(); i++){
                    if(ra.get(i).getRoom().equals(name)){
                        rooms[Integer.parseInt(name)-1].setExpense(-Integer.parseInt(ra.get(i).getPrice()));
                        ra.remove(i);
                        UPdate(0);
                        M.updateRoom();
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }


        }
        else if(n==1){
            try{
                FileWriter fr = new FileWriter("files/Breakfast.txt", true);
                for (int i = 0; i < ra1.size(); i++){
                    if(ra1.get(i).getCode().equals(name)){

                        ra1.remove(i);
                        UPdate(1);
                    }
                }
            } catch (Exception e){
                e.printStackTrace();
            }


        }
        else if(n==2){
            try{
                FileWriter fr = new FileWriter("files/Lunch.txt", true);
                for (int i = 0; i < ra2.size(); i++){
                    if(ra2.get(i).getCode().equals(name)){

                        ra2.remove(i);
                        UPdate(2);
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }


        }
        else if(n==3) {
            try {
                FileWriter fr = new FileWriter("files/Dinner.txt", true);
                for (int i = 0; i < ra3.size(); i++) {
                    if (ra3.get(i).getCode().equals(name)) {

                        ra3.remove(i);
                        UPdate(3);
                    }
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            try{
                FileWriter fr = new FileWriter("files/Beverage.txt", true);
                for (int i = 0; i < ra4.size(); i++){
                    if(ra4.get(i).getCode().equals(name)){

                        ra4.remove(i);
                        UPdate(4);
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}