package massageService;

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
import Rooms.ManagingRooms;
import Rooms.Room;
import sample.Main;

import java.io.FileInputStream;

public class MassageService extends Application {
    public int ch=0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("TSA Massage Service");
        primaryStage.setScene(getMassageScene());
        primaryStage.show();
    }
    public Scene getMassageScene(){
        ManagingRooms M = new ManagingRooms();
        Room[] rooms = M.getRooms();

        Label label1 = new Label("Room No ");
        label1.setFont(new Font("Arial", 16));
        label1.setStyle("-fx-font-weight: bold");
        label1.setTextFill(Color.web("#0f7533"));

        TextField textField1 = new TextField();
        textField1.setFont(new Font("Arial", 16));

        Label label2 = new Label("Massage Type ");
        label2.setFont(new Font("Arial", 16));
        label2.setStyle("-fx-font-weight: bold");
        label2.setTextFill(Color.web("#0f7533"));

        TextField textField2 = new TextField();
        textField2.setFont(new Font("Arial", 16));

        String massages[] =  { "1:VIP Massage 6000BDT", "2:Chinese Medicinal Massage 3500BDT", "3:Normal 2000BDT" };

        ComboBox combo_box = new ComboBox(FXCollections.observableArrayList(massages));
        combo_box.setPrefWidth(textField1.getPrefWidth());
        combo_box.setPrefHeight(textField1.getPrefHeight());

        EventHandler<ActionEvent> event =  new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e)
            {
                String choice = combo_box.getValue().toString();
                ch = Integer.parseInt(String.valueOf(choice.charAt(0)));
            }
        };

        combo_box.setOnAction(event);

        GridPane gridPane = new GridPane();
        gridPane.add(label1, 0,0);
        gridPane.add(textField1, 2,0);

        gridPane.add(new Label(), 0,1);
        gridPane.add(label2, 0,2);
        gridPane.add(combo_box,2,2);

        gridPane.setAlignment(Pos.CENTER);

        Button done = new Button();
        done.setPrefWidth(110);
        done.setPrefHeight(25);
        done.setFont(new Font("Arial", 14));
        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/ConfirmGreenButton.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(250,33,false,false, false,false)));

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

        gridPane.add(new Label(), 0,3);
        gridPane.add(done, 0,5);
        gridPane.add(back,2,5);

        gridPane.setHgap(10);

        VBox vBox = new VBox();

        vBox.getChildren().addAll(new Label(),new Label(),new Label(), new Label(), gridPane);
        vBox.setAlignment(Pos.CENTER);

        done.setOnAction(e-> {
            int room = Integer.parseInt(textField1.getText());
            double expense = rooms[room - 1].getExpense();

            if(ch==1){   rooms[room-1].setExpense(6000); }
            if(ch==2){   rooms[room-1].setExpense(3500); }
            if(ch==3){   rooms[room-1].setExpense(2000); }


            M.updateRoom();

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            try {
                stage.getIcons().add(new Image(new FileInputStream("icons/TSAAppIcon.png")));
            }catch (Exception ex){
                System.out.println("Ico");
            }
            stage.setTitle("Confirmation Box");

            Label Welcome =new Label("Massage order confirmed for,");
            Welcome.setFont(new Font("Arial", 16));
            Welcome.setStyle("-fx-font-weight: bold");
            Welcome.setTextFill(Color.web("#0f7533"));

            Label name = new Label(rooms[room-1].getCustomerName());
            name.setFont(new Font("Arial", 16));
            name.setStyle("-fx-font-weight: bold");
            name.setTextFill(Color.web("#0f7533"));

            Label label10 = new Label("Room No          ");
            label10.setFont(new Font("Arial", 16));
            label10.setStyle("-fx-font-weight: bold");
            label10.setTextFill(Color.web("#0f7533"));

            Label label11 = new Label(Integer.toString(room));
            label11.setFont(new Font("Arial", 16));
            label11.setStyle("-fx-font-weight: bold");
            label11.setTextFill(Color.web("#0f7533"));

            Label label12 = new Label("Previous Expense ");
            label12.setFont(new Font("Arial", 16));
            label12.setStyle("-fx-font-weight: bold");
            label12.setTextFill(Color.web("#0f7533"));

            Label label13 = new Label(Double.toString(expense));
            label13.setFont(new Font("Arial", 16));
            label13.setStyle("-fx-font-weight: bold");
            label13.setTextFill(Color.web("#0f7533"));

            Label label14 = new Label("Updated Expense  ");
            label14.setFont(new Font("Arial", 16));
            label14.setStyle("-fx-font-weight: bold");
            label14.setTextFill(Color.web("#0f7533"));

            Label label15 = new Label(Double.toString(rooms[room - 1].getExpense()));
            label15.setFont(new Font("Arial", 16));
            label15.setStyle("-fx-font-weight: bold");
            label15.setTextFill(Color.web("#0f7533"));

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

            vBox1.getChildren().addAll(Welcome,new Label(),name,new Label(),gridPane1,new Label(), back2);
            vBox1.setAlignment(Pos.CENTER);

            HBox hBox1 = new HBox();
            hBox1.getChildren().addAll(vBox1, new Label("                                        "));
            hBox1.setAlignment(Pos.CENTER);

            try {
                Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/ConfirmBoxLandScape.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(400,300,false,false, false,false)));

                hBox1.setBackground(background);
            }catch (Exception ex){

            }

            Scene scene1 = new Scene(hBox1,400,300);
            stage.setTitle("Massage Confirmation");
            stage.setScene(scene1);
            stage.show();

            back2.setOnAction(e1-> {
                stage.close();
            });

            textField1.setText("");
            textField2.setText("");
        });

        back.setOnAction(e-> {
            Main mm = new Main();

            Main.window.setScene(mm.mainScene());
        });

        HBox hBox = new HBox();
        hBox.getChildren().addAll(vBox, new Label("                                                                                                                                                                "));
        hBox.setAlignment(Pos.CENTER);

        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/Massage.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(1050,750,false,false, false,false)));

            hBox.setBackground(background);
        }catch (Exception ex){

        }

        Scene scene = new Scene(hBox, 1050,750);

        return scene;
    }
}
