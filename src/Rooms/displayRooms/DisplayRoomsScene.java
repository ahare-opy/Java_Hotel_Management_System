package Rooms.displayRooms;

import Rooms.ManagingRooms;
import Rooms.Room;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.Main;

import java.io.FileInputStream;

public class DisplayRoomsScene extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Hotel Management System");

        stage.setScene(getDisplayRoomsScene());
        stage.show();
    }

    public ObservableList<Room> getRoom(){
        ManagingRooms M = new ManagingRooms();
        Room[] rooms = M.getRooms();

        ObservableList<Room> rooms1 = FXCollections.observableArrayList();

        for (int i = 0; i < 50; i++){
            rooms1.add(rooms[i]);
        }

        return rooms1;
    }

    public Scene getDisplayRoomsScene() {
        TableColumn<Room, Integer> RoomNo = new TableColumn<>("Room No");
        RoomNo.setMinWidth(100);
        RoomNo.setCellValueFactory(new PropertyValueFactory<>("roomNo"));

        TableColumn<Room, String> CustomerName = new TableColumn<>("Customer Name");
        CustomerName.setMinWidth(200);
        CustomerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));

        TableColumn<Room, String> PhoneNUmber = new TableColumn<>("Phone Number");
        PhoneNUmber.setMinWidth(100);
        PhoneNUmber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        TableColumn<Room, Integer> PeriodOfStay = new TableColumn<>("Period Of Stay");
        PeriodOfStay.setMinWidth(100);
        PeriodOfStay.setCellValueFactory(new PropertyValueFactory<>("periodOfStay"));

        TableColumn<Room, String> City = new TableColumn<>("City");
        City.setMinWidth(100);
        City.setCellValueFactory(new PropertyValueFactory<>("city"));

        TableColumn<Room, String> Nationality = new TableColumn<>("Nationality");
        Nationality.setMinWidth(100);
        Nationality.setCellValueFactory(new PropertyValueFactory<>("nationality"));

        TableColumn<Room, Integer> NoOfGuest = new TableColumn<>("No Of Guest");
        NoOfGuest.setMinWidth(100);
        NoOfGuest.setCellValueFactory(new PropertyValueFactory<>("memberStaying"));

        TableColumn<Room, java.util.Date> Date = new TableColumn<>("Date");
        Date.setMinWidth(200);
        Date.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<Room, String> RoomType = new TableColumn<>("Room Type");
        RoomType.setMinWidth(100);
        RoomType.setCellValueFactory(new PropertyValueFactory<>("roomType"));

        TableColumn<Room, Double> Expense = new TableColumn<>("Expense");
        Expense.setMinWidth(100);
        Expense.setCellValueFactory(new PropertyValueFactory<>("expense"));

        TableView<Room> table = new TableView<>();
        table.setItems(getRoom());
        table.getColumns().addAll(RoomNo, CustomerName, PhoneNUmber, PeriodOfStay, City, Nationality, NoOfGuest, Date, RoomType, Expense);

        Button back = new Button();
        back.setPrefWidth(110);
        back.setPrefHeight(25);
        back.setFont(new Font("Arial", 14));
        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/BackButton.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(250,33,false,false, false,false)));

            back.setBackground(background);
        }catch (Exception ex){

        }

        Label label = new Label();
        label.setFont(new Font("Arial", 20));
        Label label1 = new Label();
        Label label2 = new Label();
        Label label5 = new Label();
        Label label6 = new Label();

        back.setOnAction(e->{
            Main mm = new Main();

            Main.window.setScene(mm.mainScene());
        });

        VBox root = new VBox();
        root.getChildren().addAll(label1, label2, label, table, label5, back, label6);
        root.setAlignment(Pos.CENTER);

        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/DisplayAllRoomsNew.jpg")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(1050,750,false,false, false,false)));

            root.setBackground(background);
        }catch (Exception ex){

        }

        Scene displayRoomsScene = new Scene(root,1050,750);

        return displayRoomsScene;
    }
}
