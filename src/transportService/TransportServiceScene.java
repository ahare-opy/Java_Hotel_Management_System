package transportService;

import javafx.application.Application;
import Rooms.ManagingRooms;
import Rooms.Room;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
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
import javafx.scene.Scene;
import sample.Main;

import java.io.FileInputStream;

public class TransportServiceScene extends Application {
    public  int ch= 0 ;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("TSA Hotel Transport Service");
        primaryStage.setScene(getTransportScene());
        primaryStage.show();
    }
    public Scene getTransportScene(){
        ManagingRooms M = new ManagingRooms();
        Room[] rooms = M.getRooms();

        Label rooml = new Label("Room No  ");
        rooml.setFont(new Font("Arial", 16));
        rooml.setStyle("-fx-font-weight: bold");
        rooml.setTextFill(Color.web("#2f479e"));

        Label Welcome = new Label();

        TextField roomtf = new TextField();
        roomtf.setFont(new Font("Arial", 16));

        Label kml   = new Label("Distance In KM   ");
        kml.setFont(new Font("Arial", 16));
        kml.setStyle("-fx-font-weight: bold");
        kml.setTextFill(Color.web("#2f479e"));

        TextField kmtf = new TextField();
        kmtf.setFont(new Font("Arial", 16));

        Label choicel = new Label("Choose Vehicle Type    ");
        choicel.setFont(new Font("Arial", 16));
        choicel.setStyle("-fx-font-weight: bold");
        choicel.setTextFill(Color.web("#2f479e"));

        // Label choicel = new Label("1:Limousine : Per KM 600BDT    2:SUV : Per KM 550BDT     3:Sedan Per KM 450BDT")
        String transport[] =  { "1:Limousine : Per KM 600BDT", "2:SUV : Per KM 550BDT", "3:Sedan Per KM 450BDT" };

        ComboBox combo_box = new ComboBox(FXCollections.observableArrayList(transport));
        combo_box.setPrefHeight(kml.getPrefHeight());
        combo_box.setPrefWidth(kml.getPrefWidth());

        EventHandler<ActionEvent> event =  new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                String choice = combo_box.getValue().toString();
                ch = Integer.parseInt(String.valueOf(choice.charAt(0)));
            }
        };
        combo_box.setOnAction(event);
        Button done = new Button();
        done.setPrefWidth(110);
        done.setPrefHeight(25);
        done.setFont(new Font("Arial", 14));
        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/ConfirmButton.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(250,33,false,false, false,false)));

            done.setBackground(background);
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



        GridPane gridPane = new GridPane();
        gridPane.add(rooml,0,0);
        gridPane.add(roomtf,1,0);
        gridPane.add(new Label(), 0,1);

        gridPane.add(choicel, 0,2);
        gridPane.add(combo_box, 1,2);
        gridPane.add(new Label(),0,3);

        gridPane.add(kml, 0,4);
        gridPane.add(kmtf, 1,4);
        gridPane.add(new Label(),0,5);

        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(new Label(),0,6 );
        gridPane.add(done, 0,7);
        gridPane.add(back,1,7);

        //gridPane.setHgap();

        VBox vBox = new VBox();
        vBox.getChildren().addAll(Welcome, new Label(),new Label(),new Label(), gridPane);
        vBox.setAlignment(Pos.CENTER);
        done.setOnAction(e->{
            int room = Integer.parseInt(roomtf.getText());
            int distanceKM = Integer.parseInt(kmtf.getText());
            double expense = rooms[room - 1].getExpense();
            if(ch==1){   rooms[room-1].setExpense(distanceKM*600); }
            if(ch==2){   rooms[room-1].setExpense(distanceKM*550); }
            if(ch==3){   rooms[room-1].setExpense(distanceKM*450); }
            M.updateRoom();

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            try {
                stage.getIcons().add(new Image(new FileInputStream("icons/TSAAppIcon.png")));
            }catch (Exception ex){
                System.out.println("Ico");
            }
            stage.setTitle("Confirmation Box");

            Label Welcome1 =new Label("Vehicle order confirmed for,");
            Welcome1.setFont(new Font("Arial", 16));
            Welcome1.setStyle("-fx-font-weight: bold");
            Welcome1.setTextFill(Color.web("#2f479e"));

            Label name = new Label(rooms[room-1].getCustomerName());
            name.setFont(new Font("Arial", 16));
            name.setStyle("-fx-font-weight: bold");
            name.setTextFill(Color.web("#2f479e"));

            Label label10 = new Label("Room No          ");
            label10.setFont(new Font("Arial", 16));
            label10.setStyle("-fx-font-weight: bold");
            label10.setTextFill(Color.web("#2f479e"));

            Label label11 = new Label(Integer.toString(room));
            label11.setFont(new Font("Arial", 16));
            label11.setStyle("-fx-font-weight: bold");
            label11.setTextFill(Color.web("#2f479e"));

            Label label12 = new Label("Previous Expense ");
            label10.setPrefWidth(label12.getPrefWidth());
            label12.setFont(new Font("Arial", 16));
            label12.setStyle("-fx-font-weight: bold");
            label12.setTextFill(Color.web("#2f479e"));

            Label label13 = new Label(Double.toString(expense));
            label13.setFont(new Font("Arial", 16));
            label13.setStyle("-fx-font-weight: bold");
            label13.setTextFill(Color.web("#2f479e"));

            Label label14 = new Label("Updated Expense  ");
            label14.setFont(new Font("Arial", 16));
            label14.setStyle("-fx-font-weight: bold");
            label14.setTextFill(Color.web("#2f479e"));

            Label label15 = new Label(Double.toString(rooms[room - 1].getExpense()));
            label15.setFont(new Font("Arial", 16));
            label15.setStyle("-fx-font-weight: bold");
            label15.setTextFill(Color.web("#2f479e"));

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
            gridPane1.add(label10,0,0);
            gridPane1.add(label11, 1,0);
            gridPane1.add(new Label(),0,1);
            gridPane1.add(label12,0,2);
            gridPane1.add(label13,1,2);
            gridPane1.add(new Label(),0,3);
            gridPane1.add(label14,0,4);
            gridPane1.add(label15,1,4);

            gridPane1.setAlignment(Pos.CENTER);
            VBox vBox1 = new VBox();

            vBox1.getChildren().addAll(Welcome1,new Label(),name,new Label(),gridPane1,new Label(), back2);
            vBox1.setAlignment(Pos.CENTER);

            HBox hBox = new HBox();
            hBox.getChildren().addAll(vBox1, new Label("                                        "));
            hBox.setAlignment(Pos.CENTER);

            try {
                Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/ConfirmBoxLandScape.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(400,300,false,false, false,false)));

                hBox.setBackground(background);
            }catch (Exception ex){

            }

            Scene scene1 = new Scene(hBox,400,300);
            stage.setTitle("Transport Confirmation");
            stage.setScene(scene1);
            stage.show();

            back2.setOnAction(e1-> {
                stage.close();
            });

            roomtf.setText("");
            kmtf.setText("");
        });

        back.setOnAction(e-> {
            Main mm = new Main();

            Main.window.setScene(mm.mainScene());
        });

        HBox hBox = new HBox();
        hBox.getChildren().addAll(vBox, new Label("                                                                                                                                                                "));
        hBox.setAlignment(Pos.CENTER);

        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/transport.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(1050,750,false,false, false,false)));

            hBox.setBackground(background);
        }catch (Exception ex){

        }

        Scene scene = new Scene(hBox, 1050,750);

        return scene;
    }
}
