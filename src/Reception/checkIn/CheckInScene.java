package Reception.checkIn;

import Rooms.ManagingRooms;
import Rooms.Room;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import sample.Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;

public class CheckInScene extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws FileNotFoundException {
        stage.setTitle("Hotel Management System");

        stage.setScene(getCheckInScene());
        stage.show();
    }

    public Scene getCheckInScene(){
        ManagingRooms M = new ManagingRooms();

        Room[] rooms = M.getRooms();

        Label label10,label11,label12,label13,label14,label15,label16,label17,label18,label19;

        GridPane gridPane = new GridPane();
        Label label1 = new Label("Room No");
        label1.setFont(new Font("Arial", 16));
        label1.setStyle("-fx-font-weight: bold");
        label1.setTextFill(Color.web("#2f479e"));

        ComboBox<String> comboBox = new ComboBox<>();

        for (int i = 0; i < rooms.length; i++){
            if(rooms[i].getCustomerName().equals("null") || rooms[i].getCustomerName().equals(null)) comboBox.getItems().add(Integer.toString(rooms[i].getRoomNo()));
        }

        //TextField textField1 = new TextField();
        //textField1.setFont(new Font("Arial", 16));

        comboBox.setPrefHeight(label1.getPrefHeight());
        comboBox.setPrefWidth(200);
        comboBox.setStyle("-fx-font-weight: bold");
        comboBox.setStyle("-fx-text-fill: #2f479e");
        comboBox.setStyle("-fx-font-size: 14");

        label11 = new Label();
        gridPane.add(label1, 0,0);
        gridPane.add(comboBox,1,0);
        gridPane.add(label11, 0,1);

        Label label2 = new Label("Customer Name  ");
        label2.setFont(new Font("Arial", 16));
        label2.setStyle("-fx-font-weight: bold");
        label2.setTextFill(Color.web("#2f479e"));
        TextField textField2 = new TextField();
        textField2.setFont(new Font("Arial", 16));
        label12 = new Label();
        gridPane.add(label2,0,2);
        gridPane.add(textField2,1,2);
        gridPane.add(label12,0,3);

        Label label3 = new Label("Phone Number");
        label3.setFont(new Font("Arial", 16));
        label3.setStyle("-fx-font-weight: bold");
        label3.setTextFill(Color.web("#2f479e"));
        TextField textField3 = new TextField();
        textField3.setFont(new Font("Arial", 16));
        label13 = new Label();
        gridPane.add(label3,0,4);
        gridPane.add(textField3,1,4);
        gridPane.add(label13,0,5);

        Label label4 = new Label("Period Of Stay");
        label4.setFont(new Font("Arial", 16));
        label4.setStyle("-fx-font-weight: bold");
        label4.setTextFill(Color.web("#2f479e"));
        TextField textField4 = new TextField();
        textField4.setFont(new Font("Arial", 16));
        label14 = new Label();
        gridPane.add(label4,0,6);
        gridPane.add(textField4,1,6);
        gridPane.add(label14,0,7);

        Label label5 = new Label("City");
        label5.setFont(new Font("Arial", 16));
        label5.setStyle("-fx-font-weight: bold");
        label5.setTextFill(Color.web("#2f479e"));
        TextField textField5 = new TextField();
        textField5.setFont(new Font("Arial", 16));
        label15 = new Label();
        gridPane.add(label5,0,8);
        gridPane.add(textField5,1,8);
        gridPane.add(label15,0,9);

        Label label6 = new Label("Nationality");
        label6.setFont(new Font("Arial", 16));
        label6.setStyle("-fx-font-weight: bold");
        label6.setTextFill(Color.web("#2f479e"));
        TextField textField6 = new TextField();
        textField6.setFont(new Font("Arial", 16));
        label16 = new Label();
        gridPane.add(label6,0,10);
        gridPane.add(textField6,1,10);
        gridPane.add(label16,0,11);

        Label label7 = new Label("No Of Guest");
        label7.setFont(new Font("Arial", 16));
        label7.setStyle("-fx-font-weight: bold");
        label7.setTextFill(Color.web("#2f479e"));
        TextField textField7 = new TextField();
        textField7.setFont(new Font("Arial", 16));
        label17 = new Label();
        gridPane.add(label7,0,12);
        gridPane.add(textField7,1,12);
        gridPane.add(label17, 0,13);

        Label label8 = new Label("Room Type");
        label8.setFont(new Font("Arial", 16));
        label8.setStyle("-fx-font-weight: bold");
        label8.setTextFill(Color.web("#2f479e"));
        TextField textField8 = new TextField();
        textField8.setFont(new Font("Arial", 16));
        label18 = new Label();
        gridPane.add(label8,0,14);
        gridPane.add(textField8,1,14);
        gridPane.add(label18,0,15);

        Label label9 = new Label("Expense");
        label9.setFont(new Font("Arial", 16));
        label9.setStyle("-fx-font-weight: bold");
        label9.setTextFill(Color.web("#2f479e"));
        TextField textField9 = new TextField();
        textField9.setFont(new Font("Arial", 16));
        label19 = new Label();
        gridPane.add(label9,0,16);
        gridPane.add(textField9,1,16);
        gridPane.add(label19,0,17);

        Button checkIn = new Button("");
        checkIn.setPrefWidth(110);
        checkIn.setPrefHeight(25);
        checkIn.setFont(new Font("Arial", 14));
        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/CheckInButton.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(250,30,false,false, false,false)));

            checkIn.setBackground(background);
        }catch (Exception ex){

        }

        Button back = new Button();
        back.setPrefWidth(110);
        back.setPrefHeight(25);
        back.setFont(new Font("Arial", 14));
        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/BackButton.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(250,33,false,false, false,false)));

            back.setBackground(background);
        }catch (Exception ex){

        }

        gridPane.add(checkIn,0,18);
        gridPane.add(back,1,18);


        gridPane.setAlignment(Pos.CENTER);

        HBox hbox = new HBox();
        hbox.getChildren().addAll( gridPane, new Label("                                                                                                                                                                                                     "));
        hbox.setAlignment(Pos.CENTER);

        checkIn.setOnAction(e-> {
            //ManagingRooms M = new ManagingRooms();

            //Room[] rooms = M.getRooms();

            int room = Integer.parseInt(comboBox.getValue());

            rooms[room - 1].setRoomNo(room);
            rooms[room - 1].setCustomerName(textField2.getText());
            rooms[room - 1].setPhoneNumber(textField3.getText());
            rooms[room - 1].setPeriodOfStay(Integer.parseInt(textField4.getText()));
            rooms[room - 1].setCity(textField5.getText());
            rooms[room - 1].setNationality(textField6.getText());
            rooms[room - 1].setMemberStaying(Integer.parseInt(textField7.getText()));
            rooms[room - 1].setDate(new Date());
            rooms[room - 1].setRoomType(textField8.getText());
            rooms[room - 1].setExpense(Double.parseDouble(textField9.getText()));

            M.setRooms(rooms);
            M.updateRoom();

            if(rooms[room - 1].getCustomerName().equals(textField2.getText())){
                ConfirmBox.display("Check In Successful");
            }

            else ConfirmBox.display("Check In Unsuccessful");

            for (int i = 0; i < rooms.length; i++){
                if(rooms[i].getCustomerName().equals("null") || rooms[i].getCustomerName().equals(null)) comboBox.getItems().add(Integer.toString(rooms[i].getRoomNo()));
            }
            textField2.setText("");
            textField3.setText("");
            textField4.setText("");
            textField5.setText("");
            textField6.setText("");
            textField7.setText("");
            textField8.setText("");
            textField9.setText("");
        });

        back.setOnAction(e-> {
            Main mm = new Main();

            Main.window.setScene(mm.mainScene());
        });

        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/CheckIN.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(1050,750,false,false, false,false)));

            hbox.setBackground(background);
        }catch (Exception ex){

        }

        Scene checkInScene = new Scene(hbox,1050,750);
        return checkInScene;
    }
}