package sample;

import Reception.checkIn.CheckInScene;
import Reception.checkOut.CheckOutScene;
import Reception.searchCustomer.SearchCustomerScene;
import Rooms.ManagingRooms;
import Rooms.Room;
import Rooms.displayRooms.DisplayRoomsScene;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import laundry.LaundryScene;
import massageService.MassageService;
import restaurant.RestaurantMainScene;
import transportService.TransportServiceScene;

import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.*;
import java.util.Scanner;

public class Main extends Application {
    ManagingRooms M = new ManagingRooms();
    Room[] rooms = M.getRooms();
    public static Stage window;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage dstage) throws Exception {
        window = new Stage();

        try {
            window.getIcons().add(new Image(new FileInputStream("icons/TSAAppIcon.png")));
        }catch (Exception ex){
            System.out.println("Ico");
        }

        window.setTitle("Hotel Management System");

        window.setOnCloseRequest(e->{
            creaditScene();
        });

        window.setScene(getloginScene());
        window.show();

    }

    public Scene getloginScene() {

        Label label2 = new Label("User Name");
        label2.setFont(new Font("Arial", 16));
        label2.setStyle("-fx-font-weight: bold");
        label2.setTextFill(Color.web("#2f479e"));

        TextField textField1 = new TextField();
        textField1.setFont(new Font("Arial", 16));

        Label label3 = new Label("Password");
        label3.setFont(new Font("Arial", 16));
        label3.setStyle("-fx-font-weight: bold");
        label3.setTextFill(Color.web("#2f479e"));

        PasswordField passwordField = new PasswordField();
        passwordField.setFont(new Font("Arial", 16));

        GridPane gridPane = new GridPane();
        gridPane.add(label2, 0,0);
        gridPane.add(new Label("  "),1,0);
        gridPane.add(textField1,2,0);
        gridPane.add(new Label(),0,1);
        gridPane.add(label3,0,2);
        gridPane.add(new Label("  "),1,2);
        gridPane.add(passwordField,2,2);

        Button login = new Button();
        login.setPrefWidth(110);
        login.setPrefHeight(25);
        login.setFont(new Font("Arial", 14));
        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/LogInButton.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(250,33,false,false, false,false)));

            login.setBackground(background);
        }catch (Exception ex){

        }

        Button close = new Button();
        close.setPrefWidth(110);
        close.setPrefHeight(25);
        close.setFont(new Font("Arial", 14));
        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/CloseButton.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(250,33,false,false, false,false)));

            close.setBackground(background);
        }catch (Exception ex){

        }

        gridPane.add(new Label(),0,3);
        gridPane.add(login,0,4);
        gridPane.add(new Label("  "),1,4);
        gridPane.add(close,2,4);

        login.setOnAction(e-> {
            try {


                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management_system", "root", "Tanvir420");

                    Statement A = connection.createStatement();

                ResultSet resultSet = A.executeQuery("SELECT * FROM password");



                //Scanner sc = new Scanner(new FileReader("files/Password.txt"));

                while (resultSet.next()){

                    if(resultSet.getString("user").equals(textField1.getText()) && resultSet.getString("pass").equals(passwordField.getText())) {
                        window.setScene(mainScene());
                    }

                    else{
                        VBox vv = new VBox();

                        Button bb = new Button();
                        bb.setPrefWidth(110);
                        bb.setPrefHeight(25);
                        bb.setFont(new Font("Arial", 14));
                        try {
                            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/BackButton.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(250,33,false,false, false,false)));

                            bb.setBackground(background);
                        }catch (Exception ex){

                        }

                        vv.getChildren().addAll(bb, new Label(" "), new Label(" "),new Label(" "),new Label(" "),new Label(" "),new Label(" "),new Label(" "),new Label(" "),new Label(" "),new Label(" "),new Label(" "));

                        vv.setAlignment(Pos.BOTTOM_CENTER);

                        bb.setOnAction(e1-> {
                            textField1.setText("");
                            passwordField.setText("");

                            window.setScene(getloginScene());
                        });

                        HBox hBox1 = new HBox();
                        hBox1.getChildren().addAll(vv, new Label("                                                                                                                                                                "));
                        hBox1.setAlignment(Pos.CENTER);

                        try {
                            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/TSALoginAccessDenied.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(1050,750,false,false, false,false)));

                            hBox1.setBackground(background);
                        }catch (Exception ex){

                        }

                        Scene prompt = new Scene(hBox1,1050,750);
                        window.setScene(prompt);
                    }
                }
            }catch (Exception ex ){

            }
        });

        close.setOnAction(e-> {
            creaditScene();
            window.close();
        });

        gridPane.setAlignment(Pos.CENTER);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(new Label(), new Label(), gridPane, new Label());

        vBox.setAlignment(Pos.CENTER);

        HBox hBox = new HBox();
        hBox.getChildren().addAll(vBox, new Label("                                                                                                                                                                "));
        hBox.setAlignment(Pos.CENTER);

        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/TSAParadiseLogInScene.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(1050,750,false,false, false,false)));

            hBox.setBackground(background);
        }catch (Exception ex){

        }

        Scene scene = new Scene(hBox,1050,750);
        return scene;
    }

    public Scene mainScene(){
        Button checkIn = new Button();
        checkIn.setPrefHeight(25);
        checkIn.setPrefWidth(200);
        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/CheckInButton.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(350,30,false,false, false,false)));

            checkIn.setBackground(background);
        }catch (Exception ex){

        }

        Button checkOut = new Button();
        checkOut.setPrefHeight(25);
        checkOut.setPrefWidth(200);
        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/checkoutButton.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(350,30,false,false, false,false)));

            checkOut.setBackground(background);
        }catch (Exception ex){

        }

        Button displayRooms = new Button();
        displayRooms.setPrefHeight(25);
        displayRooms.setPrefWidth(200);
        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/DisplayRoomsButton.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(350,30,false,false, false,false)));

            displayRooms.setBackground(background);
        }catch (Exception ex){

        }

        Button searchCustomer = new Button();
        searchCustomer.setPrefHeight(25);
        searchCustomer.setPrefWidth(200);
        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/SearchCustomer.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(350,30,false,false, false,false)));

            searchCustomer.setBackground(background);
        }catch (Exception ex){

        }

        Button restaurantService = new Button();
        restaurantService.setPrefHeight(25);
        restaurantService.setPrefWidth(200);
        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/RestaurantButton.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(350,30,false,false, false,false)));

            restaurantService.setBackground(background);
        }catch (Exception ex){

        }

        Button transportService = new Button();
        transportService.setPrefHeight(25);
        transportService.setPrefWidth(200);
        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/TransportButton.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(350,30,false,false, false,false)));

            transportService.setBackground(background);
        }catch (Exception ex){

        }

        Button massageService = new Button();
        massageService.setPrefHeight(25);
        massageService.setPrefWidth(200);
        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/MassageButton.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(350,30,false,false, false,false)));

            massageService.setBackground(background);
        }catch (Exception ex){

        }

        Button laundryService = new Button();
        laundryService.setPrefHeight(25);
        laundryService.setPrefWidth(200);
        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/LaundryButton.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(350,30,false,false, false,false)));

            laundryService.setBackground(background);
        }catch (Exception ex){

        }

        Button logOut = new Button();
        logOut.setPrefHeight(25);
        logOut.setPrefWidth(200);
        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/Logout.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(350,30,false,false, false,false)));

            logOut.setBackground(background);
        }catch (Exception ex){

        }

        checkIn.setOnAction(e-> {
            try {
                CheckInScene c = new CheckInScene();

                window.setScene(c.getCheckInScene());
            }catch (Exception ex){

            }
        });

        checkOut.setOnAction(e-> {
            CheckOutScene cc = new CheckOutScene();

            window.setScene(cc.getCheckOutScene());
        });

        displayRooms.setOnAction(e-> {
            DisplayRoomsScene dd = new DisplayRoomsScene();

            window.setScene(dd.getDisplayRoomsScene());
        });

        searchCustomer.setOnAction(e-> {
            SearchCustomerScene ss = new SearchCustomerScene();

            window.setScene(ss.getSearchCustomerScene());
        });

        restaurantService.setOnAction(e-> {
            RestaurantMainScene rr = new RestaurantMainScene();

            window.setScene(rr.getRestaurantScene());
        });

        transportService.setOnAction(e-> {
            TransportServiceScene tt = new TransportServiceScene();

            window.setScene(tt.getTransportScene());
        });

        massageService.setOnAction(e-> {
            MassageService mm = new MassageService();

            window.setScene(mm.getMassageScene());
        });

        laundryService.setOnAction(e-> {
            LaundryScene ll = new LaundryScene();

            window.setScene(ll.getLaundryServiceScene());
        });

        logOut.setOnAction(e-> {
            window.setScene(getloginScene());
        });

        VBox vBox = new VBox();
        vBox.getChildren().addAll(checkIn, new Label(), checkOut, new Label(), displayRooms, new Label(), searchCustomer, new Label(), restaurantService, new Label(), transportService, new Label(), massageService, new Label(), laundryService, new Label(), new Label(), logOut);
        vBox.setAlignment(Pos.CENTER);

        HBox hBox = new HBox(new Label("                        "), vBox);

        try {
            FileInputStream F1 = new FileInputStream("icons/MainScene.png");

            BackgroundImage backgroundImage = new BackgroundImage(new Image(F1), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,new BackgroundSize(700,500,false,false, false,true));

            Background background = new Background(backgroundImage);

            hBox.setBackground(background);
        }catch (Exception ec){
            System.out.println("Error");
        }

        Scene scene = new Scene(hBox, 1050,750);
        return scene;
    }

    public void creaditScene(){
        Stage stage = new Stage();

        try {
            stage.getIcons().add(new Image(new FileInputStream("icons/TSAAppIcon.png")));
        }catch (Exception ex){
            System.out.println("Ico");
        }

        stage.setTitle("Hotel Management System");
        HBox hBox = new HBox();

        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/Credits2.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(1050,750,false,false, false,false)));

            hBox.setBackground(background);
        }catch (Exception ex){

        }

        Scene scene1 = new Scene(hBox,1050,750);
        stage.setScene(scene1);

        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(5));

        pauseTransition.setOnFinished(e2-> stage.close());

        pauseTransition.play();
        stage.show();
    }

}