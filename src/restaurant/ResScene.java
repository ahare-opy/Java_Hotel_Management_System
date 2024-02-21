package restaurant;

import Rooms.ManagingRooms;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Main;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;


public class ResScene extends Application {
    private int n;
    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        try{
            stage.setScene(getResServiceScene());
            stage.show();}
        catch (Exception e){e.printStackTrace();}
    }

    public Scene getResServiceScene(){
        ManagingRooms M = new ManagingRooms();
        ManagingRestaurant k=new ManagingRestaurant();

        Label label1 = new Label("Code No :");
        label1.setFont(new Font("Arial", 16));
        label1.setStyle("-fx-font-weight: bold");
        label1.setTextFill(Color.web("#e3782b"));

        TextField textField1 = new TextField();
        textField1.setFont(new Font("Arial", 16));

        Label label2 = new Label("Price :");
        label2.setFont(new Font("Arial", 16));
        label2.setStyle("-fx-font-weight: bold");
        label2.setTextFill(Color.web("#e3782b"));

        TextField textField2 = new TextField();
        textField2.setFont(new Font("Arial", 16));

        Label label3 =new Label("Food Item Name :");
        label3.setFont(new Font("Arial", 16));
        label3.setStyle("-fx-font-weight: bold");
        label3.setTextFill(Color.web("#e3782b"));

        TextField textField3=new TextField();
        textField3.setFont(new Font("Arial", 16));

        Label label4=new Label("Enter List :");
        label4.setFont(new Font("Arial", 16));
        label4.setStyle("-fx-font-weight: bold");
        label4.setTextFill(Color.web("#e3782b"));

        String list1[] =  { "1: Breakfast FoodList", "2: Lunch FoodList","3: Dinner FoodList","4: Beverage FoodList" };

        ComboBox combo_box = new ComboBox(FXCollections.observableArrayList(list1));
        EventHandler<ActionEvent> event =  new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                String choice = combo_box.getValue().toString();
                n = Integer.parseInt(String.valueOf(choice.charAt(0)));
            }
        };
        combo_box.setOnAction(event);
        combo_box.setPrefWidth(textField1.getPrefWidth());

        Label label5 = new Label();
        label5.setFont(new Font("Arial", 20));

        GridPane gridPane = new GridPane();
        gridPane.add(label1, 0,0);
        gridPane.add(textField1, 1,0);
        gridPane.add(new Label(), 0,1);

        gridPane.add(label2, 0,2);
        gridPane.add(textField2,1,2);
        gridPane.add(new Label(),0,3);
        gridPane.add(label3,0,4);
        gridPane.add(textField3,1,4);
        gridPane.add(new Label(),0,5);
        gridPane.add(label4,0,6);
        gridPane.add(combo_box,1,6);


        gridPane.setAlignment(Pos.CENTER);

        Button okay = new Button();
        okay.setPrefWidth(110);
        okay.setPrefHeight(25);
        okay.setFont(new Font("Arial", 14));
        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/AddButton.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(250,33,false,false, false,false)));

            okay.setBackground(background);
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


        gridPane.add(new Label(), 0,7);
        gridPane.add(okay, 0,8);
        gridPane.add(back,1,8);

        VBox vBox = new VBox();

        vBox.getChildren().addAll(label5, new Label(), gridPane);
        vBox.setAlignment(Pos.CENTER);
        back.setOnAction(e-> {
            try {
                RestaurantMainScene o=new RestaurantMainScene();

                Main.window.setScene(o.getRestaurantScene());
            }catch (Exception ex){

            }
        });

        okay.setOnAction(e-> {
            // String name= textField3.getText();

            Restaurant r=new Restaurant();
            r.setBDT("BDT");
            r.setName(textField3.getText());
            r.setCode(textField1.getText());
            r.setPrice(textField2.getText());
            //int n=Integer.parseInt(textField4.getText());
            if(n==1){
                k.LoadBreFile();
                try{
                    Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management_system", "root", "Tanvir420");

                    Statement statement = connect.createStatement();
                    PreparedStatement breakfast = connect.prepareStatement("INSERT INTO Breakfast(foodCode,price,foodName) VALUES(?,?,?)");
                    breakfast.setInt(1,Integer.parseInt(r.getCode()));
                    breakfast.setDouble(2,Double.parseDouble(r.getPrice()));
                    breakfast.setString(3,r.getName());

                    breakfast.executeUpdate();

                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
            else if(n==2){
                k.LoadLunFile();
                try{
                    Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management_system", "root", "Tanvir420");

                    Statement statement = connect.createStatement();
                    PreparedStatement breakfast = connect.prepareStatement("INSERT INTO lunch(foodCode,price,foodName) VALUES(?,?,?)");
                    breakfast.setInt(1,Integer.parseInt(r.getCode()));
                    breakfast.setDouble(2,Double.parseDouble(r.getPrice()));
                    breakfast.setString(3,r.getName());

                    breakfast.executeUpdate();

                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
            else if(n==3){
                k.LoadDinFile();
                try{
                    Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management_system", "root", "Tanvir420");

                    Statement statement = connect.createStatement();
                    PreparedStatement breakfast = connect.prepareStatement("INSERT INTO dinner(foodCode,price,foodName) VALUES(?,?,?)");
                    breakfast.setInt(1,Integer.parseInt(r.getCode()));
                    breakfast.setDouble(2,Double.parseDouble(r.getPrice()));
                    breakfast.setString(3,r.getName());

                    breakfast.executeUpdate();

                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
            else {
                k.LoadBeverageFile();
                try{
                    Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management_system", "root", "Tanvir420");

                    Statement statement = connect.createStatement();
                    PreparedStatement breakfast = connect.prepareStatement("INSERT INTO beverage(foodCode,price,foodName) VALUES(?,?,?)");
                    breakfast.setInt(1,Integer.parseInt(r.getCode()));
                    breakfast.setDouble(2,Double.parseDouble(r.getPrice()));
                    breakfast.setString(3,r.getName());

                    breakfast.executeUpdate();

                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }



            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            try {
                stage.getIcons().add(new Image(new FileInputStream("icons/TSAAppIcon.png")));
            }catch (Exception ex){
                System.out.println("Ico");
            }
            stage.setTitle("Confirmation Box");

            Label label11 = new Label("Updated successfully!!!");
            label11.setFont(new Font("Arial", 16));
            label11.setStyle("-fx-font-weight: bold");
            label11.setTextFill(Color.web("#e3782b"));


            Button back2 = new Button();
            back2.setPrefWidth(110);
            back2.setPrefHeight(25);
            back2.setFont(new Font("Arial", 14));
            try {
                Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/BackButton.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(250,33,false,false, false,false)));

                back2.setBackground(background);
            }catch (Exception ex){

            }

            GridPane gridPane1 = new GridPane();
            gridPane1.add(new Label(),0,0);
            gridPane1.add(label11, 1,0);


            gridPane1.setAlignment(Pos.CENTER);
            VBox vBox1 = new VBox();

            vBox1.getChildren().addAll(gridPane1,new Label(), back2);
            vBox1.setAlignment(Pos.CENTER);

            try {
                Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/ConfirmBoxLandscape.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(400,300,false,false, false,false)));

                vBox1.setBackground(background);
            }catch (Exception ex){

            }

            Scene scene1 = new Scene(vBox1,400,300);
            stage.setScene(scene1);
            stage.show();

            back2.setOnAction(e1-> {
                stage.close();
            });

            textField1.setText("");
            textField2.setText("");
            textField3.setText("");
        });

        HBox hBox = new HBox();
        hBox.getChildren().addAll(vBox, new Label("                                                                                                                                                                "));
        hBox.setAlignment(Pos.CENTER);

        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/FoodAddMenuScene.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(1050,750,false,false, false,false)));

            hBox.setBackground(background);
        }catch (Exception ex){

        }

        Scene scene = new Scene(hBox, 1050,750);

        return scene;
    }
}