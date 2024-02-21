package Reception.checkOut;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.Main;

import java.io.FileInputStream;

public class CheckOutScene extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(getCheckOutScene());
        stage.show();
    }

    public Scene getCheckOutScene() {
        Label label1, label2, label3, label4, label5, label6, label7, label8;

        GridPane gridPane = new GridPane();

        label4 = new Label("Room No");
        label4.setFont(new Font("Arial", 16));
        label4.setStyle("-fx-font-weight: bold");
        label4.setTextFill(Color.web("#2f479e"));


        TextField textField1 = new TextField();
        textField1.setFont(new Font("Arial", 16));

        gridPane.add(label4,0,3);
        gridPane.add(new Label(),1,3);
        gridPane.add(textField1,2,3);

        label6 = new Label();
        label7 = new Label("Name");
        label7.setFont(new Font("Arial", 16));
        label7.setStyle("-fx-font-weight: bold");
        label7.setTextFill(Color.web("#2f479e"));


        TextField textField2 = new TextField();
        textField2.setFont(new Font("Arial", 16));

        gridPane.add(label6,0,4);
        gridPane.add(label7,0,5);
        gridPane.add(new Label(),1,5);
        gridPane.add(textField2,2,5);

        Label label9 = new Label();
        Label label10 = new Label("Phone Number  ");
        label10.setFont(new Font("Arial", 16));
        label10.setStyle("-fx-font-weight: bold");
        label10.setTextFill(Color.web("#2f479e"));


        TextField textField3 = new TextField();
        textField3.setFont(new Font("Arial", 16));

        gridPane.add(label9,0,6);
        gridPane.add(label10,0,7);
        gridPane.add(new Label(),1,7);
        gridPane.add(textField3,2,7);

        Button confirm = new Button();
        confirm.setPrefWidth(110);
        confirm.setPrefHeight(25);
        confirm.setFont(new Font("Arial", 14));
        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/ConfirmButton.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(250,33,false,false, false,false)));

            confirm.setBackground(background);
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

        Label label12 = new Label();
        Label label13 = new Label();
        gridPane.add(label12,0,8);
        gridPane.add(confirm, 0,9);
        gridPane.add(label13,1,9);
        gridPane.add(back,2,9);

        confirm.setOnAction(e-> {
            ShowOutCustomer S = new ShowOutCustomer();

            Main.window.setScene(S.getShowDetails(textField2.getText(), textField3.getText()));

            textField1.setText("");
            textField2.setText("");
            textField3.setText("");
        });

        back.setOnAction(e-> {
            Main mm = new Main();

            Main.window.setScene(mm.mainScene());
        });

        gridPane.setAlignment(Pos.CENTER);

        HBox hBox = new HBox();
        hBox.getChildren().addAll(gridPane, new Label("                                                                                                                                                                                         "));
        hBox.setAlignment(Pos.CENTER);

        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/CheckOut.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(1050,750,false,false, false,false)));

            hBox.setBackground(background);
        }catch (Exception ex){

        }

        Scene checkOutScene = new Scene(hBox,1050,750);

        return checkOutScene;
    }
}
